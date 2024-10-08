package piece;


public class Queen extends ChessPiece {
    public Queen(int x, int y, PieceColor pieceColor) {
        super(x, y, pieceColor);
    }

    @Override
    public boolean canMoveTo(int newX, int newY, ChessPiece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);

        if (dx == dy || x == newX || y == newY) {
            return isPathClear(newX, newY, board) && (canHit(newX, newY, board) || board[newX][newY] == null);
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return isWhite() ? '♕' : '♛';
    }
}