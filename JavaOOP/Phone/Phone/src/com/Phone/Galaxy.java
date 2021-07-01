package com.Phone;

public class Galaxy extends Phone implements Ringable{
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "Galaxy " +getVersionNumber()+ " says " + getRingTone();

    }
    @Override
    public String unlock() {
        String unlock = "Finger Print Unlock";
        return unlock;
    }
    @Override
    public void displayInfo() {
        System.out.println("Galaxy " +getVersionNumber()+" says " + getCarrier());

    }
}
