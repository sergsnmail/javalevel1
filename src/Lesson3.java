import java.util.Random;
import java.util.Scanner;

/**
 * String[] words = {   "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
 * "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
 * "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
 * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
 * словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые
 * стоят на своих местах.
 * Пример:
 * apple – загаданное
 * apricot - ответ игрока
 * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 * Для сравнения двух слов посимвольно можно пользоваться:
 * String str = "apple";
 * char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
 * Играем до тех пор, пока игрок не отгадает слово.
 * Используем только маленькие буквы.
 */

public class Lesson3 {

    public static void main(String[] args) {
        String hiddenWord = makeWord();
        System.out.print("I made a word. Try to guess it.\nType your answer: ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        char[] outputStr = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        char[] hiddenWordChar = hiddenWord.toCharArray();
        while (!hiddenWord.equals(answer)) {
            checkAnswer(hiddenWordChar, answer, outputStr);
            System.out.print("Wrong answer. Try again.\nType your answer: ");
            answer = sc.next();
        }
        System.out.println("Well done!");
        sc.close();
    }

    private static void checkAnswer(char[] hiddenWordChar, String answer, char[] outputStr) {
        char[] answerChar = answer.toCharArray();

        for (int i = 0; i < hiddenWordChar.length; i++) {
            if (i > answerChar.length - 1) {
                break;
            }
            if (i < outputStr.length && hiddenWordChar[i] == answerChar[i] && outputStr[i] == '#') {
                outputStr[i] = hiddenWordChar[i];
            }
        }
        System.out.println(new String(outputStr));
    }

    private static String makeWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                          "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                          "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rnd = new Random();
        return words[rnd.nextInt(words.length)];
    }

}
