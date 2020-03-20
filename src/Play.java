import java.util.Scanner;

public class Play {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        AbstractGame game;

        game = startup(scan);
        System.out.println(game.getBoard().toString());
        game.play();

    }

    public static AbstractGame startup(Scanner scan) {
        System.out.println("Which game would you like to play?");
        System.out.println("Type 1 for Connect 4");
        System.out.println("Type 2 for Gomoku");
        System.out.println("Type 3 for Checkers");
        String pick = scan.nextLine();

        if (pick.equals("1")) {
            return new Connect4Game();
        } else if (pick.equals("2")) {
            return new GomokuGame();
        } else if (pick.equals("3")) {
            return new CheckersGame();
        } else {
            System.out.println("Invalid input, try again please.");
            return startup(scan);
        }
    }
}
