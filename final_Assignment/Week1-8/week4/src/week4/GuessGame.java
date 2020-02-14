package week4;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Enter your number");
		int userInput=s.nextInt();	
		String feedback;
		boolean result=false;
		int lowerNum=1;
		int higherNum=20000;
		int attempts=0;
		int compGuess=r.nextInt((higherNum-lowerNum)+1)+lowerNum;
		int midVal=0;
		while (result==false) {
			
			if (userInput<1||userInput>20000) {
				System.out.println("Please enter a valid number");
				userInput=s.nextInt();
				
			}
			else {
				System.out.println("My guess is: "+ compGuess);
				if (userInput==compGuess) {
					System.out.println("Your number is correctly guessed ");
					result=true;
					
				}
				else {
					System.out.println("Was my guess high or low?Enter 'h' for high and 'l for low'");
					feedback=s.next();
					feedback = feedback.toLowerCase();
					
					if (feedback.equals("h") || feedback.equals("l")) {
						if (feedback.equals("h")) {
							higherNum=compGuess;
							midVal=(higherNum-lowerNum)/2+lowerNum;
							//higherNum=midVal;						
						}
						else if (feedback.equals("l")) {
							lowerNum=compGuess;
							midVal=(higherNum-lowerNum)/2+lowerNum;
							//lowerNum=midVal;			
						}
						if (midVal>userInput) {
							higherNum=midVal-1;
						}
						else {
							lowerNum=midVal+1;
						}
							compGuess=r.nextInt((higherNum-lowerNum)+1)+lowerNum;
							attempts++;
					}
					else
					{
						System.out.println("Please enter a valid feedback! Try again");
					}
					
					
				}
			}
			if (userInput==midVal) {
				System.out.println("My guess is :" + midVal);
				System.out.println("Your number is correctly guessed ");
				result=true;
			}
			
		}
		System.out.println("Your number was correctly guessed in "+attempts+" attempts");
	}	
}
