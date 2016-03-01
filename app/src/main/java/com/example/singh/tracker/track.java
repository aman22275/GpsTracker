package com.example.singh.tracker;

import android.app.Application;
import android.location.Location;
import android.widget.Toast;

/**
 * Created by singh on 3/1/2016.
 */
public class track extends Application {

    public static double lat = 23.12;
    public static double lang = 32.23;

    public track()
    {

    }
    public static Location getLatLang()
    {
        return null;
    }


   public static void setLatLang(String location)
    {

        String[] ads = location.split(",");
        lat = Double.parseDouble(ads[0]);
        lang=Double.parseDouble(ads[1]);

       // Toast.makeText(this.getApplicationContext(),"track class"+location,Toast.LENGTH_LONG).show();

    }


}
