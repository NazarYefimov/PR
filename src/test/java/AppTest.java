//  Додаємо імпорти для тестування
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //  Створюємо тест для методу initializeBoard
    @Test
    public void testInitializeBoard() {
        char[] board = new char[App.BOARD_SIZE];
        App.initializeBoard(board);
        char[] expectedBoard = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        assertArrayEquals(expectedBoard, board);
    }


    //  Створюємо тест для методу isValidMove
    @Test
    public void testIsValidMove() {
        char[] board = { 'X', 'O', '3', '4', '5', '6', '7', '8', '9' };
        assertFalse(App.isValidMove(board, 1));
        assertFalse(App.isValidMove(board, 2));
        assertTrue(App.isValidMove(board, 3));
        assertTrue(App.isValidMove(board, 9));
        assertFalse(App.isValidMove(board, 10));
    }

   //  Створюємо тест для методу checkWinner
    @Test
    public void testCheckWinner() {
        char[] board1 = { 'X', 'X', 'X', '4', '5', '6', '7', '8', '9' };
        char[] board2 = { 'O', 'O', '3', 'X', 'X', '6', '7', '8', '9' };
        char[] board3 = { 'O', 'X', '3', '4', 'X', '6', '7', '8', 'X' };
        char[] board4 = { 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X' };
        assertEquals('X', App.checkWinner(board1, App.PLAYER_X_SYMBOL));
        assertEquals('X', App.checkWinner(board2, App.PLAYER_X_SYMBOL));
        assertEquals('X', App.checkWinner(board3, App.PLAYER_X_SYMBOL));
        assertEquals('D', App.checkWinner(board4, App.PLAYER_X_SYMBOL));
    }
}
