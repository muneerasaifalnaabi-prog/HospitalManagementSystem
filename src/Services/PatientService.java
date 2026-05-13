package Services;

import Entities.Patient;
import Utils.Constants;
import Utils.HelperUtils;
import Utils.MenuMessege;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService extends BaseService implements Manageable, Searchable {

    static Scanner scanner = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public static List<Patient> getPatients() {
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

        String id  = HelperUtils.generateId("Patient");

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

        System.out.print("Enter Blood Group:");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Emergency Contact:");
        String emergencyContact = scanner.nextLine();

        System.out.print("Enter Insurance ID:");
        String insuranceId = scanner.nextLine();

        LocalDate registrationDate = null;
        boolean validReg = false;

        while (!validReg) {
            System.out.print("Enter Registration Date (dd-MM-yyyy): ");
            String input = scanner.nextLine();
            try {
                registrationDate = LocalDate.parse(input, formatter);
                validReg = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Try again:");
            }
        }

        return new Patient(
                id, fname, lname, date, gender, phoneNumber, email, address,
                patientid, bloodGroup, new ArrayList<>(), emergencyContact,
                registrationDate, insuranceId, new ArrayList<>(), new ArrayList<>()
        );
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
            p.setPhoneNumber(scanner.nextLine());
            p.setEmail(scanner.nextLine());
            p.setAddress(scanner.nextLine());
            p.setEmergencyContact(scanner.nextLine());
            p.setInsuranceId(scanner.nextLine());
        }
    }

    public void removePatient(String patientId) {
        Patient p = getPatientById(patientId);
        if (p != null) {
            patients.remove(p);
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

    public void displayAllPatients() {
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Patient patient) {
            patients.add(patient);
        }
    }

    @Override
    public void remove(String id) {
        Patient p = getPatientById(id);
        if (HelperUtils.isNotNull(p)) {
            patients.remove(p);
        }
    }

    @Override
    public void getAll() {
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    @Override
    public void search(String keyword) {
        for (Patient p : patients) {
            if (p.getFirstName().equalsIgnoreCase(keyword)
                    || p.getLastName().equalsIgnoreCase(keyword)
                    || p.getBloodGroup().equalsIgnoreCase(keyword)) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void searchById(String id) {
        Patient p = getPatientById(id);
        if (HelperUtils.isNotNull(p)) {
            System.out.println(p);
        }
    }
}