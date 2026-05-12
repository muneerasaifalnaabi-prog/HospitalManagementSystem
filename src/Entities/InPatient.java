package Entities;

import interfaces.Billable;
import interfaces.Displayable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends Patient implements Displayable , Billable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> appointments, List<String> medicalRecords, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String admittingDoctorId, String bedNumber, double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, appointments, medicalRecords);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.bedNumber = bedNumber;
        this.dailyCharges = dailyCharges;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }
    public long calculateStayDuration(){
        if (dischargeDate == null) {
            return ChronoUnit.DAYS.between(admissionDate, LocalDate.now());
        }

        return ChronoUnit.DAYS.between(admissionDate, dischargeDate);
    }
    public Double calculateTotalCharges(){
        long days = calculateStayDuration();
        return dailyCharges*days;
    }

    @Override
    public void calculateCharges() {

    }

    @Override
    public void generateBill() {

    }

    @Override
    public void processPayment(double amount) {

    }
}

