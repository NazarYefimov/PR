package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardUtilsTest {

    @Test
    public void testInitializeBoard() {
        char[] board = new char[BoardUtils.BOARD_SIZE];
        BoardUtils.initializeBoard(board);
        char[] expectedBoard = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        assertArrayEquals(expectedBoard, board);
    }

    @Test
    public void testIsValidMove() {
        char[] board = { 'X', 'O', '3', '4', '5', '6', '7', '8', '9' };
        assertFalse(BoardUtils.isValidMove(board, 1));
        assertFalse(BoardUtils.isValidMove(board, 2));
        assertTrue(BoardUtils.isValidMove(board, 3));
        assertTrue(BoardUtils.isValidMove(board, 9));
        assertFalse(BoardUtils.isValidMove(board, 10));
    }

    @Test
    public void testCheckWinner() {
        char[] board1 = { 'X', 'X', 'X', '4', '5', '6', '7', '8', '9' };
        char[] board2 = { 'O', 'O', '3', 'X', 'X', '6', '7', '8', '9' };
        char[] board3 = { 'O', 'X', '3', '4', 'X', '6', '7', '8', 'X' };
        char[] board4 = { 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X' };
        assertEquals('X', BoardUtils.checkWinner(board1, BoardUtils.PLAYER_X_SYMBOL));
        assertEquals('X', BoardUtils.checkWinner(board2, BoardUtils.PLAYER_X_SYMBOL));
        assertEquals('X', BoardUtils.checkWinner(board3, BoardUtils.PLAYER_X_SYMBOL));
        assertEquals('D', BoardUtils.checkWinner(board4, BoardUtils.PLAYER_X_SYMBOL));
    }

    @Test
    public void testMakeMove() {
        char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        BoardUtils.makeMove(board, 5, BoardUtils.PLAYER_X_SYMBOL);
        assertEquals(BoardUtils.PLAYER_X_SYMBOL, board[4]);
    }

    @Test
    public void testIsBoardFull() {
        char[] board1 = { 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X' };
        assertTrue(BoardUtils.isBoardFull(board1));

        char[] board2 = { 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', '9' };
        assertFalse(BoardUtils.isBoardFull(board2));
    }
}