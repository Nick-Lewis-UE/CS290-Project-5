public abstract class AbstractGame {

    public AbstractGame() {
    }

    protected AbstractBoard board;
    protected Player p1;
    protected Player p2;

    public void play() {
        String endMessage;
        Player playing = p1;

        while (true) {
            int[] loc;

            System.out.println(playing.getName() + "'s turn!");

            loc = scanForMove();
            this.board.takeMove(playing.getPiece(), loc);
            this.board.printBoard();
            if (board.justWon(playing, loc)) {
                endMessage = playing.getWinMessage();
                break;
            }

            if (board.isFull()) {
                endMessage = "It's a tie! You filled the board.";
                break;
            }

            if (playing.equals(p1)) {
                playing = p2;
            } else if (playing.equals(p2)) {
                playing = p1;
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
