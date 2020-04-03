import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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

        grid.get(move[3]).set(move[2], moved);
        grid.get(move[1]).set(move[0], new Piece());

        if (isJumpMove(move)) {
            int[] jumped = getJumpedPosition(move);
            grid.get(jumped[1]).set(jumped[0], new Piece());
            System.out.println(jumped[0] + " " + jumped[1]);
        }
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
    public boolean validMove(int[] move, Player p) {
        ArrayList<int[]> moves = findLegalMoves(p);

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
        return false;
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

    public ArrayList<int[]> findLegalMoves(Player p) {
        ArrayList<int[]> legalMoves;

        legalMoves = findAllJumps(p);

        if (legalMoves.isEmpty()) {
            legalMoves = findAllSimpleMoves(p);
        }
        return legalMoves;
    }

    public ArrayList<int[]> findAllSimpleMoves(Player p) {
        ArrayList<int[]> a = new ArrayList<>();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getSymbol().equals(p.getPiece().getSymbol())) {
                    a.addAll(findLocalSimpleMoves(new int[]{c, r}, p));
                }
            }
        }

        return a;
    }

    public ArrayList<int[]> findLocalSimpleMoves(int[] me, Player p) {
        int[] rowAdds;
        int[] colAdds;
        ArrayList<int[]> allMoves = new ArrayList<>();

        if (p.getPiece().getSymbol().equals("x")) {
            rowAdds = new int[] {1,1};
            colAdds = new int[] {1,-1};
        } else {
            rowAdds = new int[] {-1,-1};
            colAdds = new int[] {1,-1};
        }

        for (int i = 0; i < 2; i++) {
            if (me[me.length-1] + rowAdds[i] < getGrid().size() &&
                    me[me.length-1] + rowAdds[i] >= 0 &&
                    me[me.length-2] + colAdds[i] < getGrid().get(1).size() &&
                    me[me.length-2] + colAdds[i] >= 0) {
                String nextPiece = getGrid().get(me[1] + rowAdds[i]).get(me[0] + colAdds[i]).getSymbol();

                if (nextPiece.equals(" ")) {
                    int[] newMe = appendMoveArray(me,
                            new int[] {me[me.length-2]+colAdds[i],
                                    me[me.length-1]+rowAdds[i]});
                    allMoves.add(newMe);
                }
            }
        }

        return allMoves;
    }

    public ArrayList<int[]> findAllJumps(Player p) {
        ArrayList<int[]> a = new ArrayList<>();

        for (int r = 0; r <(getGrid()).size(); r++) {
            for (int c = 0; c <(getGrid()).get(r).size(); c++) {
                if (getGrid().get(r).get(c).getSymbol().equals(p.getPiece().getSymbol())) {
                    a.addAll(findLocalJumps(new int[]{c, r}, p));
                }
            }
        }

        return a;
    }

    public ArrayList<int[]> findLocalJumps (int[] me, Player p) {
        int[] rowAdds;
        int[] colAdds;
        boolean moreJumps = false;
        ArrayList<int[]> allMoves = new ArrayList<>();

        if (p.getPiece().getSymbol().equals("x")) {
            rowAdds = new int[] {1,1};
            colAdds = new int[] {1,-1};
        } else {
            rowAdds = new int[] {-1,-1};
            colAdds = new int[] {1,-1};
        }

        for (int i = 0; i < 2; i++) {
            if (me[me.length-1] + 2*rowAdds[i] < getGrid().size() &&
                    me[me.length-1] + 2*rowAdds[i] >= 0 &&
                    me[me.length-2] + 2*colAdds[i] < getGrid().get(1).size() &&
                    me[me.length-2] + 2*colAdds[i] >= 0) {
                String nextPiece = getGrid().get(me[1] + rowAdds[i]).get(me[0] + colAdds[i]).getSymbol();

                if (!nextPiece.equals(" ") &&
                    !nextPiece.equals(p.getPiece().getSymbol()) &&
                    getGrid().get(me[me.length-1] + 2 * rowAdds[i]).
                            get(me[me.length-2] + 2 * colAdds[i]).getSymbol().equals(" ")) {
                    int[] newMe = appendMoveArray(me,
                            new int[] {me[me.length-2]+2*colAdds[i],
                                    me[me.length-1]+2*rowAdds[i]});

                    allMoves.addAll(findLocalJumps(newMe, p));
                    moreJumps = true;
                }
            }
        }

        if (!moreJumps && me.length != 2) {
            allMoves.add(me);
        }

        return allMoves;
    }

    protected int[] appendMoveArray (int[] soFar, int[] upNext) {
        int[] combined = new int[soFar.length + upNext.length];

        System.arraycopy(soFar, 0, combined, 0, soFar.length);

        System.arraycopy(upNext, 0, combined, soFar.length + 0, upNext.length);

        return combined;
    }

}
