import java.util.ArrayList;

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

    public ArrayList<ArrayList<Piece>> makeStartBoard() {
        ArrayList<ArrayList<Piece>> a= new ArrayList<>();
        for (int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < num_col; j++) {
                a.get(i).add(j, new Piece());
            }
        }
        return a;
    }

    public boolean hasTie() {
        for (int i = 0; i < num_row; i++)
            for (int j = 0; j < num_col; j++)
                if (grid.get(i).get(j).getSymbol().equals(" ")) {
                    return false;
                }
        return true;
    }
}
