package com.ZooKeeper;

class Gorilla extends Mammal {
// constructor
    public Gorilla(){}

//    public Gorilla(int energyLevel){}
    public void throwSomething(){
        System.out.println("KingKong is throwing things!");
        this.setEnergyLevel(getEnergyLevel()-5);
        //energyLevel -= 5; if int is protected
    }
    public void eatBananas(){
        System.out.println("KingKong is eating Bananas...mmm");
        this.setEnergyLevel(getEnergyLevel()+10);
        //energyLevel += 10;
    }
    public void climb(){
        System.out.println("KingKong climbing!");
        this.setEnergyLevel(getEnergyLevel()-10);
        //energyLevel -= 10;
    }
}

//throw at people -5 energy
//eat banana +10 energy
//climb -10 energy