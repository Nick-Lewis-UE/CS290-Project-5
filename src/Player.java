public class Player {

    public Player(String symbol, String name) {
        this.piece = new Piece(symbol);
        this.name = name;
        this.winMessage = "Congratulations, " + name + "! You won!";
    }

    private Piece piece;
    private String name;
    private String winMessage;


    public Piece getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }

    public String getWinMessage() {
        return winMessage;
    }
}
