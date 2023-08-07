package org.example;

import java.util.Scanner;

// Відповідно до  принципів SOLID клас має мати 1 причину для змін, тому ми створюємо  окремі класи, для винесення методів. Ось головний клас програми "Крестики-нолики"
// Потім на кожний клас будуємо свої тести (Назви пакетів основних класів та тестових повинні бути однаковими)
public class App {

    // Це символ для першого гравця (користувача)
    public static final char PLAYER_X_SYMBOL = 'X';
    // Це символ для другого гравця (комп'ютера)
    public static final char PLAYER_O_SYMBOL = 'O';
    // Це розмір дошки (кількість клітин)
    public static final int BOARD_SIZE = 9;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] board = new char[BOARD_SIZE];
        boolean boxEmpty = false;
        char winner = 0;

         // Тут ініціалізуємо дошку перед початком гри
        BoardUtils.initializeBoard(board);
        System.out.println("Введіть номер клітини, щоб зробити хід. Гарної гри!\n");

        while (true) {
            BoardUtils.displayBoard(board);

            // Тепер перевіряємо, чи є переможець або нічия
            if (!boxEmpty) {
                BoardUtils.initializeBoard(board);
                boxEmpty = true;
            }

            if (winner == PLAYER_X_SYMBOL) {
                BoardUtils.displayWinnerMessage("Ви перемогли");
                break;
            } else if (winner == PLAYER_O_SYMBOL) {
                BoardUtils.displayWinnerMessage("Ви програли");
                break;
            } else if (winner == 'D') {
                BoardUtils.displayWinnerMessage("Нічия");
                break;
            }

            int userInput = BoardUtils.getUserInput(scan);

            // Перевіряємо, чи є введений хід допустимим
            if (BoardUtils.isValidMove(board, userInput)) {
                // Виконуємо хід користувача
                BoardUtils.makeMove(board, userInput, PLAYER_X_SYMBOL);
                winner = BoardUtils.checkWinner(board, PLAYER_X_SYMBOL);

                // Якщо переможця немає, ходимо комп'ютером
                if (winner == 0) {
                    int computerMove = ComputerPlayer.getComputerMove(board);
                    BoardUtils.makeMove(board, computerMove, PLAYER_O_SYMBOL);
                    // Перевіряємо, чи є переможець після ходу комп'ютера
                    winner = BoardUtils.checkWinner(board, PLAYER_O_SYMBOL);
                }
            } else {
                System.out.println("Недопустимий хід. Введіть ще раз.");
            }
        }
    }
}