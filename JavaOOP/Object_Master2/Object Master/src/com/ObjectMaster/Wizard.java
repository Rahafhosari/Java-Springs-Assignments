package com.ObjectMaster;

public class Wizard extends Human{
    //we set the attribute values in the constructor
    public Wizard(){
        this.setHealth(50);
        this.setIntelligence(8);
    }
 //either two ways to solve get getters and setters in the parent Class human
 // or change them to protected to be able to use them ex this.health = 50

    public void heal (Human R){ //Human R we're healing another human object
        R.setHealth(this.getIntelligence() + R.getHealth());
    }
    public void fireball (Human R){
        R.setHealth(R.getHealth() - (this.getIntelligence()*3));
    }
}
