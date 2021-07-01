// import java.util.*;
// public class exceptions {
//     public static void main(String[] args) {
//         ArrayList<Object> myList = new ArrayList<Object>();
//         myList.add("13");
//         myList.add("hello world");
//         myList.add(48);
//         myList.add("Goodbye World");    

//         for(int i = 0; i < myList.size(); i++) {
//             try {
//             Integer castedValue = (Integer) myList.get(i);
//             }
//             catch(OutOfGasException e) {
//                 System.out.println(e);
//                 System.out.println("There's and Error in index"+i+"and the value that caused it is");
//             }
//         }
//     }
// }
import java.util.*;
public class ListsExceptions{
	public static void main(String[] args){
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add("13");
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");
	
		for(int i = 0; i < myList.size(); i++) {
		try {
				ArrayList<Object> newMyList = new ArrayList<Object>();
                Integer castedValue = (Integer) myList.get(i);
				newMyList.add(castedValue);
				System.out.println("New List: "+ newMyList);

            } catch(ClassCastException e ) {
                System.out.println(e);
				System.out.println("There's and Error in index "+i+" and the value that caused it is " + myList.get(i));
				System.out.println("Original List "+myList);
            }
		}
	}
}
