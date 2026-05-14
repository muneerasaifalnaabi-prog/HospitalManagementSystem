package Services;

import Entities.Nurse;
import Entities.Patient;
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

public class NurseService extends BaseService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    public static List<Nurse> Nurses = new ArrayList<Nurse>();

    public void addNurses() {
        while (true) {
            Nurse n = addNurse();
            if (HelperUtils.isNotNull(n)) {
                add(n);
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
        String id = HelperUtils.generateId("NURSE");
        System.out.println("Generated ID: " + id);

        Nurse existNurse = getNurseById(id);
        if (HelperUtils.isNotNull(existNurse)) {
            System.out.println("ID already exists");
            return null;
        }
        String fname = InputHandler.getStringInput("First Name");
        String lname = InputHandler.getStringInput("Last Name");
        String email = InputHandler.getStringInput("Email");
        LocalDate dob = InputHandler.getLocalDateInput("Enter DOB dd-MM-yyyy");
        String gender = InputHandler.getStringInput("Gender");
        String phoneNumber = InputHandler.getStringInput("Phone Number");
        String address = InputHandler.getStringInput("Address");
        String nurseId = InputHandler.getStringInput("Nurse ID");
        String departmentId = InputHandler.getStringInput("Department ID");
        String shift = InputHandler.getStringInput("Shift");
        String qualification = InputHandler.getStringInput("Qualification");

        Nurse nurse = new Nurse(
                id, fname, lname, dob, gender, phoneNumber, email, address,
                nurseId, departmentId, shift, qualification, new ArrayList<>()
        );
        return nurse;
    }

    public Nurse getNurseById(String nurseId) {
        if (HelperUtils.isNull(nurseId)) return null;
        for (Nurse n : Nurses) {
            if (HelperUtils.isNotNull(n.getId()) && n.getId().equals(nurseId)) {
                return n;
            }
        }
        return null;
    }

    public void editNurses(String nurseId) {
        Nurse nurse = getNurseById(nurseId);
        if (HelperUtils.isNotNull(nurse)) {
            String newPhoneNumber = InputHandler.getStringInput("New Phone Number");
            nurse.setPhoneNumber(newPhoneNumber);
            String newEmail = InputHandler.getStringInput("New Email");
            nurse.setEmail(newEmail);
            String newDepartmentId = InputHandler.getStringInput("New Department ID");
            nurse.setDepartmentId(newDepartmentId);
            String newShiftId = InputHandler.getStringInput("New Shift ID");
            nurse.setShift(newShiftId);
            String newQualification = InputHandler.getStringInput("New Qualification");
            nurse.setQualification(newQualification);
            System.out.println("Nurse Edited Successfully");
        } else {
            System.out.println("Nurse Not Found");
        }
    }

    public void deleteNurses(String nurseId) {
        Nurse nurse = getNurseById(nurseId);
        if (HelperUtils.isNotNull(nurse)) {
            Nurses.remove(nurse);
            System.out.println("Nurse Deleted Successfully");
        } else {
            System.out.println("Nurse Not Found");
        }
    }

    public List<Nurse> getNursesByDepartmentId(String departmentId) {
        List<Nurse> nurses = new ArrayList<>();
        if (HelperUtils.isNull(departmentId)) return nurses;
        for (Nurse n : Nurses) {
            if (HelperUtils.isNotNull(n.getDepartmentId()) && n.getDepartmentId().equals(departmentId)) {
                nurses.add(n);
            }
        }
        return nurses;
    }

    public void searchNursesByDepartment() {
        System.out.println("Enter Department ID:");
        String departmentId = scanner.nextLine();
        List<Nurse> result = getNursesByDepartmentId(departmentId);
        if (result.isEmpty()) {
            System.out.println("No nurses found");
            return;
        }
        for (Nurse n : result) {
            n.displayInfo();
        }
    }

    public List<Nurse> getNursesByShift(String shift) {
        List<Nurse> nurses = new ArrayList<>();
        if (HelperUtils.isNull(shift)) return nurses;
        for (Nurse n : Nurses) {
            if (HelperUtils.isNotNull(n.getShift()) && n.getShift().equals(shift)) {
                nurses.add(n);
            }
        }
        return nurses;
    }

    public void searchNursesByShift() {
        System.out.println("Enter Shift : ");
        String shift = scanner.nextLine();
        List<Nurse> nurses = getNursesByShift(shift);
        if (nurses.isEmpty()) {
            System.out.println("No nurses found");
        } else {
            for (Nurse n : nurses) {
                n.displayInfo();
            }
        }
        System.out.println("Enter q to quit ");
        if (scanner.nextLine().equalsIgnoreCase("q")) {
            return;
        }
        searchNursesByShift();
    }

    public void displayNurses() {
        System.out.println("Nurse List");
        if (Nurses.isEmpty()) {
            System.out.println("Nurse List is Empty");
            return;
        }
        for (Nurse n : Nurses) {
            n.displayInfo();
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Nurse nurse) {
            if (HelperUtils.isNull(nurse.getId())) {
                nurse.setId(HelperUtils.generateId("NURSE"));
            }
            Nurses.add(nurse);
            System.out.println("Nurse added successfully");
        } else {
            System.out.println("Invalid entity type");
        }
    }

    @Override
    public void remove(String id) {
        Nurse nurse = getNurseById(id);
        if (HelperUtils.isNotNull(nurse)) {
            Nurses.remove(nurse);
            System.out.println("Nurse removed successfully");
        } else {
            System.out.println("Nurse not found");
        }
    }

    @Override
    public void getAll() {
        if (Nurses.isEmpty()) {
            System.out.println("No nurses found");
            return;
        }
        displayNurses();
    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(keyword)) return;
        boolean found = false;
        for (Nurse n : Nurses) {
            if ((HelperUtils.isNotNull(n.getFirstName()) && n.getFirstName().equalsIgnoreCase(keyword)) ||
                    (HelperUtils.isNotNull(n.getDepartmentId()) && n.getDepartmentId().equalsIgnoreCase(keyword)) ||
                    (HelperUtils.isNotNull(n.getShift()) && n.getShift().equalsIgnoreCase(keyword))) {
                System.out.println(n);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No nurses found");
        }
    }

    @Override
    public void searchById(String id) {
        Nurse nurse = getNurseById(id);
        if (HelperUtils.isNotNull(nurse)) {
            System.out.println(nurse);
        } else {
            System.out.println("Nurse not found");
        }
    }

    public void assignNuresToPatient(String patientId) {
        Nurse nurse = getNurseById(patientId);
        if (HelperUtils.isNotNull(nurse)) {
            System.out.println("Nurse assigned to patient: " + patientId);
        }
    }

    public void NurseHandler() {
        System.out.println("==== Nurse Management ===");
        int choice = InputHandler.getIntInput("Enter choice");
        switch (choice) {
            case 1 -> {
                addNurse();
                NurseHandler();
            }
            case 2 -> {
                displayNurses();
                NurseHandler();
            }
            case 3 -> {
                getNursesByDepartmentId(InputHandler.getStringInput("Department ID"));
                NurseHandler();
            }
            case 4 -> {
                getNursesByShift(InputHandler.getStringInput("Shift ID"));
                NurseHandler();
            }
            case 5 -> {
                Patient p = new Patient();
                assignNuresToPatient(String.valueOf(p));
                NurseHandler();
            }
            case 6 -> {
                editNurses(InputHandler.getStringInput("Nurse ID to update"));
                NurseHandler();
            }
            case 7 -> {
                deleteNurses(InputHandler.getStringInput("Nurse ID to delete"));
                NurseHandler();
            }
            case 8 -> {
                System.out.println("Exiting from Nurse Registration");
                return;
            }
            default -> System.out.println("Invalid choice");
        }
    }
}