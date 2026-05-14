package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient implements Displayable {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                      String gender, String phoneNumber, String email, String address,
                      String patientId, String bloodGroup, List<String> allergies,
                      String emergencyContact, LocalDate registrationDate, String insuranceId,
                      List<String> appointments, List<String> medicalRecords,
                      int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                patientId, bloodGroup, allergies, emergencyContact, registrationDate,
                insuranceId, appointments, medicalRecords);
        setVisitCount(visitCount);
        setLastVisitDate(lastVisitDate);
        setPreferredDoctorId(preferredDoctorId);
    }

    public OutPatient() {
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        if (HelperUtils.isValidNumber(visitCount, 0, Integer.MAX_VALUE)) {
            this.visitCount = visitCount;
        } else {
            this.visitCount = 0;
        }
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        if (HelperUtils.isNotNull(lastVisitDate)) {
            this.lastVisitDate = lastVisitDate;
        } else {
            this.lastVisitDate = LocalDate.now();
        }
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        if (HelperUtils.isValidString(preferredDoctorId, 2)) {
            this.preferredDoctorId = preferredDoctorId;
        } else {
            this.preferredDoctorId = "N/A";
        }
    }

    public void scheduleFollowUp(LocalDate followUpDate) {
        if (HelperUtils.isNotNull(followUpDate)) {
            System.out.println("Follow up for patient: " +
                    (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                    (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A"));
            System.out.println("Date: " + followUpDate);
            lastVisitDate = followUpDate;
        } else {
            System.out.println("Invalid follow-up date.");
        }
    }

    public void updateVisitCount() {
        visitCount++;
        System.out.println("Updated visitCount: " + visitCount);
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "OutPatient: " +
                        (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", Visits: " + visitCount +
                        ", Last Visit: " + (HelperUtils.isNotNull(lastVisitDate) ? lastVisitDate : "N/A") +
                        ", Preferred Doctor: " + (HelperUtils.isNotNull(preferredDoctorId) ? preferredDoctorId : "N/A")
        );
    }

    @Override
    public String toString() {
        return "OutPatient{" +
                "visitCount=" + visitCount +
                ", lastVisitDate=" + (HelperUtils.isNotNull(lastVisitDate) ? lastVisitDate : "N/A") +
                ", preferredDoctorId='" + (HelperUtils.isNotNull(preferredDoctorId) ? preferredDoctorId : "N/A") + '\'' +
                '}';
    }
}