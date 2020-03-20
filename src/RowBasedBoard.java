import static java.lang.Math.min;

public abstract class RowBasedBoard extends AbstractBoard {
    protected int needToWin;

    public boolean checkHorizontalWin(Player p, int row) {
        int run = 0;
        for (int i = 0; i < num_col; i++) {
            if (grid.get(row-1).get(i).getSymbol().equals(p.getPiece().getSymbol()))
                run++;
            else
                run = 0;
            if (run >=needToWin)
                return true;
        }

        return false;
    }

    public boolean checkVerticalWin(Player p, int col) {
        int run = 0;
        for (int i = 0; i < num_row; i++) {
            if(grid.get(i).get(col-1).getSymbol().equals(p.getPiece().getSymbol()))
                run++;
            else
                run = 0;
            if (run >= needToWin)
                return true;
        }

        return false;
    }

    public boolean checkDescDiagonalWin(Player p, int col, int row) {
        int run = 0;
        int smaller = min(row, col);
        int r = row-smaller;
        int c = col-smaller;

//        System.out.println("Descending debug:");
        while (r < num_row && c< num_col) {
//            System.out.println("r = " + (r) + ", c = " + (c));
            if(grid.get(r).get(c).getSymbol().equals(p.getPiece().getSymbol()))
                run++;
            else
                run = 0;
            if (run >= needToWin)
                return true;

            r++;
            c++;
        }

        return false;
    }

    public boolean checkAscDiagonalWin(Player p, int col, int row) {
        int run = 0;

        int r = row-1;
        int c = col-1;
        while (r < num_row-1 && c > 0) {
            r++;
            c--;
        }

//        System.out.println("Ascending debug:");
        while (r >= 0 && c < num_col) {
//            System.out.println("r = " + (r) + ", c = " + (c));
            if(grid.get(r).get(c).getSymbol().equals(p.getPiece().getSymbol()))
                run++;
            else
                run = 0;
            if (run >= needToWin)
                return true;

            r--;
            c++;
        }

        return false;
    }
}
