import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class GomokuBoard extends RowBasedBoard {

    public GomokuBoard() {

        this.num_col = 19;
        this.num_row = 19;
        this.size = 361;
        this.needToWin = 5;
        ArrayList<ArrayList<Piece>> grid = new ArrayList<>();
        for (int i = 0; i < num_row; i++) {
            grid.add(i, new ArrayList<>());
            for (int j = 0; j < num_col; j++) {
                grid.get(i).add(j, new Piece());
            }
        }
        this.grid = grid;
    }

    public void takeMove(Piece p, int[] move) {
            grid.get(move[1]-1).set(move[0]-1, p);
    }

    public String toString() {
        String board = "|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|\n";
        int rowID = 1;
        for (int i = 0; i < num_row; i++) {
            board += "|" + grid.get(i).get(0).getSymbol() +
                    "|" + grid.get(i).get(1).getSymbol() +
                    "|" + grid.get(i).get(2).getSymbol() +
                    "|" + grid.get(i).get(3).getSymbol() +
                    "|" + grid.get(i).get(4).getSymbol() +
                    "|" + grid.get(i).get(5).getSymbol() +
                    "|" + grid.get(i).get(6).getSymbol() +
                    "|" + grid.get(i).get(7).getSymbol() +
                    "|" + grid.get(i).get(8).getSymbol() +
                    "|" + grid.get(i).get(9).getSymbol() +
                    "|" + grid.get(i).get(10).getSymbol() +
                    "|" + grid.get(i).get(11).getSymbol() +
                    "|" + grid.get(i).get(12).getSymbol() +
                    "|" + grid.get(i).get(13).getSymbol() +
                    "|" + grid.get(i).get(14).getSymbol() +
                    "|" + grid.get(i).get(15).getSymbol() +
                    "|" + grid.get(i).get(16).getSymbol() +
                    "|" + grid.get(i).get(17).getSymbol() +
                    "|" + grid.get(i).get(18).getSymbol() +
                    "|" + rowID++ + "\n";
        }

        return board;
    }

    public boolean hasWin(Player p, int[] loc) {
        return (checkHorizontalWin(p, loc[1]) || checkVerticalWin(p, loc[0]) ||
                checkDescDiagonalWin(p, loc[0], loc[1]) || checkAscDiagonalWin(p, loc[0], loc[1]));
    }

    public boolean validMove(int[] move, Player p) {
        return (move[1] > num_row || move[1] <= 0 || move[0] <= 0 || move[0] > num_col ||
                !grid.get(move[1] - 1).get(move[0] - 1).getSymbol().equals(" "));
    }
}
