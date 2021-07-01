package com.ZooKeeper;

public class Mammal {
    private int energyLevel = 100;

//Constructor
    public Mammal(){}
//Setter
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
//Getter
    public int getEnergyLevel() {
        return this.energyLevel;
    }

    public int displayEnergyLevel(){
        System.out.println("The Energy level is:"+ this.energyLevel);
        return energyLevel;
    }
}


    //getter
    //public int getEnergy(){
    //    return this.energylevel;
    //  }