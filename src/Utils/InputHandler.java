package Utils;

import Utils.HelperUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (HelperUtils.isValidString(input)) {
                return input;
            }
            System.out.println("Please enter a valid string");
        }
    }

    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer");
            }
        }
    }

    public static int getIntInput(String prompt, int min, int max) {
        while (true) {
            int num = getIntInput(prompt);
            if (HelperUtils.isValidNumber(num, min, max)) {
                return num;
            }
            System.out.println("Please enter a number between " + min + " and " + max);
        }
    }

    public static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static Date getDateInput(String prompt) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            if (!HelperUtils.isValidDate(dateStr)) {
                System.out.println("Please enter a valid date in dd-MM-yyyy format");
                continue;
            }
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Please enter a valid date");
            }
        }
    }

    public static boolean getConfirmation(String prompt) {
        while (true) {
            System.out.print(prompt + " (yes/no): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            }
            if (input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Please answer yes or no");
        }
    }
    public static LocalDate getLocalDateInput(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (!HelperUtils.isValidDate(input)) {
                System.out.println("Invalid date format");
                continue;
            }

            return LocalDate.parse(input, formatter);
        }
    }
}