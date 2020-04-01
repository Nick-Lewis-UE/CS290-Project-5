public class CheckersGame extends AbstractGame {

    public CheckersGame() {
        this.setBoard(new CheckersBoard());
        this.setP1(new Player("x", "Player 1"));
        this.setP2(new Player("o", "Player 2"));
        this.turn = this.p1;
//        this.setJumps(new MovesList());
    }


    @Override
    public int[] scanForMove() { // returns in index format (0..7)
        int[] move = new int[4];
//        if (!findLegalJumps().isEmpty()) {
//            move = coll();
//        } else {
//
//            System.out.println("Enter your move!");
//            move = collectMove();
//
//            if (!board.validMove(move, turn)) {
//                return scanForMove();
//            }
//        }


        return move;
    }

//    public ArrayList<int[]> findLegalMoves() {
//        ArrayList<int[]> a = new ArrayList<>();
//
//        a = findLegalJumps();
//
//        if (a.size() == 0) {
//            findLegalSimpleMoves();
//        }
//        return a;
//    }


//    private int[] generateJumpMove() {
//        int[] move = new int[4];
//        int[] allMoves;
//        if (jumps.getNumJumps() == 1) {
//            System.out.println("You must take the only jump " +
//                    "available because of" +
//                    " the forced jump rule.");
//            move = appendMoveArray(jumps.getJumps().get(0),
//                    keepJumping(move, new int[] {move[2], move[3]}));
//        } else if (jumps.getNumJumps() > 1) {
//            System.out.println("There are jumps available, " +
//                    "you must take one of them: ");
//            for (int i = 0; i < jumps.getNumJumps(); i++) {
//                System.out.println(jumps.getJumps().get(i).toString());
//            }
//
//            int[] firstMove = collectMove();
//
//            if (!jumps.getJumps().contains(firstMove)) {
//                System.out.println("That is not an available jump.");
//                scanForMove();
//            } else {
//                move = appendMoveArray(firstMove,
//                        keepJumping(move, new int[]{move[2], move[3]}));
//            }
//
//        }
//        return move;
//    }
//
//    private int[] keepJumping(int[] soFar, int[] lastMove) {
//        int[] move;
//        int[] allMoves;
//        if (jumps.findLocalJumps(lastMove).size() == 1) {
//            System.out.println("You must take the only jump " +
//                    "available because of" +
//                    " the forced jump rule.");
//            move = jumps.getJumps().get(0);
//            allMoves = appendMoveArray(new int[0], move);
//        } else if (jumps.findLocalJumps(lastMove).size() > 1) {
//            System.out.println("There are jumps available, " +
//                    "you must take one of them: ");
//            for (int i = 0; i < jumps.getNumJumps(); i++) {
//                System.out.println(jumps.getJumps().get(i).toString());
//            }
//            move = collectMove();
//
//            if (!jumps.getJumps().contains(move)) {
//                System.out.println("That is not an available jump.");
//                scanForMove();
//            }
//        }
//        return move;
//    }
//
//    private int[] appendMoveArray(int[] soFar, int[] upNext) {
//        for (int i = 0; i < upNext.length; i++) {
//            soFar[soFar.length+i] = upNext[i];
//        }
//
//        return soFar;
//    }
//
//    private int[] collectMove() {
//        int[] move = new int[4];
//        Scanner scan = new Scanner(System.in);
//        String line = scan.nextLine().toUpperCase();
//        move[0] = (int) line.charAt(0) - 64 - 1;
//        move[1] = 8 - (line.charAt(1) - '0');
//        move[2] = (int) line.charAt(3) - 64 - 1;
//        move[3] = 8 - (line.charAt(4) - '0');
//
//        return move;
//    }
//
//    public MovesList getJumps() {
//        return jumps;
//    }
//
//    public void setJumps(MovesList jumps) {
//        this.jumps = jumps;
//    }
//
//    public class MovesList {
//
//        public MovesList() {
//            this.jumps = findAllJumps();
//            this.numJumps = jumps.size();
//            this.mySymbol = turn.getPiece().getSymbol();
//        }
//
//        protected ArrayList<int[]> jumps;
//        protected int numJumps;
//        protected String mySymbol;
//
//        protected ArrayList<int[]> getJumps() {
//            return jumps;
//        }
//
//        protected int getNumJumps() {
//            return numJumps;
//        }
//
//        public ArrayList<int[]> findAllJumps() {
//            ArrayList<int[]> a = new ArrayList<>();
//
//            for (int r = 0; r <(board.getGrid()).size(); r++) {
//                for (int c = 0; c <(board.getGrid()).get(r).size(); c++) {
//                    if (board.getGrid().get(r).get(c).getSymbol().equals(mySymbol)) {
//                        ArrayList<int[]> localJumps = findLocalJumps(new int[]{c, r});
//                        if (!localJumps.isEmpty())
//                            for (int[] localJump : localJumps) {
//                                a.add(a.size(), localJump);
//                            }
//                    }
//                }
//            }
//
//            return a;
//        }
//
//        public ArrayList<int[]> findLocalJumps (int[] me) {
//            int[] colAdds = new int[] {1,1,0,-1,-1,-1,0,1};
//            int[] rowAdds = new int[] {0,1,1,1,0,-1,-1,-1};
//            ArrayList<int[]> a = new ArrayList<>();
//
//            for (int i = 0; i < 8; i++) {
//                if (me[1] + 2*rowAdds[i] < board.getGrid().size() &&
//                        me[1] + 2*rowAdds[i] >= 0 &&
//                        me[0] + 2*colAdds[i] < board.getGrid().get(1).size() &&
//                        me[0] + 2*colAdds[i] >= 0) {
//                    String nextPiece = board.getGrid().get(me[1] + rowAdds[i]).get(me[0] + colAdds[i]).getSymbol();
//
//                    if (!nextPiece.equals(" ") && !nextPiece.equals(mySymbol)) {
//                        if (board.getGrid().get(me[1] + 2 * rowAdds[i]).get(me[0] + 2 * colAdds[i]).getSymbol().equals(" "))
//                            a.add(a.size(), new int[] {me[0],me[1],me[0] + 2 * colAdds[i], me[1] + 2 * rowAdds[i]});
//                    }
//                }
//            }
//
//            return a;
//        }
//    }

}
