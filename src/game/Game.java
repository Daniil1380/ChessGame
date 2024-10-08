package game;

import piece.ChessPiece;
import piece.PieceColor;
import piece.King;

import java.util.Scanner;

import static game.CoordinateUtil.FIRST_NUMBER;
import static game.CoordinateUtil.LAST_LETTER;
import static game.CoordinateUtil.LAST_NUMBER;

public class Game implements IGame {

    private static final String CASTLING = "c";

    private final ChessBoard board;
    private final BoardPrinter boardPrinter;
    private final Scanner scanner;
    private PieceColor currentColor;

    public Game(ChessBoard board) {
        this.board = board;
        this.boardPrinter = new BoardPrinter();
        this.scanner = new Scanner(System.in);
        this.currentColor = PieceColor.WHITE;
    }

    public void start() {
        board.initializeBoard();

        while (true) {
            boardPrinter.printBoard(board.getBoardArray());
            System.out.println((currentColor.isWhite() ? "Белые" : "Чёрные") + ", ваш ход. " +
                    "Введите начальные и конечные координаты (например, e2 e4. Для рокировки используйте команду 'c'):");
            String move = scanner.nextLine();

            if (processTurn(move)) {
                currentColor = currentColor.switchColor();
            }
        }
    }

    private boolean processTurn(String turnInString) {
        if (turnInString.equals(CASTLING)) {
            return processCastling();
        }

        String[] coordinates = turnInString.split(" ");
        if (coordinates.length != 2) {
            System.out.println("Неверный формат ввода. Попробуйте снова.");
            return false;
        }

        return processRegularMove(coordinates);
    }

    private boolean processCastling() {
        int fromX = 4;
        int y = currentColor.isWhite() ? FIRST_NUMBER : LAST_NUMBER;
        ChessPiece piece = board.getPiece(fromX, y);

        if (!(piece instanceof King king)) {
            System.out.println("Нельзя сделать рокировку.");
            return false;
        }

        if (king.canCastleLong(board.getBoardArray())) {
            performCastling(fromX, y, -2, FIRST_NUMBER, 3);
            return true;
        }

        if (king.canCastleShort(board.getBoardArray())) {
            performCastling(fromX, y, 2, LAST_LETTER, -2);
            return true;
        }

        System.out.println("Невозможно выполнить рокировку. Попробуйте снова.");
        return false;
    }

    private void performCastling(int fromX, int y, int kingMove, int rookFromX, int rookMove) {
        board.movePiece(fromX, y, fromX + kingMove, y);
        board.movePiece(rookFromX, y, rookFromX + rookMove, y);
    }

    private boolean processRegularMove(String[] coordinates) {
        int fromX = CoordinateUtil.getXFromCoordinate(coordinates[0]);
        int fromY = CoordinateUtil.getYFromCoordinate(coordinates[0]);
        int toX = CoordinateUtil.getXFromCoordinate(coordinates[1]);
        int toY = CoordinateUtil.getYFromCoordinate(coordinates[1]);

        if (areNotValidCoordinates(fromX, fromY) || areNotValidCoordinates(toX, toY)) {
            System.out.println("Неверные координаты. Попробуйте снова.");
            return false;
        }

        ChessPiece piece = board.getPiece(fromX, fromY);

        if (piece == null) {
            System.out.println("На этой позиции нет фигуры. Попробуйте снова.");
            return false;
        }

        if (piece.getPieceColor() != currentColor) {
            System.out.println("Неверный цвет фигуры. Попробуйте снова.");
            return false;
        }

        if (piece.canMoveTo(toX, toY, board.getBoardArray())) {
            board.movePiece(fromX, fromY, toX, toY);
            return true;
        }

        System.out.println("Фигура не может так ходить. Попробуйте снова.");
        return false;
    }

    private boolean areNotValidCoordinates(int x, int y) {
        return x == -1 || y == -1;
    }
}