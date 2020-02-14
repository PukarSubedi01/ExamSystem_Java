package week2;

import java.util.Scanner;


public class Palindrome { 
	private void palin(String str) {
		String reverse="";	
		for (int i = str.length() - 1 ; i >= 0 ; i--)
		      reverse = reverse + str.charAt(i);
		if (str.equals(reverse)) {	
			System.out.println("The word is palindrome");
		}
		else
		{
			System.out.println("The word is not palindrome");
		}
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a word");	
		String str = s.nextLine(); 
		Palindrome p = new Palindrome(); 
		p.palin(str);
		

	}

}
