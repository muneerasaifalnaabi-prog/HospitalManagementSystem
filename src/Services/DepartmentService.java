package Services;

import Entities.Department;
import Entities.Nurse;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessege;
import interfaces.Manageable;
import interfaces.Searchable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService extends BaseService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    public static List<Department> departments = new ArrayList<>();

    public void addDepartments() {
        while (true) {
            Department department = addDepartment();
            if (HelperUtils.isNotNull(department)) {
                add(department);
                System.out.println("Department Added Successfully");
            }
            System.out.println("Press q to quit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                return;
            }
        }
    }

    public Department addDepartment() {
        System.out.println("======= Add New Department =======");
        String departmentId = HelperUtils.generateId("DEP");
        System.out.println("Generated Department ID : " + departmentId);

        Department existingDepartment = getDepartmentById(departmentId);
        if (HelperUtils.isNotNull(existingDepartment)) {
            System.out.println("Department ID already exists");
            return null;
        }

        System.out.println("Enter Department Name:");
        String departmentName = scanner.nextLine();
        if (!HelperUtils.isValidString(departmentName, 2)) {
            System.out.println("Department name must be at least 2 characters.");
            return null;
        }

        System.out.println("Enter Head Doctor ID:");
        String headDoctorId = scanner.nextLine();
        if (!HelperUtils.isValidString(headDoctorId, 1)) {
            System.out.println("Head Doctor ID cannot be empty.");
            return null;
        }

        System.out.println("Enter Bed Capacity:");
        int bedCapacity = Integer.parseInt(scanner.nextLine());
        if (!HelperUtils.isPositive(bedCapacity)) {
            System.out.println("Bed capacity must be positive.");
            return null;
        }

        System.out.println("Enter Available Beds:");
        int availableBeds = Integer.parseInt(scanner.nextLine());
        if (!HelperUtils.isValidNumber(availableBeds, 0, bedCapacity)) {
            System.out.println("Available beds must be between 0 and bed capacity.");
            return null;
        }

        Department department = new Department(
                departmentId, departmentName, headDoctorId,
                new ArrayList<>(), new ArrayList<Nurse>(),
                bedCapacity, availableBeds
        );
        return department;
    }

    public Department getDepartmentById(String departmentId) {
        if (HelperUtils.isNull(departmentId)) return null;
        for (Department d : departments) {
            if (HelperUtils.isNotNull(d.getDepartmentId()) && d.getDepartmentId().equals(departmentId)) {
                return d;
            }
        }
        return null;
    }

    public void editDepartment(String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (HelperUtils.isNotNull(department)) {
            System.out.println("Enter new Department Name");
            String newName = scanner.nextLine();
            if (HelperUtils.isValidString(newName, 2)) {
                department.setDepartmentName(newName);
            }

            System.out.println("Enter new Head Doctor ID");
            String newHeadId = scanner.nextLine();
            if (HelperUtils.isValidString(newHeadId, 1)) {
                department.setHeadDoctorId(newHeadId);
            }

            System.out.println("Enter new Bed Capacity");
            int newCapacity = Integer.parseInt(scanner.nextLine());
            if (HelperUtils.isPositive(newCapacity)) {
                department.setBedCapacity(newCapacity);
            }

            System.out.println("Enter new Available Beds");
            int newAvailable = Integer.parseInt(scanner.nextLine());
            if (HelperUtils.isValidNumber(newAvailable, 0, department.getBedCapacity())) {
                department.setAvailableBeds(newAvailable);
            }

            System.out.println("Department Edited Successfully");
        } else {
            System.out.println("Department doesn't exist");
        }
    }

    public void deleteDepartment(String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (HelperUtils.isNotNull(department)) {
            departments.remove(department);
            System.out.println("Department Deleted Successfully");
        } else {
            System.out.println("Department doesn't exist");
        }
    }

    public void displayDepartments() {
        for (Department d : departments) {
            System.out.println(d);
        }
    }

    public void assignDoctorByDepartment(String doctorId, String departmentId) {
        if (HelperUtils.isNull(doctorId) || HelperUtils.isNull(departmentId)) {
            System.out.println("Invalid Input");
            return;
        }
        Department department = getDepartmentById(departmentId);
        if (HelperUtils.isNotNull(department)) {
            department.assignDoctor(doctorId);
            System.out.println("Doctor Assigned Successfully");
        } else {
            System.out.println("Department doesn't exist");
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Department department) {
            if (HelperUtils.isNull(department.getDepartmentId())) {
                department.setDepartmentId(HelperUtils.generateId("DEP"));
            }
            departments.add(department);
            System.out.println("Department added successfully");
        } else {
            System.out.println("Invalid entity type");
        }
    }

    @Override
    public void remove(String id) {
        Department department = getDepartmentById(id);
        if (HelperUtils.isNotNull(department)) {
            departments.remove(department);
            System.out.println("department removed successfully");
        } else {
            System.out.println("department not found");
        }
    }

    @Override
    public void getAll() {
        if (departments.isEmpty()) {
            System.out.println("No departments found");
            return;
        }
        for (Department a : departments) {
            System.out.println(a);
        }
    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(keyword)) return;
        boolean found = false;
        for (Department d : departments) {
            if ((HelperUtils.isNotNull(d.getDepartmentName()) && d.getDepartmentName().equalsIgnoreCase(keyword)) ||
                    (HelperUtils.isNotNull(d.getDepartmentId()) && d.getDepartmentId().equalsIgnoreCase(keyword))) {
                System.out.println(d);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No department found");
        }
    }

    public void assignNurseByDepartment() {
        String departmentId = InputHandler.getStringInput("Enter Department ID: ");
        Department department = getDepartmentById(departmentId);
        if (HelperUtils.isNull(department)) {
            System.out.println("Department not found");
            return;
        }
        String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
        NurseService nurseService = new NurseService();
        Nurse nurse = nurseService.getNurseById(nurseId);
        if (HelperUtils.isNull(nurse)) {
            System.out.println("Nurse not found");
            return;
        }
        department.getNurses().add(nurse);
        System.out.println("Nurse assigned successfully");
    }

    @Override
    public void searchById(String id) {
        Department department = getDepartmentById(id);
        if (HelperUtils.isNotNull(department)) {
            System.out.println(department);
        } else {
            System.out.println("Department not found");
        }
    }

    public void DepartmentHandler() {
        System.out.println("==== Department Management ===");
        int choice = InputHandler.getIntInput("Enter choice");
        switch (choice) {
            case 1 -> {
                addDepartments();
                DepartmentHandler();
            }
            case 2 -> {
                displayDepartments();
                DepartmentHandler();
            }
            case 3 -> {
                displayDepartments();
                DepartmentHandler();
            }
            case 4 -> {
                if (departments.size() >= 2) {
                    assignDoctorByDepartment(departments.get(0).getDepartmentId(), departments.get(1).getDepartmentId());
                } else {
                    System.out.println("Need at least two departments to assign doctor between them.");
                }
                DepartmentHandler();
            }
            case 5 -> {
                assignNurseByDepartment();
                DepartmentHandler();
            }
            case 6 -> {
                getAll();
                DepartmentHandler();
            }
            case 7 -> {
                System.out.println("Exiting from Department ...");
                return;
            }
            default -> System.out.println("Invalid choice");
        }
    }
}