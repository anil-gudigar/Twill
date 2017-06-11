package com.twilllnews.features.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Anil on 6/6/2017.
 */

public class TwillLocationChangeListener implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {
        Log.i("Twill", "Provider StatusChanged: " + location.toString());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.i("Twill", "Provider StatusChanged: " + provider);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.i("Twill", "Provider enabled: " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.i("Twill", "Provider Disabled: " + provider);
    }
}
