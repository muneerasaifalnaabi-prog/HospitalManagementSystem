package Entities;

import interfaces.Displayable;

import java.util.List;

public class Department implements Displayable {
    @Override
    public void displayInfo() {
        System.out.println(this.toString());

    }

    @Override
    public void displaySummary() {

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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public List<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<String> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }
    public void assignDoctor(String doctorid){
        if(!doctors.contains(doctorid)){
            doctors.add(doctorid);
            System.out.println("Doctor" +doctorid + "assigend to"+departmentName);

        }
    }
    public void assignNurse(String nurseid) {
        if(!nurses.contains(nurseid)){
            doctors.add(nurseid);
            System.out.println("Nurse" +nurseid + "assigend to"+departmentName);

        }
    }

    //i will complete later
    public void updateBedAvailability(int beds) {

        if (beds >= 0 && beds <= bedCapacity) {
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

