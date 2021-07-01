public class FizzBuzz {
    public static String fizzBuzz(int number) {
        if ((number % 5 == 0) && (number % 3 == 0)) {
            String print = "FizzBuzz";
            System.out.print("FizzBuzz"+"\n");
            return print;
        }
        else if (number % 3 == 0) {
            String print = "Fizz";
            System.out.print("Fizz"+"\n");
            return print;
        } 
        else if (number % 5 == 0) {
            String print = "Buzz";
            System.out.print("Buzz"+"\n");
            return print;
        } 
        else {
            String output = "Number:" + number;
            System.out.print("Number:" + number+"\n");
            return output;
        }
    }
    // FizzBuzz Function
    public static void main(String[] args) {
        fizzBuzz(3);
        fizzBuzz(5); 
        fizzBuzz(15);
        fizzBuzz(2);
        fizzBuzz(0);
        fizzBuzz(1);
    }
   
}
