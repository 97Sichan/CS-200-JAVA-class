///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           hotDogDector
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
import java.util.Scanner;
public class TextConverter {

	public static String action1337(String current) {
		/**
	     * 1337 - convert the string to leet-speak:
	     *   Replace each L or l with a 1 (numeral one)
	     *   Replace each E or e with a 3 (numeral three)
	     *   Replace each T or t with a 7 (numeral seven)
	     *   Replace each O or o with a 0 (numeral zero)
	     *   Replace each S or s with a $ (dollar sign)
	     *    
	     * @param current Original string
	     * @return string converted to leet-speak.
	     */
		current = current.replace('L', '1');
		current = current.replace('l', '1');
		current = current.replace('E', '3');
		current = current.replace('e', '3');
		current = current.replace('T', '7');
		current = current.replace('t', '7');
		current = current.replace('O', '0');
		current = current.replace('o', '0');
		current = current.replace('S', '$');
		current = current.replace('s', '$');
		return current;

	}
	/**
     *  tests action1337 method with various cases to ensure it is working
     *  correctly.
     */
	public static void testAction1337(){
		boolean error = false;
		
		String input1 = "LEets";
		String expected1 = "1337$";
		String result1 = action1337(input1);
		if( !result1.equals(expected1)) {
			error = true;
			System.out.println("1) testAction1337 with input " + input1 + ", expected: " + expected1 + " but result:" + result1);
			
		}
		String input2 = "A";
		String expected2 ="A";
		String result2 = action1337(input2);
		if( !result1.equals(expected2)) {
			error = true;
			System.out.println("1) testAction1337 with input " + input2 + ", expected: " + expected2 + " but result:" + result2);
			
		}
		
		String input3 = "L";
		String expected3 = "1";
		String result3 = action1337(input3);
		if( !result1.equals(expected3)) {
			error = true;
			System.out.println("1) testAction1337 with input " + input3 + ", expected: " + expected3 + " but result:" + result3);
			
		}
		if(error) {
			System.out.println("testAction1337 failed");
		}
		else {
			System.out.println("testAction1337 passed");
		}
	}
	/**
     * This reverses the order of characters in the current string. 
     * @param current  Original string to be reversed.
     * @return  The string in reversed order.
     */
	public static String actionReverse(String current) {
		StringBuilder originalStr = new StringBuilder(current);
		
		
		return originalStr.reverse().toString();
		
	}
	
	 /**
     *  tests actionReverse method with various cases to ensure it is working
     *  correctly. 
     */
	public static void testActionReverse() {
		boolean error = false;
		
		String input1 = "ABC";
		String expected1 = "cbA";
		String result1 = actionReverse(input1);
		if(!result1.equals(expected1)) {
			error = true;
			System.out.println("1) testActionReverse with input " + input1 + ", expected: " + expected1 + " but result:" + result1);
			
		}
		String input2 = "Sichan";
		String expected2 = "nahcIS";
		String result2 = actionReverse(input2);
		if(!result2.equals(expected2)) {
			error = true;
			System.out.println("1) testActionReverse with input " + input2 + ", expected: " + expected2 + " but result:" + result2);
		}
		
		String input3 = "Wisconsin";
		String expected3 = "nisnocSIW";
		String result3 = actionReverse(input3);
		if(!result3.equals(expected3)) {
			error = true;
			System.out.println("1) testActionReverse with input " + input3 + ", expected: " + expected3 + " but result:" + result3);
		}
		
		//FIX ME
        //add at least 2 other test cases. What edge cases can you think of?
		
		if(error) {
			System.out.println("testActionReverse failed");
		}
		else {
			System.out.println("testActionReverse passed");
		}
	}
	
	/**
     * Provides the main menu for the text converter and calls methods based
     * on menu options chosen.
     * @param args
     */
	public static void main(String[]args) {
		Scanner scnr = new Scanner(System.in);
		String input, action;
		boolean flag = true;
		System.out.println("Welcome to the Text Converter.");
		System.out.println("Available Actions:");
		System.out.println("  1337) convert to 1337-speak");
		System.out.println("  rev) reverse the string");
		System.out.println("  quit) exit the program");
		System.out.println();
		System.out.print("Please enter a string: ");
		input = scnr.nextLine();
		do {
		System.out.print("Action (1337, rev, quit): ");
		action = scnr.nextLine();
		
			if(action.equals("1337")) {
				input = action1337(input);
				
			}
			else if(action.equals("rev")) {
				input = actionReverse(input);
				
			}
			else if(action.equals("quit")) {
				flag = false;
				System.out.println("See you next time!");
			}
			else {
				System.out.println("Unrecognized action.");
			
		}
		if(flag) {
		System.out.println(input);
		
		}
		}while(flag);
	
	}
}
	
	


