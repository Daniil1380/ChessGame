package game;

public class CoordinateUtil {

    public final static char FIRST_LETTER = 'a';
    public final static char LAST_LETTER = 'h';
    public final static int FIRST_NUMBER = 0;
    public final static int LAST_NUMBER = 7;

    // Преобразование буквы в число (столбец)
    public static int getXFromCoordinate(String coordinate) {
        char col = coordinate.charAt(0);
        if (col >= FIRST_LETTER && col <= LAST_LETTER) {
            return col - FIRST_LETTER;
        }
        return -1;
    }

    // Преобразование цифры в число (строка)
    public static int getYFromCoordinate(String coordinate) {
        int result = Integer.parseInt(coordinate.substring(1)) - 1;

        if (result < FIRST_NUMBER || result > LAST_NUMBER) {
            return -1;
        }

        return result;

    }

}
