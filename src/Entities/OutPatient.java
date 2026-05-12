package Entities;

import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient implements Displayable {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> appointments, List<String> medicalRecords, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, appointments, medicalRecords);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }
    public void scheduleFollowUp(LocalDate followUpDate){
        System.out.println("Follow up for patient:" +getFirstName() + " " + getLastName());
        System.out.println("Date "+followUpDate);
        lastVisitDate = followUpDate;
    }
    public void updateVisitCount(){
        visitCount++;
        System.out.println("Updated visitCount:" +visitCount);
    }
    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

}
