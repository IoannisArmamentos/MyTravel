package com.noobs.mytravel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.noobs.mytravel.Models.Sight;
import com.noobs.mytravel.Utilities.Singleton;

public class SightFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight_final);

        Sight sight = Singleton.getInstance().getSelectedSight();

        getSupportActionBar().setTitle(sight.getName());

        ((TextView) findViewById(R.id.tvDescSight)).setText(sight.getDesc());

        if (sight.getSightImage() != null) {
            String dbEntry = sight.getSightImage();
            byte[] decodedString = Base64.decode(dbEntry, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ((ImageView)findViewById(R.id.ivSightFinal)).setImageBitmap(decodedByte);
        }
    }
}
