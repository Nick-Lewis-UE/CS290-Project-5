import java.util.ArrayList;

public abstract class AbstractBoard {
    // outer list is rows, inner list is columns
    protected ArrayList<ArrayList<Piece>> grid;
    protected int size;
    protected int num_col;
    protected int num_row;

    public AbstractBoard() {}

    public int getSize() {
        return size;
    }

    public int getNum_row() {
        return num_row;
    }

    public int getNum_col() {
        return num_col;
    }

    public ArrayList<ArrayList<Piece>> getGrid() {
        return grid;
    }

    public abstract void takeMove(Piece p, int[] move);

    public abstract String toString();

    protected abstract ArrayList<ArrayList<Piece>> makeStartBoard();

    public abstract boolean hasWin(Player p, int[] loc);

    public abstract boolean validMove(int[] move, Player p);

    public abstract boolean hasTie();
}
