package com.Phone;

public class PhoneTester {
    public static void main(String[] args) {
        Galaxy S20Ultra = new Galaxy("S20Ultra",80,"Jawwal","Ringing Bells");
        Iphone Xr = new Iphone("Xr",90,"Oreedo","Alarm Ringing");

        S20Ultra.displayInfo();
        System.out.println(S20Ultra.ring());
        System.out.println(S20Ultra.unlock());
        System.out.println("Battery Percentage:"+S20Ultra.getBatteryPercentage());

        System.out.println();
        Xr.displayInfo();
        System.out.println(Xr.ring());
        System.out.println(Xr.unlock());
        System.out.println("Battery Percentage:"+Xr.getBatteryPercentage());
        }
}
