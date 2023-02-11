package com.example.furnatureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MedicalActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private MedicalAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private List<MedicalRow> appList;
    int[] covers = new int[]{
            R.drawable.fash11,
            R.drawable.fash12,
            R.drawable.fash13,
            R.drawable.fash14,
            R.drawable.fash15,
            R.drawable.fash16
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // 4- Making the home button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator
                (R.drawable.menuu);
        recyclerView = findViewById(R.id.recyclerviewMedical);
        appList = new ArrayList<>();
        //Adapter
        adapter = new MedicalAdapter(this, appList);
        manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);


        // Layout Manager
        recyclerView.setLayoutManager(manager);

        // Adapter
        recyclerView.setAdapter(adapter);

        // 6- Putting Data into recyclerView
        IntializeDataIntoRecyclerView();

    }

    private void IntializeDataIntoRecyclerView() {
        MedicalRow a = new MedicalRow(covers[0]);
        appList.add(a);

        a = new MedicalRow(covers[1]);
        appList.add(a);

        a = new MedicalRow(covers[2]);
        appList.add(a);

        a = new MedicalRow(covers[3]);
        appList.add(a);

        a = new MedicalRow(covers[4]);
        appList.add(a);

        a = new MedicalRow(covers[5]);
        appList.add(a);

        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);


    }

    // 3- Handling click on toolbar buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}