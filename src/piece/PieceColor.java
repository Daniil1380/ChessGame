package piece;

public enum PieceColor {

    BLACK,
    WHITE;


    public PieceColor switchColor() {
        if (this == BLACK) {
            return WHITE;
        }
        else {
            return BLACK;
        }
    }

    public boolean isWhite() {
        return this == WHITE;
    }
}
