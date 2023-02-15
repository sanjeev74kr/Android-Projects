package com.example.maa;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class AmountCalculation {
    double bill;

public AmountCalculation()
{}

public double calculateBill(double price)
{

    bill=bill+price;
    return bill;
}

}


