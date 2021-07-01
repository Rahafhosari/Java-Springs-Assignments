import java.util.ArrayList;

public class Portfolio {
    //because I am calling the instances from 
    private ArrayList<Project> proDirectory= new ArrayList<Project>();
    
    //Constructor
    public Portfolio(){}

    //Getter
    public ArrayList<Project> getProjectDirectory(){
        return this.proDirectory;
    }
    //Setter 
    public void setProjectDirectory(Project newProj){ //Iam setting an instance of the Object project
        this.proDirectory.add(newProj);
    }
    //Getting and displaying cost
    public double getPortfolioCost(){
        double sum = 0.0;
        for (int i = 0; i < proDirectory.size(); i++) {
            sum += this.proDirectory.get(i).getcost();
            //this.proDirectory.get(i) >> gets the whole project
        }
        return sum;
    }

    public void ShowPortfolio(){
        for (int i = 0; i < proDirectory.size(); i++) {
            System.out.println(this.proDirectory.get(i).elevatorPitch());
        }
        System.out.println(this.getPortfolioCost());
        //we used "this: in this.getPortfolioCost because the method is associated with an instance 
        //so when we call it we're 
    }
}
