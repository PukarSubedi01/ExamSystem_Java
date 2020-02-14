package week1;

import java.util.Scanner;

public class CharReverse {
	private void reverse(String str){
		String reverse=""; //variable to store reverse word
		for (int i = str.length() - 1 ; i >= 0 ; i--)
		      reverse = reverse + str.charAt(i);
		System.out.print("The reverse of " + str +" is: "+ reverse);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a word or a sentence");
		String str = s.nextLine(); //variable to store user input
		CharReverse cR=new CharReverse();
		cR.reverse(str);
		

	}
}
