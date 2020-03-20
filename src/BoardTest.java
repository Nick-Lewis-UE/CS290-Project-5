import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest {
    protected void testBoard(AbstractBoard b, ArrayList<ArrayList<Piece>> grid) {
//        System.out.println("Grid Size: " + grid.size());
        for (int i = 0; i < b.getNum_row(); i++) {
//            System.out.println(b.getGrid().get(i).getSymbol());
//            System.out.println(grid.get(i).getSymbol());
            for (int j = 0; j < b.getNum_col(); j++)
                Assert.assertEquals(grid.get(i).get(j).getSymbol(),
                        b.getGrid().get(i).get(j).getSymbol());
        }
    }

    protected void testBoard(AbstractBoard b, int num_col, int num_row, int size,
                             ArrayList<ArrayList<Piece>> grid) {
//        System.out.println("Grid Size: " + grid.size());
        for (int i = 0; i < b.getNum_row(); i++) {
//            System.out.println(b.getGrid().get(i).getSymbol());
//            System.out.println(grid.get(i).getSymbol());
            for (int j = 0; j < b.getNum_col(); j++)
                Assert.assertEquals(grid.get(i).get(j).getSymbol(),
                        b.getGrid().get(i).get(j).getSymbol());

            Assert.assertEquals(num_col, b.getNum_col());
            Assert.assertEquals(num_row, b.getNum_row());
            Assert.assertEquals(size, b.getSize());
        }
    }


    public ArrayList<ArrayList<Piece>> makeEmptyBoard(int rows, int cols) {
        ArrayList<ArrayList<Piece>> a= new ArrayList();
        for (int i = 0; i < rows; i++) {
            a.add(i, new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                a.get(i).add(j, new Piece());
            }
        }
        return a;
    }

    private int[] makeLoc(int col, int row) {
        int[] loc = new int[2];
        loc[0] = col;
        loc[1] = row;
        return loc;
    }

    @Test
    public void testConstructors() {
        // Gomoku

        // testing empty constructor
        GomokuBoard g1 = new GomokuBoard();
        testBoard(g1, makeEmptyBoard(19, 19));


        // Connect4
        Connect4Board b2 = new Connect4Board();
        testBoard(b2, makeEmptyBoard(6, 7));
    }

    @Test
    public void testPrintBoard() {
        System.out.println("Empty Connect4 Board.");
        Connect4Board b1 = new Connect4Board();
        b1.toString();

        System.out.println("Empty Gomoku Board.");
        GomokuBoard g1 = new GomokuBoard();
        g1.toString();
    }

    @Test
    public void testaddPiece() {
        // Gomoku
        GomokuBoard g1 = new GomokuBoard();
        Piece p1 = new Piece("x");
        int[] loc1 = new int[2];
        loc1[0] = loc1[1] = 5;
        g1.takeMove(p1, loc1);

        ArrayList<ArrayList<Piece>> a1 = makeEmptyBoard(19,19);
        a1.get(4).set(4, p1);
        testBoard(g1, a1);

        //Connect4
        Connect4Board c1 = new Connect4Board();
        Piece p2 = new Piece("o");
        Piece p3 = new Piece("x");
        int[] loc2 = new int[1];
        int[] loc3 = new int[1];
        loc2[0] = 3;
        loc3[0] = 5;
        c1.takeMove(p2, loc2);
        c1.takeMove(p3, loc3);
        ArrayList<ArrayList<Piece>> a2 = makeEmptyBoard(6,7);
        a2.get(5).set(2, p2);
        a2.get(5).set(4, p3);
        testBoard(c1, a2);

        int[] loc4 = new int[1];
        loc4[0] = 5;
        c1.takeMove(p3, loc4);
        a2.get(4).set(4, p3);
        testBoard(c1, a2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIllegalAddPiece() {
        GomokuBoard g1 = new GomokuBoard();
        Piece p1 = new Piece("x");
        g1.takeMove(p1, makeLoc(300, 300));
        g1.takeMove(p1, makeLoc(-20, -1));

        Connect4Board c1 = new Connect4Board();
        c1.takeMove(p1, makeLoc(300, 300));
        c1.takeMove(p1, makeLoc(-5, 3));
    }

    @Test
    public void testJustWon() {
        GomokuBoard g1 = new GomokuBoard();
        Piece p1 = new Piece("x");
        Player player1 = new Player("x", "nick");

        g1.takeMove(p1,makeLoc(1,1));
        g1.takeMove(p1,makeLoc(1,2));
        g1.takeMove(p1,makeLoc(1,3));
        g1.takeMove(p1,makeLoc(1,4));
        g1.takeMove(p1,makeLoc(1,5));

        Assert.assertEquals(true, g1.hasWin(player1, makeLoc(1,1)));

        GomokuBoard g2 = new GomokuBoard();
        g2.takeMove(p1,makeLoc(5,2));
        g2.takeMove(p1,makeLoc(6,2));
        g2.takeMove(p1,makeLoc(7,2));
        g2.takeMove(p1,makeLoc(8,2));
        g2.takeMove(p1,makeLoc(9,2));

        Assert.assertEquals(true, g2.hasWin(player1, makeLoc(7,2)));

    }
}
