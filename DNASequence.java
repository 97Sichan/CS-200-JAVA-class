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
import java.util.ArrayList;
import java.util.Scanner;

public class DNASequence {

   /**
     * adds a nucleotide to the given ArrayList of Characters
     * All nucleotides characters should be convereted to upperCase
     *
     * @param DNA the DNA sequence to add the nucleotide to
     * @param nucleotide the Character that should be added to the DNA sequence, or null if the DNA is null
     */
   public static void addNucleotide(ArrayList<Character> DNA, Character nucleotide) {
      if(DNA == null) return;
      DNA.add(String.valueOf(nucleotide).toUpperCase().charAt(0));
   }

   /**
     * creates a String representing the given DNA sequence
     *
     * @param DNA the DNA sequence to create a String from
     * @return the String representation of the DNA sequence, or null if either input is null
     */
   public static String getSequence(ArrayList<Character> DNA) {
      if(DNA == null) return null;
      String seq = "";
      for(int i = 0; i < DNA.size(); i++) {
         seq += DNA.get(i);
      }
      return seq;
   }

   /**
    * add to this method using the inline comments as a guide
    */
   public static void main(String[] args) {

      ArrayList<Character> DNA = new ArrayList<Character>();
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter number of nucleotides: ");
      // read in the number of nucleotides for this DNA sequence
      // if the number entered is 0 or less, print "No nucleotides available to generate DNA!" and exit
      int n = sc.nextInt();
      sc.nextLine();
      if(n <= 0) {
         System.out.println("No nucleotides available to generate DNA!");
         
      }
      else {
         int i = 0;
         System.out.println("Enter each nucleotide on a new line:");
         while (i <n) {
            char ch = sc.nextLine().toUpperCase().charAt(0);
            if(ch == 'A'|| ch == 'C' || ch =='G'||ch == 'T') {
               addNucleotide(DNA, ch);
               i++;
            }
         }
         System.out.println("The DNA sequence you entered is "+ getSequence(DNA));
      }
      
      

      


      

   }

}