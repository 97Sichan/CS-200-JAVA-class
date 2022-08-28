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
/**
 * The behavior of this code is different in Eclipse as compared to zyBooks.
 * Refactor the code so that it works in both zyBooks and Eclipse.
 * 
 * @author mrenault, Yanan
 *
 */
public class EclipseVsZyBooks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int a = readInt(sc);
		System.out.println("Enter a second integer: ");
		int b = readInt(sc);
		System.out.println("The integers you entered are " + a + " and " + b);
		compareValue(a, b);
        System.out.println("Enter a word:");
        String c = readWord(sc);
        System.out.println("Enter a second word: ");
        String d = readWord(sc);
        System.out.println("The words you entered are \"" + c + "\" and \"" + d + "\"");
        compareValue(c, d);
        
        
  
        


	}
	
	public static void  compareValue(String c, String d) {
		if(c.equals(d))
        	 System.out.println("The two words are the same");
        else
        	System.out.println("The two words are different");
        return;
	}
	public static void compareValue (int a, int b) {
		if (a == b)
		System.out.println(a + " equals " + b);
		else if (a<b)
			System.out.println(a + " is less than "+ b);
		else
			System.out.println(a+" is more than "+b);
	}
	public static int readInt(Scanner sc) {
		
		return sc.nextInt();
	}
	
	public static String readWord(Scanner sc) {
		
		return sc.next();
	}

}
