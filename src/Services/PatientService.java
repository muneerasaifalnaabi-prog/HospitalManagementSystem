package Services;

import Entities.*;
import Utils.HelperUtils;
import Utils.InputHandler;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
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
    public void addPatient(String firstName, String lastName, String phone) {

        Patient patient = new Patient();
        patient.setId(HelperUtils.generateId("PAT"));
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patients.add(patient);
    }
    public void addPatient(String firstName, String lastName, String phone , String bloodGroup, String email){
        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setPhoneNumber(bloodGroup);
        patient.setPhoneNumber(email);

        patients.add(patient);

    }

    public Patient getPatientById(String patientId) {
        if (HelperUtils.isNull(patientId)) return null;
        for (Patient p : patients) {
            if (p.getId() != null && p.getId().equals(patientId)) {
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
    public static void displayPatients(){
        if (HelperUtils.isNull(patients)) { System.out.println("No patients registered."); return; }
        for(Patient p : patients){
            p.displayInfo();
        }
    }
    public void displayPatients(String filter){
        if (HelperUtils.isNull(filter)) {
            displayAllPatients();
            return;
        }
        boolean found = false;
        for (Patient p : patients) {
            if ((p.getGender() != null && p.getGender().equalsIgnoreCase(filter)) ||
                    (p.getBloodGroup() != null && p.getBloodGroup().equalsIgnoreCase(filter)) ||
                    (p.getInsuranceId() != null && p.getInsuranceId().equalsIgnoreCase(filter))) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No patients match filter: " + filter);
    }

    public void displayPatients(int limit){
        int count = 0;
        for (Patient p : patients) {
            if (count >= limit) break;
            System.out.println(p);
            count++;
        }
    }
    @Override
        public void add(Object entity) {
            if (entity instanceof Patient patient) {
                if (HelperUtils.isNull(patient.getId())) {
                    patient.setId(HelperUtils.generateId("PAT"));
                }
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
        displayAllPatients();
    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(keyword)) return;
        boolean found = false;
        for (Patient p : patients) {
            if ((p.getFirstName() != null && p.getFirstName().equalsIgnoreCase(keyword)) ||
                    (p.getLastName() != null && p.getLastName().equalsIgnoreCase(keyword)) ||
                    (p.getBloodGroup() != null && p.getBloodGroup().equalsIgnoreCase(keyword))) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("No patients found");
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
        addaddPatients();
        LocalDate admissionDate = InputHandler.getLocalDateInput("Enter Admission date");
        LocalDate dischargeDate =InputHandler.getLocalDateInput("Enter DOB (dd-MM-yyyy):");
        String roomNumber = InputHandler.getStringInput("Enter Room Number: ");
        String bedNumber = InputHandler.getStringInput("Enter Bed Number: ");
        double dailyCharges = InputHandler.getDoubleInput("Daily Charges: ");
        String admittingDoctorId = InputHandler.getStringInput("Enter Admitting Doctor ID: ");
        InPatient inPatient = new InPatient();
        inPatient.setAdmissionDate(admissionDate);
        inPatient.setDischargeDate(dischargeDate);
        inPatient.setRoomNumber(roomNumber);
        inPatient.setBedNumber(bedNumber);
        inPatient.setDailyCharges(dailyCharges);
        inPatient.setAdmittingDoctorId(admittingDoctorId);
    }

    public void registerOutPatient(){
        System.out.println("OutPatient registration");
        addaddPatients();
        OutPatient outPatient = new OutPatient();
        LocalDate lastVisitDate = InputHandler.getLocalDateInput("Enter Last Visit");
        outPatient.setLastVisitDate(lastVisitDate);
        String patientId = InputHandler.getStringInput("Enter Patient ID: ");
        outPatient.setPatientId(patientId);
    }
    public void registerEmergencyPatient(){
        System.out.println("EmergencyPatient registration");
        addPatient();
        EmergencyPatient emergencyPatient = new EmergencyPatient();
        String emergencyType = InputHandler.getStringInput("Emergency Type");
        emergencyPatient.setEmergencyType(emergencyType);
        String arrivalMode = InputHandler.getStringInput("Arrival Mode");
        emergencyPatient.setArrivalMode(arrivalMode);
        int triageLevel = InputHandler.getIntInput("Triage Level");
        emergencyPatient.setTriageLevel(triageLevel);
    }
    public void searchPatientsHandler(){
        System.out.println("Patients search");
        System.out.println("""
                1.Search Patient by any keyword
                2.search Patient by name 
                3.search by id
                """);
        int choice = InputHandler.getIntInput("Enter choice: ");
        switch (choice) {
            case 1 ->{
                String keyword = InputHandler.getStringInput("Enter keyword: ");
                search(keyword);
                searchPatientsHandler();
            }
            case 2 ->{
               searchPatientsByName(InputHandler.getStringInput("Enter name: "));
               searchPatientsHandler();
            }
            case 3 ->{
                searchById(InputHandler.getStringInput("Enter ID: "));
                searchPatientsHandler();
            }
        }

    }
    public  void HadlerPatient(){
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
                getAll();
                HadlerPatient();
            }
            case 6->{
                searchPatientsHandler();
                HadlerPatient();
            }
            case 7->{
                editPatient(InputHandler.getStringInput("Enter ID: "));
                HadlerPatient();
            }
            case 8->{
                removePatient(InputHandler.getStringInput("Enter ID: "));
                HadlerPatient();
            }
            case 9->{
                MedicalRecord m = new MedicalRecord();
                m.displayInfo();
                HadlerPatient();
            }
            case 10->{
                System.out.println("Extitng from Patient Registration");
                return;
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
            }


        }
    }

}