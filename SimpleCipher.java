///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           SimpleCipher
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
public class SimpleCipher {

	  public static int[] encrypt(int[] toEnc, int[] key) {
          
          if (toEnc == null) {
                return null;
          }
          
          int result[] = new int[toEnc.length];
          
          for (int i = 0; i < toEnc.length; i++) {
               
                int c = toEnc[i] ^ key[i % key.length];
                
                result[i] = c;
          }
          return result;
    }

    public static int[] decrypt(int[] toDec, int[] key) {
          return encrypt(toDec, key);
    }
  
    public static char[] toCharArr(int[] intArr) {
          if (intArr == null) {
                return null;
          }
          char[] charArr = new char[intArr.length];
          for (int i = 0; i < intArr.length; i++) {
                charArr[i] = (char) intArr[i];
          }
          return charArr;
    }
   
    public static int[] toIntArr(char[] charArr) {
          if (charArr == null) {
                return null;
          }
          int[] intArr = new int[charArr.length];
          for (int i = 0; i < intArr.length; i++) {
                intArr[i] = charArr[i]; 
          }
          return intArr;
    }
  
    public static void main(String[] args) {
        
          int arr[] = { 'H', 'e', 'l', 'l', 'o' };
          int key[] = { 'f', 'o', 'o' };
         
          System.out.println(Arrays.toString(encrypt(arr, key)));
          
          System.out.println(toCharArr(encrypt(encrypt(arr, key), key)));
          
          System.out.println(toCharArr(decrypt(encrypt(arr, key), key)));
          
          
       
    }
		

	

}
