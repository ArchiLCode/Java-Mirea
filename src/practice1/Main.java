package practice1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsumerUpLetters consumer = new ConsumerUpLetters();
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        consumer.accept(inputString);
    }
}
