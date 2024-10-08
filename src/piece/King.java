package piece;


import static game.CoordinateUtil.FIRST_NUMBER;
import static game.CoordinateUtil.LAST_NUMBER;

public class King extends ChessPiece {

    private boolean isFirstMove;

    public King(int x, int y, PieceColor pieceColor) {
        super(x, y, pieceColor);
        this.isFirstMove = true;
    }

    @Override
    public boolean canMoveTo(int newX, int newY, ChessPiece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);

        if ((dx == 1 && dy == 0) || (dx == 0 && dy == 1) || (dx == 1 && dy == 1)) {
            return isPathClear(newX, newY, board) && (board[newX][newY] == null || canHit(newX, newY, board));
        }
        return false;
    }

    @Override
    public void move(int newX, int newY) {
        super.move(newX, newY);
        isFirstMove = false;
    }

    @Override
    public char getSymbol() {
        return isWhite() ? '♔' : '♚';
    }


    public boolean canCastleShort(ChessPiece[][] board) {
        if (!(board[LAST_NUMBER][y] instanceof Rook)) {
            return false;
        }

        for (int i = x + 1; i <= x + 2; i++) {
            if (board[i][y] != null) {
                return false;
            }
        }
        return isFirstMove;

    }

    public boolean canCastleLong(ChessPiece[][] board) {
        if (!(board[FIRST_NUMBER][y] instanceof Rook)) {
            return false;
        }

        for (int i = x - 1; i >= x - 3; i--) {
            if (board[i][y] != null) {
                return false;
            }
        }
        return isFirstMove;
    }
}