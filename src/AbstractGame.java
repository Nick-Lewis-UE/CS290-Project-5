public abstract class AbstractGame {

    public AbstractGame() {
    }

    protected AbstractBoard board;
    protected Player p1;
    protected Player p2;
    protected Player turn;

    public void play() {
        String endMessage;
        this.turn = p1;

        while (true) {
            int[] move;

            System.out.println(turn.getName() + "'s turn!");

            move = scanForMove();
            this.board.takeMove(turn.getPiece(), move);
            System.out.println(this.board.toString());
            if (board.hasWin(turn, move)) {
                endMessage = turn.getWinMessage();
                break;
            }

            if (board.hasTie()) {
                endMessage = "It's a tie! You filled the board.";
                break;
            }

            if (turn.equals(p1)) {
                turn = p2;
            } else if (turn.equals(p2)) {
                turn = p1;
            }
        }

        System.out.println(endMessage);
    }

    public abstract int[] scanForMove();

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
