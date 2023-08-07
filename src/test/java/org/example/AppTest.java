package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

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
        assertEquals('X', BoardUtils.checkWinner(board1, App.PLAYER_X_SYMBOL));
        assertEquals('X', BoardUtils.checkWinner(board2, App.PLAYER_X_SYMBOL));
        assertEquals('X', BoardUtils.checkWinner(board3, App.PLAYER_X_SYMBOL));
        assertEquals('D', BoardUtils.checkWinner(board4, App.PLAYER_X_SYMBOL));
    }

    @Test
    public void testGetUserInputValidInput() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int userInput = BoardUtils.getUserInput(scanner);
        assertEquals(5, userInput);
    }

    @Test
    public void testGetUserInputInvalidInput() {
        String input = "invalid\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThrows(NoSuchElementException.class, () -> BoardUtils.getUserInput(scanner));
    }
}