public class Mammal {
    protected int energyLevel = 100;

//Constructor
    public Mammal(){
        this.energyLevel = energyLevel;
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