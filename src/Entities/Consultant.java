package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class Consultant extends Doctor {
   private List<String> consultationTypes;
   private Boolean onlineConsultationAvailable;
   private int consultationDuration;

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, List<String> consultationTypes, int consultationDuration, Boolean onlineConsultationAvailable) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.consultationTypes = consultationTypes;
        this.consultationDuration = consultationDuration;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        if (HelperUtils.isNotNull(consultationTypes)) {
            this.consultationTypes = consultationTypes;
        }
    }

    public Boolean getOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(Boolean onlineConsultationAvailable) {
        if (HelperUtils.isNotNull(onlineConsultationAvailable)) {
            this.onlineConsultationAvailable = onlineConsultationAvailable;
        }
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        if (HelperUtils.isPositive(consultationDuration)) {
            this.consultationDuration = consultationDuration;
        }
    }
    public void scheduleConsultation(String type){
        if (!HelperUtils.isValidString(type)) {
            System.out.println("Invalid consultation type");
            return;
        }

        if (HelperUtils.isNotNull(consultationTypes)) {
            consultationTypes.add(type);
        }
        consultationTypes.add(type);
        System.out.println("Consultation scheduled for " + type);
        System.out.println("Doctor :" +getFirstName());
        System.out.println("Doctor :" +getLastName());
        System.out.println("Duration :" +getConsultationDuration()+"minute");

        if(onlineConsultationAvailable){
            System.out.println("Doctor :" +getFirstName());
            System.out.println("Doctor :" +getLastName());
            System.out.println("This consultation  can be done online ");
        }
        else {
            System.out.println("This consultation is only in-person.");
        }

    }
    public void provideSecondOpinion(String diagnosis){
        if (!HelperUtils.isValidString(diagnosis)) {
            System.out.println("Invalid diagnosis");
            return;
        }
        System.out.println("Doctor :" +getFirstName() + "is reviewing the diagnosis...");
        System.out.println("Original Diagnosis :" +diagnosis);
        System.out.println("Second Opinion Second opinion: further evaluation required / confirmed / alternative diagnosis suggested.");

    }
    @Override
    public void displayInfo(){
        System.out.println(this.toString());
    }
    @Override
    public void displaySummary(){
        System.out.println(
                "Consultant: Dr. " + getFirstName() + " " + getLastName() +
                        ", Specialization: " + getSpecialization() +
                        ", Duration: " + consultationDuration + " minutes" +
                        ", Online Available: " + onlineConsultationAvailable
        );

    }


    @Override
    public String toString() {
        return "Consultant{" +
                "consultationTypes=" + consultationTypes +
                ", onlineConsultationAvailable=" + onlineConsultationAvailable +
                ", consultationDuration=" + consultationDuration +
                '}';
    }
}
