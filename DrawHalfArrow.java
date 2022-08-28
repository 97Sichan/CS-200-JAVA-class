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
public class DrawHalfArrow {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int arrowBaseHeight = 0;
		int arrowBaseWidth = 0;
		int arrowHeadWidth = 0;
		
		int i = 0;
		int j = 0;
		
		System.out.print("Enter arrow base height: ");
		arrowBaseHeight = scnr.nextInt();
		
		System.out.print("Enter arrow base width: ");
		arrowBaseWidth = scnr.nextInt();
		
		System.out.print("Enter arrow head width: ");
		arrowHeadWidth = scnr.nextInt();
		
		//make sure arrow head width is larger than base width
		while(arrowHeadWidth <= arrowBaseWidth) {
			System.out.print("Enter arrow head width: ");
			arrowHeadWidth = scnr.nextInt();
		}
		System.out.println();
		
		//draw arrow base
		for(i = 0; i < arrowBaseHeight; i++) {
			for(j = 0; j < arrowBaseWidth; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//draw arrow head
		for(i = arrowHeadWidth; i > 0; i--) {
			for(j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

}
