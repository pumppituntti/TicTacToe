/**
 * The TicTacToe class contains the main game loop and a win or draw check.
 *
 * @author Artem Tolpa
 */

public class TicTacToe {
    /**
     * The main method creates objects for the player, computer and playing field (board).
     * <p>
     * The method implements the main game loop, which repeats until a winner is identified
     * or the field is completely filled, which means a draw.
     */

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        Board board = new Board();
        Player player = new Player();
        Computer computer = new Computer();
        board.board = board.create();
        board.print(board.board);
        player.setPlayerChar();
        computer.setComputerChar(Player.playerChar);
        if (Computer.computerChar == 'X') {
            computer.setPosition(board.board);
            board.print(board.board);
        }
        while (!board.playerWin && !board.compWin && !board.draw) {
            player.setPosition(board.board);
            board.print(board.board);
            board.winCheck(board.board);
            if (board.draw || board.playerWin)
                break;
            computer.setPosition(board.board);
            board.print(board.board);
            board.winCheck(board.board);
        }
        if (board.playerWin)
            System.out.println("YOU WIN!");
        else if (board.compWin)
            System.out.println("COMPUTER WINS!");
        else if (board.draw)
            System.out.println("DRAW!");
    }
}
