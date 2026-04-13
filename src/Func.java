import java.util.Scanner;

public class Func {
    static public void menu() {
        System.out.println("=========Tic Tac Toe=========");
        System.out.println("||   Please select option  ||");
        System.out.println("||         1. Play         ||");
        System.out.println("||         2. Info         ||");
        System.out.println("||         3. Exit         ||");
        System.out.println("=============================");
    }

    static public void gamemode() {
        System.out.println("=========Tic Tac Toe=========");
        System.out.println("|| Please select game mode ||");
        System.out.println("||         1. Solo         ||");
        System.out.println("||         2. Duo          ||");
        System.out.println("||         3. Back         ||");
        System.out.println("=============================");
    }

    static public void info() {
        System.out.println("==========Game Info==========");
        System.out.println("||   The aim of the game   ||");
        System.out.println("||   is to arrange three   ||");
        System.out.println("||  characters in one row  ||");
        System.out.println("|| vertically, horizontally||");
        System.out.println("||       or diagonally     ||");
        System.out.println("|| The first player to put ||");
        System.out.println("|| the symbols in one line ||");
        System.out.println("||      wins the game!     ||");
        System.out.println("=============================");
    }

    static public void draw(Object[] board) {
        Game.displayBoard(board);
        System.out.println("============System===========");
        System.out.println("||       It's a draw!      ||");
        System.out.println("=============================");
    }

    static public void win(Object[] board, char player) {
        Game.displayBoard(board);
        System.out.println("============System===========");
        System.out.println("||      Player " + player + " wins!     ||");
        System.out.println("=============================");
    }

    static public void sysFarewell() {
        System.out.println("============System===========");
        System.out.println("||     See Ya next time!   ||");
        System.out.println("=============================");
    }

    static public void sysError() {
        System.out.println("============System===========");
        System.out.println("||   Oops! Wrong option!   ||");
        System.out.println("=============================");
    }

    static private Scanner scanner = new Scanner(System.in);

    static public int scanInt() {
        try {
            System.out.print(">> ");
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println(" Invalid input!");
            return scanInt();
        }
    }

    static public void closeScanner() {
        scanner.close();
    }
}
