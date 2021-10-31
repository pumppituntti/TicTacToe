/**
 * The class contains methods related to the player (setting the game symbol and making a move).
 *
 * @author Artem Tolpa
 */

import java.io.Console;

public class Player {
    static char playerChar;
    Console c = System.console();

    /**
     * The method asks the player to set the game symbol and checks that the entered symbol is correct (X or O).
     * Input continues until the correct character is entered (X or O).
     */

    public void setPlayerChar() {
        while (playerChar != 'X' && playerChar != 'O' && playerChar != 'x' && playerChar != 'o') {
            System.out.println("Choose your character (X/O)");
            playerChar = c.readLine().charAt(0);
            if (playerChar != 'X' && playerChar != 'O' && playerChar != 'x' && playerChar != 'o')
                System.out.println("Wrong character!");
        }
        if (playerChar == 'x')
            playerChar = 'X';
        if (playerChar == 'o')
            playerChar = 'O';
    }

    /**
     * The method asks the player to make a move.
     * <p>
     * The player has to enter two numbers (line and column number).
     * Input continues until correct values are entered (integers ranging from [1 - board size]).
     * <p>
     * It is also checked that the spot is not taken.
     * If the spot is taken, then the player must make a move again.
     *
     * @param array the state of the game board at the current moment.
     */

    public void setPosition(char[][] array) {
        int line = -1, column = -1;
        System.out.print("\nTake your turn! ");
        while (true) {
            // Is the line OK?
            while (true) {
                boolean error = false;
                System.out.println("Choose a line");
                String tempLine = c.readLine();
                try {
                    Integer.parseInt(tempLine);
                } catch (Exception e) {
                    error = true;
                }
                if (!error) {
                    line = Integer.parseInt(tempLine) - 1;
                } else
                    System.out.println("ERROR! Wrong input!");
                if (line >= 0 && line <= Board.size)
                    break;
                else
                    System.out.println("Give a number from 1 to " + Board.size);
            }
            //Is the column OK?
            while (true) {
                boolean error = false;
                System.out.println("Choose a column");
                String tempColumn = c.readLine();
                try {
                    Integer.parseInt(tempColumn);
                } catch (Exception e) {
                    error = true;
                }
                if (!error) {
                    column = Integer.parseInt(tempColumn) - 1;
                } else
                    System.out.println("ERROR! Wrong input!");
                if (column >= 0 && column <= Board.size)
                    break;
                else
                    System.out.println("Give a number from 1 to " + Board.size);
            }
            //Is the spot free?
            if (!((array[line][column] == 'X') || (array[line][column] == 'O'))) {
                array[line][column] = playerChar;
                break;
            } else
                System.out.println("This spot is taken! Choose another one!");
        }
    }
}
