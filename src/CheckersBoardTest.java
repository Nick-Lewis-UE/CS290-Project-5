import com.sun.tools.doclint.Checker;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CheckersBoardTest extends BoardTest {

    @Test
    public void testConstructors() {}

    @Test
    public void testTakeMove() {
    }

    @Test
    public void testPrintBoard() {
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
    }

    @Test
    public void testHasTie() {
    }
}
