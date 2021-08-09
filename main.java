import java.util.*;

public class Main {
    
    static Scanner cin = new Scanner(System.in);
    
    static char playerHasWon(char[][] board) { //to see if someone has won and return the winning char
        boolean resX = false;
        boolean resO = false;
        
	//Check each row
	for (int i = 0; i < 3; i++) {
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
			if (board[i][0] == 'X') {
                    		resX = true;
                	} else {
                    		resO = true;
                	}
		}
	}

	//Check each column
	for (int j = 0; j < 3; j++) {
		if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
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
	if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
		return board[0][0];
	}
	if (board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != ' ') {
		return board[2][0];
	}

	//Otherwise nobody has not won yet
	return '_';
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
    
    static boolean stateRes(char[][] board) { // to analyze the game state
        char whoWon = playerHasWon(board); 
        if (whoWon == '_') {
            return false;
        } else if(whoWon == 'I') {
            System.out.println("Impossible");
            return true;
        } else {
            System.out.println(Character.toString(whoWon) + " wins");
            return true;
        }
    }
    
    static void interact(char[] cellsArr) { //to interact with the tic tac toe
        int x = 0;
        int y = 0;
        int k = 0;
        char[][] board = board3D(cellsArr);
        boolean res = false;
        while (k < 9) {
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
            } else if (board[x-1][y-1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                if (k % 2 == 0) {
                    board[x-1][y-1] = 'X';
                } else {
                    board[x-1][y-1] = 'O';
                }
                printRes(to2D(board));
                if (k > 5) {
                    res = stateRes(board);
                    if (res == true) {
                        break;
                    }
                }
                k++;
            }
        }
        if (!res) {
            System.out.println("Draw");
        }
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
        char[] cellsArr = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        printRes(cellsArr); 
        interact(cellsArr); 
    }
}
