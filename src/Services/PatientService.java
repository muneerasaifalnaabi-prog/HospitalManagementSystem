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
    static List<Patient>patients =new ArrayList<>();

    public void addaddPatients(){
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

        System.out.println("Enter  id :");
        String id = scanner.nextLine();
        Patient p =getPatientById(id);
        if (p != null) {
            System.out.println("ID already exit ");
        }

        System.out.print("Enter First Name: ");
        String fname =scanner.nextLine();

        System.out.print("Enter last Name: ");
        String lname =scanner.nextLine();

        System.out.println("Enter date Of Birth yyyy-MM-dd'T'hh:mm:ss.SX ex 2012-02-22T02:06:58.147Z:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = null;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter a date (dd-MM-yyyy): ");
            String input = scanner.nextLine();

            try {
                // Parse the input string to LocalDate
                date = LocalDate.parse(input, formatter);
                valid = true; // Parsing successful
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format or value. Please try again.");
            }
        }

        System.out.println("Enter gender");
        String gender =scanner.nextLine();

        System.out.println("phoneNumber");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Physical Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter  patientid :");
        String patientid = scanner.nextLine();

        System.out.print("Enter Blood Group (e.g., O+, A-): ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Emergency Contact Name/Phone: ");
        String emergencyContact = scanner.nextLine();

        System.out.print("Enter Insurance ID: ");
        String insuranceId = scanner.nextLine();

        System.out.print("Enter Registration Date (YYYY-MM-DD) [Leave empty for today's date]: ");
        LocalDate registrationDate = LocalDate.parse(scanner.nextLine());

        Patient patient = new Patient(id,fname,lname,date,gender,phoneNumber,
                email,address,patientid,bloodGroup,new ArrayList<>(),emergencyContact,registrationDate,
                insuranceId,new ArrayList<>(),new ArrayList<>());
        return patient;
    }
    public Patient  getPatientById(String patientId){
        for (Patient p :patients){
            if (p.getId().equals(patientId)){
                return p;
            }
        }
        return null;
    }
    public void editPatient(String patientId, Patient updatedPatient) {
        if (patientId != null) {
           for (Patient p : patients) {
               if (p.getId().equals(patientId)) {
                   System.out.println("Enter new phone number:");
                   p.setPhoneNumber(scanner.nextLine());

                   System.out.println("Enter new Email ");
                   p.setEmail(scanner.nextLine());

                   System.out.println("Enter new Address Line:");
                   p.setAddress(scanner.nextLine());

                   System.out.println("Enter new Emergency Contact Name:");
                   p.setEmergencyContact(scanner.nextLine());

                   System.out.println("Enter new Insurance ID:");
                   p.setInsuranceId(scanner.nextLine());



               }
           }
        }
    }
        public void removePatient(String patientId){
        Patient p = getPatientById(patientId);
        if (p != null) {
            patients.remove(p);
            System.out.println(Constants.REMOVE_PATIENT_SUCCESSFULLY);
        }
            System.out.println("Pation not found");

        }
        public List<Patient> searchPatientsByName(String name) {
            System.out.println("Enter Patient Name  to search:");
            System.out.println("Search Results:");
            for (Patient p : patients) {
                if (p.getFirstName().toLowerCase().contains(name.toLowerCase())) {
                    p.displayInfo();
                }
            }
            return new ArrayList<>();
        }
        public void searchPatients(){
        System.out.println("Enter Patient Name  to search:");
        String searchName = scanner.nextLine();
            System.out.println("Search Results:");
            List<Patient> searchResults = searchPatientsByName(searchName);
            if (searchResults != null) {
                for (Patient p : searchResults) {
                    p.displayInfo();

                }
                System.out.println("No matches found");
                System.out.println("Enter q to quit or enter key to continue");
                if(scanner.nextLine().equals("q")){
                    return;
                }
                searchPatients();
            }
        }
        public  void displayAllPatients() {
            System.out.println("===== All Patient =====");
            for (Patient p : patients) {
                p.displayInfo();
            }

        }
        public void handelPatientServic(){

        int option = scanner.nextInt();
        switch (option){
            case 1 ->{
                addaddPatients();
                handelPatientServic();
            }
            case 2 ->{
                editPatient(addPatient().getPatientId(),  addPatient());
                handelPatientServic();
            }
            case 3 ->{
                removePatient(addPatient().getPatientId());
                handelPatientServic();
            }
            case 4 ->{
                searchPatients();
                handelPatientServic();
            }
            case 5 ->{
                displayAllPatients();
                handelPatientServic();
            }
            case 6 ->{
                System.out.println("Exit from Application");
                return;

            }
            default ->  System.out.println("Invalid option");
        }
        }



    }




