package com.sergsnmail.level1.lesson8;

/**
 * Класс для построения текстового поля калькулятора
 */
public class ExpressionHelper {

    /**
     * Добаить строку к исходной строке.
     *
     * @param sourceStr Исходная строка
     * @param appendStr Строка для добавления
     * @return Новая строка
     */
    public static String append(String sourceStr, String appendStr) {
        StringBuilder stringBuilder;
        String localAppendStr = appendStr;
        String localSourceStr = sourceStr;
        if (localAppendStr != null && !localAppendStr.isEmpty()) {

            /**
             * Если добавляем функцию [sqr], или символ не являющийся числом (=> это опретаор из набора [+,-,*,/,^]).
             */
            if (localAppendStr.length() > 1 || !isDigit(localAppendStr.charAt(0)) && localAppendStr.charAt(0) != '.') {

                if (localSourceStr.length() > 0) {
                    /**
                     * Если предыдущий символ опертаор, и мы пытаемся добавить еще один опрертор, то удаляем предыдущий оператор
                     * Проверяется предыдущий символ, если это не цифра и не ')' => это один из операторов [+,-,*,/]
                     */
                    if (!isDigit(localSourceStr.charAt(localSourceStr.length() - 1)) && localSourceStr.charAt(sourceStr.length() - 1) != ')') {
                        localSourceStr = remove(localSourceStr, 1);
                    }

                    /**
                     * Если добавляем функцию sqr(), то берем предыдущее выражение/число и подсталвяем его в аргумент функции
                     */
                    if ("sqr".equals(localAppendStr)) {
                        String lastDigit = getLastExpr(localSourceStr);
                        if (lastDigit != null && !lastDigit.isEmpty()) {
                            int count = localSourceStr.length() - localSourceStr.lastIndexOf(lastDigit);
                            localSourceStr = remove(localSourceStr, count);
                            localAppendStr = "sqr" + "(" + lastDigit + ")";
                        }
                    }
                }
            }

            /**
             * Число можно добавлять к функции только через оператор
             */
            if (isDigit(localAppendStr.charAt(0))) {
                if (localSourceStr.length() > 0 && localSourceStr.charAt(localSourceStr.length() - 1) == ')') { // не даем добавить число без оператора к функции
                    localAppendStr = "";
                }
            }

            /**
             * Символ "." можно добавлять только к целому числу.
             */
            if (localAppendStr.equals(".")) {
                if ((localSourceStr.length() > 0 && !isDigit(localSourceStr.charAt(localSourceStr.length() - 1))) || (getDigitBackward(localSourceStr, localSourceStr.length() - 1).contains("."))) { // не даем добавить число без оператора к функции
                    localAppendStr = "";
                }
            }
        }
        stringBuilder = new StringBuilder(localSourceStr);
        stringBuilder.append(localAppendStr);
        return stringBuilder.toString();
    }

    /**
     * Удалить последний символ из строки
     *
     * @param sourceStr Исходная строка
     * @param count     Количество символов для удаления
     * @return Новая строка
     */
    public static String remove(String sourceStr, int count) {
        StringBuilder stringBuilder = new StringBuilder(sourceStr);
        if (stringBuilder.length() != 0) {
            stringBuilder.delete(stringBuilder.length() - count, stringBuilder.length());
        }
        return stringBuilder.toString();
    }

    /**
     * Получить предыдущее выражение (число или функцию)
     *
     * @param expStr
     * @return
     */
    private static String getLastExpr(String expStr) {
        if (expStr.charAt(expStr.length() - 1) == ')') {
            return getGroupBackward(expStr, expStr.length() - 1);
        } else {
            return getDigitBackward(expStr, expStr.length() - 1);
        }
    }

    /**
     * Получить предыдущую цифру
     *
     * @param exprStr Строка поиска
     * @param endIdx  Индекс начала поиска
     * @return Строка цифры
     */
    private static String getDigitBackward(String exprStr, int endIdx) {
        int beginIdx = 0;
        for (int i = endIdx; i >= 0; i--) {
            if (!isDigit(exprStr.charAt(i)) && exprStr.charAt(i) != '.') {
                beginIdx = i + 1;
                break;
            }
        }
        return exprStr.substring(beginIdx, endIdx + 1);
    }

    /**
     * Получить строку предыдущей функции с аргументами
     *
     * @param exprStr  Строка поиска
     * @param beginIdx Индекс начала поиска
     * @return Строка функции
     */
    private static String getGroupBackward(String exprStr, int beginIdx) {
        int totalCount = 1;
        int currentCount = 0;
        int currentIdx = beginIdx;
        char currentSymbol = 0;

        while (currentSymbol != '(' && currentCount != totalCount) {
            currentIdx--;
            currentSymbol = exprStr.charAt(currentIdx);
            if (currentSymbol == ')') {
                totalCount++;
            }
            if (currentSymbol == '(') {
                currentCount++;
            }
        }

        String funcName = getFuncName(exprStr, currentIdx - 1);

        return funcName + exprStr.substring(currentIdx, beginIdx + 1);
    }

    /**
     * Получить имя функции без аргументов
     *
     * @param exprStr Строка поиска
     * @param endIdx  Индекс начала поиска
     * @return Имя функции
     */
    private static String getFuncName(String exprStr, int endIdx) {
        int beginIdx = 0;
        for (int i = endIdx; i >= 0; i--) {
            if (!isLetter(exprStr.charAt(i))) {
                beginIdx = i + 1;
                break;
            }
        }
        return exprStr.substring(beginIdx, endIdx + 1);
    }

    /**
     * Проверка текущего символа на число
     *
     * @param ch символ для проверки
     * @return true если текущий символ число, иначе false
     */
    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * Проверка текущего символа на букву
     *
     * @param ch символ для проверки
     * @return true если текущий символ строка, иначе false
     */
    private static boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

}
