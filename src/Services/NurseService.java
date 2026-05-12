package Services;

import Entities.Nurse;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService extends BaseService implements Manageable, Searchable {
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

        for (Nurse n : Nurses) {

            if (n.getId().equals(nurseId)) {
                return n;
            }
        }

        return null;
    }

public void editNurses(String nurseId) {
    Nurse nurse = getNurseById(nurseId);
    if (nurse != null) {
        System.out.println("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        nurse.setPhoneNumber(newPhoneNumber);

        System.out.println("Enter new email: ");
        String newEmail = scanner.nextLine();
        nurse.setEmail(newEmail);

        System.out.println("Enter new Department ID: ");
        String newDepartmentId = scanner.nextLine();
        nurse.setDepartmentId(newDepartmentId);

        System.out.println("Enter new Shift ID: ");
        String newShiftId = scanner.nextLine();
        nurse.setShift(newShiftId);
        System.out.println("Enter new Qualification: ");
        String newQualification = scanner.nextLine();
        nurse.setQualification(newQualification);
        System.out.println("Nurse Edited Successfully");
    }
    else  {
        System.out.println("Nurse Edited Failed");
    }

}
public void deleteNurses(String nurseId) {
    Nurse nurse = getNurseById(nurseId);
    if (nurse != null) {
        Nurses.remove(nurse);
        System.out.println("Nurse Deleted Successfully");
    }
    else  {
        System.out.println("Nurse Deleted Failed");
    }

}
public List<Nurse> getNursesByDepartmentId(String departmentId) {
    List<Nurse> nurses=new ArrayList<>();
    for (Nurse n : Nurses) {
        if (n.getDepartmentId().equals(departmentId)) {
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
    List<Nurse> nurses=new ArrayList<>();
    for (Nurse n : Nurses) {
        if (n.getShift().equals(shift)) {
            nurses.add(n);
        }
    }
    return nurses;
}
public void searchNursesByShift() {
    System.out.println("Enter Shift : ");
    String shift = scanner.nextLine();
    List<Nurse> nurses=getNursesByShift(shift);
    for (Nurse n : nurses) {
        if (n.getShift().equals(shift)) {
            n.displayInfo();
        }
        else  {
            System.out.println("Nurse Not Found");
        }
    }
    System.out.println("Enter q to quit ");
    if (scanner.nextLine().equalsIgnoreCase("q")) {
        return;
    }
    searchNursesByShift();
}
public void  displayNurses(){
    System.out.println("Nurse List");
    if (Nurses.size()==0) {
        System.out.println("Nurse List is Empty");
    }
    for (Nurse n : Nurses) {
        n.displayInfo();
    }
}


    @Override
    public void add(Object entity) {

        if (entity instanceof Nurse nurse) {
            Nurses.add(nurse);
            System.out.println("Nurse added successfully");
        } else {
            System.out.println("Invalid entity type");
        }
    }

    @Override
    public void remove(String id) {

        Nurse nurse = getNurseById(id);

        if (nurse != null) {
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

        for (Nurse n : Nurses) {
            System.out.println(n);
        }
    }

    @Override
    public void search(String keyword) {

        boolean found = false;

        for (Nurse n : Nurses) {

            if (n.getFirstName().equalsIgnoreCase(keyword)
                    || n.getDepartmentId().equalsIgnoreCase(keyword)
                    || n.getShift().equalsIgnoreCase(keyword)) {

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

        if (nurse != null) {
            System.out.println(nurse);
        } else {
            System.out.println("Nurse not found");
        }
    }
}
