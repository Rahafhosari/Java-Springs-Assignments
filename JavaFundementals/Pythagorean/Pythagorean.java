import java.lang.Math;

public class Pythagorean {
    //calculate Hypotenuse
    public static double pythagorean(int legA, int legB) {
        double hypo = Math.pow(legA,2) + Math.pow(legB,2);
        double hypotenuse = Math.sqrt(hypo);
        System.out.print(hypotenuse);
        return hypotenuse;
    }
    public static void main(String[] args) {
        int legA = 3;
        int legB = 4;
        pythagorean(legA, legB);
    }
}

