import java.util.Scanner;

public class App {

    // Додаємо символ для першого гравця (користувача)
    public static final char PLAYER_X_SYMBOL = 'X';

    // Додаємо символ для другого гравця (комп'ютера)
    public static final char PLAYER_O_SYMBOL = 'O';

    // Вказуємо розмір дошки (кількість клітин)
    public static final int BOARD_SIZE = 9;

       public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] board = new char[BOARD_SIZE];
        boolean boxEmpty = false;
        char winner = 0;

        // Ініціалізуємо дошку перед самою грою
        initializeBoard(board);
        System.out.println("Введіть номер клітини, щоб зробити хід. Гарної гри!\n");

        while (true) {
            // Виводимо дошку на екран
            displayBoard(board);

            // Якщо дошка пуста, ініціалізуємо її знову
            if (!boxEmpty) {
                initializeBoard(board);
                boxEmpty = true;
            }

            // Перевіряємо, чи є переможець або чи є нічия
            if (winner == PLAYER_X_SYMBOL) {
                displayWinnerMessage("Ви перемогли");
                break;
            } else if (winner == PLAYER_O_SYMBOL) {
                displayWinnerMessage("Ви програли");
                break;
            } else if (winner == 'D') {
                displayWinnerMessage("Нічия");
                break;
            }

            // Отримуємо введений користувачем хід
            int userInput = getUserInput(scan);

            // Перевіряємо, чи є введений хід допустимим
            if (isValidMove(board, userInput)) {
                // Виконуємо хід користувача
                makeMove(board, userInput, PLAYER_X_SYMBOL);

                // Перевіряємо, чи є переможець після ходу користувача
                winner = checkWinner(board, PLAYER_X_SYMBOL);

                // Якщо переможця немає, ходимо комп'ютером
                if (winner == 0) {
                    int computerMove = getComputerMove(board);
                    makeMove(board, computerMove, PLAYER_O_SYMBOL);

                    // Перевіряємо, чи є переможець після ходу комп'ютера
                    winner = checkWinner(board, PLAYER_O_SYMBOL);
                }
            } else {
                System.out.println("Недопустимий хід. Введіть ще раз.");
            }
        }
    }
       // Ініціалізує дошку з символами  1 до 9
       public static void initializeBoard(char[] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = (char) ('1' + i);
        }
    }

      // Виводить дошку на екран.
    public static void displayBoard(char[] board) {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    //  Виводить повідомлення про переможця гри
      public static void displayWinnerMessage(String message) {
        System.out.println(message + " гру!\nСтворено Shreyas Saha. Дякуємо за гру!");
    }

    //  Отримує хід користувача
    public static int getUserInput(Scanner scan) {
        return scan.nextInt();
    }


    //  Перевіряє, чи є введений хід допустимим
    public static boolean isValidMove(char[] board, int input) {
        return input > 0 && input <= BOARD_SIZE && (board[input - 1] != PLAYER_X_SYMBOL && board[input - 1] != PLAYER_O_SYMBOL);
    }

    //  Виконує хід гравця
    public static void makeMove(char[] board, int input, char symbol) {
        board[input - 1] = symbol;
    }

    // Отримує хід комп'ютера
    public static int getComputerMove(char[] board) {
        int move;
        do {
            move = (int) (Math.random() * (BOARD_SIZE - 1 + 1) + 1);
        } while (board[move - 1] == PLAYER_X_SYMBOL || board[move - 1] == PLAYER_O_SYMBOL);
        return move;
    }

    //  Перевіряє, чи є переможець на дошці після здійснення ходу
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
            return 'D'; // D означає "нічия"
        } else {
            return 0; // 0 означає, що переможця поки немає
        }
    }

       //  Перевіряє, чи заповнена дошка
    public static boolean isBoardFull(char[] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i] != PLAYER_X_SYMBOL && board[i] != PLAYER_O_SYMBOL) {
                return false; // Якщо знайдено хоча б одну пусту клітину, дошка не заповнена
            }
        }
        return true; // Якщо всі клітини заповнені, дошка заповнена
    }
}

