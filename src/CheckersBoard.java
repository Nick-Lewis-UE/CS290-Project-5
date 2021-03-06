import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

public class CheckersBoard extends AbstractBoard {

    public CheckersBoard() {
        this.num_col = 8;
        this.num_row = 8;
        this.size = 64;
        this.grid = makeStartBoard();
    }

    @Override
    public void takeMove(Piece p, int[] move) {
        Piece moved = grid.get(move[1]).get(move[0]);

        for (int i = 3; i < move.length; i = i + 2) {
            grid.get(move[i]).set(move[i - 1], moved);
            grid.get(move[i - 2]).set(move[i - 3], new Piece());

            if (isJumpMove(move)) {
//                int[] jumped = getJumpedPosition(move);
                grid.get((move[i]+ move[i-2])/2).set((move[i-1]+move[i-3])/2,
                        new Piece());
//                System.out.println(jumped[0] + " " + jumped[1]);
            }
        }

        if (kingMe(move, p)) {
            grid.get(move[move.length - 1]).set(move[move.length - 2],
                    new Piece(moved.getSymbol().toUpperCase()));
        }
    }

    protected boolean kingMe(int[] move, Piece p) {
        int kingRow;

        if (p.getSymbol().equals("x")) {
            kingRow = 7;
        } else if (p.getSymbol().equals("o")){
            kingRow = 0;
        } else return false;

        if (move[move.length-1] == kingRow) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        int row_num = 8;
        StringBuilder board = new StringBuilder("|A|B|C|D|E|F|G|H|\n");
        for (int i = 0; i < num_row; i++) {
            board.append("|").
                    append(grid.get(i).get(0).getSymbol()).append("|").
                    append(grid.get(i).get(1).getSymbol()).append("|").
                    append(grid.get(i).get(2).getSymbol()).append("|").
                    append(grid.get(i).get(3).getSymbol()).append("|").
                    append(grid.get(i).get(4).getSymbol()).append("|").
                    append(grid.get(i).get(5).getSymbol()).append("|").
                    append(grid.get(i).get(6).getSymbol()).append("|").
                    append(grid.get(i).get(7).getSymbol()).append("|").
                    append(" ").append(row_num--).append("\n");
        }

        return board.toString();
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
    public boolean validMove(int[] move, Player p) {
        ArrayList<int[]> moves = findLegalMoves(p.getPiece());

        for (int[] each : moves) {
            if (Arrays.equals(each, move))
                return true;
        }

        return false;

//        // check if the piece is in the first location
//        if (grid.get(move[1]).get(move[0]).getSymbol() != p.getPiece().getSymbol()) {
//            System.out.println("You don't have a piece at that starting location.");
//            return false;
//        }
//
//        // check if the second coordinate is taken
//        if (grid.get(move[3]).get(move[2]).getSymbol() != " ") {
//            System.out.println("There is already another piece where you're trying to go.");
//            return false;
//        }
//
//        // check if not diagonal
//        if (move[0] == move[2] || move[1] == move[3]) {
//            System.out.println("You can only move pieces diagonally.");
//            return false;
//        }
//
//        // check if too big of a move
//        if (abs(move[3]- move[1]) > 2 || abs(move[2]- move[0]) > 2) {
//            System.out.println("You can only move one square at a time or two if you're jumping.");
//            return false;
//        }
//
//        // check if valid jump
//        if (isJumpMove(move)) {
//            int[] jumped = getJumpedPosition(move);
//            if (grid.get(jumped[1]).get(jumped[0]).getSymbol() == p.getPiece().getSymbol() ||
//                    grid.get(jumped[1]).get(jumped[0]).getSymbol() == " ") {
//                System.out.println("You can only move one square at a time unless you're jumping" +
//                        ", and there's nothing to jump there.");
//                return false;
//            }
//        }
//
//        return true;
    }

    @Override
    public boolean hasTie() {
        if (findLegalMoves(new Piece("x")).isEmpty() &&
        findLegalMoves(new Piece("o")).isEmpty())
            return true;
        else return false;
    }

    protected boolean isJumpMove(int[] loc) {
        return abs(loc[3]-loc[1]) == 2 && abs(loc[2]-loc[0]) == 2;
    }

    protected int[] getJumpedPosition(int[] loc) {
        int[] jumped = new int[2];
        jumped[0] = (loc[2]+loc[0])/2;
        jumped[1] = (loc[3]+loc[1])/2;

        return jumped;
    }

    public ArrayList<int[]> findLegalMoves(Piece p) {
        ArrayList<int[]> legalMoves;

        legalMoves = findAllJumps(p);

        if (legalMoves.isEmpty()) {
            legalMoves = findAllSimpleMoves(p);
        }
        return legalMoves;
    }

    public ArrayList<int[]> findAllSimpleMoves(Piece p) {
        ArrayList<int[]> a = new ArrayList<>();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getSymbol().toLowerCase().equals(
                        p.getSymbol())) {
                    a.addAll(findLocalSimpleMoves(new int[]{c, r},
                            getGrid().get(r).get(c)));
                }
            }
        }

        return a;
    }

    public ArrayList<int[]> findLocalSimpleMoves(int[] me, Piece p) {
        int[] rowAdds;
        int[] colAdds;
        ArrayList<int[]> allMoves = new ArrayList<>();

        if (p.getSymbol().equals("x") ||
        p.getSymbol().equals("O")) {
            rowAdds = new int[] {1,1};
            colAdds = new int[] {1,-1};
        } else {
            rowAdds = new int[] {-1,-1};
            colAdds = new int[] {1,-1};
        }

        for (int i = 0; i < 2; i++) {
            try {
                String nextPiece = getGrid().get(me[1] + rowAdds[i]).get(me[0] + colAdds[i]).getSymbol();

                if (nextPiece.equals(" ")) {
                    int[] newMe = appendMoveArray(me,
                            new int[] {me[me.length-2]+colAdds[i],
                                    me[me.length-1]+rowAdds[i]});
                    allMoves.add(newMe);
                }
            } catch (IndexOutOfBoundsException e) {}
        }

        return allMoves;
    }

    public ArrayList<int[]> findAllJumps(Piece p) {
        ArrayList<int[]> a = new ArrayList<>();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getSymbol().toLowerCase().equals(
                        p.getSymbol())) {
                    a.addAll(findLocalJumps(new int[]{c, r},
                            getGrid().get(r).get(c)));
                }
            }
        }

        return a;
    }

    public ArrayList<int[]> findLocalJumps (int[] me, Piece p) {
        int[] rowAdds;
        int[] colAdds;
        boolean moreJumps = false;
        ArrayList<int[]> allMoves = new ArrayList<>();

        if (p.getSymbol().equals("x") ||
        p.getSymbol().equals("O")) {
            rowAdds = new int[] {1,1};
            colAdds = new int[] {1,-1};
        } else {
            rowAdds = new int[] {-1,-1};
            colAdds = new int[] {1,-1};
        }

        for (int i = 0; i < 2; i++) {
            try {
                String nextPiece = getGrid().get(me[me.length-1] + rowAdds[i]).
                        get(me[me.length-2] + colAdds[i]).getSymbol();

                if (!nextPiece.equals(" ") &&
                        !nextPiece.equals(p.getSymbol()) &&
                        getGrid().get(me[me.length - 1] + 2 * rowAdds[i]).
                                get(me[me.length - 2] + 2 * colAdds[i]).getSymbol().equals(" ")) {
                    int[] newMe = appendMoveArray(me,
                            new int[]{me[me.length - 2] + 2 * colAdds[i],
                                    me[me.length - 1] + 2 * rowAdds[i]});

                    allMoves.addAll(findLocalJumps(newMe, p));
                    moreJumps = true;
                }
            } catch(IndexOutOfBoundsException e) {}
        }

        if (!moreJumps && me.length != 2) {
            allMoves.add(me);
        }

        return allMoves;
    }

    protected int[] appendMoveArray (int[] soFar, int[] upNext) {
        int[] combined = new int[soFar.length + upNext.length];

        System.arraycopy(soFar, 0, combined, 0, soFar.length);

        System.arraycopy(upNext, 0, combined, soFar.length, upNext.length);

        return combined;
    }

}
