import org.junit.Test;

public class CheckersGameTest extends GameTest {

    @Test
    public void testScanForMove() {

    }

//    @Test
//    public void testFindAllJumps() {
//        CheckersGame g1 = new CheckersGame();
//
//        Assert.assertTrue(g1.getJumps().findAllJumps().isEmpty());
//
//        g1.getBoard().takeMove(new Piece("x"), new int[] {1,2,2,3});
//        g1.getBoard().takeMove(new Piece("o"), new int[] {4,5,3,4});
//        g1.getBoard().takeMove(new Piece("o"), new int[] {0,5,1,4});
//        g1.getBoard().takeMove(new Piece("x"), new int[] {7,2,6,3});
//        g1.getBoard().takeMove(new Piece("o"), new int[] {6,5,5,4});
//
//        ArrayList<int[]> a = new ArrayList<>();
//        a.add(new int[] {2,3,4,5});
//        a.add(new int[] {2,3,0,5});
//        a.add(new int[] {6,3,4,5});
//        Assert.assertArrayEquals(a.get(0), g1.getJumps().findAllJumps().get(0));
//        Assert.assertArrayEquals(a.get(1), g1.getJumps().findAllJumps().get(1));
//        Assert.assertArrayEquals(a.get(2), g1.getJumps().findAllJumps().get(2));
//    }
//
//    @Test
//    public void testCountMyJumps() {
//        CheckersGame g1 = new CheckersGame();
//
//        g1.getBoard().takeMove(new Piece("x"), new int[] {1,2,2,3});
//        g1.getBoard().takeMove(new Piece("o"), new int[] {4,5,3,4});
//        int[] me = new int[] {2,3};
//
//        ArrayList<int[]> a = new ArrayList<>();
//        a.add(new int[] {2,3,4,5});
//        Assert.assertArrayEquals(a.get(0), g1.getJumps().findLocalJumps(me).get(0));
//
//        g1.getBoard().takeMove(new Piece("o"), new int[] {0,5,1,4});
//        a.add(new int[] {2,3,0,5});
//        Assert.assertArrayEquals(a.get(0), g1.getJumps().findLocalJumps(me).get(0));
//        Assert.assertArrayEquals(a.get(1), g1.getJumps().findLocalJumps(me).get(1));
//    }
}
