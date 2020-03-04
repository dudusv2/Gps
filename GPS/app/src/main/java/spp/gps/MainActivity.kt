package spp.gps

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val listOfPermission = ArrayList<String>()
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            listOfPermission.add(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            listOfPermission.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(listOfPermission.isNotEmpty()){
            ActivityCompat.requestPermissions(this,listOfPermission.toTypedArray(),1)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}