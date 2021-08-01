import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class {@code PasswordGenerator} implemented an algorithm for generating passwords for email clients.
 *
 * @author Dmitrii A.
 * @version 1.0
 * @since JDK10.0.1
 */
public class PasswordGenerator {
    /**
     * This is a string field that stores the values of all characters in the alphabet, and numbers.
     */
    private final String VALUE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * This is a variable of an object of the Random class
     */
    private Random random = new Random();

    /**
     * Here start point of the program
     *
     * @param args command line values
     */
    public static void main(String[] args) {
        PasswordGenerator main = new PasswordGenerator();
        main.start();
    }

    /**
     * Here start point of the program
     */
    void start() {
        Scanner sc = new Scanner(System.in, "utf-8");// кодировки Cp866 -> "windows-1251"
        String comand;

        System.out.println("Сгенерировать новый пароль?\n\"Да \\ Нет\"");

        while (true) {
            comand = sc.nextLine().toLowerCase();

            if (comand.equals("да")) {
                clearConsole();
                System.out.println("\nПароль: " + passwordGenerator(sc));
                System.out.println("\nСгенерировать новый пароль?\n\"Да \\ Нет\"");
            } else {
                sc.close();
                break;
            }
        }
    }

    /**
     * This method will return generate a random character.
     *
     * @param sc number of characters to generate.
     * @return a string of random characters.
     */
    public String passwordGenerator(Scanner sc) {
        System.out.println("Укажите длину пароля");
        int passLength = Integer.parseInt(sc.nextLine());
        char charArrays[] = VALUE.toCharArray();

        String generateString = "";

        for (int i = 0; i < passLength; i++)
            generateString += charArrays[random.nextInt(62)];

        return generateString;
    }

    /**
     * This method for clear the Console screen!
     */
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
