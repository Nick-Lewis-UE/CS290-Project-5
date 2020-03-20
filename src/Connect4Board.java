public class Connect4Board extends RowBasedBoard {

//    public Connect4Board(ArrayList<ArrayList<Piece>> grid) {
//        this.grid = grid;
//    }

    public Connect4Board() {
        this.num_col = 7;
        this.num_row = 6;
        this.size = 42;
        this.needToWin = 4;
        this.grid = makeStartBoard();
    }

    public void takeMove(Piece p, int[] loc) {
        for (int i = num_row-1; i >= 0; i--) {
            if (grid.get(i).get(loc[0]-1).getSymbol().equals(" ")) {
                grid.get(i).set(loc[0]-1, p);
                break;
            }
        }
    }

    public String toString() {
        String board = "";
        System.out.print("|1|2|3|4|5|6|7|\n");
        for (int i = 0; i < num_row; i++) {
            board += "|"+grid.get(i).get(0).getSymbol()+
                    "|"+grid.get(i).get(1).getSymbol()+
                    "|"+grid.get(i).get(2).getSymbol()+
                    "|"+grid.get(i).get(3).getSymbol()+
                    "|"+grid.get(i).get(4).getSymbol()+
                    "|"+grid.get(i).get(5).getSymbol()+
                    "|"+grid.get(i).get(6).getSymbol()+
                    "|" + "\n";
        }

        return board;
    }

    public boolean hasWin(Player p, int[] loc) {
        // not working
        for (int j = 1; j <= num_row; j++) {
            if (checkHorizontalWin(p, j))
                return true;
        }
        // vertical win?
        if (checkVerticalWin(p, loc[0]))
            return true;
        // descending diagonal win
        for (int i = 1; i <= num_row; i++) {
            if (checkDescDiagonalWin(p, loc[0], i))
                return true;
        }
        // ascending diagonal win
        for (int i = 1; i <= num_row; i++) {
            if (checkAscDiagonalWin(p, loc[0], i))
                return true;
        }

        return false;
    }

    public boolean validMove(int[] loc) {
        return (loc[0] <= 0 || loc[0] > num_col ||
                !grid.get(0).get(loc[0] - 1).getSymbol().equals(" "));
    }
}
