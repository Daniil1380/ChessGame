package game;

public class Main {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        IGame game = new Game(board);
        game.start();
    }

}