package com.example.opscice4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var auth: FirebaseAuth

    private val SYDNEY = LatLng(-33.862, 151.21)
    private val ZOOM_LEVEL = 13f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this case, we just move the camera to Sydney and add a marker in Sydney.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        with(mMap) {
            moveCamera(CameraUpdateFactory.newLatLngZoom(SYDNEY, ZOOM_LEVEL))
            addMarker(MarkerOptions().position(SYDNEY))
        }

        // TODO: Implement these methods for full functionality
        enableMyLocation()
        addLandmarkMarkers()
    }

    private fun enableMyLocation() {
        // TODO: Request location permission and enable user location on the map
    }

    private fun addLandmarkMarkers() {
        // TODO: Fetch nearby landmarks from a webservice and add markers to the map
    }
}