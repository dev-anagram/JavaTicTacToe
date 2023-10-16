import java.util.Arrays;
import java.util.Random;


public class Game {
    static public Object[] cleanBoard() {
        Object[] board = new Object[9];
        int i = 0;
        while (i < 9) {
            board[i] = i + 1;
            i++;
        }
        return board;
    }

    static public void displayBoard(Object[] board) {
        System.out.println("============Board============");
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.print("||          ");
            } else if (i == 3 || i == 6) {
                System.out.print("\n||          ");

            }
            System.out.print(board[i] + " ");
            if(i == 2 || i == 5 || i == 8){
                System.out.print("          ||");
            }
        }
        System.out.println("\n=============================");
    }

    static public void playerPick(Object[] board, char player) {
        Game.displayBoard(board);
        System.out.println("Player "+player+" place your choice: ");
        int playerChoice = Func.scanInt();
        if (board[playerChoice - 1] instanceof Number) {
            board[playerChoice - 1] = player;
        } else {
            System.out.println("Incorrect pick!");
            playerPick(board, player);
        }
    }

    static public void computerPick(Object[] board, char player){
        System.out.println("Computer "+player+" is thinking...");
        boolean[] possiblePicks = new boolean[9];
        Arrays.fill(possiblePicks, true);
        for (int i = 0; i < board.length; i++) {
            if(board[i] instanceof Character){
                possiblePicks[i] = false;
            }
        }
        Random rand = new Random();
        int selectedId = -1;
        while (selectedId == -1) {
            int randomId = rand.nextInt(possiblePicks.length);
            if (possiblePicks[randomId]) {
                selectedId = randomId;
            }
        }

        board[selectedId] = player;
    }

    static public boolean checkIfDraw(Object[] board) {
        boolean game = true;
        int filledNodes = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] instanceof Character) {
                filledNodes++;
            }
        }
        if (filledNodes >= 9) {
            game = false;
        }
        return game;
    }

    public static int checkWinCondition(Object[] board, char player, char player1) {
        char t1, t2, t3;
        int winner = 0;
        for (int i = 0; i < 8; i += 3) {
            if (board[i] instanceof Character && board[i + 1] instanceof Character && board[i + 2] instanceof Character) {
                t1 = (char) board[i];
                t2 = (char) board[i + 1];
                t3 = (char) board[i + 2];
                if (t1 == player && t1 == t2 && t2 == t3) {
                    if(t1 == player1){
                        winner = 1;
                    }else{
                        winner = 2;
                    }
                    return winner;
                }
            }
        }

        for (int i = 0; i < 3; i += 1) {
            if (board[i] instanceof Character && board[i + 3] instanceof Character && board[i + 6] instanceof Character) {
                t1 = (char) board[i];
                t2 = (char) board[i + 3];
                t3 = (char) board[i + 6];
                if (t1 == player && t1 == t2 && t2 == t3) {
                    if(t1 == player1){
                        winner = 1;
                    }else{
                        winner = 2;
                    }
                    return winner;
                }
            }
        }
        if (board[0] instanceof Character && board[4] instanceof Character && board[8] instanceof Character) {
            t1 = (char) board[0];
            t2 = (char) board[4];
            t3 = (char) board[8];
            if (t1 == player && t1 == t2 && t2 == t3) {
                if(t1 == player1){
                    winner = 1;
                }else{
                    winner = 2;
                }
                return winner;
            }
        }
        if (board[2] instanceof Character && board[4] instanceof Character && board[6] instanceof Character) {
            t1 = (char) board[2];
            t2 = (char) board[4];
            t3 = (char) board[6];
            if (t1 == player && t1 == t2 && t2 == t3) {
                if(t1 == player1){
                    winner = 1;
                }else{
                    winner = 2;
                }
                return winner;
            }
        }

        return winner;
    }

    static public void duo(boolean game, char player1, char player2){
        int winner;
        Object[] board;
        board = Game.cleanBoard();
        while (game) {
            Game.playerPick(board, player1);
            winner = Game.checkWinCondition(board, player1, player1);
            if (winner == 1) {
                Func.win(board, player1);
                break;
            }

            game = Game.checkIfDraw(board);
            if (!game) {
                Func.draw(board);
                break;
            }

            Game.playerPick(board, player2);
            winner = Game.checkWinCondition(board, player2, player1);
            if (winner == 2) {
                Func.win(board, player2);
                break;
            }

            game = Game.checkIfDraw(board);
            if (!game) {
                Func.draw(board);
                break;
            }
        }
    }

    static public void solo(boolean game, char player1, char player2){
        int winner;
        Object[] board;
        board = Game.cleanBoard();
        while (game) {
            Game.playerPick(board, player1);
            winner = Game.checkWinCondition(board, player1, player1);
            if (winner == 1) {
                Func.win(board, player1);
                break;
            }

            game = Game.checkIfDraw(board);
            if (!game) {
                Func.draw(board);
                break;
            }


            Game.computerPick(board, player2);
            winner = Game.checkWinCondition(board, player2, player1);
            if (winner == 2) {
                Func.win(board, player2);
                break;
            }

            game = Game.checkIfDraw(board);
            if (!game) {
                Func.draw(board);
                break;
            }
        }
    }
}