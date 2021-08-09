package tictactoe;
import java.util.*;

public class Main {
    
    static Scanner cin = new Scanner(System.in);
    
    static char playerHasWon(char[][] board) { //to see if someone has won and return the winning char
        boolean resX = false;
        boolean resO = false;
        
		//Check each row
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '_') {
				if (board[i][0] == 'X') {
                    resX = true;
                } else {
                    resO = true;
                }
			}
		}

		//Check each column
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '_') {
				if (board[0][j] == 'X') {
                    resX = true;
                } else {
                    resO = true;
                }
			}
		}
        
        //checking for both X and O winning
        if (resO == true && resX == true) {
            return 'I';
        } else if (resO == true) {
            return 'O';
        } else if (resX == true) {
            return 'X';
        }

		//Check the diagonals
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '_') {
			return board[0][0];
		}
		if (board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '_') {
			return board[2][0];
		}

		//Otherwise nobody has not won yet
		return '_';
	}
    
    static int[] countXO(char[] cellsArr) { //to count number of X O and _
        int[] count = new int[3];
        
        for (int i = 0; i < cellsArr.length; i++) {
            if (cellsArr[i] == 'X') {
                count[0]++;
            } else if (cellsArr[i] == 'O') {
                count[1]++;
            } else {
                count[2]++;
            }
        }
        return count;
    }
    
    static char[][] board3D(char[] cellsArr) { //making 3D array
        char[][] board = new char[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cellsArr[k];
                k++;
            }
        }
        return board;
    }
    
    static char[] to2D(char[][] board) { //to 2D array
        char[] cellsArr = new char[9];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellsArr[k] = board[i][j];
                k++;
            }
        }
        return cellsArr;
    }
    
    static String stateRes(char[] cellsArr) { // to analyze the game state
        int[] count = countXO(cellsArr); 
        if (Math.abs(count[0] - count[1]) > 1) {
            return "Impossible";
        }
        
        char[][] board = board3D(cellsArr);
        
        char whoWon = playerHasWon(board); 
        if (whoWon == '_') {
            if (count[2] == 0) {
                return "Draw";
            } else {
                return "Game not finished";
            }
        } else if(whoWon == 'I') {
            return "Impossible";
        } else {
            return Character.toString(whoWon) + " wins";
        }
    }
    
    static char[] interact(char[] cellsArr) { //to interact with the tic tac toe
        int x = 0;
        int y = 0;
        char[][] board = board3D(cellsArr);
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                x = cin.nextInt();
                y = cin.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x > 3 || x < 1 || y > 3 || y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (board[x-1][y-1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                board[x-1][y-1] = 'X';
                break;
            }
        }
        return to2D(board);
    }
    
    static void printRes(char[] cellsArr) { // to print Tic Tac Toe matrix
        System.out.println("---------");
        int k = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cellsArr[k] + " ");
                k++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    
    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String cells = cin.next();
        char[] cellsArr = cells.toCharArray();
        printRes(cellsArr); 
        //System.out.println(stateRes(cellsArr)); 
        printRes(interact(cellsArr)); 
    }
}
