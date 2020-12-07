public class Computer {
    static char computerChar;
    static boolean firstTurn = true;

    public void setComputerChar(char playerChar) {
        if (playerChar == 'X' || playerChar == 'x')
            computerChar = 'O';
        else
            computerChar = 'X';
        System.out.println("OK! Computer's character is " + computerChar);
    }

    public void setPosition(char[][] array) {
        System.out.println("Computer's turn...");

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int random1, random2;

        if (!firstTurn) {

        }

        while (firstTurn) {
            random1 = random(0, Board.size - 1);
            random2 = random(0, Board.size - 1);
            if (array[random1][random2] != computerChar && array[random1][random2] != Player.playerChar) {
                array[random1][random2] = computerChar;
                firstTurn = false;
                break;
            }
        }


    }

    public static int random(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
