public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player player = new Player();
        Computer computer = new Computer();

        board.board = board.create();
        board.print(board.board);
        player.setPlayerChar();
        computer.setComputerChar(Player.playerChar);

        while (!board.playerWin && !board.compWin && !board.draw) {
            player.setPosition(board.board);
            board.print(board.board);
            board.winCheck(board.board);
            if (board.draw || board.playerWin)
                break;
         //   computer.setPosition(board.board);
         //   board.print(board.board);
         //   board.winCheck(board.board);
        }

        if (board.playerWin)
            System.out.println("YOU WIN!");
        if (board.compWin)
            System.out.println("COMPUTER WINS!");
        if (board.draw)
            System.out.println("DRAW!");
    }
}
