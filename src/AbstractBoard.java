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

    public abstract void takeMove(Piece p, int[] loc);

    public abstract void printBoard();

    public ArrayList<ArrayList<Piece>> makeEmptyBoard() {
        ArrayList<ArrayList<Piece>> a= new ArrayList<>();
        for (int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < num_col; j++) {
                a.get(i).add(j, new Piece());
            }
        }
        return a;
    }

    public abstract boolean hasWin(Player p, int[] loc);

    public abstract boolean validMove(int[] loc);

    public boolean isFull() {
        for (int i = 0; i < num_row; i++)
            for (int j = 0; j < num_col; j++)
                if (grid.get(i).get(j).getSymbol().equals(" ")) {
                    return false;
                }
        return true;
    }
}
