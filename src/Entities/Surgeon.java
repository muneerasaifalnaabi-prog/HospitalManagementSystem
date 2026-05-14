package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor implements Displayable {
    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private Boolean operationTheatreAccess;

    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email, String address,
                   String doctorId, String specialization, String qualification,
                   int experienceYears, String departmentId, Double consultationFee,
                   List<String> availableSlots, List<String> assignedPatients,
                   int surgeriesPerformed, List<String> surgeryTypes, Boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                doctorId, specialization, qualification, experienceYears, departmentId,
                consultationFee, availableSlots, assignedPatients);
        setSurgeriesPerformed(surgeriesPerformed);
        setSurgeryTypes(surgeryTypes);
        setOperationTheatreAccess(operationTheatreAccess);
    }

    public Surgeon() {
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        if (HelperUtils.isValidNumber(surgeriesPerformed, 0, Integer.MAX_VALUE)) {
            this.surgeriesPerformed = surgeriesPerformed;
        } else {
            this.surgeriesPerformed = 0;
        }
    }

    public List<String> getSurgeryTypes() {
        if (HelperUtils.isNull(surgeryTypes)) {
            surgeryTypes = new ArrayList<>();
        }
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        if (HelperUtils.isNotNull(surgeryTypes)) {
            this.surgeryTypes = surgeryTypes;
        } else {
            this.surgeryTypes = new ArrayList<>();
        }
    }

    public Boolean getOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(Boolean operationTheatreAccess) {
        if (HelperUtils.isNotNull(operationTheatreAccess)) {
            this.operationTheatreAccess = operationTheatreAccess;
        } else {
            this.operationTheatreAccess = false;
        }
    }

    public boolean performSurgery(String surgeryType) {
        if (HelperUtils.isNull(surgeryType)) {
            System.out.println("Surgery type cannot be null.");
            return false;
        }
        if (!HelperUtils.isNotNull(operationTheatreAccess) || !operationTheatreAccess) {
            System.out.println("No operation theatre access.");
            return false;
        }
        if (HelperUtils.isNull(surgeryTypes) || !surgeryTypes.contains(surgeryType)) {
            System.out.println("Surgery type not supported: " + surgeryType);
            return false;
        }
        surgeriesPerformed++;
        System.out.println("Surgery performed successfully. Total: " + surgeriesPerformed);
        return true;
    }

    public void updateSurgeryCount() {
        if (HelperUtils.isPositive(surgeriesPerformed)) {
            surgeriesPerformed++;
        } else {
            surgeriesPerformed = 1;
        }
        System.out.println("Total surgeries performed: " + surgeriesPerformed);
    }

    public void displaySurgeonInfo() {
        System.out.println("Surgeon info");
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Surgeon: " +
                        (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", Surgeries: " + surgeriesPerformed +
                        ", Operation Theatre Access: " +
                        (HelperUtils.isNotNull(operationTheatreAccess) ? operationTheatreAccess : false) +
                        ", Surgery Types: " +
                        (HelperUtils.isNotNull(surgeryTypes) ? surgeryTypes : "[]")
        );
    }

    @Override
    public String toString() {
        return "Surgeon{" +
                "surgeriesPerformed=" + surgeriesPerformed +
                ", surgeryTypes=" + (HelperUtils.isNotNull(surgeryTypes) ? surgeryTypes : "[]") +
                ", operationTheatreAccess=" +
                (HelperUtils.isNotNull(operationTheatreAccess) ? operationTheatreAccess : false) +
                '}';
    }
}