package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rvMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        GetDataServices retrofitInstance=
                 RetrofitInstance.getRetrofitInstance().create(GetDataServices.class);
        Call<PhotoModel> listCall =retrofitInstance.getAllPhotos(1);
        listCall.enqueue(new Callback<PhotoModel>() {
            @Override
            public void onResponse(Call<PhotoModel> call, Response<PhotoModel> response) {
                ParsData(response.body().data);
            }

            @Override
            public void onFailure(Call<PhotoModel> call, Throwable t) {

            }
        });
    }

    private void ParsData(List<PhotoModel.Data> body) {
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(body);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


}