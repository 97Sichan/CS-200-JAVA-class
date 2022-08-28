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
public class DrawRightTriangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char symbol;
		int height;
		System.out.print("Enter a character: ");
		symbol = input.next().charAt(0);
		
		System.out.print("Enter triangle height (1-10): ");
		height = input.nextInt();
		
		while(height<1||height>10) {
			System.out.print("Please enter height between 1 and 10.\n");
			height = input.nextInt();
		
		}
		System.out.println();
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(symbol+" ");
			}
			System.out.println("");
		}
		

	}

}
