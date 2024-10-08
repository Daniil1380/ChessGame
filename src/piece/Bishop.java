package piece;


public class Bishop extends ChessPiece {
    public Bishop(int x, int y, PieceColor pieceColor) {
        super(x, y, pieceColor);
    }

    @Override
    public boolean canMoveTo(int newX, int newY, ChessPiece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);

        if (dx == dy) {
            return isPathClear(newX, newY, board) && (board[newX][newY] == null || canHit(newX, newY, board));
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return isWhite() ? '♗' : '♝';
    }
}