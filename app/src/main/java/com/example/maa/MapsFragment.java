package com.example.maa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsFragment extends Fragment {

     Location location;
     TextView location_name; //
    TextView confirm;
    List<Address> addresses;
    MapsFragment(Location location)
    {

        this.location=location;


    }


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            if (location != null) {

                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions().position(latLng).draggable(true).title("Your food will be delivered here");
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                googleMap.addMarker(markerOptions).showInfoWindow();
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                       googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(),18));
                        return true;
                    }
                });

                googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                    @Override
                    public void onMarkerDragStart(@NonNull Marker marker) {
                        LatLng pos=marker.getPosition();
                        Geocoder geocoder=new Geocoder(getActivity(), Locale.getDefault());
                        try {
                             addresses=geocoder.getFromLocation(pos.latitude,pos.longitude,1);

                            location_name.setText(addresses.get(0).getAddressLine(0));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                    }

                    @Override
                    public void onMarkerDrag(@NonNull Marker marker) {
                        LatLng pos=marker.getPosition();

                        Geocoder geocoder=new Geocoder(getActivity(), Locale.getDefault());
                        try {
                             addresses=geocoder.getFromLocation(pos.latitude,pos.longitude,1);
                            location_name.setText(addresses.get(0).getAddressLine(0));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onMarkerDragEnd(@NonNull Marker marker) {
                        LatLng pos=marker.getPosition();

                        Geocoder geocoder=new Geocoder(getActivity(), Locale.getDefault());
                        try {
                            addresses=geocoder.getFromLocation(pos.latitude,pos.longitude,1);
                            location_name.setText(addresses.get(0).getAddressLine(0));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            else
                Toast.makeText(getContext(),"Location not found",Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_maps, container, false);
        location_name=(TextView)getActivity().findViewById(R.id.location); //Initializing the textView of MainActivity

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //SupportMapFragment - A fragment to place map in application
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);

        }

        confirm=(TextView)getActivity().findViewById(R.id.confirm_button);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }

        });
    }


}