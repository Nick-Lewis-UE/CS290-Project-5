public class Connect4Move extends AbstractMove {

    public Connect4Move(int col) {
        this.col = col;
    }

    private int getCol(int col) {
        return col;
    }

    protected int col;
}
