import java.util.*;

public class Main {
    
    static char playerHasWon(char[][] board) {
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
    
    static int[] countXO(char[] cellsArr) {
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
    
    static String stateRes(String cells) {
        char[] cellsArr = cells.toCharArray();
        
        int[] count = countXO(cellsArr); //to count number of X and O  
        if (Math.abs(count[0] - count[1]) > 1) {
            return "Impossible";
        }
        
        //making a 3D array
        char[][] board = new char[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cellsArr[k];
                k++;
            }
        }
        
        char whoWon = playerHasWon(board); //to see if someone has won and return the winning char
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
    
    static void printRes(String cells) {
        char[] cellsArr = cells.toCharArray();
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
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = cin.next();
        printRes(cells); // to print Tic Tac Toe Table
        System.out.println(stateRes(cells)); // to analyze the game state
    }
}
