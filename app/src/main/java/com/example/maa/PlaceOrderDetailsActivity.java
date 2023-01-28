package com.example.maa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PlaceOrderDetailsActivity extends AppCompatActivity implements PaymentResultListener {
    CardView makePaymentButton;
    double netBillingAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_details);

        Checkout.preload(getApplicationContext());
        Intent intent=getIntent();
        netBillingAmount=intent.getDoubleExtra("billingAmount",0.0);
    makePaymentButton=findViewById(R.id.makePaymentButton);
    makePaymentButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            payNow(netBillingAmount);


        }
    });

    }
    private void payNow(Double netBillingAmount)
    {
        final Activity activity=this;
        Checkout checkout=new Checkout();
        checkout.setKeyID("rzp_test_CgVH1Dt6rqaEA7");
        checkout.setImage(R.drawable.spashscreen);

        double finalAmount=netBillingAmount*100;

        try{
            JSONObject options= new JSONObject();
            options.put("name","Maa");
            options.put("theme.color","#E93B81");
            options.put("currency","INR");
            options.put("amount",finalAmount+"");
            options.put("prefix contact","86356726");
            checkout.open(activity,options);
        }catch(Exception e)
        {
            Log.e("checkout","Error in starting checkout");
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        //Toast.makeText(getApplicationContext(), "payment success", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setMessage("Your Payment is successful" + "\n" +
                "\n"+
                "\n"+
                "your order will be delivered at your scheduled time ")
                .setCancelable(false)
                .setTitle("Ordered Successfully")
                .setIcon(R.drawable.happy_face)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }).show();

    }

    @Override
    public void onPaymentError(int i, String s) {
   Toast.makeText(getApplicationContext(),"payment failed",Toast.LENGTH_SHORT).show();
    }
}