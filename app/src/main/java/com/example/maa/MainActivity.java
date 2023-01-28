package com.example.maa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BottomNavigationView bottomNavigationView;
    private TextView location_name; //user's current location TextView
    //private SearchView search;
    private Fragment fragment;

    List<Cook> cookList;


    //FusedLocationProviderClient- It is a location api in google play service used to find location
    // and it is the main entry point
    FusedLocationProviderClient fusedLocationProviderClient;
    Location location;  //-> A class representing geographical location with latitude and longitude
    LocationManager locationManager;  //It provides access to the location services

    //Firebase Declaration
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing view
        location_name = findViewById(R.id.location);
       // search= findViewById(R.id.search_bar);


        recyclerView = findViewById(R.id.recycle_view_layout);

        //getFusedLocationProviderClient() - It is used to create new instance of FusedLocationProviderClient to
        // use in non-activity context
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        //Checking permission
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else {

            //Requesting permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        location_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.map_container, new MapsFragment(location)).addToBackStack(null).commit();
            }
        });

        //Initialize firebase
        firebaseDatabase=FirebaseDatabase.getInstance();
        database=firebaseDatabase.getReference().child("cook");

        //ArrayList
        cookList=new ArrayList<>();


        //Initialize and add listener to read data change in firebase;
        ChildEventListener childEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Cook cook=snapshot.getValue(Cook.class);
                cookList.add(cook);
                recyclerView.setAdapter(new RecycleViewAdapter(cookList));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        database.addChildEventListener(childEventListener);

        //set layout manager to recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Initialize bottom navigation
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        //show/hide behaviour of bottom navigation on scrolling
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBahavior());

        //Load Navigation item fragment
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           switch (item.getItemId())
           {
               case R.id.navigation_home:
                   return true;
               case R.id.navigation_profile:
                   fragment=new ProfileFragment();
                   loadFragment(fragment);
                   return true;
               case  R.id.navigation_cart:
                   fragment=new ViewCartFragment();
                   loadFragment(fragment);
                   return true;
           }


                return false;
            }
        });



/*
        ValueEventListener valueEventListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cook=new Cook();
                Iterable<DataSnapshot> dataSnapshotIterable=snapshot.getChildren();
                Iterator<DataSnapshot> iterator=dataSnapshotIterable.iterator();
                while(iterator.hasNext())
                {
                    DataSnapshot next=(DataSnapshot)iterator.next();
                    cook.setBanner((String) next.child("banner").getValue());
                    cook.setCookName((String)next.child("cookName").getValue());
                    //cook.setId((Integer) next.child("id").getValue());
                    cook.setProfilePic((String) next.child("profilePic").getValue());
                    cook.setRating((Object) next.child("rating").getValue());
                    cookList.add(cook);

                }
                recyclerView.setAdapter(new RecycleViewAdapter(cookList));
            }

            @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       };
       database.addValueEventListener(valueEventListener);
*/

        //set Adapter and layout manager to recyclerview



    }

 public void loadFragment(Fragment fragment)
 {
     getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
 }

    //Method to detect user's current location
    private void getLocation() {

        //checking permission before getting location it's mandatory
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //using locationManager to check gps is enabled or not
        locationManager = (LocationManager) getSystemService(getApplicationContext().LOCATION_SERVICE);
         //condition to check gps state
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //getLastLocation() - It returns a Task that can use to get Location object with latitude and longitude

            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    location = task.getResult();
                    if (location != null) {
                        try {

                            //Geocoder - A class for handling geocoding and reverse geocoding
                            //means to convert address into latitude longitude and reverse
                            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            location_name.setText(addresses.get(0).getAddressLine(0));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        createLocationRequest();
                    }

                }
            });
        }
        //if location is not enabled
        else {
            buildAlertNoGps();
        }
    }

    //Method to show alertDialog to enable GPS
    private void buildAlertNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setMessage("Please enable location to know about" + "\n" +
                "your nearby cooks and dishes ")
                .setCancelable(false)
                .setIcon(R.drawable.location_icon)
                .setTitle("Disabled Location!!")
                .setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
            .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();

                }
            });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // A method to create accuracy of location accuracy
    public void createLocationRequest() {
        LocationRequest locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(5000)
                .setFastestInterval(1000)
                .setNumUpdates(3);

// Pending to search

        LocationCallback locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);
                location = locationResult.getLastLocation();
                try {
                    Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    location_name.setText(addresses.get(0).getAddressLine(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                locationCallback, Looper.myLooper());
    }

@Override
    public  void onStart()
{
    super.onStart();
    locationManager = (LocationManager) getSystemService(getApplicationContext().LOCATION_SERVICE);
    if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
        {
        createLocationRequest();
        }
    }
}
}
