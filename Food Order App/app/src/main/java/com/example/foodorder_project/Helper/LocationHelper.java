package com.example.foodorder_project.Helper;

import com.google.android.gms.location.LocationRequest;

public class LocationHelper {
    public static LocationRequest getLocationRequest() {
        return new LocationRequest()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10000)  // 10 seconds
                .setFastestInterval(5000);  // 5 seconds
    }
}
