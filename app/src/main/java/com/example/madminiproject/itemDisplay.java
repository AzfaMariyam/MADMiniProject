package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class itemDisplay extends AppCompatActivity {
    private static final String TAG = "itemDisplay";

    //vars
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    DatabaseReference refDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        Log.d(TAG, "oncreate: started");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImgBitmaps: preparing bitmaps");

        mImageUrls.add("https://cdn.elkor.lv/media/catalog/product/cache/0/image/9df78eab33525d08d6e5fb8d27136e95/1/6/164008_9p291_00020_emporio_armani.png.jpg");
        mName.add("Shirt");
        mPrice.add("Rs.2550.00");

        mImageUrls.add("https://images.asos-media.com/products/armani-exchange-text-logo-t-shirt-in-black/11138204-1-black?$XXL$&wid=513&fit=constrain");
        mName.add("TShirt");
        mPrice.add("Rs.2850.00");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecy: initrecy");

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mName, mPrice, mImageUrls);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
