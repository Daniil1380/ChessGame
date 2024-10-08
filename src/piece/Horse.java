package piece;


public class Horse extends ChessPiece {
    public Horse(int x, int y, PieceColor pieceColor) {
        super(x, y, pieceColor);
    }

    @Override
    public boolean canMoveTo(int newX, int newY, ChessPiece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);

        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            return isPathClear(newX, newY, board) && (board[newX][newY] == null || canHit(newX, newY, board));
        }
        return false;
    }

    public boolean isPathClear(int newX, int newY, ChessPiece[][] board) {
        return true;
    }

    @Override
    public char getSymbol() {
        return isWhite() ? '♘' : '♞';
    }
}