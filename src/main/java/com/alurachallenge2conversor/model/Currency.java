package com.alurachallenge2conversor.model;

import com.google.gson.annotations.SerializedName;

public class Currency {
    public boolean success;
    public float timestamp;
    public String base;
    public String date;
    @SerializedName("rates")
    public Rates rates;

    public Currency() {}

}
