package Entities;

import Utils.HelperUtils;
import Utils.InputHandler;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctor {
    private List<String> consultationTypes;
    private Boolean onlineConsultationAvailable;
    private int consultationDuration;

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth,
                      String gender, String phoneNumber, String email, String address,
                      String doctorId, String specialization, String qualification,
                      int experienceYears, String departmentId, Double consultationFee,
                      List<String> availableSlots, List<String> assignedPatients,
                      List<String> consultationTypes, int consultationDuration,
                      Boolean onlineConsultationAvailable) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                doctorId, specialization, qualification, experienceYears, departmentId,
                consultationFee, availableSlots, assignedPatients);
        setConsultationTypes(consultationTypes);
        setConsultationDuration(consultationDuration);
        setOnlineConsultationAvailable(onlineConsultationAvailable);
    }

    public Consultant() {
        super();
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        if (HelperUtils.isNotNull(consultationTypes)) {
            List<String> validTypes = new ArrayList<>();
            for (String type : consultationTypes) {
                if (HelperUtils.isValidString(type)) {
                    validTypes.add(type);
                }
            }
            this.consultationTypes = validTypes;
        } else {
            this.consultationTypes = new ArrayList<>();
        }
    }

    public Boolean getOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(Boolean onlineConsultationAvailable) {
        if (HelperUtils.isNotNull(onlineConsultationAvailable)) {
            this.onlineConsultationAvailable = onlineConsultationAvailable;
        } else {
            this.onlineConsultationAvailable = false;
        }
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        if (HelperUtils.isPositive(consultationDuration)) {
            this.consultationDuration = consultationDuration;
        } else {
            this.consultationDuration = 30;
        }
    }

    public void scheduleConsultation(String type) {
        if (!HelperUtils.isValidString(type)) {
            System.out.println("Invalid consultation type – must be a non-empty string.");
            return;
        }

        if (HelperUtils.isNull(consultationTypes)) {
            consultationTypes = new ArrayList<>();
        }

        if (!consultationTypes.contains(type)) {
            consultationTypes.add(type);
            System.out.println("Consultation scheduled for: " + type);
        } else {
            System.out.println("Consultation type already exists: " + type);
        }

        System.out.println("Doctor: " +
                (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A"));
        System.out.println("Duration: " + getConsultationDuration() + " minute(s)");

        if (HelperUtils.isNotNull(onlineConsultationAvailable) && onlineConsultationAvailable) {
            System.out.println("This consultation can be done online.");
        } else {
            System.out.println("This consultation is only in‑person.");
        }
    }

    public void provideSecondOpinion(String diagnosis) {
        if (!HelperUtils.isValidString(diagnosis)) {
            System.out.println("Invalid diagnosis – must be a non-empty string.");
            return;
        }
        String doctorName = (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "Consultant");
        System.out.println("Dr. " + doctorName + " is reviewing the diagnosis...");
        System.out.println("Original Diagnosis: " + diagnosis);
        System.out.println("Second Opinion: Further evaluation required / confirmed / alternative diagnosis suggested.");
    }

    public void updateConsultationDurationInteractive() {
        int newDuration = InputHandler.getIntInput("Enter new consultation duration (minutes): ", 15, 120);
        setConsultationDuration(newDuration);
        System.out.println("Consultation duration updated to " + getConsultationDuration() + " minutes.");
    }

    public void toggleOnlineAvailabilityInteractive() {
        boolean confirm = InputHandler.getConfirmation("Enable online consultations?");
        setOnlineConsultationAvailable(confirm);
        System.out.println("Online consultation availability set to: " + getOnlineConsultationAvailable());
    }

    public void addConsultationTypeInteractive() {
        String newType = InputHandler.getStringInput("Enter new consultation type: ");
        scheduleConsultation(newType);
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Consultant: Dr. " + (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", Specialization: " + (HelperUtils.isNotNull(getSpecialization()) ? getSpecialization() : "N/A") +
                        ", Duration: " + consultationDuration + " minutes" +
                        ", Online Available: " + (HelperUtils.isNotNull(onlineConsultationAvailable) ? onlineConsultationAvailable : false)
        );
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "consultationTypes=" + (HelperUtils.isNotNull(consultationTypes) ? consultationTypes : "[]") +
                ", onlineConsultationAvailable=" + (HelperUtils.isNotNull(onlineConsultationAvailable) ? onlineConsultationAvailable : false) +
                ", consultationDuration=" + consultationDuration +
                ", doctorId=" + (HelperUtils.isNotNull(getDoctorId()) ? getDoctorId() : "N/A") +
                ", firstName=" + (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") +
                ", lastName=" + (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                '}';
    }
}