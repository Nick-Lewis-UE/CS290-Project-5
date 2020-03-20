import java.util.Scanner;

public class GomokuGame extends AbstractGame {

    public GomokuGame() {
        this.setBoard(new GomokuBoard());
        this.setP1(new Player("x"));
        this.setP2(new Player("o"));
    }

    @Override
    public int[] scanForMove(){
        System.out.println("Enter the coordinate to place your piece at!");
        int[] loc = new int[2];
        Scanner scan = new Scanner(System.in);
        String letter = scan.findInLine(".").toUpperCase();
        loc[0] = (int)letter.charAt(0)-64;
        loc[1] = scan.nextInt();

        if (board.validMove(loc)) {
            System.out.println("Invalid row/column. Please try again.");
            return scanForMove();
        }

        return loc;

    }
}
