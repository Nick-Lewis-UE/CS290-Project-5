public class CheckersBoard extends AbstractBoard {
    @Override
    public void takeMove(Piece p, int[] loc) {

    }

    @Override
    public void printBoard() {

    }

    @Override
    public boolean hasWin(Player p, int[] loc) {
        return false;
    }

    @Override
    public boolean validMove(int[] loc) {
        return false;
    }

    @Override
    public boolean hasTie() {
        return false;
    }
}
