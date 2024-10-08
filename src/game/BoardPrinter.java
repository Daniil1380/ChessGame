package game;

import piece.ChessPiece;

public class BoardPrinter {

    private static final int BOARD_SIZE = 8;

    public void printBoard(ChessPiece[][] boardArray) {
        printColumnLabels();
        for (int y = BOARD_SIZE - 1; y >= 0; y--) {
            printRow(y, boardArray);
        }
    }

    private void printColumnLabels() {
        System.out.println("   a b  c d  e f  g  h");
    }

    private void printRow(int y, ChessPiece[][] board) {
        System.out.print((y + 1) + " ");
        for (int x = 0; x < BOARD_SIZE; x++) {
            printCell(x, y, board);
        }
        System.out.println();
    }

    private void printCell(int x, int y, ChessPiece[][] boardArray) {
        String cellContent = (boardArray[x][y] == null) ? "⛆" : String.valueOf(boardArray[x][y].getSymbol());
        System.out.print(cellContent + " ");
    }

}
