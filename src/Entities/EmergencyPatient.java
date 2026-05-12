package Entities;

import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends InPatient  {
    private String emergencyType;
    private String arrivalMode;
    private int triageLevel;
    private Boolean admittedViaER;

    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> appointments, List<String> medicalRecords, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String admittingDoctorId, String bedNumber, double dailyCharges, String emergencyType, String arrivalMode, int triageLevel, Boolean admittedViaER) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, appointments, medicalRecords, admissionDate, dischargeDate, roomNumber, admittingDoctorId, bedNumber, dailyCharges);
        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = admittedViaER;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        this.arrivalMode = arrivalMode;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        if (triageLevel >=1 && triageLevel <= 5) {
            this.triageLevel = triageLevel;
        }

    }

    public Boolean getAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(Boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }
}
