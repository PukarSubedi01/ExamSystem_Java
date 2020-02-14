package week4;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int length;
		System.out.println("Enter the length of an array");
		length = s.nextInt();
		int myArr[]= new int[length];
		for (int i = 0; i < myArr.length; i++) {
			System.out.println("Enter the value at index "+i);
			myArr[i]=s.nextInt();
		}
		Arrays.sort(myArr); //used to sort an array..
		System.out.println("Enter a number you want to search");
		int num=s.nextInt();
		int result = binarySearch(myArr,num);
		if (result == -1) 
            System.out.println(num +" not present"); 
        else
            System.out.println(num+ " found at "
                               + "index " + result); 
	}
	static int binarySearch(int[] arr,int number){
		int left=0; 
		int right=arr.length-1;
		while (left <= right) { 
            int midVal = left + (right - left) / 2; 
            if (arr[midVal] == number) 
                return midVal; 
  
            if (arr[midVal] < number) 
                left = midVal + 1; 
  
         
            else
                right = midVal - 1; 
        }  
        return -1; 
	
	}
}
