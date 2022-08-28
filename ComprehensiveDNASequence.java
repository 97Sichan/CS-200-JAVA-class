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

public class ComprehensiveDNASequence {

  
   public static void removeSequence(ArrayList<Character> DNA, String sequence) {
      if (DNA == null || sequence == null) {
         return;
      }
      sequence = sequence.toUpperCase();
      String newString1 = getSequence(DNA);
      for (int i = 0; i < newString1.length()-sequence.length() + 1; i++) {
         if (sequence.equals(newString1.substring(i, i+sequence.length()))) {
            newString1 = newString1.substring(0, i) + newString1.substring(i+sequence.length());
        
            DNA.clear();
            for (i = 0; i < newString1.length(); i++) {
               DNA.add(newString1.charAt(i));
            }
            System.out.println(newString1);
            return;
         }
      }
   }


   public static boolean containsSequence(ArrayList<Character> DNA, String sequence) {
      if (DNA == null || sequence == null) {
         return false;
      }
      sequence = sequence.toUpperCase();
      String newString2 = getSequence(DNA);
      for (int i = 0; i < newString2.length()-sequence.length() + 1; i++) {
         if (sequence.equals(newString2.substring(i, i+sequence.length()))) {
            return true;
         }
      } return false;
      
   }


   public static boolean containsNucleotide(ArrayList<Character> DNA, Character nucleotide) {
      if (DNA == null || nucleotide == null) {
         return false;
      }
      nucleotide = Character.toUpperCase(nucleotide);
      for (int i = 0; i < DNA.size(); i++) {
         if (DNA.get(i) == nucleotide) {
            return true;
         }
      }
      return false;

   }

   
   public static void swapNucleotide(ArrayList<Character> DNA, Character swap1, Character swap2) {
      if (DNA == null || swap1 == null || swap2 == null) {
         return;
      }
      swap1 = Character.toUpperCase(swap1);
      swap2 = Character.toUpperCase(swap2);

      for (int i = 0; i < DNA.size(); i++) {
         if (DNA.get(i) == swap1 || DNA.get(i) == swap2) {
            if (DNA.get(i) == swap1) {
               DNA.set(i, swap2);   
            } else {
               DNA.set(i, swap1);
            }
            
         }
      }
   }

   public static void addNucleotide(ArrayList<Character> DNA, Character nucleotide) {
      if (DNA == null || nucleotide == null) {
         return;
      }
      nucleotide = Character.toUpperCase(nucleotide);
      DNA.add(nucleotide);
   }

   public static String getSequence(ArrayList<Character> DNA) {
      String result = "";
      if (DNA == null) {
         return null;
      }
      for (char i : DNA) {
         result = result + i;
      }
      return result;
   }

   public static void main(String[] args) {

      ArrayList<Character> DNA = new ArrayList<Character>();
      Scanner sc = new Scanner(System.in);
      int myNum = 0;
      char myChar = 0;
      boolean myValid = true;
      char tempswap1;
      char tempswap2;
      char temp;
      String tempSeq;
      String removedSeq;

      System.out.print("Enter number of nucleotides: ");
      while (myValid) {
         myNum = sc.nextInt();
         if (myNum <= 0) {
            System.out.println("No nucleotides available to generate DNA!");
         } else {
            myValid = false;
         }
      }

      System.out.println("Enter each nucleotide on a new line:");
      for (int i = 0; i < myNum; i++) {
         myValid = true;
         while (myValid) {
            myChar = sc.next().charAt(0);
            if (!(myChar == 'a' || myChar == 'A' || myChar == 'c' || myChar == 'C' || myChar == 't'
                  || myChar == 'T' || myChar == 'g' || myChar == 'G')) {
            } else {
               myValid = false;
            }
         }
         addNucleotide(DNA, myChar);
      }

      System.out.print("The DNA sequence you entered is ");
      System.out.println(getSequence(DNA));

      System.out.print("Enter the nucleotide you want to swap: ");
      tempswap1 = sc.next().charAt(0);
      tempswap1 = Character.toUpperCase(tempswap1);

      System.out.print("Enter the nucleotide you want to swap it with: ");
      tempswap2 = sc.next().charAt(0);
      tempswap2 = Character.toUpperCase(tempswap2);

      System.out.print("The new DNA sequence is ");
      swapNucleotide(DNA, tempswap1, tempswap2);
      System.out.println(getSequence(DNA));

      System.out.print("Enter the nucleotide you want to look for: ");
      temp = sc.next().charAt(0);
      temp = Character.toUpperCase(temp);

      System.out.print("The nucleotide was ");
      if (containsNucleotide(DNA, temp) == false) {
         System.out.println("not found");
      } else {
         System.out.println("found");
      }

      System.out.print("Enter the sequence you want to look for: ");
      tempSeq = sc.next();
      tempSeq = tempSeq.toUpperCase();
      
      System.out.print("The sequence was ");
      if (containsSequence(DNA, tempSeq) == false) {
         System.out.println("not found");
      } else {
         System.out.println("found");
      }

      System.out.print("Enter the sequence you want to remove: ");
      removedSeq = sc.next();
      removedSeq = removedSeq.toUpperCase();
      
      System.out.print("The new DNA sequence is ");
      removeSequence(DNA, removedSeq);
      
   }

}