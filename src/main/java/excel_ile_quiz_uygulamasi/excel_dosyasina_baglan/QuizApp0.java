package excel_ile_quiz_uygulamasi.excel_dosyasina_baglan;

import java.io.IOException;
import java.util.Scanner;

public class QuizApp0 {
    private static boolean isRunning = true;
    private static Scanner input = new Scanner(System.in);
    private static ExcelConnection0 excel;
    private static String username;
    private static String password;
    private static int i = 0;
    private static int counter = 0;
    private static boolean isLoggedIn = false;

    public static void main(String[] args) throws IOException {
        //Excel dosyasına bağlanma işlemi
        excel = new ExcelConnection0();
        excel.connect();

        System.out.println("\n...Welcome to the Quiz App...\n");

        while (isRunning) {
            if (!isLoggedIn) {
                int choice = displayLoginMenu();
                if (choice == 1) {
                    login();
                } else if (choice == 2) {
                    signUp();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                //quiz logic
            }
        }

        System.out.println("Total number of questions: " + excel.getNumberOfRows());
        System.out.println("\n______________________________\nQUESTIONS");

        // Bütün soruları okuma
        for (int i = 0; i < excel.getNumberOfRows()+1; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(excel.getSheet1().getRow(i).getCell(j) + ", ");
            }
        }

        //Excel dosyasını kaydetme ve kapatma işlemi
        excel.disconnect();
    }

    public static int displayLoginMenu() {
        System.out.print("What would you like to do?\n\tLogin --> Press 1\n\tSign Up --> Press 2\nYour choice: ");
        return input.nextInt();
    }

    public static void login() {
        while (!isLoggedIn) {
            System.out.print("Enter your username: ");
            username = input.next();
            for (i = 0; i < excel.getNumberOfRows()+1; i++) {
                if (username.equals(excel.getSheet1().getRow(i).getCell(0).getStringCellValue())) {
                    counter = 1;
                }
            }
            if (counter == 1) {
                System.out.print("Enter your password: ");
                password = input.next();
                if (password.equals(excel.getSheet1().getRow(i).getCell(1).getStringCellValue())) {
                    isLoggedIn = true;
                    System.out.println("Welcome, " + username + "!");
                } else {
                    System.out.println("Incorrect password. Please try again.");
                }
            } else {
                System.out.println("Username not found. Please try again.");
            }
        }
    }

    public static void signUp() {
        while (!isLoggedIn) {
            int counter = 0;
            System.out.print("Enter a new username: ");
            username = input.next();
            for (i = 0; i < excel.getNumberOfRows()+1; i++) {
                if (username.equals(excel.getSheet1().getRow(i).getCell(0).getStringCellValue())) {
                    counter = 1;
                }
            }
            if (counter == 0) {
                excel.getSheet1().createRow(excel.getNumberOfRows()+1).createCell(0).setCellValue(username);
                excel.getSheet2().createRow(excel.getNumberOfRows()+1).createCell(0).setCellValue(username);
                System.out.print("Enter a new password: ");
                password = input.next();
                excel.getSheet1().getRow(excel.getNumberOfRows()+1).createCell(1).setCellValue(password);
                isLoggedIn = true;
                System.out.println("Account created successfully!");
            } else {
                System.out.println("Username already taken. Please choose a different one.");
            }
        }
    }
}
