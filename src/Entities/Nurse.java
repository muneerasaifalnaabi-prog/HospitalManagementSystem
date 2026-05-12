package Entities;

import Utils.Constants;
import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;


public class Nurse extends Person implements Displayable {
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<Patient> assignedPatients;

    public Nurse(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String nurseId, String departmentId, String shift, String qualification, List<Patient> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = assignedPatients;
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        if (HelperUtils.isNotNull(nurseId)) {
            this.nurseId = nurseId;
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<Patient> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<Patient> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    @Override
    public void displayInfo(){
        System.out.println(this.toString());
    }
    @Override
    public void displaySummary() {
        System.out.println(
                "Nurse: " + getFirstName() + " " + getLastName() +
                        ", ID: " + nurseId +
                        ", Department: " + departmentId +
                        ", Shift: " + shift +
                        ", Patients: " + assignedPatients.size()
        );
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
    /*====================== */
    public void  assignPatients(Patient patient){
        assignedPatients.add(patient);
        System.out.println(Constants.PATIENT_ASSIGN_SUCCESSFULLY);

    }
    public void  removePatient(Patient patient){
        assignedPatients.remove(patient);
        System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
    }

}
