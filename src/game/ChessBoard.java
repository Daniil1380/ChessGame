package game;

import piece.*;

public class ChessBoard {

    private static final int BOARD_SIZE = 8;

    private final ChessPiece[][] boardArray;

    public ChessBoard() {
        this.boardArray = new ChessPiece[BOARD_SIZE][BOARD_SIZE];
    }

    public ChessPiece[][] getBoardArray() {
        return boardArray;
    }

    public void initializeBoard() {
        initializePawns();
        initializeMainPieces();
    }

    private void initializePawns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            boardArray[i][1] = new Pawn(i, 1, PieceColor.WHITE);
            boardArray[i][6] = new Pawn(i, 6, PieceColor.BLACK);
        }
    }

    private void initializeMainPieces() {
        PieceColor[] colors = {PieceColor.WHITE, PieceColor.BLACK};
        int[] rows = {0, 7};

        for (int i = 0; i < 2; i++) {
            PieceColor color = colors[i];
            int row = rows[i];

            boardArray[0][row] = new Rook(0, row, color);
            boardArray[1][row] = new Horse(1, row, color);
            boardArray[2][row] = new Bishop(2, row, color);
            boardArray[3][row] = new Queen(3, row, color);
            boardArray[4][row] = new King(4, row, color);
            boardArray[5][row] = new Bishop(5, row, color);
            boardArray[6][row] = new Horse(6, row, color);
            boardArray[7][row] = new Rook(7, row, color);
        }
    }

    public ChessPiece getPiece(int x, int y) {
        return boardArray[x][y];
    }

    public void movePiece(int fromX, int fromY, int toX, int toY) {
        ChessPiece chessPiece = boardArray[fromX][fromY];
        if (chessPiece != null) {
            chessPiece.move(toX, toY);
            boardArray[toX][toY] = chessPiece;
            boardArray[fromX][fromY] = null;
        }
    }


}