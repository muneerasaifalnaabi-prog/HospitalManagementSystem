package Services;

import Entities.Appointment;
import Entities.Department;
import Entities.Nurse;
import Utils.HelperUtils;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService extends BaseService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    static List<Department> departments = new ArrayList<>();
    public void addDepartments() {

        while (true) {

            Department department = addDepartment();

            if (department != null) {

                departments.add(department);

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

        if (existingDepartment != null) {

            System.out.println("Department ID already exists");

            return null;
        }

        System.out.println("Enter Department Name:");
        String departmentName = scanner.nextLine();

        System.out.println("Enter Head Doctor ID:");
        String headDoctorId = scanner.nextLine();

        System.out.println("Enter Bed Capacity:");
        int bedCapacity = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Available Beds:");
        int availableBeds = Integer.parseInt(scanner.nextLine());

        Department department = new Department(
                departmentId,
                departmentName,
                headDoctorId,
                new ArrayList<>(),
                new ArrayList<Nurse>(),
                bedCapacity,
                availableBeds
        );

        return department;
    }


    public Department getDepartmentById(String departmentId) {

        for (Department d : departments) {

            if (d.getDepartmentId().equals(departmentId)) {

                return d;
            }
        }

        return null;
    }
    public void editDepartment(String departmentId) {

        Department department = getDepartmentById(departmentId);

        if (HelperUtils.isNull(department)) {

            System.out.println("Enter new Department Name");
            department.setDepartmentName(scanner.nextLine());

            System.out.println("Enter new Head Doctor ID");
            department.setHeadDoctorId(scanner.nextLine());

            System.out.println("Enter new Bed Capacity");
            department.setBedCapacity(Integer.parseInt(scanner.nextLine()));

            System.out.println("Enter new Available Beds");
            department.setAvailableBeds(Integer.parseInt(scanner.nextLine()));

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

        if (HelperUtils.isNull(doctorId)
                || HelperUtils.isNull(departmentId)) {

            System.out.println("Invalid Input");

            return;
        }

        Department department = getDepartmentById(departmentId);

        if (HelperUtils.isNotNull(department)) {

            department.assignDoctor(doctorId);

            System.out.println("Doctor Assigned Successfully");
        }
        else {

            System.out.println("Department doesn't exist");
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Department department){
            departments.add(department);
            System.out.println("Department added successfully");
        }
        else {
            System.out.println("Invalid entity type");

        }

    }

    @Override
    public void remove(String id) {
        Department department =getDepartmentById(id);
        if (HelperUtils.isNotNull(department)) {
            departments.remove(department);
            System.out.println("department removed successfully");
        }
        else {
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
        boolean found =false;

        for (Department d : departments){
            if (d.getDepartmentName().equalsIgnoreCase(keyword)
                    || d.getDepartmentId().equalsIgnoreCase(keyword)) {

                System.out.println(d);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No department found");
        }

    }

    @Override
    public void searchById(String id) {
        Department department =getDepartmentById(id);

        if (HelperUtils.isNotNull(department)) {
            System.out.println(department);
        }
        else {
            System.out.println("Department not found");
        }

    }
}
