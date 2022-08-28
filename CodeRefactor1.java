///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           CodeRefactor1
// Course:          CS 200, Spring, 2020
//
// Author:          Sichan Kim
// Email:           skim932@wisc.edu 
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// https://cs200-www.cs.wisc.edu/wp/syllabus/#academicintegrity
// Source or Recipient; Description
// 
// 
// 
//         
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.util.Arrays; 
import java.util.Scanner;
public class CodeRefactor1 {

	public static void main(String[] args) {
		    System.out.println("Code Refactor 1");
	        System.out.println("Example output for methods");
	        int[] arrayNumbers1 = {3, 4, 5, 2, 0};
	        display("one:", arrayNumbers1);
	        char[] arrayCharacters = {'a', 'b', 'c', 'd', 'e'};
	        shiftCharacters(arrayCharacters, 2);
	        System.out.print("after two: ");
	        System.out.println(arrayCharacters);
	        int[] arrayNumbers2 = {1234, 3764, 20947, 20001, 9099};
	        System.out.println("after three: " + myMaxElement(arrayNumbers2));
	        int[] arrayNumbers3 = {8, 7, 3, 4, 5, 0, 1};
	        reversedList(arrayNumbers3, true);
	        System.out.println("after four: " + Arrays.toString(arrayNumbers3));
	        Scanner sc = new Scanner("-5 6 error 25 happy 20 14 end");
	        int r = myEnterInput(sc, "Enter a number between 10 and 20, inclusive", 10, 20);
	    }
	/**
     * This method prints the description followed by the contents of list.
     * The list begins with '[', ends with ']' and each element is separated
     * with ', '.
     * Example: display( "a description", new int[]{1,2,3})
     * a description [1, 2, 3]
     * @param description The text printed out before the list of integers.
     * @param list1 The array of integers to be printed.
     */
	    public static void display(String depiction, int[] list1) {
	        System.out.print(depiction);
	        System.out.print(" [");
	        for (int i = 0; i < list1.length; i ++) {
	            if (i > 0) {
	                System.out.print(", ");
	            }
	            System.out.print(list1[i]);
	        }
	        System.out.println("]");
	    }
	    
	    public static void shiftCharacters(char[] list, int numCharShift) {
	        for (int i = 0; i < numCharShift; i++) {
	            char s = list[list.length - 1];
	            for (int j = list.length - 1; j > 0; j --) {
	                list[j] = list[j - 1];
	            }
	            list[0] = s;
	        }
	    }
	   
	    public static int myMaxElement(int[] list) {
	        int max1;
	        max1 = list[0];
	        int i;
	        for (i = 0; i < list.length; i++) {
	           if (list[i] > max1){
	               max1 = list[i];
	           }
	        }
	        return max1;
	    }
	  
	    public static void reversedList(int[] list, boolean reversedList2) {
	        int temp1;
	        int i;
	        int j;
	        for (i = 0; i < list.length; i++) {
	            for ( j = i + 1; j < list.length; j ++) {
	                if (reversedList2) {
	                    if (list[i] > list[j]) {
	                        temp1 = list[i];
	                        list[i] = list[j];
	                        list[j] = temp1;
	                    }
	                    else {
	                        if (list[i] < list[j]) {
	                            temp1 = list[i];
	                            list[i] = list[j];
	                            list[j] = temp1;
	                        }
	                    }
	                }
	            }
	        }
	    }
	   
	    public static int myEnterInput(Scanner sc, String memo, int lowLimitation, int highLimitation) {
	        System.out.println(memo);
	        boolean someLimits = false;
	        int num1 = 0;
	        do {
	            if (sc.hasNextInt()) {
	                num1 = sc.nextInt();
	                if (num1 >= lowLimitation && num1 <= highLimitation) 
	                    someLimits = true;
	                
	                else 
	                    System.out.println("Value must be between " + lowLimitation + " and " + highLimitation + ".");
	                
	            }
	            else 
	                sc.next();
	            
	        } while (!someLimits);
	        return num1;

	}

}
