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


public class ReimbursementDatabase {
   public static String displayDatabase(ArrayList<ArrayList<ArrayList<String>>> database, ArrayList<String> names) {
      if (database == null || names == null) {
         return null;
      }
      String result = "";
      for (int i = 0; i < database.size(); i++) {
         result = result + "Expenses for " + names.get(i) + "\n";
         if (database.get(i).size() == 0) {
            result = result + "[ no expenses ]\n";
         }
         for (int j = 0; j < database.get(i).size(); j++) {
            if (database.get(i).get(j) == null || database.get(i).isEmpty()) {
               result = result + "[ no expenses ]\n";
            } else if (database.get(i).get(j) != null) {
               result = result + database.get(i).get(j) + "\n";
            }
         }
         result = result + "\n";
      }
      return result;
   }


   public static double totalExpensesClient(ArrayList<ArrayList<ArrayList<String>>> database, int tempNum) {
      if (database == null || tempNum < 0 || database.size() <= tempNum) {
         return -1;
      }
      if (database.get(tempNum) == null || database.get(tempNum).size() == 0) {
         return 0;
      }
      double result = 0;
      for (int i = 0; i < database.get(tempNum).size(); i++) {
         result = result + Double.valueOf(database.get(tempNum).get(i).get(2));
      }
      if (result == 0) {
         return 0;
      } else {
         return result;
      }
   }

  
   public static double totalExpenses(ArrayList<ArrayList<ArrayList<String>>> database) {
      if (database == null) {
         return -1;
      }
      double tempresult = 0;
      for (int i = 0; i < database.size(); i++) {
         tempresult = tempresult + totalExpensesClient(database, i);
      }
      return tempresult;
   }


   public static double averageExpensesClient(ArrayList<ArrayList<ArrayList<String>>> database, int clientNum) {
      if (database == null || clientNum < 0 || database.size() <= clientNum) {
         return -1;
      }
      if (database.get(clientNum) == null || database.get(clientNum).size() == 0) {
         return 0;
      }
      double result = 0;
      double num = 0;
      for (int i = 0; i < database.get(clientNum).size(); i++) {
         result = result + Double.valueOf(database.get(clientNum).get(i).get(Config.COST));
         num = num + 1;
      }
      result = result / num;
      if (result == 0) {
         return 0;
      } else {
         return result;
      }
   }

 
   public static double averageExpenses(ArrayList<ArrayList<ArrayList<String>>> database) {
      if (database == null) {
         return -1;
      }
      double result = 0;
      int num = 0;
      for (int i = 0; i < database.size(); i++) {
         result = result + averageExpensesClient(database, i);
         num = num + 1;
      }
      result = result / num;
      return result;
   }

   public static void reimburseClient(ArrayList<ArrayList<ArrayList<String>>> database, int clientNum) {
      if (database == null || clientNum < 0 || database.size() < clientNum) {
         return;
      }
      if (database.get(clientNum) == null) {
         return;
      }
      database.get(clientNum).clear();
   }


   public static String mostRecentExpense(ArrayList<ArrayList<ArrayList<String>>> database, int tempClientNum) {
      if (database == null || tempClientNum < 0 || database.size() <= tempClientNum) {
         return null;
      }
      if (database.get(tempClientNum) == null || database.get(tempClientNum).size() == 0) {
         return "[ no expenses ]";
      }
      String result;
      result = database.get(tempClientNum).get(database.get(tempClientNum).size() - 1).toString();
      if (result == null) {
         return null;
      }
      return result;
   }

 
   public static void main(String[] args) {
      ArrayList<ArrayList<ArrayList<String>>> database = Config.DATABASE;
      ArrayList<String> names = Config.NAMES;

      Config.menu(database, names);
   }
}