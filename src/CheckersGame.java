import java.util.Scanner;

public class CheckersGame extends AbstractGame {

    public CheckersGame() {
        this.setBoard(new CheckersBoard());
        this.setP1(new Player("x", "Player 1"));
        this.setP2(new Player("o", "Player 2"));
    }

    @Override
    public int[] scanForMove() { // returns in index format (0..7)
        System.out.println("Enter your move!");
        int[] move = new int[4];
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().toUpperCase();
        move[0] = (int)line.charAt(0)-64-1;
        move[1] = 8-(line.charAt(1)-'0');
        move[2] = (int)line.charAt(3)-64-1;
        move[3] = 8-(line.charAt(4)-'0');
//        System.out.println(move[0] + "-" +
//                move[1] + "-" +
//                move[2] + "-" +
//                move[3]);

        return move;
    }
}
