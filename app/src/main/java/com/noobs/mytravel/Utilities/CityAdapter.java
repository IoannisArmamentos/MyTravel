package com.noobs.mytravel.Utilities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.cardview.widget.CardView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noobs.mytravel.Models.City;
import com.noobs.mytravel.R;
import com.noobs.mytravel.SightActivity;

import java.util.ArrayList;

public class CityAdapter extends ArrayAdapter<City> {

    private final Activity activity;
    private final ArrayList<City> cities;

    public CityAdapter(Activity activity, ArrayList<City> cities) {
        super(activity, R.layout.row_city, cities);
        this.activity = activity;
        this.cities = cities;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_city, parent, false);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.ivCity = convertView.findViewById(R.id.ivCity);
            holder.cardView = convertView.findViewById(R.id.cardView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(cities.get(position).getName());
        if (cities.get(position).getCityImage() != null) {
            String dbEntry = cities.get(position).getCityImage();
            byte[] decodedString = Base64.decode(dbEntry, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            //holder.ivCity.setImageBitmap(decodedByte);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singleton.getInstance().setSelectedCity(cities.get(position));
                activity.startActivity(new Intent(activity, SightActivity.class));
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        private TextView tvName;
        private ImageView ivCity;
        private CardView cardView;
    }

}
