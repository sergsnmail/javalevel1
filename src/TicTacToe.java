import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        /**
         *  Размер игрового поля.
         */
        int fieldSize = 3;

        /**
         * Коичество фишек расположенных по порядку, для фиксации выигрыша
         */
        int signWinCount = 3;

        /**
         * Фишка игрока
         */
        char playerSign = 'X';

        /**
         * Фишка компьютера
         */
        char aiSign = 'O';

        Scanner sc = new Scanner(System.in);
        while (true) {
            startGame(fieldSize, signWinCount, playerSign, aiSign);
            System.out.print("Try again [y/n]:");
            if (!sc.next().toUpperCase().equals("Y")) {
                break;
            }
        }
    }

    /**
     * Основной игровой цикл
     *
     * @param fieldSize размер игрового поля
     * @param signWinCount количество фишек расположенных по порядку, для фиксации выигрыша
     * @param playerSign фишка игрока
     * @param aISign фишка компьютера
     */
    private static void startGame(int fieldSize, int signWinCount, char playerSign, char aISign) {
        char[][] field = createField(fieldSize, '.');
        drawField(field);
        int maxTurnCount = fieldSize * fieldSize;
        int currentTurn = 1;
        boolean hasWinner = false;

        while (currentTurn <= maxTurnCount) {
            System.out.println("You turn");
            playerTurn(playerSign, field);
            hasWinner = winChecker(field, playerSign, signWinCount);
            if (hasWinner) {
                System.out.println("You win!");
                break;
            }
            System.out.println("AI turn");
            //aIRandomTurn(field, aISign);
            aIAnalyzedTurn(field, aISign, playerSign, signWinCount);
            hasWinner = winChecker(field, aISign, signWinCount);
            if (hasWinner) {
                System.out.println("AI win!");
                break;
            }
            currentTurn += 2;
        }
        if (!hasWinner) {
            System.out.println("Draw!");
        }
    }

    /**
     *  Метод определения хода искуственного интеллекта на основе уже расставленных фишек на игровом поле
     *
     * 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
     *
     * @param field игровое поле
     * @param aISign фишка компьтера
     * @param playerSign фишка игрока
     * @param signWinCount количество фишек по порядку для выигрыша
     */
    private static void aIAnalyzedTurn(char[][] field, char aISign, char playerSign, int signWinCount) {

        boolean isAITurned = false;

        // Find my final turn
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == '.') {
                    field[i][j] = aISign;
                    if (winChecker(field, aISign, signWinCount)) {
                        field[i][j] = aISign;
                        isAITurned = true;
                        break;
                    } else {
                        field[i][j] = '.';
                    }
                }
            }
            if (isAITurned) {
                break;
            }
        }

        // Find enemy final turn
        if (!isAITurned) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == '.') {
                        field[i][j] = playerSign;
                        if (winChecker(field, playerSign, signWinCount)) {
                            field[i][j] = aISign;
                            isAITurned = true;
                            break;
                        } else {
                            field[i][j] = '.';
                        }
                    }
                }
                if (isAITurned) {
                    break;
                }
            }
        }

        // Turned to any empty cell around enemy sign
        if (!isAITurned) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == playerSign) {
                        // right cell
                        if (j + 1 <= field.length - 1 && field[i][j + 1] == '.') {
                            field[i][j + 1] = aISign;
                            isAITurned = true;
                            break;
                        }
                        // bottom right cell
                        if (i + 1 < field.length && j + 1 < field.length && field[i + 1][j + 1] == '.') {
                            field[i + 1][j + 1] = aISign;
                            isAITurned = true;
                            break;
                        }
                        // bottom cell
                        if (i + 1 < field.length && field[i + 1][j] == '.') {
                            field[i + 1][j] = aISign;
                            isAITurned = true;
                            break;
                        }
                        // bottom left cell
                        if (i + 1 < field.length && j - 1 >= 0 && field[i + 1][j - 1] == '.') {
                            field[i + 1][j - 1] = aISign;
                            isAITurned = true;
                            break;
                        }
                        // left cell
                        if (j - 1 >= 0 && field[i][j - 1] == '.') {
                            field[i][j - 1] = aISign;
                            isAITurned = true;
                            break;
                        }
                        // upper left cell
                        if (i - 1 >= 0 && j - 1 >= 0 && field[i - 1][j - 1] == '.') {
                            field[i - 1][j - 1] = aISign;
                            isAITurned = true;
                            break;
                        }
                        // upper cell
                        if (i - 1 >= 0 && field[i - 1][j] == '.') {
                            field[i - 1][j] = aISign;
                            isAITurned = true;
                            break;
                        }
                        // upper right cell
                        if (i - 1 >= 0 && j + 1 < field.length && field[i - 1][j + 1] == '.') {
                            field[i - 1][j + 1] = aISign;
                            isAITurned = true;
                            break;
                        }
                    }
                }
                if (isAITurned) {
                    break;
                }
            }

        }
        drawField(field);
    }

    /**
     * Метод определения хода искуственного интеллкта на основе случайных чисел
     *
     * @param field игровое поле
     * @param sign фишка комьютера
     */
    private static void aIRandomTurn(char[][] field, char sign) {
        Random rnd = new Random();
        int x, y;
        do {
            x = rnd.nextInt(field.length + 1);
            y = rnd.nextInt(field.length + 1);
        } while (!isCoordsValid(x, y, field));
        field[y][x] = sign;
        drawField(field);
    }

    /**
     * Метод для проверки игрового поля, любого квадратного размера, на наличие выигрышной последовательности фишек.
     *
     * 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
     * Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
     *
     * @param field игровое поле
     * @param turnSign фишка для проверки
     * @param signWinCount необходимое количество фишек в последовательности для фиксации выигрыша
     * @return истина если последовательность найдена, иначе ложь
     */
    private static boolean winChecker(char[][] field, char turnSign, int signWinCount) {
        int checkCount = field.length;
        int signCount = 0;

        if (signWinCount <= 0 || signWinCount > checkCount) {
            signWinCount = checkCount;
        }

        /**
         * Проверка всех горизонталей
         */
        for (int i = 0; i < checkCount; i++) {
            signCount = 0;
            for (int j = 0; j < checkCount; j++) {
                if (field[i][j] == turnSign) {
                    signCount++;
                } else {
                    signCount = 0;
                }
                if (signCount >= signWinCount) {
                    return true;
                }
            }
        }

        /**
         * Проверка всех вертикалей
         */
        for (int i = 0; i < checkCount; i++) {
            signCount = 0;
            for (int j = 0; j < checkCount; j++) {
                if (field[j][i] == turnSign) {
                    signCount++;
                } else {
                    signCount = 0;
                }
                if (signCount >= signWinCount) {
                    return true;
                }
            }
        }

        /**
         * Проверка всех левых диагоналей
         */
        int diagonalsNumber = field.length * 2 - 1;
        int countCell = 1;
        int startColumn = field.length - 1;
        int startRow = 0;
        int row = startRow;
        int column = startColumn;
        for (int i = 1; i <= diagonalsNumber; i++) {
            signCount = 0;
            int j = 0;
            while (j < countCell) {
                if (field[row][column] == turnSign) {
                    signCount++;
                } else {
                    signCount = 0;
                }
                if (signCount >= signWinCount) {
                    return true;
                }
                row++;
                column++;
                j++;
            }
            if (i < diagonalsNumber / 2 + 1) {
                startRow = 0;
                countCell++;
                startColumn--;
            } else {
                startRow++;
                countCell--;
                startColumn = 0;
            }
            row = startRow;
            column = startColumn;
        }

        /**
         * Проверка всех правых диагоналей
         */
        countCell = 1;
        startColumn = 0;
        startRow = 0;
        row = startRow;
        column = startColumn;
        for (int i = 1; i <= diagonalsNumber; i++) {
            signCount = 0;
            int j = 0;
            while (j < countCell) {
                if (field[row][column] == turnSign) {
                    signCount++;
                } else {
                    signCount = 0;
                }
                if (signCount >= signWinCount) {
                    return true;
                }
                row++;
                column--;
                j++;
            }
            if (i < diagonalsNumber / 2 + 1) {
                startRow = 0;
                countCell++;
                startColumn++;
            } else {
                startRow++;
                countCell--;
                startColumn = field.length - 1;
            }
            row = startRow;
            column = startColumn;
        }
        return false;
    }

    /**
     * Метод хода игрока
     *
     * @param pSign фишка игрока
     * @param field игровое поле
     */
    private static void playerTurn(char pSign, char[][] field) {
        int x, y;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("Enter X in range [1-%s]: ", field.length);
            x = sc.nextInt() - 1;
            System.out.printf("Enter Y in range [1-%s]: ", field.length);
            y = sc.nextInt() - 1;
        } while (!isCoordsValid(x, y, field));
        field[y][x] = pSign;
        drawField(field);
    }

    /**
     * Метод проверки введеных значений координат хоа игрока на корректность
     *
     * @param x координата по Х
     * @param y координата по У
     * @param field игровое поле
     * @return истина если значения координат корректны, иначе ложь
     */
    private static boolean isCoordsValid(int x, int y, char[][] field) {
        int fieldRange = field.length - 1;
        if (x < 0 || x > fieldRange || y < 0 || y > fieldRange || field[y][x] != '.') {
            return false;
        }
        return true;
    }

    /**
     * Метод создания игрового поля заданного размера
     *
     * @param size размер игрового поля
     * @param initValue соимвол пустого значения
     * @return возвращает двумердный массив игрового поля
     */
    private static char[][] createField(int size, char initValue) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = initValue;
            }
        }
        return field;
    }

    /**
     * Метод отрисовки игровго поля
     *
     * @param field массив игрового поля
     */
    private static void drawField(char[][] field) {
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(String.format("%s", field[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }
}
