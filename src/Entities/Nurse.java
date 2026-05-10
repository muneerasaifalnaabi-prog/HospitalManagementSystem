package Entities;

import java.time.LocalDate;
import java.util.List;

enum shift{
     Morning,
    Evening,
    Night

}
public class Nurse extends Person {
    private String nurseId;
    private String departmentId;
    private shift shift;
    private String qualification;
    private List<String> assignedPatients;

    public Nurse(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String nurseId, String departmentId, shift shift, List<String> assignedPatients, String qualification) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.assignedPatients = assignedPatients;
        this.qualification = qualification;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        toString();


    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId='" + nurseId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", shift=" + shift +
                ", qualification='" + qualification + '\'' +
                ", assignedPatients=" + assignedPatients +
                '}';
    }

}
