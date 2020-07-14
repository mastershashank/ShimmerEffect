package com.shimmer.shimmereffect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdaptor adaptor;
    ArrayList<ShimmerModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        adaptor = new RecyclerViewAdaptor(list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(adaptor);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
                adaptor.showShimmer = false;
                adaptor.notifyDataSetChanged();
            }
        }, 4000);

    }


    //Load Dummy Data

    private void loadData() {
        list.add(new ShimmerModel("Title1", "Description1"));
        list.add(new ShimmerModel("Title2", "Description2"));
        list.add(new ShimmerModel("Title3", "Description3"));
        list.add(new ShimmerModel("Title4", "Description4"));
        list.add(new ShimmerModel("Title5", "Description5"));
        list.add(new ShimmerModel("Title6", "Description6"));
        list.add(new ShimmerModel("Title7", "Description7"));
        list.add(new ShimmerModel("Title8", "Description8"));
        list.add(new ShimmerModel("Title9", "Description9"));
        list.add(new ShimmerModel("Title10", "Description10"));
    }
}
