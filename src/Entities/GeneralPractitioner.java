package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctor {
    private Boolean walkinAvailable;
    private Boolean homeVisitAvailable;
    private Boolean vaccinationCertified;

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth,
                               String gender, String phoneNumber, String email, String address,
                               String doctorId, String specialization, String qualification,
                               int experienceYears, String departmentId, Double consultationFee,
                               List<String> availableSlots, List<String> assignedPatients,
                               Boolean walkinAvailable, Boolean homeVisitAvailable, Boolean vaccinationCertified) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                doctorId, specialization, qualification, experienceYears, departmentId,
                consultationFee, availableSlots, assignedPatients);
        setWalkinAvailable(walkinAvailable);
        setHomeVisitAvailable(homeVisitAvailable);
        setVaccinationCertified(vaccinationCertified);
    }

    public GeneralPractitioner() {
    }

    public Boolean getWalkinAvailable() {
        return walkinAvailable;
    }

    public void setWalkinAvailable(Boolean walkinAvailable) {
        if (HelperUtils.isNotNull(walkinAvailable)) {
            this.walkinAvailable = walkinAvailable;
        } else {
            this.walkinAvailable = false;
        }
    }

    public Boolean getHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(Boolean homeVisitAvailable) {
        if (HelperUtils.isNotNull(homeVisitAvailable)) {
            this.homeVisitAvailable = homeVisitAvailable;
        } else {
            this.homeVisitAvailable = false;
        }
    }

    public Boolean getVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(Boolean vaccinationCertified) {
        if (HelperUtils.isNotNull(vaccinationCertified)) {
            this.vaccinationCertified = vaccinationCertified;
        } else {
            this.vaccinationCertified = false;
        }
    }

    public void administerVaccine(String patientName, String vaccineName) {
        if (!HelperUtils.isValidString(patientName) || !HelperUtils.isValidString(vaccineName)) {
            System.out.println("Invalid input: patient name or vaccine name cannot be empty.");
            return;
        }
        if (HelperUtils.isNotNull(vaccinationCertified) && vaccinationCertified) {
            System.out.println("Vaccination certified for " + patientName + " is approved.");
            System.out.println("Doctor: " +
                    (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                    (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                    " is administering the vaccine.");
            System.out.println("Patient Name: " + patientName);
            System.out.println("Vaccine Name: " + vaccineName);
        } else {
            System.out.println("Doctor is not certified to administer vaccines.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "General Practitioner: Dr. " +
                        (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", Walk-in: " + (HelperUtils.isNotNull(walkinAvailable) ? walkinAvailable : false) +
                        ", Home Visit: " + (HelperUtils.isNotNull(homeVisitAvailable) ? homeVisitAvailable : false) +
                        ", Vaccination Certified: " + (HelperUtils.isNotNull(vaccinationCertified) ? vaccinationCertified : false)
        );
    }

    @Override
    public String toString() {
        return "GeneralPractitioner{" +
                "walkinAvailable=" + (HelperUtils.isNotNull(walkinAvailable) ? walkinAvailable : false) +
                ", homeVisitAvailable=" + (HelperUtils.isNotNull(homeVisitAvailable) ? homeVisitAvailable : false) +
                ", vaccinationCertified=" + (HelperUtils.isNotNull(vaccinationCertified) ? vaccinationCertified : false) +
                '}';
    }
}