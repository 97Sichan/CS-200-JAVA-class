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
import java.util.Arrays;

public class TestDNASequence {
	
	/**
     * calls your addNucleotide method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testAddNucleotide() {
        System.out.println("Starting testAddNucleotide...");
        //Test 1
        {
            // this test adds two new nucleotides 'o' and 'k' to the DNA
			// then checks that they were correctly added and capitalized in the ArrayList
			ArrayList<Character> testDNA = new ArrayList<Character>();
            DNASequence.addNucleotide(testDNA, 'a');
            DNASequence.addNucleotide(testDNA, 't');
			
            if(!testDNA.get(0).equals('A') || !testDNA.get(1).equals('T')) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + 'A');
                System.out.println("    Result: " + testDNA.get(0));
                System.out.println("    Expected: " + 'T');
                System.out.println("    Result: " + testDNA.get(1));
                return false;
            }
        }
		
		// add more tests here
        ArrayList<Character> testDNA = new ArrayList<Character>();
        DNASequence.addNucleotide(testDNA, 'o');
        DNASequence.addNucleotide(testDNA, 'k');
		
        if(!testDNA.get(0).equals('O') || !testDNA.get(1).equals('K')) {
            System.out.println("  Test 1 failed!");
            System.out.println("    Expected: " + 'O');
            System.out.println("    Result: " + testDNA.get(0));
            System.out.println("    Expected: " + 'K');
            System.out.println("    Result: " + testDNA.get(1));
            return false;
        }
		
        System.out.println("...Done testAddNucleotide");
        return true;
    }
	
	/**
     * calls your getSequence method to verify correct behavior
     * add more tests to make sure that your method works in all cases
     */
    public static boolean testGetSequence() {
        System.out.println("Starting testGetSequence...");
        //Test 1
        {
            // this test makes a new DNA with the characters ATCGATCG
			// then checks that the resulting sequence is "ATCGATCG"
			ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('A', 'T', 'C', 'G', 'A', 'T', 'C', 'G'));
            String result = DNASequence.getSequence(testDNA);
            String expected = "ATCGATCG";
            
			if(!result.equals(expected)) {
                System.out.println("  Test 1 failed!");
                System.out.println("    Expected: " + expected);
                System.out.println("    Result: " + result);
                return false;
            }
        }
        
		// add more tests here
        ArrayList<Character> testDNA = new ArrayList<Character>(Arrays.asList('A', 'T', 'C', 'W', 'A', 'T', 'C', 'W'));
        String result = DNASequence.getSequence(testDNA);
        String expected = "ATCWATCW";
        
		if(!result.equals(expected)) {
            System.out.println("  Test 1 failed!");
            System.out.println("    Expected: " + expected);
            System.out.println("    Result: " + result);
            return false;
        }
		
		System.out.println("...Done testGetSequence");
        return true;
    }

    public static void main(String[] args) {
        testGetSequence();
		testAddNucleotide();
    }
    
}
