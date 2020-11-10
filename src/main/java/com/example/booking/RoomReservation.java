package com.example.booking;

import android.content.Context;
import android.content.Intent;
//import android.support.v4.view.ViewPager;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.booking.adapters.ImageAdapter;
import com.example.booking.adapters.CustomBaseAdapter;
import com.example.booking.adapters.RowItemReservationBaseAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class RoomReservation extends FragmentActivity implements OnMapReadyCallback {

    Button btnBook;

    private GoogleMap mMap;

    public static final String[] condition = new String[] { "2 People", "1 bedroom", "Wi-fi","Bathroom"};

    ListView listView;
    List<RowItemReservation> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_reservation);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnBook = (Button)findViewById(R.id.book_now);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent available_rooms = new Intent(RoomReservation.this, AvailableRooms.class);
                startActivity(available_rooms);
            }
        });

        rowItems = new ArrayList<RowItemReservation>();
        for (int i = 0; i < condition.length; i++) {
            RowItemReservation item = new RowItemReservation(condition[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.reservation_list);
        RowItemReservationBaseAdapter adapter = new RowItemReservationBaseAdapter(this, rowItems);
        listView.setAdapter(adapter);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng city = new LatLng(-34, 151);
        String strCity = "Athens";
        LatLng city = getLocationFromAddress(this,strCity);
        mMap.addMarker(new MarkerOptions().position(city));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((city),6.0f));
    }

    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return p1;
    }

}