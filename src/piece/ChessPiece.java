package piece;

public abstract class ChessPiece {
    protected int x;
    protected int y;
    protected PieceColor pieceColor;

    public ChessPiece(int x, int y, PieceColor pieceColor) {
        this.x = x;
        this.y = y;
        this.pieceColor = pieceColor;
    }

    public abstract boolean canMoveTo(int newX, int newY, ChessPiece[][] board);

    public abstract char getSymbol();

    public boolean isWhite() {
        return pieceColor == PieceColor.WHITE;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public boolean isPathClear(int newX, int newY, ChessPiece[][] board) {
        int stepX = Integer.compare(newX, x);
        int stepY = Integer.compare(newY, y);

        int currentX = x + stepX;
        int currentY = y + stepY;

        while (currentX != newX || currentY != newY) {
            if (board[currentX][currentY] != null) {
                return false;
            }
            currentX += stepX;
            currentY += stepY;
        }

        return true;
    }

    public boolean canHit(int newX, int newY, ChessPiece[][] board) {
        ChessPiece another = board[newX][newY];
        return another != null && another.getPieceColor() != pieceColor;
    }

    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }
}