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

import com.noobs.mytravel.Models.Sight;
import com.noobs.mytravel.R;
import com.noobs.mytravel.SightFinal;

import java.util.ArrayList;

public class SightAdapter extends ArrayAdapter<Sight> {

    private final Activity activity;
    private final ArrayList<Sight> sights;

    public SightAdapter(Activity activity, ArrayList<Sight> sights) {
        super(activity, R.layout.row_city, sights);
        this.activity = activity;
        this.sights = sights;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_city, parent, false);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.ivSight = convertView.findViewById(R.id.ivSight);
            holder.cardView = convertView.findViewById(R.id.cardView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(sights.get(position).getName());
        if (sights.get(position).getSightImage() != null) {
            String dbEntry = sights.get(position).getSightImage();
            byte[] decodedString = Base64.decode(dbEntry, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            // holder.ivSight.setImageBitmap(decodedByte);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singleton.getInstance().setSelectedSight(sights.get(position));
                activity.startActivity(new Intent(activity, SightFinal.class));
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        private TextView tvName;
        private ImageView ivSight;
        private CardView cardView;
    }
}
