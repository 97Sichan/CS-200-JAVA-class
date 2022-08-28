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
public class HotdogDetector {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String firstString;
		System.out.print("Enter a food: ");
		firstString = input.nextLine();

		if(firstString.trim().equals("hotdog"))
			System.out.println("hotdog");
		else
			System.out.println("not hotdog");


	}
}