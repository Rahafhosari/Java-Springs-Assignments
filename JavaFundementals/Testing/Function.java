import java.util.Date;

public class Function {

    public static void oneTo255() {
        for (int i = 0; i<=255; i++){
            System.out.print(i +", ");
        }
    }

    public String getCurrentDate() {
        Date date = new Date();
        return "The Current date is: " + date;
    }
}

