package com.ObjectMaster;

public class TestHuman {
    public static void main(String[] args) {
       Human Rhf = new Human();
       Human Baha = new Human();
       Wizard Loay = new Wizard();
       Samurai Abed = new Samurai();
       Samurai Jeries = new Samurai();
       Ninja Tareq = new Ninja();

//        Rhf.attack(Baha);
//        System.out.println(Baha.getHealth());
       Loay.fireball(Rhf);
       System.out.println(Rhf.getHealth());
       Loay.heal(Rhf);
       System.out.println(Rhf.getHealth());

       Abed.deathBlow(Baha);
       System.out.println(Baha.getHealth());
       Abed.meditate();
       System.out.println(Abed.getHealth());


       Tareq.steal(Loay);
       Tareq.runaway();
       System.out.println(Loay.getHealth());

        System.out.println("We have " +Abed.howMany()+" Samurai");

        //howMany static method
        //System.out.println(Samurai.howMany_statics());
    }

}
