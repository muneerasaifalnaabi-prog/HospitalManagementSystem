package Services;

import Entities.InPatient;
import Entities.Patient;
import Utils.Constants;
import Utils.HelperUtils;
import Utils.InputHandler;
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
    static InPatient inPatient;
    Patient patient = new Patient();



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

        String id = HelperUtils.generateId("PAT");

        if (HelperUtils.isNotNull(getPatientById(id))) {
            System.out.println("ID already exists");
            return null;
        }

        String fname = InputHandler.getStringInput("Enter First Name: ");
        String lname = InputHandler.getStringInput("Enter Last Name: ");

        LocalDate date = InputHandler.getLocalDateInput("Enter DOB (dd-MM-yyyy): ");

        String gender = InputHandler.getStringInput("Enter gender: ");
        String phoneNumber = InputHandler.getStringInput("Enter phone: ");
        String email = InputHandler.getStringInput("Enter email: ");
        String address = InputHandler.getStringInput("Enter address: ");

        String patientid = InputHandler.getStringInput("Enter patient id: ");
        String bloodGroup = InputHandler.getStringInput("Enter blood group: ");
        String emergencyContact = InputHandler.getStringInput("Enter emergency contact: ");
        String insuranceId = InputHandler.getStringInput("Enter insurance id: ");

        LocalDate registrationDate = InputHandler.getLocalDateInput("Enter registration date: ");


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
        if (HelperUtils.isNotNull(p)) {
            p.setPhoneNumber(InputHandler.getStringInput("Enter phone: "));
            p.setEmail(InputHandler.getStringInput("Enter email: "));
            p.setAddress(InputHandler.getStringInput("Enter address: "));
            p.setEmergencyContact(InputHandler.getStringInput("Enter emergency contact: "));
            p.setInsuranceId(InputHandler.getStringInput("Enter insurance id: "));

            System.out.println("Patient updated successfully");
        } else {
            System.out.println("Patient not found");
        }
    }


    public void removePatient(String patientId) {
        Patient p = getPatientById(patientId);
        if (HelperUtils.isNotNull(p)) {
            patients.remove(p);
            System.out.println("Patient removed successfully");
        }
        else  {
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
            p.displayInfo();
            System.out.println(p);
        }
    }
    public void registerInPatient(){
        System.out.println("InPatient registration");
        Patient p = new InPatient();
        addPatient();
        /*
        private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;
         */
        System.out.println("Enter admission date:");
        String admissionDate = scanner.nextLine();
    }
    public void registerOutPatient(){
        System.out.println("OutPatient registration");
    }
    public void registerEmergencyPatient(){
        System.out.println("EmergencyPatient registration");
        addPatient();
    }
    public void viewPatientMedicalHistory(){
        String patientId =  InputHandler.getStringInput("Enter Patient ID: ");
        Patient patient = getPatientById(patientId);
        if (HelperUtils.isNotNull(patient)) {


        }

    }
    public void HadlerPatient(){
        System.out.println("====== Patient Management =======");
        System.out.println(MenuMessege.PATIENT_MENU_MESSEGE);
        int choice = InputHandler.getIntInput("Enter choice: ");
        switch (choice) {
            case 1->{
                addaddPatients();
                HadlerPatient();
            }
            case 2->{
                registerInPatient();
                HadlerPatient();
            }
            case 3->{
                registerOutPatient();
                HadlerPatient();
            }
            case 4->{
                registerEmergencyPatient();
                HadlerPatient();
            }
            case 5->{
                displayAllPatients();
                HadlerPatient();
            }
            case 6->{
                //searchPatientsHandler();
                HadlerPatient();
            }
            case 7->{
                //updatePatientHandler();
                HadlerPatient();
            }
            case 8->{
               // removePatientHandler();
                HadlerPatient();
            }
            case 9->{
                //viewPatientMedicalHistory();
                HadlerPatient();
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
            }


        }
    }
}