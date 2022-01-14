package com.svetikov.flyticket.model;



import java.util.Random;



public class DiscountCard implements MakeDiscount{
    private double discount;
    Random rnd =new Random();

    @Override
    public double makeDiscount(){

        discount = Math.floor(rnd.nextDouble()*100.0)/100.0;

        return discount;
    }
}
