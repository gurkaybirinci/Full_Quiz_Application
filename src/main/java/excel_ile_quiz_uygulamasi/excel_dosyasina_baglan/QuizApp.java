package excel_ile_quiz_uygulamasi.excel_dosyasina_baglan;

import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Quiz App!");

        while (true) {
            System.out.print("Enter 1 to Sign Up, 2 to Sign In, or 3 to Exit: ");
            int choice = input.nextInt();
            if (choice == 1) {
                userManager.signUp();
                break;
            } else if (choice == 2) {
                userManager.signIn();
                break;
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
