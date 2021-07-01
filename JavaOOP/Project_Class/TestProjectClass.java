public class TestProjectClass {
    public static void main(String[] args) {
        //Project project1 = new Project();
        //Project project2 = new Project("COMANY");
        Project project3 = new Project("COMANY1","Telecommunication",5000.0);
        Project project4 = new Project("COMANY2","Telecommunication",3000.0);
        Project project5 = new Project("COMANY3","Telecommunication",4000.0);
        Portfolio porto1 = new Portfolio();
        //Adding projects to instance porto1 of Class Portfolio which takes an ArrayList
        porto1.setProjectDirectory(project3);
        porto1.setProjectDirectory(project4);
        porto1.setProjectDirectory(project5);

        //project3.setName("Axsos Acadey");
        //System.out.println(project3.elevatorPitch());
        //System.out.println(project2.getName());
        //System.out.println(project1.getDesc());
        System.out.println(Project.test());
    }
}
