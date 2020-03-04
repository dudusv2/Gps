package spp.gps.location

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import org.json.JSONObject

class Localization(val context: Context) : LocationListener {

    private companion object {
        var gps: Location? = null
    }

    override fun onLocationChanged(location: Location?) {
        gps = location
        Log.i("GPS_chanege", location!!.provider)
        Log.i("GPS_chanege", ":)")
        createLocationJSON(location)
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {}
    override fun onProviderEnabled(p0: String?) {}
    override fun onProviderDisabled(p0: String?) {}

    /**
     * Pobiera aktualną lokalizację
     */
    @SuppressLint("MissingPermission")
    fun createLocalization() {

        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        val locationNet = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        if (locationGPS != null && locationNet != null) {
            gps = when (0 < locationGPS.time - locationNet.time) {
                true -> locationGPS
                false -> locationNet
            }
        } else if (locationGPS != null) {
            gps = locationGPS
        } else if (locationNet != null) {
            gps = locationNet
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this)
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, this)

    }

    //    fun getLocation(): JSONObject {
//        return createLocationJSON()
//    }
    fun createLocationJSON(loc: Location?)//: JSONObject
    {
        //Todo tu wyciagay dane i skłądamy Jsona
        Log.i("GPS_Log_wysokość", loc!!.altitude.toString())
        Log.i("GPS_Log_dostawca", loc.provider)
        Log.i("GPS_Log_kierunek", loc.bearing.toString())
        Log.i("GPS_Log_kier. dok w st", loc.bearingAccuracyDegrees.toString())
        Log.i("GPS_Log_mineło ns", loc.elapsedRealtimeNanos.toString())
        Log.i("GPS_Log_predkość", loc.speed.toString())

    }

}