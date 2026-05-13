package Utils;

import java.util.Scanner;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);
    public static String etStringInput(String prompt){
        while(true){
            System.out.print(prompt);
            String input = scanner.nextLine();
            if(HelperUtils.isValidString(input)){
                return input;
            }
            System.out.println("Please enter a valid string");
        }
    }
    public static int getIntInput(String prompt, int min, int max) {
        while(true){
            int num =getIntInput(prompt, min, max);
            if (HelperUtils.isValidNumber(num, min, max)) {
                return num;
            }
            System.out.println("Please enter a valid number");
        }
    }
    public static int getIntInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        double num = Double.parseDouble(input);


    }
}
