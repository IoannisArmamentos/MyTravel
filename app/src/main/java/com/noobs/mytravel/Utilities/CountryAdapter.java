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

import com.noobs.mytravel.CityActivity;
import com.noobs.mytravel.Models.Country;
import com.noobs.mytravel.R;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {

    private final Activity activity;
    private final ArrayList<Country> countries;

    public CountryAdapter(Activity activity, ArrayList<Country> countries) {
        super(activity, R.layout.row, countries);
        this.activity = activity;
        this.countries = countries;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.row, parent, false);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.ivFlag = convertView.findViewById(R.id.ivFlag);
            holder.cardView = convertView.findViewById(R.id.cardView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(countries.get(position).getName());
        if (countries.get(position).getFlagImage() != null) {
            String dbEntry = countries.get(position).getFlagImage();
            byte[] decodedString = Base64.decode(dbEntry, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            holder.ivFlag.setImageBitmap(decodedByte);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singleton.getInstance().setSelectedCountry(countries.get(position));
                activity.startActivity(new Intent(activity, CityActivity.class));
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        private TextView tvName;
        private ImageView ivFlag;
        private CardView cardView;
    }

}
