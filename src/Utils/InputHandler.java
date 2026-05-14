package Utils;

import Utils.HelperUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
    // In InputHandler.java

    public static LocalDate getLocalDateInput(String prompt) {
        List<DateTimeFormatter> formatters = Arrays.asList(
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("d-M-yyyy"),
                DateTimeFormatter.ofPattern("dd-M-yyyy"),
                DateTimeFormatter.ofPattern("d-MM-yyyy")
        );

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            for (DateTimeFormatter formatter : formatters) {
                try {
                    return LocalDate.parse(input, formatter);
                } catch (DateTimeParseException e) {
                }
            }
            System.out.println("Invalid date format. Please use dd-MM-yyyy or d-M-yyyy (e.g., 12-05-2026 or 12-5-2026)");
        }
    }
}