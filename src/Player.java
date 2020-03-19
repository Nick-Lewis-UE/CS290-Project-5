public class Player {

    public Player(String symbol) {
        this.setPiece(new Piece(symbol));
    }

    private Piece piece;


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
