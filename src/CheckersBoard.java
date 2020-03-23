import java.util.ArrayList;

import static java.lang.Math.abs;

public class CheckersBoard extends AbstractBoard {

    public CheckersBoard() {
        this.num_col = 8;
        this.num_row = 8;
        this.size = 64;
        this.grid = makeStartBoard();
    }

    @Override
    public void takeMove(Piece p, int[] loc) {
        Piece moved = grid.get(loc[1]).get(loc[0]);
        System.out.println(moved.getSymbol());
    }

    @Override
    public String toString() {
        int row_num = 8;
        String board = "|A|B|C|D|E|F|G|H|\n";
        for (int i = 0; i < num_row; i++) {
            board += "|"+grid.get(i).get(0).getSymbol()+
                    "|"+grid.get(i).get(1).getSymbol()+
                    "|"+grid.get(i).get(2).getSymbol()+
                    "|"+grid.get(i).get(3).getSymbol()+
                    "|"+grid.get(i).get(4).getSymbol()+
                    "|"+grid.get(i).get(5).getSymbol()+
                    "|"+grid.get(i).get(6).getSymbol()+
                    "|"+grid.get(i).get(7).getSymbol()+
                    "|" + " " + row_num-- + "\n";
        }

        return board;
    }

    @Override
    protected ArrayList<ArrayList<Piece>> makeStartBoard() {
        ArrayList<ArrayList<Piece>> a = new ArrayList<>();

        for(int i = 0; i < num_row; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < num_col; j++) {
                if (((i == 0 || i == 2) && j % 2 != 0) ||
                        (i == 1 && j % 2 == 0))
                    a.get(i).add(j, new Piece("x"));
                else if (((i == 5 || i == 7) && j % 2 == 0) ||
                        (i == 6 && j % 2 != 0))
                    a.get(i).add(j, new Piece("o"));
                else
                    a.get(i).add(j, new Piece());
            }
        }

        return a;
    }

    @Override
    public boolean hasWin(Player p, int[] loc) {
        return false;
    }

    @Override
    public boolean validMove(int[] loc, Player p) {
        // check if the piece is in the first location
        if (grid.get(loc[1]).get(loc[0]).getSymbol() != p.getPiece().getSymbol()) {
            System.out.println("You don't have a piece at that starting location.");
            return false;
        }

        // check if the second coordinate is taken
        if (grid.get(loc[3]).get(loc[2]).getSymbol() != " ") {
            System.out.println("There is already another piece where you're trying to go.");
            return false;
        }

        // check if not diagonal
        if (loc[0] == loc[2] || loc[1] == loc[3]) {
            System.out.println("You can only move pieces diagonally.");
            return false;
        }

        // check if too big of a move
        if (abs(loc[3]-loc[1]) > 2 || abs(loc[2]-loc[0]) > 2) {
            System.out.println("You can only move one square at a time or two if you're jumping.");
            return false;
        }

        // check if valid jump
        if (abs(loc[3]-loc[1]) == 2 && abs(loc[2]-loc[0]) == 2) {
            if (grid.get((loc[3]+loc[1])/2).get((loc[2]+loc[0])/2).getSymbol() == p.getPiece().getSymbol() ||
                    grid.get((loc[3]+loc[1])/2).get((loc[2]+loc[0])/2).getSymbol() == " ") {
                System.out.println("You can only move one square at a time unless you're jumping" +
                        ", and there's nothing to jump there.");
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean hasTie() {
        return false;
    }
}
