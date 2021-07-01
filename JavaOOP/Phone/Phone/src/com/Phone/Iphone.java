package com.Phone;

import java.sql.SQLOutput;

public class Iphone extends Phone implements Ringable{
    public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "Iphone " +getVersionNumber()+ " says " + getRingTone();

    }
    @Override
    public String unlock() {
        String unlock = "Facial Recognition Unlock";
        return unlock;
    }
    @Override
    public void displayInfo() {
        System.out.println("Iphone " +getVersionNumber()+" says " + getCarrier());

    }
}
