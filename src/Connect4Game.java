import java.util.Scanner;

public class Connect4Game extends AbstractGame{

    public Connect4Game() {
        this.setBoard(new Connect4Board());
        this.setP1(new Player("x", "Player 1"));
        this.setP2(new Player("o", "Player 2"));
    }

    public int[] scanForMove() {
        System.out.println("Enter a column to drop into!");
        Scanner scan = new Scanner(System.in);
        int col = scan.nextInt();

        int[] coordinate = new int[1];
        coordinate[0] = col;

        if (board.validMove(coordinate)) {
            System.out.println("Invalid column. Please try again.");
            return scanForMove();
        }

        return coordinate;
    }
}
