import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CheckersBoardTest extends BoardTest {

    int num_col = 8;
    int num_row = 8;
    int size = 64;

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

        // valid move
        int[] move1 = new int[] {1,2,2,3};
        Assert.assertTrue(c1.validMove(move1));

        // invalid starting point
        int[] move2 = new int[] {1,1,2,2};
        Assert.assertFalse(c1.validMove(move2));

        // invalid ending point
        int[] move3 = new int[] {0,1,1,2};
        Assert.assertFalse(c1.validMove(move3));

        // no piece to be jumped
        int[] move4 = new int[] {1,2,3,4};
        Assert.assertFalse(c1.validMove(move4));

        // not diagonal move
        int[] move5 = new int[] {1,2,1,3};
        Assert.assertFalse(c1.validMove(move5));

        // can't move backwards (need to write takeMove first)

        // must take forced jump
    }

    @Test
    public void testHasTie() {
    }
}
