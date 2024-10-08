package piece;


public class Rook extends ChessPiece {
    public Rook(int x, int y, PieceColor pieceColor) {
        super(x, y, pieceColor);
    }

    @Override
    public boolean canMoveTo(int newX, int newY, ChessPiece[][] board) {
        if (x == newX || y == newY) {
            return isPathClear(newX, newY, board) && (board[newX][newY] == null || canHit(newX, newY, board));
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return isWhite() ? '♖' : '♜';
    }
}