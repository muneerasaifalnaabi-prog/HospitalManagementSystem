package Entities;

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
        this.surgeriesPerformed = surgeriesPerformed;
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
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public boolean  performSurgery(String surgeryType){

        if(!surgeryTypes.contains(surgeryType)){
            return false;
        }

        if(operationTheatreAccess){
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
        super.displayInfo();
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {

    }
}
