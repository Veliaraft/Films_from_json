package com.example.books2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView year;
    private TextView runtime;
    private TextView country;
    private TextView genre;
    private TextView desc;
    private int quantity;
    private Button b;
    ArrayList<Movies> m = new ArrayList<>();

    private String getJsonStringFromRaw() {
        String jsonString = null;
        try {
            InputStream inputStream = getAssets().open("movies.json");
            InputStreamReader reader = new InputStreamReader(inputStream);
            int size = inputStream.available();
            byte[] buffer= new byte[size];
            inputStream.read(buffer);
            jsonString = new String(buffer);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        year = findViewById(R.id.year);
        runtime = findViewById(R.id.runtime);
        country = findViewById(R.id.country);
        genre = findViewById(R.id.genre);
        desc = findViewById(R.id.desc);
        String reader = getJsonStringFromRaw();
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(reader).getAsJsonArray();
        Gson gson = new Gson();
        for (JsonElement user : jsonArray) {
            Movies movie = gson.fromJson(user, Movies.class);
            m.add(movie);
        }
        quantity = m.size();

        b = findViewById(R.id.get_film);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int i = r.nextInt(quantity);
                Movies mov = m.get(i);
                name.setText(mov.Title);
                year.setText(mov.Year);
                runtime.setText(mov.Runtime);
                country.setText(mov.Country);
                genre.setText(mov.Genre);
                desc.setText(mov.Description);
            }
        });
    }
}