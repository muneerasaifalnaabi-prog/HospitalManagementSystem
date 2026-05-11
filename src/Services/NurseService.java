package Services;

import Entities.Nurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService {
static Scanner scanner=new Scanner(System.in);
static List<Nurse> Nurses=new ArrayList<Nurse>();

public void addNurses(){
    while(true){
        Nurse n = addNurse();
        if(n==null){
            Nurses.add(n);
            System.out.println("Nurse Added Successfully");
        }
        System.out.println("Press q to quit ");
        if (scanner.nextLine().equalsIgnoreCase("q")) {
            return;
        }
    }

}

public Nurse addNurse() {
        System.out.println("========= Added New Nurse =====");

        System.out.println("Enter id:");
        String id = scanner.nextLine();

        Nurse existNurse = getNurseById(id);

        if (existNurse != null) {
            System.out.println("ID already exists");
            return null;
        }

        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lname = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = null;
        boolean valid = false;

        while (!valid) {

            System.out.print("Enter Date Of Birth (dd-MM-yyyy): ");
            String input = scanner.nextLine();

            try {
                date = LocalDate.parse(input, formatter);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format or value. Please try again.");
            }
        }

        System.out.println("Enter gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Physical Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter nurse id:");
        String nurseId = scanner.nextLine();

        System.out.print("Enter Department ID: ");
        String departmentId = scanner.nextLine();

        System.out.print("Enter Shift: ");
        String shift = scanner.nextLine();

        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();

        Nurse nurse = new Nurse(
                id,
                fname,
                lname,
                date,
                gender,
                phoneNumber,
                email,
                address,
                nurseId,
                departmentId,
                shift,
                qualification,
                new ArrayList<>()
        );

        return nurse;
    }

    public Nurse getNurseById(String nurseId) {

        for (Nurse n : nurses) {

            if (n.getId().equals(nurseId)) {
                return n;
            }
        }

        return null;
    }


}
