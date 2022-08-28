///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           CodeRefactor2
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
import java.util.Random;
import java.util.Scanner;

public class CodeRefactor2 {
    
    //What do these magic numbers do? Should they be final?
	/** mn1 is same with nominatedValue
	 *  mn2 is same with myEmpty
	 *  mn3 is same with someOfPlayer
	 *  mn4 is same with computerPlayer
	 *  mn5 is same with boardOfSize
	 *  mn6 is same with anyMessage
	 *  they should be final
	 */
    static int nominatedValue = -1;
    final static int myEmpty = 0;
    final static int someOfPlayer = 1;
    final static int computerPlayer = 2;
    static int boardOfSize = 3;
    static String[] anyMessage = {"","You", "The computer"};

    
    /** Run a game of tic-tac-toe
     * 
     * @param args used for zybooks testing only
     */
    public static void main (String[] args) {
        //initalize scanner and random. args will only by used for zybooks tests
        Scanner scnr = null;
        if (args.length == 0) scnr = new Scanner(System.in);
        else scnr = new Scanner(args[0]);
        Random rand = null;
        if (args.length > 1) rand = new Random(Integer.parseInt(args[1]));
        else rand = new Random();

        System.out.println("Welcome to tic-tac-toe. \nOn your turn, just select a box from 1 - 9 to add your token");
        int[][] board = new int[boardOfSize][boardOfSize];
        int startingPlayer = rand.nextInt(2) + 1;
        System.out.println(anyMessage[startingPlayer] + " will start first");
        int currentPlayer = startingPlayer;
        
        printBoard(board);
        while(!gameOver(board)) {
            int move = nominatedValue;
            while(!isValidMove(board, move)) {	
                if(currentPlayer == someOfPlayer) {
                    move = playerMove(board, scnr);
                }	
                else {
                    move = computerMovement(board, rand);
                    }
                }
            System.out.println(anyMessage[currentPlayer] + " chose square " + (move+1));
            setMark(board, move, currentPlayer);
            currentPlayer = 3 - currentPlayer;
            printBoard(board);
        }
        scnr.close();
        System.out.println("Thank you for playing");
    }
    
    /** Get the next movement of the someOfPlayer
     * @param board an array containing the current status of each position
     * @param scanner to scan get the user input
     * @return move of the player
     */
    public static int playerMove(int[][] board, Scanner scanner) {
        int selectedMove =  nominatedValue;
        System.out.println("Please select a valid move");
        while(!scanner.hasNextInt()) {
            System.out.println("invalid input");
            scanner.nextLine();
        }
        selectedMove = scanner.nextInt() - 1;
        if(!isValidMove(board, selectedMove)) System.out.println("invalid move");
        return selectedMove;
    }

    /** Get the computerPlayer movement
     * @param board an array containing the current status of each position
     * @param random to generate the random number
     * @return move of the computer
     */
    public static int computerMovement(int[][] board, Random random) {
        int generatedMove = searchMove(board);
        if(!isValidMove(board, generatedMove)) generatedMove = stopPlayer(board);
        while(!isValidMove(board, generatedMove)) {
            generatedMove = random.nextInt(boardOfSize * boardOfSize);
        }
        return generatedMove;
    }
    
    /** finds the move for the computerPlayer
     * @param board an array containing the current status of each position
     * @return optimal move for computerPlayer to win 
     */
    public static int searchMove(int[][] board) {
        for(int i = 0; i < boardOfSize * boardOfSize; i ++) {
            int[][] tempBoard = copyBoard(board);
            if(!isValidMove(tempBoard, i)) continue;setMark(tempBoard, i, computerPlayer);
            int value = checkStatusOfWinning(board, tempBoard, computerPlayer,i);
            if(value == i) return i;
                
    }
        return nominatedValue;
        
    }

    /** Not make someOfPlayer to win
     * @param board an array containing the current status of each position
     * @return optimal movement for computerPlayer to win 
     */
    public static int stopPlayer(int[][] board) {
        for(int i = 0; i < boardOfSize * boardOfSize; i ++) {
            int[][] tempBoard = copyBoard(board);
            if(!isValidMove(tempBoard, i)) continue;setMark(tempBoard, i, someOfPlayer);
            int value = checkStatusOfWinning(board,tempBoard,someOfPlayer,i);
            if(value == i) return i;
        }
            return nominatedValue;
            		
    }
        public static int checkStatusOfWinning(int[][]board,int[][] tempBoard, int playerToCheck, int i) {
        	if(tempBoard[1][1] == playerToCheck) {
        		if(tempBoard[0][0] == playerToCheck && tempBoard[2][2] == playerToCheck) return i;
        		if (tempBoard[0][2] == playerToCheck && tempBoard[2][0] == playerToCheck) return i; 
        		if (tempBoard[0][1] == playerToCheck && tempBoard[2][1] == playerToCheck) return i; 
        		if (tempBoard[1][0] == playerToCheck && tempBoard[1][2] == playerToCheck) return i; } 
        		if (tempBoard[0][0] == playerToCheck) { if (tempBoard[0][1] == playerToCheck && tempBoard[0][2] == playerToCheck) return i; 
        		if (tempBoard[1][0] == playerToCheck && tempBoard[2][0] == playerToCheck) return i; } 
        		if (board[2][2] == playerToCheck) { 
        		if (board[0][2] == playerToCheck && board[1][2] == playerToCheck) return i; 
        		if (board[2][0] == playerToCheck && board[2][1] == playerToCheck) return i;
        		
        	}
        		return nominatedValue;
        }
    
    /** Copies the board into a new two dimensional array
     * 
     * @param board an array containing the current status of each position
     * @return a copy of the original board
     */
    public static int[][] copyBoard(int[][] board){
        int[][] tmpBoard = new int[boardOfSize][];
        for(int row = 0; row < boardOfSize; row++) {
            tmpBoard[row] = board[row].clone();
        }
        return tmpBoard;
    }

    /** Checks if a box is available for a given move
     * 
     * @param board an array containing the current status of each position
     * @param move the position to add to the board
     * @return if the addition was successful
     */
    public static boolean isValidMove(int[][] board, int move) {
        if(move < 0 || move >= boardOfSize * boardOfSize) return false;
        if(getMark(board, move) != myEmpty) return false;
        return true;
    }
    
    /** Returns the current mark for a box on a board
     * 
     * @param board an array containing the current status of each position
     * @param box the position to query
     * @return the current mark at the given position
     */
    public static int getMark(int[][] board, int box) {
        return board[(box) / boardOfSize][(box) % boardOfSize];
    }

    /** Sets the mark for a box on a board
     * 
     * @param board an array containing the current status of each position
     * @param box the position to update
     * @param player the value to use for the update
     */
    public static void setMark(int[][] board, int box, int player) {
        board[(box) / boardOfSize][(box) % boardOfSize] = player;
    }
    
    /** Checks to see if the game is over via a win or tie
     * 
     * @param board an array containing the current status of each position
     * @return true if the game is tied or one player won
     */
    public static boolean gameOver(int[][] b) {
        for(int p = someOfPlayer; p <= computerPlayer; p ++) {
            if(b[1][1] == p) {
                if(b[0][0] == p && b[2][2] == p){
                    System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                    return true;
                }
                if(b[0][2] == p && b[2][0] == p){System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                return true;}
                if(b[0][1] == p && b[2][1] == p) {System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                return true;}; 
                if(b[1][0] == p && b[1][2] == p) {System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                return true;}}
            if(b[0][0] == p) {
                if(b[0][1] == p && b[0][2] == p) {System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                return true;}
                if(b[1][0] == p && b[2][0] == p) {System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                return true;}
            }
            if(b[2][2] == p) {
                if(b[0][2] == p && b[1][2] == p) {System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                return true;}
                if(b[2][0] == p && b[2][1] == p) {System.out.println(anyMessage[p] + ((p == someOfPlayer)?" win":" wins"));
                return true;}
            }
        }
        if(tie(b)) return true;
        return false;
    }
    
    /** Determines if the game is tied
     * 
     * @param board an array containing the current status of each position
     * @return true if the game ended in a tie
     */
    public static boolean tie(int[][] board) {
        for(int[] row : board) {
            for(int val : row) {
                if(val == myEmpty) return false;
            }
        }
        System.out.println("The game ends in a tie");
        return true;
    }
    
    
    /** Prints the board to the screen
     * 
     * @param board an array containing the current status of each position
     */
    public static void printBoard(int[][] board) {
        int curSpace = 0;
        System.out.println("-------");
        for(int[] row : board) {
            System.out.print("|");
            for(int val : row) {
                curSpace ++;
                char curChar;
                switch(val) {	
                    case myEmpty:
                        curChar = (char) (curSpace + '0');
                        break;
                    case someOfPlayer:
                        curChar = 'X';
                        break;
                    default:
                        curChar = 'O';
                }
                System.out.print(curChar);
                System.out.print('|');
            }
            System.out.println();System.out.println("-------");
        }
    }
}
