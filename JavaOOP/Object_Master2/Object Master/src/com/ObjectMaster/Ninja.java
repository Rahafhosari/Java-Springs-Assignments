package com.ObjectMaster;

public class Ninja extends Human {
    public Ninja(){
        this.setStealth(10);
        this.setHealth(100);
    }

    public void steal (Human R) { //Human R we're healing another human object
        R.setHealth(R.getHealth() - this.getStealth());
        this.setHealth(this.getHealth() + this.getStealth());

        //in cas protected
        //h.setHealth(-this.getStealth());
        //this.setHealth(this.getStealth());
        //in the Human class in the heath setter put += health
    }
    public void runaway(){
        this.setHealth(this.getHealth()-10);
    }
}
