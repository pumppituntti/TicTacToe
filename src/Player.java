import java.io.Console;

public class Player {
    static char playerChar;
    Console c = System.console();

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

    public void setPosition(char[][] array) {
        int line, column;

        System.out.print("\nTake your turn! ");
        while (true) {
            while (true) {
                System.out.println("Choose a line");
                line = Integer.parseInt(c.readLine()) - 1;
                if (line > 0 && line <= Board.size)
                    break;
                else
                    System.out.println("ERROR! Wrong input!");
            }
            while (true) {
                System.out.println("Choose a column");
                column = Integer.parseInt(c.readLine()) - 1;
                if (column > 0 && column <= Board.size)
                    break;
                else
                    System.out.println("ERROR! Wrong input!");
            }

            if (!((array[line][column] == 'X') || (array[line][column] == 'O'))) {
                array[line][column] = playerChar;
                break;
            } else
                System.out.println("This spot is taken! Choose another one!");
        }
    }
}
