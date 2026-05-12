package Services;

import Entities.Doctor;
import Entities.Patient;
import Utils.MenuMessege;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Services.PatientService.getPatients;

public class DoctorService extends  BaseService implements Manageable, Searchable {

    static Scanner scanner = new Scanner(System.in);
    static List<Doctor> doctors = new ArrayList<>();
    static PatientService patientService = new PatientService();

    public void addDoctors() {

        while (true) {

            Doctor d = addDoctor();

            if (d != null) {
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

        System.out.println("Enter id:");
        String id = scanner.nextLine();

        Doctor existDoctor = getDoctorById(id);

        if (existDoctor != null) {
            System.out.println("ID already exists");
            return null;
        }

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

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
        String phone = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Physical Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter doctor id:");
        String doctorId = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();

        System.out.print("Enter Experience Years: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Department ID: ");
        String departmentId = scanner.nextLine();

        System.out.print("Enter Consultation Fee: ");
        Double consultationFee = scanner.nextDouble();
        scanner.nextLine();

        List<String> availableSlots = new ArrayList<>();

        while (true) {

            System.out.print("Enter Available Slot: ");
            String slot = scanner.nextLine();

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
                date,
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

            if (d.getId().equals(doctorId)) {
                return d;
            }
        }

        return null;
    }

    public void editDoctor(String doctorId) {

        Doctor d = getDoctorById(doctorId);

        if (d != null) {

            System.out.println("Enter new phone number:");
            d.setPhoneNumber(scanner.nextLine());

            System.out.println("Enter new Email:");
            d.setEmail(scanner.nextLine());

            System.out.println("Enter new Address:");
            d.setAddress(scanner.nextLine());

            System.out.println("Enter new Specialization:");
            d.setSpecialization(scanner.nextLine());

            System.out.println("Enter new Qualification:");
            d.setQualification(scanner.nextLine());

            System.out.println("Enter new Experience Years:");
            d.setExperienceYears(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Enter new Consultation Fee:");
            d.setConsultationFee(scanner.nextDouble());
            scanner.nextLine();

            System.out.println("Doctor updated successfully.");

        } else {
            System.out.println("Doctor not found");
        }
    }

    public void removeDoctor(String doctorId) {

        Doctor d = getDoctorById(doctorId);

        if (d != null) {

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

        System.out.println("Enter specialization to search:");
        String specialization = scanner.nextLine();

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

    }
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }
public void assignPatient(String doctorId, String patientId){
    Patient patient =new Patient();
    patient.setId(doctorId);
    patient.setId(patientId);
    System.out.println("Assigning Patient");
}
//i will see later
public void assignPatient(String doctorId, List<String> patientIds){
    for (Doctor doctor : doctors){
        if(doctor.getId().equals(doctorId)){
            for(Patient p : getPatients()){
                for(String x : patientIds){
                    if(p.getId().equals(x)){
                        doctor.getAssignedPatients().add(String.valueOf(p));
                        System.out.println("Patient assigned successfully.");
                    }else{
                        System.out.println("Patient not assigned successfully.");
                    }

                }

            }

        }else{
            System.out.println("Doctor not found");
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
public void  displayDoctors(String departmentId, boolean showAvailableOnly){
    System.out.println("===== All Doctors by departmentId =====");
    boolean found =false;
    for (Doctor d : doctors) {
        if (d.getDepartmentId().equals(departmentId) && !d.getAvailableSlots().isEmpty()) {
            d.displayInfo();
            found = true;
        }
    }
    if (!found) {
        System.out.println("No doctors found");
    }
}

    public void handelDoctorService() {
        System.out.println(MenuMessege.DOCTOR_MENU_MESSEGE);
        while (true) {
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1 -> addDoctors();

                case 2 -> {

                    System.out.println("Enter Doctor ID:");
                    String id = scanner.nextLine();

                    editDoctor(id);
                }

                case 3 -> {

                    System.out.println("Enter Doctor ID:");
                    String id = scanner.nextLine();

                    removeDoctor(id);
                }

                case 4 -> searchDoctors();

                case 5 -> displayDoctors();

                case 6 -> displayAvailableDoctors();

                case 7 -> {

                    System.out.println("Exit from Application");
                    return;
                }

                default -> System.out.println("Invalid option");
            }
        }
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public void searchById(String id) {

    }
}