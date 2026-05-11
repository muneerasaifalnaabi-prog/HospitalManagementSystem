package Entities;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctor {
    private Boolean walkinAvailable;
    private Boolean homeVisitAvailable;
    private Boolean vaccinationCertified;

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, Boolean walkinAvailable, Boolean homeVisitAvailable, Boolean vaccinationCertified) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }

    public Boolean getWalkinAvailable() {
        return walkinAvailable;
    }

    public void setWalkinAvailable(Boolean walkinAvailable) {
        this.walkinAvailable = walkinAvailable;
    }

    public Boolean getHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(Boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public Boolean getVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(Boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }
    /*public void scheduleHomeVisit(String patientName ,String address){
        if (!homeVisitAvailable){
            System.out.println("Home visit are not availble for this doctor ");
            return;
        }
        homeVisitAvailable
    }*/
    public void  administerVaccine(String patientName ,String vaccineNmae){
        if (vaccinationCertified){
            System.out.println("Vaccination certified for "+patientName+" is approved");
            System.out.println("Doctor :" +getFirstName() + "is reviewing the diagnosis...");
            System.out.println("Patient Name :" +patientName);
            System.out.println("Vaccine Name :" +vaccineNmae);
        }
        System.out.println("Doctor is not certified to administer vaccines.");
        return;
    }
}
