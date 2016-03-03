package com.example.singh.tracker;

import android.app.Application;
import android.location.Location;

/**
 * Created by singh on 3/1/2016.
 */
public class track extends Application {

    public static double lat = 1;
    public static double lang = 2;
    public static double lat1 =3;
    public static double lang1=4;

    public track()
    {

    }
    public static Location getLatLang()
    {
        return null;
    }


   public static void setLatLang(String location)
    {

       String a[] = location.split(",");
        lat = Double.parseDouble(a[0]);
        lang=Double.parseDouble(a[1]);
        lat1=Double.parseDouble(a[2]);
        lang1=Double.parseDouble(a[3]);
        //lang2=Double.parseDouble(ads[3]);

        // Toast.makeText(this.getApplicationContext(),"track class"+location,Toast.LENGTH_LONG).show();

    }


}
