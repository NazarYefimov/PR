package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {

    @Test
    public void testGetComputerMove() {
        char[] board = { 'X', 'O', 'X', 'O', 'X', '6', 'O', 'X', '9' };
        int computerMove = ComputerPlayer.getComputerMove(board);
        assertTrue(computerMove >= 1 && computerMove <= BoardUtils.BOARD_SIZE);
        assertTrue(board[computerMove - 1] != BoardUtils.PLAYER_X_SYMBOL && board[computerMove - 1] != BoardUtils.PLAYER_O_SYMBOL);
    }
}
