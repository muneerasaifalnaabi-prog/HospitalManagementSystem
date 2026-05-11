package Services;

import Entities.Patient;
import Utiles.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    static Scanner scanner = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public void addaddPatients() {
        while (true) {
            Patient p = addPatient();
            if (p != null) {
                patients.add(p);
                System.out.println("Patient added successfully.");
            }
            System.out.println("Press q to go back to menu or press Enter to add another patient:");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                return;
            }
        }
    }

    public Patient addPatient() {
        System.out.println("========= Added New Patient =====");

        System.out.println("Enter id :");
        String id = scanner.nextLine();

        Patient existing = getPatientById(id);
        if (existing != null) {
            System.out.println("ID already exists!");
            return null;
        }

        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter last Name: ");
        String lname = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = null;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter date Of Birth (dd-MM-yyyy): ");
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use dd-MM-yyyy.");
            }
        }

        System.out.println("Enter gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter phoneNumber:");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Physical Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter patient id string:");
        String patientid = scanner.nextLine();

        System.out.print("Enter Blood Group (e.g., O+, A-): ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Emergency Contact Name/Phone: ");
        String emergencyContact = scanner.nextLine();

        System.out.print("Enter Insurance ID: ");
        String insuranceId = scanner.nextLine();

        System.out.print("Enter Registration Date (YYYY-MM-DD) [Leave empty for today's date]: ");
        String regInput = scanner.nextLine();
        LocalDate registrationDate;
        if (regInput.isEmpty()) {
            registrationDate = LocalDate.now();
        } else {
            registrationDate = LocalDate.parse(regInput);
        }

        return new Patient(id, fname, lname, date, gender, phoneNumber,
                email, address, patientid, bloodGroup, new ArrayList<>(), emergencyContact, registrationDate,
                insuranceId, new ArrayList<>(), new ArrayList<>());
    }

    public Patient getPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }

    public void editPatient(String patientId) {
        Patient p = getPatientById(patientId);
        if (p != null) {
            System.out.println("Editing Patient: " + p.getFirstName());
            System.out.println("Enter new phone number:");
            p.setPhoneNumber(scanner.nextLine());

            System.out.println("Enter new Email:");
            p.setEmail(scanner.nextLine());

            System.out.println("Enter new Address Line:");
            p.setAddress(scanner.nextLine());

            System.out.println("Enter new Emergency Contact Name:");
            p.setEmergencyContact(scanner.nextLine());

            System.out.println("Enter new Insurance ID:");
            p.setInsuranceId(scanner.nextLine());
            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    public void removePatient(String patientId) {
        Patient p = getPatientById(patientId);
        if (p != null) {
            patients.remove(p);
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient not found");
        }
    }

    public List<Patient> searchPatientsByName(String name) {
        List<Patient> results = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getFirstName().toLowerCase().contains(name.toLowerCase())) {
                results.add(p);
            }
        }
        return results;
    }

    public void searchPatients() {
        System.out.println("Enter Patient Name to search:");
        String searchName = scanner.nextLine();
        List<Patient> searchResults = searchPatientsByName(searchName);

        if (!searchResults.isEmpty()) {
            for (Patient p : searchResults) {
                p.displayInfo();
            }
        } else {
            System.out.println("No matches found");
        }

        System.out.println("Enter q to quit or enter key to continue searching:");
        if (scanner.nextLine().equalsIgnoreCase("q")) {
            return;
        }
        searchPatients();
    }

    public void displayAllPatients() {
        System.out.println("===== All Patients =====");
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        }
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    public void handelPatientServic() {
        String input = scanner.nextLine();
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            handelPatientServic();
            return;
        }

        switch (option) {
            case 1 -> addaddPatients();
            case 2 -> {
                System.out.println("Enter ID of patient to edit:");
                editPatient(scanner.nextLine());
            }
            case 3 -> {
                System.out.println("Enter ID of patient to remove:");
                removePatient(scanner.nextLine());
            }
            case 4 -> searchPatients();
            case 5 -> displayAllPatients();
            case 6 -> {
                System.out.println("Exit from Application");
                return;
            }
            default -> System.out.println("Invalid option");
        }
        handelPatientServic();
    }
}