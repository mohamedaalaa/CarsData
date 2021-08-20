package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoModel {

    @SerializedName("status")
    String status;

    List<Data> data;


    static class Data{
        int id;
        String brand;
        String constractionYear;
        boolean isUsed;
        String imageUrl;
    }
}
