public class Main {
    public static void main(String[] args) {
        Function basic = new Function();
        basic.oneTo255();
		// System.out.println();
        
        Function date = new Function();
        String todayDate = date.getCurrentDate();
        System.out.println();
        System.out.println(todayDate);
	}
}

