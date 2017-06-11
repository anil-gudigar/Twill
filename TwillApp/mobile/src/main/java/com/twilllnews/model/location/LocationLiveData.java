package com.twilllnews.model.location;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.util.Log;

/**
 * Created by Anil on 6/7/2017.
 */

public class LocationLiveData  extends LiveData<Location> {
    private static LocationLiveData sInstance;
    private LocationManager mLocationManager;
    private final Context mContext;

    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.i("Twill", "LocationLiveData -> Provider StatusChanged: " + location.toString());
            setValue(location);
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
    };
    @SuppressWarnings("MissingPermission")
    private LocationLiveData(Context context) {
        Log.i("Twill", "LocationLiveData -> locationManager: ");
        mContext = context;
        mLocationManager =
                (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
        Log.d("BoundLocationMgr", "Listener added");

        // Force an update with the last location, if available.
        Location lastLocation = mLocationManager.getLastKnownLocation(
                LocationManager.GPS_PROVIDER);
        if (lastLocation != null) {
            listener.onLocationChanged(lastLocation);
        }
    }

    @MainThread
    public static LocationLiveData get(Context context) {
        if (sInstance == null) {
            sInstance = new LocationLiveData(context.getApplicationContext());
        }
        return sInstance;
    }

    @SuppressWarnings("MissingPermission")
    @Override
    protected void onActive() {
        Log.i("Twill", "LocationLiveData -> onActive: ");
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
    }

    @Override
    protected void onInactive() {
        Log.i("Twill", "LocationLiveData -> onInactive: ");
        mLocationManager.removeUpdates(listener);
    }
}