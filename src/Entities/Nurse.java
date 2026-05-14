package Entities;

import Utils.Constants;
import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person implements Displayable {
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<Patient> assignedPatients;

    public Nurse(String id, String firstName, String lastName, LocalDate dateOfBirth,
                 String gender, String phoneNumber, String email, String address,
                 String nurseId, String departmentId, String shift, String qualification,
                 List<Patient> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        setNurseId(nurseId);
        setDepartmentId(departmentId);
        setShift(shift);
        setQualification(qualification);
        setAssignedPatients(assignedPatients);
    }

    public Nurse() {
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        if (HelperUtils.isNotNull(nurseId)) {
            this.nurseId = nurseId;
        } else {
            this.nurseId = HelperUtils.generateId("NUR");
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isNotNull(departmentId)) {
            this.departmentId = departmentId;
        } else {
            this.departmentId = "N/A";
        }
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        if (HelperUtils.isValidString(shift)) {
            this.shift = shift;
        } else {
            this.shift = "Morning";
        }
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        if (HelperUtils.isValidString(qualification)) {
            this.qualification = qualification;
        } else {
            this.qualification = "Unknown";
        }
    }

    public List<Patient> getAssignedPatients() {
        if (HelperUtils.isNull(assignedPatients)) {
            assignedPatients = new ArrayList<>();
        }
        return assignedPatients;
    }

    public void setAssignedPatients(List<Patient> assignedPatients) {
        if (HelperUtils.isNotNull(assignedPatients)) {
            this.assignedPatients = assignedPatients;
        } else {
            this.assignedPatients = new ArrayList<>();
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Nurse: " + (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", ID: " + (HelperUtils.isNotNull(nurseId) ? nurseId : "N/A") +
                        ", Department: " + (HelperUtils.isNotNull(departmentId) ? departmentId : "N/A") +
                        ", Shift: " + (HelperUtils.isNotNull(shift) ? shift : "N/A") +
                        ", Patients: " + (HelperUtils.isNotNull(assignedPatients) ? assignedPatients.size() : 0)
        );
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId='" + (HelperUtils.isNotNull(nurseId) ? nurseId : "N/A") + '\'' +
                ", departmentId='" + (HelperUtils.isNotNull(departmentId) ? departmentId : "N/A") + '\'' +
                ", shift=" + (HelperUtils.isNotNull(shift) ? shift : "N/A") +
                ", qualification='" + (HelperUtils.isNotNull(qualification) ? qualification : "N/A") + '\'' +
                ", assignedPatients=" + (HelperUtils.isNotNull(assignedPatients) ? assignedPatients : "[]") +
                '}';
    }

    public void assignPatients(Patient patient) {
        if (HelperUtils.isNotNull(patient)) {
            List<Patient> list = getAssignedPatients();
            if (!list.contains(patient)) {
                list.add(patient);
                System.out.println(Constants.PATIENT_ASSIGN_SUCCESSFULLY);
            } else {
                System.out.println("Patient already assigned.");
            }
        } else {
            System.out.println("Invalid patient.");
        }
    }

    public void removePatient(Patient patient) {
        if (HelperUtils.isNotNull(patient) && HelperUtils.isNotNull(assignedPatients) && assignedPatients.contains(patient)) {
            assignedPatients.remove(patient);
            System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
        } else {
            System.out.println("Patient not found or invalid.");
        }
    }
}