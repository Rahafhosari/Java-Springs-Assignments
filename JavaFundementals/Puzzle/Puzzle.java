import java.util.*;

public class Puzzle {
    public static void main(String[] args) {
        //int[] arr={3,5,1,2,7,9,8,13,25,32};
        //greater10(arr);
        //String[] arr={"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        //shuffle(arr);
        randomNum(55,100); 
    }

//Return the sum of the array and a new array containing indicies greater than 10
    public static ArrayList<Integer> greater10(int arr[]) {
        int sum =0;
        ArrayList<Integer> newarr = new ArrayList<Integer>();
        for(int i=0; i<arr.length;i++){
            sum += i;
        }
        System.out.println("The sum ="+sum);
        //for second part define a new array
        for(int i=0; i<arr.length;i++){
            if (arr[i] > 10) {
                newarr.add(arr[i]);
            }
        }
        System.out.println(newarr);
        return newarr;
    }
//Suffle array, return new array with names more than 5 characters
    public static ArrayList<String> shuffle(String[] arr){
        ArrayList<String> names = new ArrayList<String>();
        Random rand = new Random();
        for (int i=0; i< arr.length; i++){
            int randomstr = rand.nextInt(arr.length);
            String temp = arr[randomstr];
            arr[randomstr] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
        for (int i=0; i< arr.length; i++){
            if ((arr[i].length()) >= 5){
                names.add(arr[i]);
            }
        }
        return (names);
    }
//Alpahbet
public static void AlphabetPuzzle(char[] alphabet) {
    shuffeArray(alphabet);
    System.out.println(String.format("%s is first", alphabet[0]));
    System.out.println(String.format("%s is last", alphabet[25]));
    if(isVowel(alphabet[0]))
        System.out.println("ITS A VOWEL");
}
private static boolean isVowel(char letter) {
    Random r = new Random();
    return (
        letter == 'a' ||
        letter == 'e' ||
        letter == 'i' ||
        letter == 'o' ||
        letter == 'u' ||
        // y is sometimes a vowel lol
        (letter == 'y' && r.nextInt(2) == 1)
        );
}
// 10 random numbers between 55-100.
    public static int[] randomNum(int lowerBound, int higherBound){
        int arr[] = new int[10];
        Random rand = new Random();
        int randnum = rand.nextInt(higherBound-lowerBound) + lowerBound;
        for (int i = 0; i < arr.length; i++) {
            //int randnum = rand.nextInt(arr.length);
            arr[i] = randnum;
        }
        Arrays.sort(arr);
        return arr;
    }
//Random string 
    public static String[] RandomStringArr() {
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = StringManipulator.RandomString(5);
        return arr;
    }
    // public static int[] randomNumsorted(){
    // }

}


//int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		// Random rand = new Random();
		
		// for (int i = 0; i < array.length; i++) {
		// 	int randomIndexToSwap = rand.nextInt(array.length);
		// 	int temp = array[randomIndexToSwap];
		// 	array[randomIndexToSwap] = array[i];
		// 	array[i] = temp;
        // }

