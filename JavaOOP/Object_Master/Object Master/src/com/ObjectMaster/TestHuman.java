package com.ObjectMaster;

public class TestHuman {
    public static void main(String[] args) {
        Human Rhf = new Human();
        Human Baha = new Human();
        Rhf.attack(Baha);
        System.out.println(Baha.getHealth());
    }

}
