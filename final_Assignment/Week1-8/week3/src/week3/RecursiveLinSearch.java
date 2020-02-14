package week3;

import java.util.Scanner;

public class RecursiveLinSearch {
	 public static void main(String[] args)  
     { 
    	 int ar[] = {1,2,3,4,5,6,7,8,9,10};
    	 int number,length;
    	 Scanner s=new Scanner(System.in);
    	 System.out.println("Enter the number you want to search");	
         number=s.nextInt();
         s.close();
         length=ar.length-1;
          
        int index = linearSearch(ar, 0, length, number); 
        if (index == -1) 
        	System.out.println(number + " is not present in any index"); 
            
        else
        	System.out.println(number + " is at index " +index);
        } 
     static int linearSearch(int ar[], int index, int length, int number) 
     { 
          if (length < index) 
             return -1; 
          if (ar[index] == number) 
             return index; 
          if (ar[length] == number) 
             return length; 
          return linearSearch(ar, index+1, length-1, number); 
     } 
       
}
