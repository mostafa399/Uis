package com.example.furnatureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FashionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdaptery adapter;
    private StaggeredGridLayoutManager layoutManager;

    private List<MyRow>appList;
    int []covers=new int[]{
            R.drawable.fash1
            ,R.drawable.fash2
            ,R.drawable.fash3
            ,R.drawable.fash4
            ,R.drawable.fash5
            ,R.drawable.fash6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);
        recyclerView=findViewById(R.id.recyclerViewy);
        appList=new ArrayList<>();
        adapter=new RecyclerViewAdaptery(this,appList);
        layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initializeDataIntoRecyclerView();
    }

    private void initializeDataIntoRecyclerView() {
        MyRow a=new MyRow(covers[0],"Box Tee" );
        appList.add(a);
        a=new MyRow(covers[1],"BoyFriend Tee" );
        appList.add(a);
        a=new MyRow(covers[2],"Shirt Sleve" );
        appList.add(a);
        a=new MyRow(covers[3],"BoyFriend Tee" );
        appList.add(a);
        a=new MyRow(covers[4],"BoyFriend Tee" );
        appList.add(a);
        a=new MyRow(covers[5],"Shirt Sleve" );
        appList.add(a);
        adapter.notifyDataSetChanged();

    }
}