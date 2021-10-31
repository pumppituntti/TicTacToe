/**
 * The Computer class contains methods associated with computer game actions.
 *
 * @author Artem Tolpa
 */

public class Computer {
    static char computerChar;

    /**
     * The method sets the game symbol for the computer to the opposite of the player symbol.
     *
     * @param playerChar player-set symbol.
     */

    public void setComputerChar(char playerChar) {
        if (playerChar == 'X' || playerChar == 'x')
            computerChar = 'O';
        else
            computerChar = 'X';
        System.out.println("OK! Computer's character is " + computerChar);
    }

    /**
     * The method makes a move by placing the symbol in a random place on the playing field.
     *
     * In this case, the computer has no intelligence, it makes a move randomly.
     *
     * @param array the state of the game board at the current moment.
     */

    public void setPosition(char[][] array) {
        System.out.println("Computer's turn...");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int random1, random2;
        while (true) {
            random1 = random(0, Board.size - 1);
            random2 = random(0, Board.size - 1);
            if (array[random1][random2] != computerChar && array[random1][random2] != Player.playerChar) {
                array[random1][random2] = computerChar;
                break;
            }
        }
    }

    /**
     * The method returns a random number from min to max.
     * It is required for the computer to make a move.
     *
     * @param min minimum value.
     * @param max maximum value.
     * @return a random number from min to max.
     */

    public static int random(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
