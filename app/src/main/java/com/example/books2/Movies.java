package com.example.books2;

import com.google.gson.annotations.SerializedName;

public class Movies{
    @SerializedName("Title")
    public String Title;

    @SerializedName("Year")
    public String Year;

    @SerializedName("Runtime")
    public String Runtime;

    @SerializedName("Genre")
    public String Genre;

    @SerializedName("Country")
    public String Country;

    @SerializedName("Description")
    public String Description;

}