package com.noobs.mytravel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.noobs.mytravel.Models.City;
import com.noobs.mytravel.Models.Sight;
import com.noobs.mytravel.Utilities.SightAdapter;
import com.noobs.mytravel.Utilities.Singleton;

import java.util.ArrayList;

public class SightActivity extends AppCompatActivity {
    private ListView listView;
    private SightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight);

        City city = Singleton.getInstance().getSelectedCity();

        getSupportActionBar().setTitle(city.getName());

        ((TextView) findViewById(R.id.tvDescCity)).setText(city.getDesc());

        ArrayList<Sight> sights = Singleton.getInstance().getSights(this);

        this.listView = findViewById(R.id.lvSights);

        adapter = new SightAdapter(this, sights);

        listView.setAdapter(adapter);

        if (city.getCityImage() != null) {
            String dbEntry = city.getCityImage();
            byte[] decodedString = Base64.decode(dbEntry, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ((ImageView)findViewById(R.id.ivSight)).setImageBitmap(decodedByte);
        }
    }
}
