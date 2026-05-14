package Entities;

import Utils.HelperUtils;
import interfaces.Billable;
import interfaces.Displayable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends Patient implements Displayable, Billable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                     String gender, String phoneNumber, String email, String address,
                     String patientId, String bloodGroup, List<String> allergies,
                     String emergencyContact, LocalDate registrationDate, String insuranceId,
                     List<String> appointments, List<String> medicalRecords,
                     LocalDate admissionDate, LocalDate dischargeDate, String roomNumber,
                     String admittingDoctorId, String bedNumber, double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                patientId, bloodGroup, allergies, emergencyContact, registrationDate,
                insuranceId, appointments, medicalRecords);
        setAdmissionDate(admissionDate);
        setDischargeDate(dischargeDate);
        setRoomNumber(roomNumber);
        setAdmittingDoctorId(admittingDoctorId);
        setBedNumber(bedNumber);
        setDailyCharges(dailyCharges);
    }

    public InPatient() {
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        if (HelperUtils.isNotNull(admissionDate)) {
            this.admissionDate = admissionDate;
        } else {
            this.admissionDate = LocalDate.now();
        }
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        if (HelperUtils.isNotNull(dischargeDate)) {
            this.dischargeDate = dischargeDate;
        } else {
            this.dischargeDate = null;
        }
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        if (HelperUtils.isValidString(roomNumber)) {
            this.roomNumber = roomNumber;
        } else {
            this.roomNumber = "N/A";
        }
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        if (HelperUtils.isValidString(bedNumber)) {
            this.bedNumber = bedNumber;
        } else {
            this.bedNumber = "N/A";
        }
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        if (HelperUtils.isValidString(admittingDoctorId)) {
            this.admittingDoctorId = admittingDoctorId;
        } else {
            this.admittingDoctorId = "N/A";
        }
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        if (HelperUtils.isPositive(dailyCharges)) {
            this.dailyCharges = dailyCharges;
        } else {
            this.dailyCharges = 100.0;
        }
    }

    public long calculateStayDuration() {
        if (HelperUtils.isNull(dischargeDate)) {
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
        double total = calculateTotalCharges();
        System.out.println("Total Charges: " + total);
    }

    @Override
    public void generateBill() {
        long days = calculateStayDuration();
        double total = calculateTotalCharges();

        System.out.println("===== HOSPITAL BILL =====");
        System.out.println("Patient ID: " + (HelperUtils.isNotNull(getPatientId()) ? getPatientId() : "N/A"));
        System.out.println("Admission Date: " + (HelperUtils.isNotNull(admissionDate) ? admissionDate : "N/A"));
        System.out.println("Discharge Date: " + (HelperUtils.isNotNull(dischargeDate) ? dischargeDate : "N/A"));
        System.out.println("Days Stayed: " + days);
        System.out.println("Room Number: " + (HelperUtils.isNotNull(roomNumber) ? roomNumber : "N/A"));
        System.out.println("Bed Number: " + (HelperUtils.isNotNull(bedNumber) ? bedNumber : "N/A"));
        System.out.println("Daily Charges: " + dailyCharges);
        System.out.println("TOTAL AMOUNT: " + total);
        System.out.println("=========================");
    }

    @Override
    public void processPayment(double amount) {
        if (!HelperUtils.isPositive(amount)) {
            System.out.println("Invalid payment amount.");
            return;
        }
        double total = calculateTotalCharges();
        if (amount >= total) {
            System.out.println("Payment successful.");
            System.out.println("Change: " + (amount - total));
        } else {
            System.out.println("Payment failed. Insufficient amount.");
            System.out.println("Remaining amount: " + (total - amount));
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "InPatient: " +
                        (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", Room: " + (HelperUtils.isNotNull(roomNumber) ? roomNumber : "N/A") +
                        ", Bed: " + (HelperUtils.isNotNull(bedNumber) ? bedNumber : "N/A") +
                        ", Admission: " + (HelperUtils.isNotNull(admissionDate) ? admissionDate : "N/A") +
                        ", Doctor ID: " + (HelperUtils.isNotNull(admittingDoctorId) ? admittingDoctorId : "N/A")
        );
    }

    @Override
    public String toString() {
        return "InPatient{" +
                "admissionDate=" + (HelperUtils.isNotNull(admissionDate) ? admissionDate : "N/A") +
                ", dischargeDate=" + (HelperUtils.isNotNull(dischargeDate) ? dischargeDate : "N/A") +
                ", roomNumber='" + (HelperUtils.isNotNull(roomNumber) ? roomNumber : "N/A") + '\'' +
                ", bedNumber='" + (HelperUtils.isNotNull(bedNumber) ? bedNumber : "N/A") + '\'' +
                ", admittingDoctorId='" + (HelperUtils.isNotNull(admittingDoctorId) ? admittingDoctorId : "N/A") + '\'' +
                ", dailyCharges=" + dailyCharges +
                '}';
    }
}