import java.io.Console;

public class Board {
    static int size;
    Console c = System.console();
    char[][] board;
    boolean playerWin, compWin, draw;
    char field = '.';


    public char[][] create() {
        while (size < 3) {
            System.out.println("Give board size");
            size = Integer.parseInt(c.readLine());
        }
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = field;
            }
        }
        return board;
    }

    public void print(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public void winCheck(char[][] array) {
        draw = true;

        for (int i = 0; i < array.length; i++) {
            int playerCheck = 0;
            int compCheck = 0;
            for (int j = 0; j < array.length; j++) {

                // Player's character counter
                if (array[i][j] == Player.playerChar ||
                        array[j][i] == Player.playerChar ||
                        array[j][j] == Player.playerChar) {
                    playerCheck++;
                } else
                    playerCheck = 0;
                if (size < 5) {
                    if (playerCheck == size)
                        playerWin = true;
                } else {
                    if (playerCheck == 5)
                        playerWin = true;
                }

                // Computer's character counter
                if (array[i][j] == Computer.computerChar ||
                        array[j][i] == Computer.computerChar) {
                    compCheck++;
                } else
                    compCheck = 0;
                if (size < 5) {
                    if (compCheck == size)
                        compWin = true;
                } else {
                    if (compCheck == 5)
                        compWin = true;
                }

                // Draw check
                if (array[i][j] == field)
                    draw = false;
            }
        }
    }
}
