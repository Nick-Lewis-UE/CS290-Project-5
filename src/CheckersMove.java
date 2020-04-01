public class CheckersMove extends AbstractMove {

    public CheckersMove(int startCol, int startRow,
                        int endCol, int endRow) {
        this.startCol = startCol;
        this.endCol = endCol;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    protected int startRow;
    protected int startCol;
    protected int endRow;
    protected int endCol;

}
