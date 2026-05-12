package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class Surgeon extends Doctor implements Displayable {
 private int surgeriesPerformed;
 private List<String> surgeryTypes;
 private  Boolean operationTheatreAccess;

    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, int surgeriesPerformed, List<String> surgeryTypes, Boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        if (HelperUtils.isValidNumber(surgeriesPerformed, 0, Integer.MAX_VALUE)) {
            this.surgeriesPerformed = surgeriesPerformed;
        }
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public Boolean getOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(Boolean operationTheatreAccess) {
        if (HelperUtils.isNotNull(operationTheatreAccess)) {
            this.operationTheatreAccess = operationTheatreAccess;
        }
    }

    public boolean performSurgery(String surgeryType) {
        if (HelperUtils.isNull(surgeryType)) {
            return false;
        }

        if (!operationTheatreAccess) {
            return false;
        }

        if (HelperUtils.isNull(surgeryTypes) || !surgeryTypes.contains(surgeryType)) {
            return false;
        }

        surgeriesPerformed++;
        return true;
    }
    public void updateSurgeryCount() {
        surgeriesPerformed++;
        System.out.println("Total surgeries performed: " + surgeriesPerformed);
    }

    @Override
    public String toString() {
        return "Surgeon{" +
                "surgeriesPerformed=" + surgeriesPerformed +
                ", surgeryTypes=" + surgeryTypes +
                ", operationTheatreAccess=" + operationTheatreAccess +
                '}';
    }
    public void displaySurgeonInfo(){
        System.out.println("Surgeon info");
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Surgeon: " + getFirstName() + " " + getLastName() +
                        ", Surgeries: " + surgeriesPerformed +
                        ", Operation Theatre Access: " + operationTheatreAccess +
                        ", Surgery Types: " + surgeryTypes
        );
    }
}
