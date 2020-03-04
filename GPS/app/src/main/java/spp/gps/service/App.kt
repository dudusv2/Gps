package spp.gps.service

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import spp.gps.MainActivity

class App() : Application() {

    override fun onCreate() {
        super.onCreate()
        startService(Intent(this, GpsService::class.java))
    }


}
