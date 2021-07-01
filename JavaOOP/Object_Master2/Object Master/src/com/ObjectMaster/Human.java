package com.ObjectMaster;

import java.sql.SQLOutput;

public class Human {
    private int strength;
    private int stealth;
    private int intelligence;
    private int health;

    //Constructor
    public Human() {
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
    }
//Setter
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public void setHealth(int health) {
        this.health = health;
    }
//Getter
    public int getStrength() {
        return strength;
    }

    public int getStealth() {
        return stealth;
    }

    public int getIntelligence() {
        return intelligence;
    }
    public int getHealth() {
        return health;
    }



    public void attack(Human R) {
        R.health -= this.strength;
    }

}
//    //Setter
//    public void setStrength(int strength) {
//        this.strength = strength;
//    }
//
//    public void setStealth(int stealth) {
//        this.stealth = stealth;
//    }
//
//    public void setIntelligence(int intelligence) {
//        this.intelligence = intelligence;
//    }
//
//    public void setHealth(int health) {
//        this.health = health;
//    }
////Getter
//
//    public int getStrength() {
//        return strength;
//    }
//
//    public int getStealth() {
//        return stealth;
//    }
//
//    public int getIntelligence() {
//        return intelligence;
//    }
//
//    public int getHealth() {
//        return health;
//    }