package com.v.aidetect;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerHome;
    List<Integer> imageList = new ArrayList<>();
    List<String> imageDescriptionList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        recyclerHome = findViewById(R.id.homeRecycler);



        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerHome.setLayoutManager(gridLayoutManager);

        addToHome();

        recyclerHome.setAdapter(new HomeAdapter(imageList,imageDescriptionList));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void addToHome(){
        imageList.add(R.drawable.corn);
        imageList.add(R.drawable.tomato);
        imageList.add(R.drawable.potato);
        imageList.add(R.drawable.apple);



        imageDescriptionList.add(getResources().getString(R.string.corn));
        imageDescriptionList.add(getResources().getString(R.string.tomato));
        imageDescriptionList.add(getResources().getString(R.string.potato));
        imageDescriptionList.add(getResources().getString(R.string.apple));
    }

}