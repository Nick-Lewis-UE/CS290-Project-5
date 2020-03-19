import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.Scanner;

public abstract class AbstractGame {

    public AbstractGame() {
    }

    protected AbstractBoard board;
    protected Player p1;
    protected Player p2;

    public void play() {
        int winningPlayer = 1;
        while (true) {
            Scanner scan = new Scanner(System.in);
            int[] loc;
//            int gridIndex;
//
            System.out.println("Player 1's turn!");
//
            loc = scanForPiece();
            this.board.addPiece(p1.getPiece(), loc);
            this.board.printBoard();
            if (board.justWon(p1, loc)) {
                winningPlayer = 1;
                break;
            }
//
            System.out.println("Player 2's turn!");

            loc = scanForPiece();
            this.board.addPiece(p2.getPiece(), loc);
            this.board.printBoard();
            if (board.justWon(p2, loc)) {
                winningPlayer = 2;
                break;
            }

            if (board.isFull()) {
                winningPlayer = 0;
                break;
            }
        }

        String[] winMessage = new String[3];
        winMessage[0] = "It's a tie! You filled the board.";
        winMessage[1] = "Player 1";
        winMessage[2] = "Player 2";
        System.out.println("Congratulations, " + winMessage[winningPlayer] +
                "! You won!");

    }

    public int[] scanForPiece() { return new int[2];}

    public AbstractBoard getBoard() {
        return board;
    }

    public void setBoard(AbstractBoard board) {
        this.board = board;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }
}
