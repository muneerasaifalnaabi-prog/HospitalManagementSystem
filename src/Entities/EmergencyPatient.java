package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends InPatient {
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
        if (HelperUtils.isValidString(emergencyType)) {
            this.emergencyType = emergencyType;
        } else {
            System.out.println("InValid input");
        }
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        if (HelperUtils.isValidString(arrivalMode)) {
            this.arrivalMode = arrivalMode;
        }
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        if (HelperUtils.isValidNumber(triageLevel, 1, 5)) {
            this.triageLevel = triageLevel;
        }
        else {
            System.out.println("invalid input");
        }

    }
    @Override
    public void displayInfo(){
        System.out.println(this.toString());
    }
    @Override
    public void displaySummary(){
        System.out.println(
                "Emergency Patient: " + getFirstName() + " " + getLastName() +
                        ", Emergency Type: " + emergencyType +
                        ", Triage Level: " + triageLevel +
                        ", Arrival Mode: " + arrivalMode +
                        ", ER Admission: " + admittedViaER
        );

    }

    public Boolean getAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(Boolean admittedViaER) {
        if (HelperUtils.isNotNull(admittedViaER)) {
            this.admittedViaER = admittedViaER;
        }
    }

    @Override
    public String toString() {
        return "EmergencyPatient{" +
                "emergencyType='" + emergencyType + '\'' +
                ", arrivalMode='" + arrivalMode + '\'' +
                ", triageLevel=" + triageLevel +
                ", admittedViaER=" + admittedViaER +
                '}';
    }
}
