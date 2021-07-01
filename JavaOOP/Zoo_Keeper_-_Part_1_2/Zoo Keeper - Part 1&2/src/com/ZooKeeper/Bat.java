package com.ZooKeeper;

public class Bat extends Mammal {
    // constructor
    public Bat() {
        this.setEnergyLevel(300);
    }

    //    public Gorilla(int energyLevel){}
    public void fly() {
        System.out.println("Bat is flying!");
        this.setEnergyLevel(getEnergyLevel() - 50);
        //energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("mmmmmmm...");
        this.setEnergyLevel(getEnergyLevel() + 25);
        //energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("Bat Attacking Town");
        this.setEnergyLevel(getEnergyLevel() - 100);
        //energyLevel -= 100;
    }
}