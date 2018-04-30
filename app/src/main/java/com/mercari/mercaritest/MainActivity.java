package com.mercari.mercaritest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.mercari.mercaritest.data.model.SellItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<SellItems> sellItemsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SellItemsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView = (RecyclerView) findViewById(R.id.showDataRecyclerView);

        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        JSONArray data = fetchData();
        if (data != null && data.length() > 0) {
            for (int i=0; i<data.length(); i++) {
                try {
                    JSONObject itemObject = data.getJSONObject(i);
                    SellItems item = new SellItems(itemObject.getString("id"), itemObject.getString("name"), itemObject.getString("status"),
                            itemObject.getString("photo"), itemObject.getInt("num_likes"), itemObject.getInt("num_comments"), itemObject.getInt("price"));
                    sellItemsList.add(item);
                } catch (JSONException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            mAdapter = new SellItemsAdapter(sellItemsList);
            recyclerView.setAdapter(mAdapter);
        } else {
            // no data available to display
        }
    }

    private JSONArray fetchData() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("all.json")));
            // do reading, usually loop until end of file reading
            StringBuilder jsonData = new StringBuilder("");
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                jsonData.append(mLine);
            }
            Log.d(TAG, "Data read is " + jsonData);
            return parseJsonData(jsonData.toString());
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
        return null;
    }

    private JSONArray parseJsonData(String jsonData) {
        // parse json data
        try {
            JSONObject mainObject = new JSONObject(jsonData.toString());
            JSONArray dataItems = mainObject.getJSONArray("data");
            Log.d(TAG, "elems " + dataItems.length());
            return dataItems;
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }
}
