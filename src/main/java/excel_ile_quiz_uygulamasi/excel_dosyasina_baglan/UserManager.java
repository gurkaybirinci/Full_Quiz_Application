package excel_ile_quiz_uygulamasi.excel_dosyasina_baglan;

import java.util.Scanner;

public class UserManager {
    private ExcelConnection excel;
    private boolean isLoggedIn;
    private String username;
    private String password;
    private int i;
    Scanner input = new Scanner(System.in);

    public UserManager() {
        excel = new ExcelConnection();
        excel.connect();
    }

    public void signUp() {
        int counter = 0;
        System.out.print("Enter a new username: ");
        username = input.next();
        for (i = 0; i < excel.getNumberOfRows(); i++) {
            if (username.equals(excel.getSheet().getRow(i).getCell(0).getStringCellValue())) {
                counter = 1;
                System.out.println("This username is already taken. Please try again.");
                break;
            }
        }

        if (counter == 0) {
            System.out.print("Enter a new password: ");
            password = input.next();
            excel.getSheet().createRow(excel.getNumberOfRows()).createCell(0).setCellValue(username);
            excel.getSheet().getRow(excel.getNumberOfRows()-1).createCell(1).setCellValue(password);
            excel.close();
            System.out.println("Sign up successful!");
            isLoggedIn = true;
        }
    }


//    public void signUp() {
//        while (!isLoggedIn) {
//            int counter = 0;
//            System.out.print("Enter a new username: ");
//            username = input.next();
//            for (i = 0; i < excel.getNumberOfRows(); i++) {
//                if (username.equals(excel.getSheet().getRow(i).getCell(0).getStringCellValue())) {
//                    counter = 1;
//                }
//            }
//
//            if (counter == 0) {
//                excel.getSheet().createRow(excel.getNumberOfRows()).createCell(0).setCellValue(username);
//                System.out.print("Enter a new password: ");
//                password = input.next();
//                excel.getSheet().getRow(excel.getNumberOfRows()).createCell(1).setCellValue(password);
//                isLoggedIn = true;
//                excel.close();
//                System.out.println("Account created successfully!");
//            } else {
//                System.out.println("Username already taken. Please choose a different one.");
//            }
//        }
//    }
    public void signIn() {
        while (!isLoggedIn) {
            System.out.print("Enter your username: ");
            username = input.next();
            for (i = 0; i < excel.getNumberOfRows(); i++) {
                if (username.equals(excel.getSheet().getRow(i).getCell(0).getStringCellValue())) {
                    System.out.print("Enter your password: ");
                    password = input.next();
                    if (password.equals(excel.getSheet().getRow(i).getCell(1).getStringCellValue())) {
                        isLoggedIn = true;
                        excel.close();
                        System.out.println("Login successful!");
                        break;
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                    }
                }
            }
            if (!isLoggedIn) {
                System.out.println("Incorrect username. Please try again.");
            }
        }
    }
}
