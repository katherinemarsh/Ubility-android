package com.android.ubility_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        need to create place for api
        Places.initialize(applicationContext, "AIzaSyCLLmlBLscA-pXv4IMF2uA8FVKtpUOOg5o")
        // Create a new Places client instance
        val placesClient = Places.createClient(this)
    }
}
