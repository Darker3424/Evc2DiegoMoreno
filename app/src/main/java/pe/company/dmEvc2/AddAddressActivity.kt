package pe.company.dmEvc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class AddAddressActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmert_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0
        val limaSjl = LatLng(-11.990207,-76.991884)
        val limaCent = LatLng(-12.057713,-77.038179)
        val limaSJM = LatLng(-12.158267,-76.949112)
        map.addMarker(MarkerOptions().position(limaSjl).title("IDAT, San Juan de Lurigancho"))
        map.addMarker(MarkerOptions().position(limaCent).title("IDAT, Lima Centro"))
        map.addMarker(MarkerOptions().position(limaSJM).title("IDAT, San Juan de Miraflores"))
        val boundBuilder = LatLngBounds.builder()
            .include(limaSjl)
            .include(limaCent)
            .include(limaSJM)
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(boundBuilder.build(), 30))
    }
}