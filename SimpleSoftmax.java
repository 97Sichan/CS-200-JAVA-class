///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           SimpleSoftmax
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
public class SimpleSoftmax {

    public static double[] softmax(double[] nonNormArr) {
        if (nonNormArr == null) {
              return null;
        }
        double sum_exps = 0;
        for (int i = 0; i < nonNormArr.length; i++) {
              sum_exps += Math.exp(nonNormArr[i]);
        }
        double normArray[] = new double[nonNormArr.length];
        for (int i = 0; i < nonNormArr.length; i++) {
              normArray[i] = Math.exp(nonNormArr[i]) / sum_exps;
        }
        return normArray;
  }
 
  public static int predictLabel(double[] normArr) {
        if (normArr == null || normArr.length == 0) {
              return -1;
        }
        
        int index_max = -1;
        
        for (int i = 0; i < normArr.length; i++) {
             
              if (index_max == -1 || normArr[i] > normArr[index_max]) {
                    index_max = i;
              }
        }
        return index_max;
  }
 
  public static double calcPredictionAccuracy(double[][] nonNormArrSeq,
              int[] groundTruthArr) {
        
        if (nonNormArrSeq == null || groundTruthArr == null
                    || nonNormArrSeq.length != groundTruthArr.length
                    || nonNormArrSeq.length == 0) {
              return -1;
        }
        int[] predictionArr = new int[nonNormArrSeq.length];
        
        for (int i = 0; i < nonNormArrSeq.length; i++) {
              
              double[] nonNormArr = nonNormArrSeq[i];
              
              double[] normArr = softmax(nonNormArr);
             
              predictionArr[i] = predictLabel(normArr);
        }
        int right = 0; 
        
        for (int i = 0; i < nonNormArrSeq.length; i++) {
              if (predictionArr[i] == groundTruthArr[i]) {
                    
                    right++;
              }
        }
      
        double accuracy = (double) right / nonNormArrSeq.length;
        return accuracy;

	}

}
