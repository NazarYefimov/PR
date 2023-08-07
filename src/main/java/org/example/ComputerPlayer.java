package org.example;

// Цей клас відповідає за роботу комп'ютерного гравця
public class ComputerPlayer {

    public static int getComputerMove(char[] board) {
        int move;
        do {
            move = (int) (Math.random() * (App.BOARD_SIZE - 1 + 1) + 1);
        } while (board[move - 1] == App.PLAYER_X_SYMBOL || board[move - 1] == App.PLAYER_O_SYMBOL);
        return move;
    }
}
