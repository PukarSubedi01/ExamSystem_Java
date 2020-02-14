package week3;

import java.util.Scanner;


public class RecursiveRevStr {
	  public static void main(String[] args)  
	    { 
	    	Scanner s = new Scanner(System.in);
	    	System.out.println("Please enter a word");
	        String str = s.nextLine(); 
	        RecursiveRevStr obj = new RecursiveRevStr(); 
	        System.out.println("The reverse is: " + obj.reverse(str)); 
	    }  
	  //Function to print reverse of the passed string 
	    public String reverse(String str) 
	    { 
	        if ((str==null)||(str.length() <= 1)) 
	           return str; 
	        else
	        { 
	        	return reverse(str.substring(1)) + str.charAt(0);
	        } 
	    } 
}
