class Gorilla extends Mammal {
    // constructor
    public Gorilla() {
        super();
    }
    public Gorilla(int energyLevel){
        super();

    }
    public void throwSomething(){
        System.out.println("KingKong is throwing things!");
        energyLevel -= 5;
    }
    public void eatBananas(){
        System.out.println("KingKong is eating Bananas...mmm");
        energyLevel += 10;

    }
    public void climb(){
        System.out.println("KingKong climbing!");
        energyLevel -= 10;
    }
}


//throw at people -5 energy
//eat banana +10 energy
//climb -10 energy