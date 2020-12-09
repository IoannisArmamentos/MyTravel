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
import com.noobs.mytravel.Models.Country;
import com.noobs.mytravel.Utilities.CityAdapter;
import com.noobs.mytravel.Utilities.Singleton;

import java.util.ArrayList;

public class CityActivity extends AppCompatActivity {
    private ListView listView;
    private CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        Country country = Singleton.getInstance().getSelectedCountry();

        getSupportActionBar().setTitle(country.getName());

        ((TextView) findViewById(R.id.tvDescCountry)).setText(country.getDescription());

        ArrayList<City> cities = Singleton.getInstance().getCities(this);

        this.listView = findViewById(R.id.lvCities);

        adapter = new CityAdapter(this, cities);

        listView.setAdapter(adapter);

        if (country.getFlagImage() != null) {
            String dbEntry = country.getFlagImage();
            byte[] decodedString = Base64.decode(dbEntry, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ((ImageView)findViewById(R.id.ivCity)).setImageBitmap(decodedByte);
        }

    //    Singleton.getInstance().setSelectedCity(cities.get(0));
    }
}
