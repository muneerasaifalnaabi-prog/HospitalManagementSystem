package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.util.List;

public class Department implements Displayable {
    @Override
    public void displayInfo() {
        System.out.println(this.toString());

    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Department: " + departmentName +
                        ", Head Doctor ID: " + headDoctorId +
                        ", Doctors Count: " + doctors.size() +
                        ", Nurses Count: " + nurses.size() +
                        ", Available Beds: " + availableBeds + "/" + bedCapacity
        );

    }

    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors;
    private List<Nurse> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentId, String departmentName, String headDoctorId, List<String> doctors, List<Nurse> nurses, int bedCapacity, int availableBeds) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.doctors = doctors;
        this.nurses = nurses;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
    }

    public Department() {
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId, 2)) {
            this.departmentId = departmentId;
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (HelperUtils.isValidString(departmentName, 3)) {
            this.departmentName = departmentName;
        }
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        if (HelperUtils.isValidString(headDoctorId, 2)) {
            this.headDoctorId = headDoctorId;
        }
    }

    public List<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<String> doctors) {
        if (HelperUtils.isNotNull(doctors)) {
            this.doctors = doctors;
        }
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        if (HelperUtils.isNotNull(nurses)) {
            this.nurses = nurses;
        }
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        if (HelperUtils.isPositive(bedCapacity)) {
            this.bedCapacity = bedCapacity;
        }
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        if (HelperUtils.isPositive(bedCapacity)) {
            this.availableBeds = availableBeds;
        }
    }

    public void assignDoctor(String doctorid) {
        if (HelperUtils.isValidString(doctorid) && !doctors.contains(doctorid)) {
            doctors.add(doctorid);
            System.out.println("Doctor" + doctorid + "assigend to" + departmentName);

        }
    }

    public void assignNurse(Nurse nurse) {
        if (HelperUtils.isNotNull(nurse) && !nurses.contains(nurse)) {
            nurses.add(nurse);
            System.out.println("Nurse assigned to " + departmentName);
        }
    }


    public void updateBedAvailability(int beds) {

        if (HelperUtils.isValidNumber(beds, 0, bedCapacity)) {
            availableBeds = beds;
            System.out.println("Available beds updated.");
        } else {
            System.out.println("Invalid bed count.");
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", headDoctorId='" + headDoctorId + '\'' +
                ", doctors=" + doctors +
                ", nurses=" + nurses +
                ", bedCapacity=" + bedCapacity +
                ", availableBeds=" + availableBeds +
                '}';
    }
}

