import org.junit.Assert;
import org.junit.Test;

public class PieceTest {
    private void testPiece(Piece p, String symbol) {
        Assert.assertEquals(symbol, p.getSymbol());
    }

    @Test
    public void testConstructors() {
        String s1 = "x";
        Piece p1 = new Piece (s1);
        testPiece(p1, s1);

        Piece p2 = new Piece();
        testPiece(p2, " ");
    }
}
