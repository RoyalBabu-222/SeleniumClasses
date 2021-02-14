public class ReverseString {

	public static void main(String[] args) {

		String S1, S2="";
		
		java.util.Scanner input = new java.util.Scanner(System.in);
				
		System.out.println("Enter a String to reverse");
		
		S1= input.nextLine();
		
		int l = S1.length();
		
		for(int i=l-1;i>=0;i--)
			S2=S2+S1.charAt(i);
		
		System.out.println("Reverse of the String is: " +S2);
	}

}
