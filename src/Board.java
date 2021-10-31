/**
 * The class contains methods related to creating, filling the playing field and checking win/draw.
 *
 * @author Artem Tolpa
 */

import java.io.Console;

public class Board {
    static int size;
    Console c = System.console();
    char[][] board;
    boolean playerWin, compWin, draw;
    char field = '.';

    /**
     * The method creates a playing field of size NxN. The size of the field is set by the player.
     * The size of the playing field cannot be less than 3x3.
     * Incorrect input is also checked. Input continues until the played enters an integer greater than 3.
     *
     * @return a character two-dimensional array of size NxN filled with the symbols of the playing field.
     */

    public char[][] create() {
        while (size < 3) {
            System.out.println("\nGive board size (min 3)");
            String tempSize = c.readLine();
            boolean error = false;
            try {
                Integer.parseInt(tempSize);
            } catch (Exception e) {
                error = true;
            }
            if (!error) {
                size = Integer.parseInt(tempSize);
            } else
                System.out.println("ERROR! Wrong input! Enter an integer!");
        }
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = field;
            }
        }
        return board;
    }

    /**
     * The method prints the game board.
     *
     * @param array the game board (2D array) to print.
     */

    public void print(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * The method checks the array (game board) in case of a win or a draw.
     * <p>
     * The method checks if the field contains a contiguous sequence of player's
     * or computer's elements of the length needed to win.
     * <p>
     * With a game board size from 3 to 5, the length of the sequence required to win
     * is 3 - 5 (depending on the size of the field).
     * For a field larger than 5 this length is 5.
     * <p>
     * Diagonals are checked by dividing the playing field into squares of size [lengthToWin x lengthToWin]
     * (the length of the sequence required to win). Diagonals are checked in each of these squares.
     * <p>
     * If the game board is full, but no winner has been identified, then a draw is declared.
     *
     * @param array game board to check.
     */

    public void winCheck(char[][] array) {
        draw = true;
        int lengthToWin;
        if (size < 5)
            lengthToWin = size;
        else lengthToWin = 5;
        //Diagonals
        int m;
        if (lengthToWin == size)
            m = size - 1;
        else m = lengthToWin - 1;
        for (int i = 0; i < array.length - m; i++) {
            for (int j = 0; j < array.length - m; j++) {
                boolean playerDiag1 = true;
                boolean playerDiag2 = true;
                boolean compDiag1 = true;
                boolean compDiag2 = true;
                //Check squares
                //Check player's diagonals
                for (int k = 0; k < lengthToWin; k++) {
                    for (int l = 0; l < lengthToWin; l++) {
                        if (k == l)
                            playerDiag1 = playerDiag1 && (array[k + i][l + j] == Player.playerChar);
                        if (lengthToWin - k - 1 == l) {
                            playerDiag2 = playerDiag2 && (array[k + i][l + j] == Player.playerChar);
                        }
                    }
                }
                if (playerDiag1 || playerDiag2)
                    playerWin = true;
                //Check computer's diagonals
                for (int k = 0; k < lengthToWin; k++) {
                    for (int l = 0; l < lengthToWin; l++) {
                        if (k == l)
                            compDiag1 = compDiag1 && (array[k + i][l + j] == Computer.computerChar);
                        if (lengthToWin - k - 1 == l)
                            compDiag2 = compDiag2 && (array[k + i][l + j] == Computer.computerChar);
                    }
                }
                if (compDiag1 || compDiag2)
                    compWin = true;
            }
        }
        // Lines and columns
        for (int i = 0; i < array.length; i++) {
            int playerCheck = 0;
            int compCheck = 0;
            for (int j = 0; j < array.length; j++) {
                // Player's character counter
                if (array[i][j] == Player.playerChar ||
                        array[j][i] == Player.playerChar) {
                    playerCheck++;
                } else
                    playerCheck = 0;
                if (playerCheck == lengthToWin)
                    playerWin = true;
                // Computer's character counter
                if (array[i][j] == Computer.computerChar ||
                        array[j][i] == Computer.computerChar) {
                    compCheck++;
                } else
                    compCheck = 0;
                if (compCheck == lengthToWin)
                    compWin = true;
                // Draw check
                if (!playerWin && !compWin) {
                    if (array[i][j] == field)
                        draw = false;
                }
            }
        }
    }
}
