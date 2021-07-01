import java.util.ArrayList;

public class HelloWorld {
    public static void main(String[] args) {
       //printNumbers();
        //printOddNumbers();
        //printSum();
        int[] array={1,2,3,4};
        //int y= 3;
        // iteratArray(array);
        //findMax(array);
        //getAvg(array);
        arrayOddNumbers();
        //greaterY(array, y);
        //square(array);
        //postiveArray(array);
        // int [] returnarray=sumMaxMin(array);
        // for (int i=0; i<returnarray.length ; i++){
        //     System.out.print(returnarray[i]+", ");
        // }
        shift(array);
    }

    public static void printNumbers(){
    for (int i=1; i<=255; i++) {
        System.out.print(i +", ");			
    }
} 
public static void printOddNumbers(){
    for (int i=1; i<=255; i++) {
        if (i%2!=0){
        System.out.print(i +", ");
        }			
    }
} 
public static void printSum(){
    int sum = 0;
    for (int i=0; i<=255; i++) {
        sum+=i;
        System.out.println("New num: "+ i +"|"+ "Sum: "+ sum);
    }
} 
public static void iteratArray(int[] array){
    for (int i=0; i<array.length ; i++) {
        System.out.println(array[i]); 			
    }
}
public static void findMax(int[] arr){
    int max = arr[0];
    for (int i=1; i<arr.length ; i++) {
        if(arr[i]>max){
            max = arr[i];
        }			
    }
    System.out.println(max); 
}
public static void getAvg(int[] arr){
    int sum = 0;
    for (int i=0; i<arr.length ; i++) {
        sum += arr[i];	
    }
    System.out.println(sum/arr.length); 
}
public static ArrayList<Integer> arrayOddNumbers(){
    ArrayList<Integer> y = new ArrayList<Integer>();
    for (int i=1; i<=255; i++) {
        if (i%2!=0){
            y.add(i);
        }			
    }
    System.out.println(y);
    return y;
} 
public static void greaterY(int[] arr, int y){
    int count = 0;
    for (int i=0; i<arr.length; i++) {
        if (arr[i]>y){
            count ++;
        }			
    }
    System.out.println(count);
} 
public static void square(int[] arr){
    for (int i=0; i<arr.length; i++) {
        arr[i] = arr[i]*arr[i];	
        System.out.println(arr[i]);		
    }
} 
public static void postiveArray(int[] arr){
    ArrayList<Integer> postivearr = new ArrayList<Integer>();
    for (int i=0; i<arr.length; i++) {
        if (arr[i]>=0){
            postivearr.add(arr[i]);
        }			
    }
    System.out.println(postivearr);
} 
public static int[] sumMaxMin(int[] arr){
    int sum = 0;
    int max=arr[0];
    int min=arr[0];
    int[] myArray = new int[3]; 
    for (int i=0; i< arr.length; i++) {
        sum+=arr[i];
        if (arr[i]<min){
            min=arr[i];
            
        }
        if (arr[i]>max){
            max=arr[i];
            
        }  
    }
    myArray[0]=min;
    myArray[1]=max;
    myArray[2]=sum/arr.length;
    return myArray;

} 
public static void shift(int[] arr){
    for(int i=0; i<arr.length-1; i++){
        arr[i]=arr[i+1];
    }
    arr[arr.length-1]=0;
    for (int i=0; i<arr.length; i++){
        System.out.println(arr[i]);
    }
    
}
}

