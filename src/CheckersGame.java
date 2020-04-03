import java.util.Scanner;

public class CheckersGame extends AbstractGame {

    public CheckersGame() {
        this.setBoard(new CheckersBoard());
        this.setP1(new Player("x", "Player 1"));
        this.setP2(new Player("o", "Player 2"));
        this.turn = this.p1;
//        this.setJumps(new MovesList());
    }


    @Override
    public int[] scanForMove() { // returns in index format (0..7)
        int[] move = collectMove();

        if (!board.validMove(move, turn)) {
            System.out.println("Invalid move. Please try again.");
            return scanForMove();
        }

        return move;
    }

    private int[] collectMove() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().toUpperCase();

        int[] move = new int[2*((line.length()+1)/3)];
        move[0] = (int) line.charAt(0) - 64 - 1;
        move[1] = 8 - (line.charAt(1) - '0');

        int scanPoint = 3;
        int arrayIndex = 2;

        do {
            move[arrayIndex] = (int) line.charAt(scanPoint) - 64 - 1;
            move[arrayIndex+1] = 8 - (line.charAt(scanPoint+1) - '0');
            scanPoint = scanPoint+3;
            arrayIndex = arrayIndex+2;
        } while (scanPoint <= line.length()-2);

        return move;
    }
}
