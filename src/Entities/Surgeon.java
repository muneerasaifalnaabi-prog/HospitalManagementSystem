package Entities;

import java.time.LocalDate;
import java.util.List;

public class Surgeon extends Doctor {
 private int surgeriesPerformed;
 private List<String> surgeryTypes;
 private  List<String> operationTheatreAccess;

    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, List<String> operationTheatreAccess, int surgeriesPerformed, List<String> surgeryTypes) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.operationTheatreAccess = operationTheatreAccess;
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public List<String> getOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(List<String> operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }
}
