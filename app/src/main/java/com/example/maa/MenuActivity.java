package com.example.maa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;
    TextView idLabel,nameLabel,ratingLabel,bestDishLabel;
    TextView cookId,cookName,cookRating,cookBestDish;
    ImageView profilePic;
    long cook_Id;
    CardView placeOrderButton;
    TextView amount;
     double billing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cookName=findViewById(R.id.textName);
        cookId=findViewById(R.id.textId);
        cookRating=findViewById(R.id.textRating);
        cookBestDish=findViewById(R.id.textDish);
        profilePic=findViewById(R.id.cookProfile);
        placeOrderButton=findViewById(R.id.bill);
        amount=findViewById(R.id.amount);

        //Display and retrieve details to new Activity
        Intent intent=getIntent();
        cook_Id =intent.getLongExtra("id",1);
        cookId.setText(cook_Id+"");
        cookName.setText(intent.getStringExtra("name"));
        cookRating.setText(intent.getDoubleExtra("rating",0.00)+"");
        cookBestDish.setText("Handi Paneer");

        //Displaying image
        Glide.with(getApplicationContext()).load(intent.getStringExtra("profile"))
                .centerCrop()
                .transform(new CircleCrop())
                .into(profilePic);

        //Initialize tabLayout and viewPager
        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.viewPager);

//        //Add tab to tabLayout
//        tabLayout.addTab(tabLayout.newTab().setText("Breakfast"));
//        tabLayout.addTab(tabLayout.newTab().setText("Lunch"));
//        tabLayout.addTab(tabLayout.newTab().setText("Dinner"));

        //for equally positioning tab in tab layout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initialize fragment adapter and set adapter to viewpager
        fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),cook_Id);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        LocalBroadcastManager.getInstance(this).registerReceiver(amountReceiver,new IntentFilter("passAmount"));

    placeOrderButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent= new Intent(MenuActivity.this,PlaceOrderDetailsActivity.class);
            intent.putExtra("billingAmount",billing);
            startActivity(intent);

        }
    });

    }


    @Override
    protected  void onStart() {
        super.onStart();


            }
   @Override
   protected void onResume()
   {
       super.onResume();



   }

   //for receiving the data passed by broadcast manager we use BroadcastReceiver
    public BroadcastReceiver amountReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
             billing=intent.getDoubleExtra("amount",0.00);
            Log.d("checkCall", "checkBill method called");

            if(billing>=0.0)
            {
                Log.d("checkCall", "In checkBill method:if condition is checked ");
                placeOrderButton.setVisibility(View.VISIBLE);

                amount.setText("Rs."+billing+"");
            }
        }
    };




}