package com.example.furnatureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class FurnatureActivity extends AppCompatActivity {
private static RecyclerView.Adapter adapter;
private RecyclerView.LayoutManager layoutManager;
private static RecyclerView recyclerView;
private static ArrayList<DataModel>data;
private Context context;
    private static RecyclerView.Adapter adapter2;
    private RecyclerView.LayoutManager layoutManager2;
    private static RecyclerView recyclerView2;
    private static ArrayList<DataModel>data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateMainCard();
        initiateSecondaryCard();
    }
    private void initiateMainCard(){
        recyclerView=findViewById(R.id.recyclerViewPremier);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //getting Data from model
        data=new ArrayList<>();
        for (int i=0;i<MyData.nameArray.length;i++){
            data.add(new DataModel(
                    MyData.nameArray[i]
                    ,MyData.versionArray[i]
                    ,MyData.id_[i]
                    ,MyData.drawableArray[i] ));

        }
        adapter=new CustomAdapter(data,this);
        recyclerView.setAdapter(adapter);

    }
    private void initiateSecondaryCard(){
        recyclerView2=findViewById(R.id.recyclerViewSecondary);
        recyclerView2.setHasFixedSize(true);
        layoutManager2=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        //getting Data from model
        data2=new ArrayList<>();
        for (int i=0;i<MyData2.nameArray.length;i++){
            data2.add(new DataModel(
                    MyData2.nameArray[i]
                    ,MyData2.versionArray[i]
                    ,MyData2.id_[i]
                    ,MyData2.drawableArray[i] ));

        }
        adapter2=new CustomAdapter2(data2,this);
        recyclerView2.setAdapter(adapter2);

    }

    public void onClick(View view) {
        Intent intent=new Intent(FurnatureActivity.this,FashionActivity.class);
        startActivity(intent);

    }

    public void onClickMedical(View view) {
        Intent intent=new Intent(FurnatureActivity.this,MedicalActivity.class);
        startActivity(intent);

    }

    public void onClickFood(View view) {
        Intent intent=new Intent(FurnatureActivity.this,FoodActivity.class);
        startActivity(intent);
    }
}