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


}
