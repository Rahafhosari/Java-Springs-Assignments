public class Project {
    private String name = ""; //may be initalized to an empty string > private STring name = "";
    private String description= "";
    private double intialcost =0.0;
    
    //Constructors
//1
    public Project() {}
//2
    public Project(String name) {
        this.name = name;
    }
//3
    public Project(String name, String description, double intialcost) {
        this.name = name;
        this.description = description;
        this.intialcost = intialcost;
    }
    //Getters
    public String getName(){
        return this.name;
        // or return name;
    }
    public String getDesc(){
        return this.description;
        // or return description;
    }
    public double getcost(){
        return this.intialcost;
    }

    //Setters (we're using void because we're not retuning anything we're just setting)
    public void setName (String name){
        this.name = name; //= name is the parameter I am passing
    }
    public void setDesc (String description){
        this.description = description; //= name is the parameter I am passing
    }
    public void setcost (double intialcost){
        this.intialcost = intialcost; 
    }

    //A Custom getter method that combines two attributes 
    public String elevatorPitch(){
        return this.name +":"+ this.description + ", This project costs"+ this.intialcost+"$";
    }
    public static String test(){ //allows you to call a fucntion that doesn't require an instant
        return "This is a Test!";
    }
}

//Constructor takes the same name as the class