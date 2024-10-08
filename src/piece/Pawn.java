package piece;


public class Pawn extends ChessPiece {

    private boolean isFirstMove;

    public Pawn(int x, int y, PieceColor pieceColor) {
        super(x, y, pieceColor);
        this.isFirstMove = true;
    }

    @Override
    public boolean canMoveTo(int newX, int newY, ChessPiece[][] board) {
        if (canHit(newX, newY, board)) {
            return true;
        }

        int direction = isWhite() ? 1 : -1;
        return x == newX && (newY == y + direction
                || (newY == y + direction * 2 && isFirstMove))
                && isPathClear(newX, newY, board)
                && board[newX][newY] == null;
    }

    @Override
    public void move(int newX, int newY) {
        super.move(newX, newY);
        isFirstMove = false;
    }

    @Override
    public char getSymbol() {
        return isWhite() ? '♙' : '♟';
    }

    @Override
    public boolean canHit(int newX, int newY, ChessPiece[][] board) {
        int direction = isWhite() ? 1 : -1;

        if ((newX == x + 1 || newX == x - 1) && newY == y + direction) {
            return board[newX][newY] != null && board[newX][newY].getPieceColor() != pieceColor;
        }
        return false;
    }
}