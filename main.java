package tictactoe;
import java.util.*;

public class Main {
    
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
        printRes(cells);
    }
}
