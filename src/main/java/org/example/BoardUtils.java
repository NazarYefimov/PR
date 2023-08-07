package org.example;

import java.util.Scanner;

// Тут ми створили утилітарний клас для роботи з дошкою гри
public class BoardUtils {
    public static final char PLAYER_X_SYMBOL = 'X';
    public static final char PLAYER_O_SYMBOL = 'O';
    public static final int BOARD_SIZE = 9;

    // Ініціалізуємо дошку з символами 1 до 9
    public static void initializeBoard(char[] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = (char) ('1' + i);
        }
    }

    // Виводимо дошку на екран
    public static void displayBoard(char[] board) {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }
    // Виводить повідомлення про переможця гри
    public static void displayWinnerMessage(String message) {
        System.out.println(message + " гру!\nСтворено Shreyas Saha. Дякуємо за гру!");
    }
    // Отримуємо хід користувача
    public static int getUserInput(Scanner scan) {
        return scan.nextInt();
    }
    // Перевіряємо, чи є введений хід допустимим
    public static boolean isValidMove(char[] board, int input) {
        return input > 0 && input <= BOARD_SIZE && (board[input - 1] != PLAYER_X_SYMBOL && board[input - 1] != PLAYER_O_SYMBOL);
    }
    // Виконує хід гравця
    public static void makeMove(char[] board, int input, char symbol) {
        board[input - 1] = symbol;
    }
    // Перевіряє, чи заповнена дошка
    public static boolean isBoardFull(char[] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i] != PLAYER_X_SYMBOL && board[i] != PLAYER_O_SYMBOL) {
                return false; // Якщо знайдено хоча б одну пусту клітину, дошка не заповнена
            }
        }
        return true; // Якщо всі клітини заповнені, дошка заповнена
    }
    // Тепер на потрібно перевірити, чи є переможець на дошці після здійснення ходу
    public static char checkWinner(char[] board, char symbol) {
        if ((board[0] == symbol && board[1] == symbol && board[2] == symbol) ||
                (board[3] == symbol && board[4] == symbol && board[5] == symbol) ||
                (board[6] == symbol && board[7] == symbol && board[8] == symbol) ||
                (board[0] == symbol && board[3] == symbol && board[6] == symbol) ||
                (board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
                (board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
                (board[0] == symbol && board[4] == symbol && board[8] == symbol) ||
                (board[2] == symbol && board[4] == symbol && board[6] == symbol)) {
            return symbol;
        } else if (isBoardFull(board)) {
            return 'D'; // означає "нічия"
        } else {
            return 0; // означає, що переможця поки немає
        }
    }
}