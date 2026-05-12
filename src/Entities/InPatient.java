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

    public long calculateStayDuration() {
        if (dischargeDate == null) {
            return ChronoUnit.DAYS.between(admissionDate, LocalDate.now());
        }

        return ChronoUnit.DAYS.between(admissionDate, dischargeDate);
    }

    public Double calculateTotalCharges() {
        long days = calculateStayDuration();
        return dailyCharges * days;
    }

    @Override
    public void calculateCharges() {
        double total =calculateTotalCharges();
        System.out.println("Total Of Chargs "+total);

    }

    @Override
    public void generateBill() {
        long days = calculateStayDuration();
        double total = calculateTotalCharges();

        System.out.println("===== HOSPITAL BILL =====");
        System.out.println("Patient ID: " + getPatientId());
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Discharge Date: " + dischargeDate);
        System.out.println("Days Stayed: " + days);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Bed Number: " + bedNumber);
        System.out.println("Daily Charges: " + dailyCharges);
        System.out.println("TOTAL AMOUNT: " + total);
        System.out.println("=========================");

    }

    @Override
    public void processPayment(double amount) {

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(this.toString());


    }

    @Override
    public void displaySummary() {
        System.out.println(
                "InPatient: " + getFirstName() + " " + getLastName() +
                        ", Room: " + roomNumber +
                        ", Bed: " + bedNumber +
                        ", Admission: " + admissionDate +
                        ", Doctor ID: " + admittingDoctorId
        );

    }

    @Override
    public String toString() {
        return "InPatient{" +
                "admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedNumber='" + bedNumber + '\'' +
                ", admittingDoctorId='" + admittingDoctorId + '\'' +
                ", dailyCharges=" + dailyCharges +
                '}';
    }
}

