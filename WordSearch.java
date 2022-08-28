///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           TestSimpleSoftmax
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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class WordSearch {
   public static void main(String[] args) {
       testReadDictionary();
       testReadWordSearch();
   }
   
   public static ArrayList readDictionary(String dictionaryFilename) {
       ArrayList<String> animals = new ArrayList<>();
       FileInputStream filestream;
       try {
           filestream = new FileInputStream(dictionaryFilename);
           BufferedReader br = new BufferedReader(new InputStreamReader(filestream));
           String str = br.readLine();
           while (str != null) {
               animals.add(str);
               str = br.readLine();
           }
           br.close();
       } catch (FileNotFoundException e) {
           System.out.println(" Unable to read file " + dictionaryFilename);
          
       } catch (IOException e) {
           e.printStackTrace();
       }
       return animals;
   }
   /**
   * Opens and reads a wordSearchFileName file returning a block of characters.
   * Example: jwufyhsinf agzucneqpo majeurnfyt
   *
   * If there is an error reading the file, such as the file cannot be found, then
   * the following message is shown: Error: Unable to read file with replaced with
   * the parameter value.
   *
   * @param wordSearchFileName The dictionary file to read.
   * @return A 2d-array of characters representing the block of letters.
   */
   public static char[][] readWordSearch(String wordSearchFileName) {
       ArrayList<String> words = new ArrayList<>();
       FileInputStream filestream;
       try {
           filestream = new FileInputStream(wordSearchFileName);
           BufferedReader br = new BufferedReader(new InputStreamReader(filestream));
           String str = br.readLine();
           while (str != null) {
               words.add(str);
               str = br.readLine();
           }
           br.close();
       } catch (FileNotFoundException e) {
           System.out.println(" Unable to read file " + wordSearchFileName);
          
       } catch (IOException e) {
           e.printStackTrace();
       }
       char[][] charWords = new char[words.size()][];
       for (int i = 0; i < words.size(); i++) {
           charWords[i] = words.get(i).toCharArray();
       }
       return charWords;
   }
   public static void testReadDictionary() {
       // ADD TEST CASES
       ArrayList dictionaryWords;
      
       System.out.println("Positive Test Case for Dictionary Serach");
       String dictionaryFilePath = "C:\\PERSONAL\\CHEGG\\JAVA\\file\\dictionary.txt";
       dictionaryWords = readDictionary(dictionaryFilePath);
       System.out.println("Number of words found : "+dictionaryWords.size());
       System.out.println("They are : "+dictionaryWords.toString());
      
      
       System.out.println("\nNegative Test Case for Dictionary Serach");
       dictionaryFilePath = "C:\\PERSONAL\\CHEGG\\JAVA\\file\\dictionaryDummy.txt";
       dictionaryWords = readDictionary(dictionaryFilePath);
   }
   public static void testReadWordSearch() {
       // ADD TEST CASES
       char[][] wordsList;
      
       System.out.println("\n\nPositive Test Case for Word Serach");
       String wordFilePath = "C:\\PERSONAL\\CHEGG\\JAVA\\file\\wordsearch.txt";
       wordsList = readWordSearch(wordFilePath);
       System.out.println("Number of words found : "+wordsList.length);
      
       System.out.println("\nNegative Test Case for Word Serach");
       wordFilePath = "C:\\PERSONAL\\CHEGG\\JAVA\\file\\wordsearchDummy.txt";
       wordsList = readWordSearch(wordFilePath);
   }
}