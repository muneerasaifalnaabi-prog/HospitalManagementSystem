package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.util.List;

public class Department implements Displayable {

    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors;
    private List<Nurse> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentId, String departmentName, String headDoctorId,
                      List<String> doctors, List<Nurse> nurses, int bedCapacity, int availableBeds) {
        setDepartmentId(departmentId);
        setDepartmentName(departmentName);
        setHeadDoctorId(headDoctorId);
        setDoctors(doctors);
        setNurses(nurses);
        setBedCapacity(bedCapacity);
        setAvailableBeds(availableBeds);
    }

    public Department() {
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId, 2)) {
            this.departmentId = departmentId;
        } else {
            this.departmentId = HelperUtils.generateId("DEP");
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (HelperUtils.isValidString(departmentName, 3)) {
            this.departmentName = departmentName;
        } else {
            this.departmentName = "Unknown";
        }
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        if (HelperUtils.isValidString(headDoctorId, 2)) {
            this.headDoctorId = headDoctorId;
        } else {
            this.headDoctorId = "N/A";
        }
    }

    public List<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<String> doctors) {
        if (HelperUtils.isNotNull(doctors)) {
            this.doctors = doctors;
        } else {
            this.doctors = new java.util.ArrayList<>();
        }
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        if (HelperUtils.isNotNull(nurses)) {
            this.nurses = nurses;
        } else {
            this.nurses = new java.util.ArrayList<>();
        }
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        if (HelperUtils.isPositive(bedCapacity)) {
            this.bedCapacity = bedCapacity;
        } else {
            this.bedCapacity = 10;
        }
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        if (HelperUtils.isValidNumber(availableBeds, 0, bedCapacity)) {
            this.availableBeds = availableBeds;
        } else {
            this.availableBeds = bedCapacity / 2;
        }
    }

    public void assignDoctor(String doctorid) {
        if (HelperUtils.isValidString(doctorid) && HelperUtils.isNotNull(doctors) && !doctors.contains(doctorid)) {
            doctors.add(doctorid);
            System.out.println("Doctor " + doctorid + " assigned to " + departmentName);
        } else {
            System.out.println("Invalid doctor ID or doctor already assigned.");
        }
    }

    public void assignNurse(Nurse nurse) {
        if (HelperUtils.isNotNull(nurse) && HelperUtils.isNotNull(nurses) && !nurses.contains(nurse)) {
            nurses.add(nurse);
            System.out.println("Nurse assigned to " + departmentName);
        } else {
            System.out.println("Invalid nurse or nurse already assigned.");
        }
    }

    public void updateBedAvailability(int beds) {
        if (HelperUtils.isValidNumber(beds, 0, bedCapacity)) {
            availableBeds = beds;
            System.out.println("Available beds updated to " + availableBeds);
        } else {
            System.out.println("Invalid bed count. Must be between 0 and " + bedCapacity);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Department: " + (HelperUtils.isNotNull(departmentName) ? departmentName : "N/A") +
                        ", Head Doctor ID: " + (HelperUtils.isNotNull(headDoctorId) ? headDoctorId : "N/A") +
                        ", Doctors Count: " + (HelperUtils.isNotNull(doctors) ? doctors.size() : 0) +
                        ", Nurses Count: " + (HelperUtils.isNotNull(nurses) ? nurses.size() : 0) +
                        ", Available Beds: " + availableBeds + "/" + bedCapacity
        );
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + (HelperUtils.isNotNull(departmentId) ? departmentId : "N/A") + '\'' +
                ", departmentName='" + (HelperUtils.isNotNull(departmentName) ? departmentName : "N/A") + '\'' +
                ", headDoctorId='" + (HelperUtils.isNotNull(headDoctorId) ? headDoctorId : "N/A") + '\'' +
                ", doctors=" + (HelperUtils.isNotNull(doctors) ? doctors : "[]") +
                ", nurses=" + (HelperUtils.isNotNull(nurses) ? nurses : "[]") +
                ", bedCapacity=" + bedCapacity +
                ", availableBeds=" + availableBeds +
                '}';
    }
}