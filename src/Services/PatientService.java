package Services;

import Entities.Patient;
import Utils.Constants;
import Utils.MenuMessege;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {

    static Scanner scanner = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    public static List<Patient> getPatients(){
        return patients;
    }

    public void addaddPatients() {

        while (true) {

            Patient p = addPatient();

            if (p != null) {
                patients.add(p);
                System.out.println("Patient added successfully.");
            }

            System.out.println("Press q to go back to menu or press Enter to add another patient:");

            if (scanner.nextLine().equalsIgnoreCase("q")) {
                return;
            }
        }
    }

    public Patient addPatient() {

        System.out.println("========= Added New Patient =====");

        System.out.println("Enter id :");
        String id = scanner.nextLine();

        Patient existPatient = getPatientById(id);

        if (existPatient != null) {
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

        System.out.println("Enter patient id:");
        String patientid = scanner.nextLine();

        System.out.print("Enter Blood Group (e.g., O+, A-): ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Emergency Contact Name/Phone: ");
        String emergencyContact = scanner.nextLine();

        System.out.print("Enter Insurance ID: ");
        String insuranceId = scanner.nextLine();

        System.out.print("Enter Registration Date (dd-MM-yyyy): ");

        LocalDate registrationDate = null;
        boolean validRegistrationDate = false;

        while (!validRegistrationDate) {

            String input = scanner.nextLine();

            try {
                registrationDate = LocalDate.parse(input, formatter);
                validRegistrationDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter again:");
            }
        }

        Patient patient = new Patient(
                id,
                fname,
                lname,
                date,
                gender,
                phoneNumber,
                email,
                address,
                patientid,
                bloodGroup,
                new ArrayList<>(),
                emergencyContact,
                registrationDate,
                insuranceId,
                new ArrayList<>(),
                new ArrayList<>()
        );

        return patient;
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
            System.out.println("Patient not found");
        }
    }

    public void removePatient(String patientId) {

        Patient p = getPatientById(patientId);

        if (p != null) {

            patients.remove(p);
            System.out.println(Constants.REMOVE_PATIENT_SUCCESSFULLY);

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

        System.out.println("Search Results:");

        List<Patient> searchResults = searchPatientsByName(searchName);

        if (!searchResults.isEmpty()) {

            for (Patient p : searchResults) {
                p.displayInfo();
            }

        } else {
            System.out.println("No matches found");
        }

        System.out.println("Enter q to quit or enter key to continue");

        if (scanner.nextLine().equalsIgnoreCase("q")) {
            return;
        }

        searchPatients();
    }

    public void displayAllPatients() {

        System.out.println("===== All Patients =====");

        if (patients.isEmpty()) {
            System.out.println("No patients found");
            return;
        }

        for (Patient p : patients) {
            p.displayInfo();
        }
    }
    public void addPatient(String firstName, String lastName, String phone){
        Patient p = new Patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPhoneNumber(phone);
    }
    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email){
        Patient p = new Patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPhoneNumber(phone);
        p.setBloodGroup(bloodGroup);
    }
    public void addPatient(Patient patient){
        patients.add(patient);
        System.out.println(patient);
    }
    /*public void searchPatients(String keyword){
        System.out.println("Enter Patient Name to search:");
        String searchName = scanner.nextLine();
        System.out.println("Search Results:");
        List<Patient> searchResults = searchPatientsByName(searchName);
        if (!searchResults.isEmpty()) {
            for (Patient p : searchResults) {
                p.displayInfo();
            }
        }
        }

     */
    public void searchPatients(String firstName, String lastName){
        System.out.println("Enter Patient first and last Name to search:");
        String fname = scanner.nextLine();
        String lname = scanner.nextLine();
        System.out.println("Search Results:");
        for(Patient p : patients){
            if (p.getFirstName().toLowerCase().contains(firstName.toLowerCase())&&p.getLastName().toLowerCase().contains(lastName.toLowerCase())){
                p.displayInfo();
            }
        }

    }
    public void displayPatients(String filter){
        System.out.println("Filter Results:");
        Boolean found = false;
        for (Patient p : patients) {
            if(p.getBloodGroup().equalsIgnoreCase(filter)||p.getGender().equalsIgnoreCase(filter)|| p.getFirstName().toLowerCase().contains(filter.toLowerCase())) {

                p.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matches found");
        }
    }
    public void displayPatients(int limit){
        System.out.println("==== limit Patients ===");
        if (patients.isEmpty()) {
            System.out.println("No patients found");
            return;
        }
        int count = 0;
        for (Patient p : patients) {
            if (count == limit) {
                break;
            }
            count++;
            p.displayInfo();
        }
    }


    public void handelPatientServic() {
        System.out.println("===== Patient Service =====");
        System.out.println(MenuMessege.PATIENT_MENU_MESSEGE);

        while (true) {

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {

                case 1 -> addaddPatients();

                case 2 -> {

                    System.out.println("Enter Patient ID:");
                    String id = scanner.nextLine();

                    editPatient(id);
                }

                case 3 -> {

                    System.out.println("Enter Patient ID:");
                    String id = scanner.nextLine();

                    removePatient(id);
                }

                case 4 -> searchPatients();

                case 5 -> displayAllPatients();

                case 6 -> {

                    System.out.println("Exit from Application");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}