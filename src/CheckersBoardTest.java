import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckersBoardTest extends BoardTest {

    int num_col = 8;
    int num_row = 8;
    int size = 64;

    private String printMoves(CheckersBoard c, Player p) {
        String moves = "{";
        ArrayList<int[]> movelist = c.findLegalMoves(p);

        for (int[] each : movelist) {
            moves = moves + "{";
            for (int each2 : each) {
                moves = moves + each2;
            }
            moves = moves + "}";
        }
        moves = moves + "}";

        return moves;
    }

    @Test
    public void testConstructors() {
        CheckersBoard c = new CheckersBoard();
        ArrayList<ArrayList<Piece>> b = c.makeStartBoard();

        testBoard(c, num_col, num_row, size, b);
    }

    @Test
    public void testTakeMove() {
    }

    @Test
    public void testToString() {
        CheckersBoard c1 = new CheckersBoard();

        String s = "|A|B|C|D|E|F|G|H|\n" +
                "| |x| |x| |x| |x| 8\n" +
                "|x| |x| |x| |x| | 7\n" +
                "| |x| |x| |x| |x| 6\n" +
                "| | | | | | | | | 5\n" +
                "| | | | | | | | | 4\n" +
                "|o| |o| |o| |o| | 3\n" +
                "| |o| |o| |o| |o| 2\n" +
                "|o| |o| |o| |o| | 1\n";

//        System.out.println(s);
//        System.out.println(c1.toString());

        Assert.assertEquals(s, c1.toString());
    }

    @Test
    public void testMakeStartBoard() {
        ArrayList<ArrayList<Piece>> a = new ArrayList<>();
        a.add(0, new ArrayList<>());
        a.add(1, new ArrayList<>());
        a.add(2, new ArrayList<>());
        a.add(3, new ArrayList<>());
        a.add(4, new ArrayList<>());
        a.add(5, new ArrayList<>());
        a.add(6, new ArrayList<>());
        a.add(7, new ArrayList<>());

        a.get(0).add(0, new Piece());
        a.get(0).add(1, new Piece("x"));
        a.get(0).add(2, new Piece());
        a.get(0).add(3, new Piece("x"));
        a.get(0).add(4, new Piece());
        a.get(0).add(5, new Piece("x"));
        a.get(0).add(6, new Piece());
        a.get(0).add(7, new Piece("x"));

        a.get(1).add(0, new Piece("x"));
        a.get(1).add(1, new Piece());
        a.get(1).add(2, new Piece("x"));
        a.get(1).add(3, new Piece());
        a.get(1).add(4, new Piece("x"));
        a.get(1).add(5, new Piece());
        a.get(1).add(6, new Piece("x"));
        a.get(1).add(7, new Piece());

        a.get(2).add(0, new Piece());
        a.get(2).add(1, new Piece("x"));
        a.get(2).add(2, new Piece());
        a.get(2).add(3, new Piece("x"));
        a.get(2).add(4, new Piece());
        a.get(2).add(5, new Piece("x"));
        a.get(2).add(6, new Piece());
        a.get(2).add(7, new Piece("x"));

        a.get(3).add(0, new Piece());
        a.get(3).add(1, new Piece());
        a.get(3).add(2, new Piece());
        a.get(3).add(3, new Piece());
        a.get(3).add(4, new Piece());
        a.get(3).add(5, new Piece());
        a.get(3).add(6, new Piece());
        a.get(3).add(7, new Piece());

        a.get(4).add(0, new Piece());
        a.get(4).add(1, new Piece());
        a.get(4).add(2, new Piece());
        a.get(4).add(3, new Piece());
        a.get(4).add(4, new Piece());
        a.get(4).add(5, new Piece());
        a.get(4).add(6, new Piece());
        a.get(4).add(7, new Piece());

        a.get(5).add(0, new Piece("o"));
        a.get(5).add(1, new Piece());
        a.get(5).add(2, new Piece("o"));
        a.get(5).add(3, new Piece());
        a.get(5).add(4, new Piece("o"));
        a.get(5).add(5, new Piece());
        a.get(5).add(6, new Piece("o"));
        a.get(5).add(7, new Piece());

        a.get(6).add(0, new Piece());
        a.get(6).add(1, new Piece("o"));
        a.get(6).add(2, new Piece());
        a.get(6).add(3, new Piece("o"));
        a.get(6).add(4, new Piece());
        a.get(6).add(5, new Piece("o"));
        a.get(6).add(6, new Piece());
        a.get(6).add(7, new Piece("o"));

        a.get(7).add(0, new Piece("o"));
        a.get(7).add(1, new Piece());
        a.get(7).add(2, new Piece("o"));
        a.get(7).add(3, new Piece());
        a.get(7).add(4, new Piece("o"));
        a.get(7).add(5, new Piece());
        a.get(7).add(6, new Piece("o"));
        a.get(7).add(7, new Piece());

//        for (int i = 0; i < 8; i++) {
//            System.out.println("|"+a.get(i).get(0).getSymbol()+
//                    "|"+a.get(i).get(1).getSymbol()+
//                    "|"+a.get(i).get(2).getSymbol()+
//                    "|"+a.get(i).get(3).getSymbol()+
//                    "|"+a.get(i).get(4).getSymbol()+
//                    "|"+a.get(i).get(5).getSymbol()+
//                    "|"+a.get(i).get(6).getSymbol()+
//                    "|"+a.get(i).get(7).getSymbol()+
//                    "|");
//        }

        CheckersBoard c1 = new CheckersBoard();
//        c1.printBoard();
        testBoard(c1, a);
    }

    @Test
    public void testHasWin() {
    }

    @Test
    public void testValidMove() {
        CheckersBoard c1 = new CheckersBoard();
        Player p1 = new Player("x", "player");

        // valid move
        int[] move1 = new int[] {1,2,2,3};
        Assert.assertTrue(c1.validMove(move1, p1));

        // invalid starting point
        int[] move2 = new int[] {1,1,2,2};
        Assert.assertFalse(c1.validMove(move2, p1));

        // invalid ending point
        int[] move3 = new int[] {0,1,1,2};
        Assert.assertFalse(c1.validMove(move3, p1));

        // no piece to be jumped
        int[] move4 = new int[] {1,2,3,4};
        Assert.assertFalse(c1.validMove(move4, p1));

        // not diagonal move
        int[] move5 = new int[] {1,2,1,3};
        Assert.assertFalse(c1.validMove(move5, p1));

        // can't move backwards (need to write takeMove first)

        // must take forced jump
    }

    @Test
    public void testHasTie() {
    }

    @Test
    public void testIsJumpMove() {
        CheckersBoard c1 = new CheckersBoard();
        int[] j = new int[4];
        j[0] = 2;
        j[1] = 3;
        j[2] = 4;
        j[3] = 5;

        Assert.assertTrue(c1.isJumpMove(j));
    }

    @Test
    public void testGetJumpedPosition() {
        CheckersBoard c1 = new CheckersBoard();
        int[] j = new int[4];
        j[0] = 2;
        j[1] = 3;
        j[2] = 4;
        j[3] = 5;

        int[] jumped = new int[2];
        jumped[0] = 3;
        jumped[1] = 4;

        Assert.assertArrayEquals(jumped, c1.getJumpedPosition(j));
    }

    @Test
    public void testFindLegalMoves() {
        CheckersBoard c1 = new CheckersBoard();
        Player p1 = new Player("x", "Nick");
        ArrayList<int[]> a1 = c1.findLegalMoves(p1);
        ArrayList<int[]> a2 = c1.findAllSimpleMoves(p1);

        for (int i = 0; i < a2.size(); i++) {
            Assert.assertArrayEquals(a2.get(i), a1.get(i));
        }

        c1.takeMove(new Piece("x"), new int[] {1,2,2,3});
        c1.takeMove(new Piece("o"), new int[] {4,5,3,4});
        c1.takeMove(new Piece("o"), new int[] {0,5,1,4});
        c1.takeMove(new Piece("x"), new int[] {7,2,6,3});
        c1.takeMove(new Piece("o"), new int[] {6,5,5,4});

        ArrayList<int[]> a3 = c1.findLegalMoves(p1);
        ArrayList<int[]> a4 = c1.findAllJumps(p1);


        for (int i = 0; i < a4.size(); i++) {
            Assert.assertArrayEquals(a4.get(i), a3.get(i));
        }

    }

    @Test
    public void testFindAllSimpleMoves() {
        CheckersBoard c1 = new CheckersBoard();
        Player p1 = new Player("x", "Nick");

        ArrayList<int[]> a1 = new ArrayList<>();
        a1.add(new int[] {1,2,2,3});
        a1.add(new int[] {1,2,0,3});
        a1.add(new int[] {3,2,4,3});
        a1.add(new int[] {3,2,2,3});
        a1.add(new int[] {5,2,6,3});
        a1.add(new int[] {5,2,4,3});
        a1.add(new int[] {7,2,6,3});

        ArrayList<int[]> a2 = c1.findAllSimpleMoves(p1);

        Assert.assertFalse(a2.isEmpty());

        for (int i = 0; i < a2.size(); i++) {
            Assert.assertArrayEquals(a1.get(i), a2.get(i));
        }
    }

    @Test
    public void testFindLocalSimpleMoves() {
        CheckersBoard c1 = new CheckersBoard();
        Player p1 = new Player("x", "Nick");

        Assert.assertFalse(c1.findLocalSimpleMoves(new int[] {1,2}, p1).isEmpty());

        Assert.assertArrayEquals(new int[] {1,2,2,3},
                c1.findLocalSimpleMoves(new int[] {1,2}, p1).get(0));
        Assert.assertArrayEquals(new int[] {1,2,0,3},
                c1.findLocalSimpleMoves(new int[] {1,2}, p1).get(1));
        Assert.assertTrue(c1.findLocalSimpleMoves(new int[] {7,0}, p1).isEmpty());

        c1.takeMove(new Piece("o"), new int[] {4,5,3,4});
        c1.takeMove(new Piece("o"), new int[] {3,4,2,3});

        Assert.assertArrayEquals(new int[] {1,2,0,3},
                c1.findLocalSimpleMoves(new int[] {1,2}, p1).get(0));
    }

    @Test
    public void testFindAllJumps() {
        CheckersBoard b1 = new CheckersBoard();
        Player p1 = new Player("x", "Nick");

        Assert.assertTrue(b1.findAllJumps(p1).isEmpty());

        b1.takeMove(new Piece("x"), new int[] {1,2,2,3});
        b1.takeMove(new Piece("o"), new int[] {4,5,3,4});
        b1.takeMove(new Piece("o"), new int[] {0,5,1,4});
        b1.takeMove(new Piece("x"), new int[] {7,2,6,3});
        b1.takeMove(new Piece("o"), new int[] {6,5,5,4});

        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[] {2,3,4,5});
        a.add(new int[] {2,3,0,5});
        a.add(new int[] {6,3,4,5});
        Assert.assertArrayEquals(a.get(0), b1.findAllJumps(p1).get(0));
        Assert.assertArrayEquals(a.get(1), b1.findAllJumps(p1).get(1));
        Assert.assertArrayEquals(a.get(2), b1.findAllJumps(p1).get(2));
    }

    @Test
    public void testFindLocalJumps() {
        CheckersBoard c1 = new CheckersBoard();
        Player p1 = new Player ("x", "Nick");

        c1.takeMove(new Piece("x"), new int[] {1,2,2,3});
        c1.takeMove(new Piece("o"), new int[] {4,5,3,4});
        int[] me = new int[] {2,3};

        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[] {2,3,4,5});

        Assert.assertArrayEquals(a.get(0), c1.findLocalJumps(me, p1).get(0));

        c1.takeMove(new Piece("o"), new int[] {0,5,1,4});
        a.add(new int[] {2,3,0,5});
        Assert.assertArrayEquals(a.get(0), c1.findLocalJumps(me, p1).get(0));
        Assert.assertArrayEquals(a.get(1), c1.findLocalJumps(me, p1).get(1));
    }

    @Test
    public void testAppendMoveArray() {
        CheckersBoard b1 = new CheckersBoard();

        int[] a1 = new int[] {1,2,3,4};
        int[] a2 = new int[] {5,6};

        Assert.assertArrayEquals(new int[] {1,2,3,4,5,6}, b1.appendMoveArray(a1, a2));
    }
}
