import java.util.ArrayList;

public class CheckersBoard extends AbstractBoard {

    public CheckersBoard() {
        this.num_col = 8;
        this.num_row = 8;
        this.size = 64;
        this.grid = makeStartBoard();
    }

    @Override
    public void takeMove(Piece p, int[] loc) {

    }

    @Override
    public void printBoard() {

    }

    @Override
    public ArrayList<ArrayList<Piece>> makeStartBoard() {
        return null;
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
