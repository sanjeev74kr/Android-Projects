package com.example.maa;

import java.util.ArrayList;
import java.util.List;

public class BreakfastMenu {
    int cookId;
    String dishName;
    String dishImage;
    boolean countable;
    long halfPrice;
    long fullPrice;
    long unitPrice;

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }



    public boolean isCountable() {
        return countable;
    }

    public void setCountable(boolean countable) {
        this.countable = countable;
    }

    BreakfastMenu()
    {

    }

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    public long getHalfPrice() {
        return halfPrice;
    }

    public void setHalfPrice(long halfPrice) {
        this.halfPrice = halfPrice;
    }

    public long getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(long fullPrice) {
        this.fullPrice = fullPrice;
    }
}
