package Services;

import Entities.*;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessege;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService extends  BaseService implements Manageable, Searchable {

    static Scanner scanner = new Scanner(System.in);
    static List<Doctor> doctors = new ArrayList<>();
    static PatientService patientService = new PatientService();

    public void addDoctors() {
        while (true) {
            Doctor d = addDoctor();

            if (HelperUtils.isNotNull(d)) {
                doctors.add(d);
                System.out.println("Doctor added successfully.");
            }
            System.out.println("Press q to go back to menu or press Enter to add another doctor:");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                return;
            }
        }
    }
    public Doctor addDoctor() {
        System.out.println("========= Added New Doctor =====");
        String id = HelperUtils.generateId("DOC");
        System.out.println("Generated System ID: " + id);

        Doctor existDoctor = getDoctorById(id);
        if (HelperUtils.isNotNull(existDoctor)) {
            System.out.println("ID already exists");
            return null;
        }

        String firstName = InputHandler.getStringInput("First Name");
        String lastName = InputHandler.getStringInput("Last Name");
        LocalDate dob = InputHandler.getLocalDateInput("Enter DOB dd-mm-yyyy ");
        String gender = InputHandler.getStringInput("Enter Gender");
        String phone = InputHandler.getStringInput("Enter Phone Number");
        String email = InputHandler.getStringInput(" Enter Email");
        String address = InputHandler.getStringInput("Enter Address");
        String doctorId =InputHandler.getStringInput(" Enter Doctor ID");
        String specialization = InputHandler.getStringInput("Enter Specialization");
        String qualification =InputHandler.getStringInput("Enter Qualification");
        int experienceYears =InputHandler.getIntInput("Enter Experience Years");
        String departmentId =InputHandler.getStringInput("Enter Department ID");
        Double consultationFee =InputHandler.getDoubleInput("Enter Consultation Fee");

        List<String> availableSlots = new ArrayList<>();
        while (true) {
            String slot = InputHandler.getStringInput(" Enter Slot Number");
            availableSlots.add(slot);
            System.out.println("Press q to stop adding slots or press Enter to continue:");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                break;
            }
        }

        Doctor doctor = new Doctor(
                id,
                firstName,
                lastName,
                dob,
                gender,
                phone,
                email,
                address,
                doctorId,
                specialization,
                qualification,
                experienceYears,
                departmentId,
                consultationFee,
                availableSlots,
                new ArrayList<>()
        );

        return doctor;
    }

    public Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }

    public void editDoctor(String doctorId) {
        Doctor d = getDoctorById(doctorId);
        if (HelperUtils.isNull(d)) {
            d.setPhoneNumber(InputHandler.getStringInput("Enter new Phone Number"));
            d.setEmail(InputHandler.getStringInput("Enter new Email"));
            d.setAddress(InputHandler.getStringInput("Enter new Address"));
            d.setSpecialization(InputHandler.getStringInput("Enter new Specialization"));
            d.setQualification(InputHandler.getStringInput("Enter new Qualification"));
            d.setExperienceYears(InputHandler.getIntInput("Enter new Experience Years"));
            scanner.nextLine();
            d.setConsultationFee(InputHandler.getDoubleInput("Enter new Consultation Fee"));
            scanner.nextLine();

            System.out.println("Doctor updated successfully.");

        } else {
            System.out.println("Doctor not found");
        }
    }

    public void removeDoctor(String doctorId) {

        Doctor d = getDoctorById(doctorId);

        if (HelperUtils.isNotNull(d)) {

            doctors.remove(d);
            System.out.println("Doctor removed successfully.");

        } else {
            System.out.println("Doctor not found");
        }
    }

    public List<Doctor> searchDoctorsBySpecialization(String specialization) {

        List<Doctor> results = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.getSpecialization().toLowerCase().contains(specialization.toLowerCase())) {
                results.add(d);
            }
        }

        return results;
    }

    public void searchDoctors() {

        String specialization = InputHandler.getStringInput(" Enter Specialization to search");
        System.out.println("Search Results:");
        List<Doctor> searchResults = searchDoctorsBySpecialization(specialization);
        if (!searchResults.isEmpty()) {
            for (Doctor d : searchResults) {
                d.displayInfo();
            }

        } else {
            System.out.println("No matches found");
        }
        System.out.println("Enter q to quit or press Enter to continue");
        if (scanner.nextLine().equalsIgnoreCase("q")) {
            return;
        }

        searchDoctors();
    }

    public void displayDoctors() {
        System.out.println("===== All Doctors =====");
        if (doctors.isEmpty()) {
            System.out.println("No doctors found");
            return;
        }

        for (Doctor d : doctors) {
            d.displayInfo();
        }
    }

    public List<Doctor> getAvailableDoctors() {
        List<Doctor> availableDoctors = new ArrayList<>();
        for (Doctor d : doctors) {
            if (!d.getAvailableSlots().isEmpty()) {
                availableDoctors.add(d);
            }
        }

        return availableDoctors;
    }

    public void displayAvailableDoctors() {

        System.out.println("===== Available Doctors =====");
        List<Doctor> availableDoctors = getAvailableDoctors();
        if (!availableDoctors.isEmpty()) {
            for (Doctor d : availableDoctors) {
                d.displayInfo();
            }

        } else {
            System.out.println("No available doctors");
        }
    }
    public void addDoctor(String name, String specialization, String phone){
        Doctor d =  new Doctor();
        d.setFirstName(name);
        d.setSpecialization(specialization);
        d.setPhoneNumber(phone);

    }
    public void addDoctor(String name, String specialization, String phone, double consultationFee){
        Doctor d =  new Doctor();
        d.setFirstName(name);
        d.setSpecialization(specialization);
        d.setPhoneNumber(phone);
        d.setConsultationFee(consultationFee);
        doctors.add(d);

    }
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }

    public void assignPatient(String doctorId, String patientId) {

        Doctor doctor = getDoctorById(doctorId);

        if (HelperUtils.isNull(doctor)) {
            System.out.println("Doctor not found");
            return;
        }

        for (Patient p : patientService.getPatients()) {

            if (p.getId().equals(patientId)) {

                doctor.getAssignedPatients().add(patientId);
                System.out.println("Patient assigned successfully");
                return;
            }
        }

        System.out.println("Patient not found");
    }
//i will see later
public void assignPatient(String doctorId, List<String> patientIds) {

    Doctor doctor = getDoctorById(doctorId);

    if (HelperUtils.isNull(doctor)) {
        System.out.println("Doctor not found");
        return;
    }

    for (String patientId : patientIds) {

        for (Patient p : patientService.getPatients()) {

            if (p.getId().equals(patientId)) {
                doctor.getAssignedPatients().add(patientId);
                System.out.println("Patient assigned: " + patientId);
                break;
            }
        }
    }
}



public void displayDoctors(String specialization){
    System.out.println("===== All Doctors by specialization =====");
    boolean found =false;
    for (Doctor d : doctors) {
        if (d.getSpecialization().toLowerCase().equals(specialization.toLowerCase())) {
            d.displayInfo();
            found = true;
        }
    }
    if (!found) {
        System.out.println("No doctors found");
    }
}
    public void displayDoctors(String departmentId, boolean showAvailableOnly) {

        boolean found = false;

        for (Doctor d : doctors) {

            boolean matchDept = d.getDepartmentId().equals(departmentId);
            boolean matchAvailability = !showAvailableOnly || !d.getAvailableSlots().isEmpty();

            if (matchDept && matchAvailability) {
                d.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctors found");
        }
    }
    public void addSurgeon() {
        System.out.println("===== Add Surgeon =====");
        addDoctor();
        Surgeon s = new Surgeon();
        s.setSurgeriesPerformed(InputHandler.getIntInput("Enter surgery number"));
    }
    public void addConsultation() {
        System.out.println("===== Add Consultation =====");
        addDoctor();
        Consultant consultant = new Consultant();
        consultant.setConsultationDuration(InputHandler.getIntInput("Enter duration"));
        consultant.setOnlineConsultationAvailable(true);
    }
    public void addGeneralPrescription() {
        System.out.println("===== Add General Prescription =====");
        addDoctor();
        GeneralPractitioner generalPractitioner=new GeneralPractitioner();
    }

    public void handelDoctorService() {
        System.out.println(MenuMessege.DOCTOR_MENU_MESSEGE);
        int choice = InputHandler.getIntInput("Enter choice");
            switch (choice) {
                case 1 -> {
                    addDoctors();
                    handelDoctorService();
                }
                case 2 -> {
                    addSurgeon();
                    handelDoctorService();
                }
                case 3 -> {
                    addConsultation();
                    handelDoctorService();
                }
                case 4 ->{
                    addGeneralPrescription();
                    handelDoctorService();
                }
                case 5 -> {
                    displayDoctors();
                    handelDoctorService();
                }
                case 6 -> {
                    searchDoctorsBySpecialization(InputHandler.getStringInput("Enter specialization to search"));
                    handelDoctorService();
                }
                case 7 -> {
                    displayAvailableDoctors();
                    handelDoctorService();
                }
                case 8 -> {
                    assignPatient(InputHandler.getStringInput("Enter Doctor Id"), InputHandler.getStringInput("Enter Patient Id"));
                    handelDoctorService();
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof  Doctor doctor){
            doctors.add(doctor);
            System.out.println("Doctor added successfully");
        }
        else {
        System.out.println("Invalid entity type");

    }

    }

    @Override
    public void remove(String id) {
        Doctor doctor =getDoctorById(id);
        if (HelperUtils.isNotNull(doctor)) {
            doctors.remove(doctor);
            System.out.println("doctor removed successfully");
        }
        else {
            System.out.println("doctor not found");
        }

    }

    @Override
    public void getAll() {
        if (doctors.isEmpty()) {
            System.out.println("No Doctor found");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println(d);
        }

    }

    @Override
    public void search(String keyword) {
        boolean found = false;

        for (Doctor d : doctors) {

            if (d.getFirstName().equalsIgnoreCase(keyword)
                    || d.getSpecialization().equalsIgnoreCase(keyword)
                    || d.getDepartmentId().equalsIgnoreCase(keyword)) {

                System.out.println(d);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctors found");
        }
    }
    @Override
    public void searchById(String id) {
        Doctor doctor = getDoctorById(id);

        if (HelperUtils.isNotNull(doctor)) {
            System.out.println(doctor);
        } else {
            System.out.println("Doctor not found");
        }
    }
}