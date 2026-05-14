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

    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                            String gender, String phoneNumber, String email, String address,
                            String patientId, String bloodGroup, List<String> allergies,
                            String emergencyContact, LocalDate registrationDate, String insuranceId,
                            List<String> appointments, List<String> medicalRecords,
                            LocalDate admissionDate, LocalDate dischargeDate, String roomNumber,
                            String admittingDoctorId, String bedNumber, double dailyCharges,
                            String emergencyType, String arrivalMode, int triageLevel, Boolean admittedViaER) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId,
                appointments, medicalRecords, admissionDate, dischargeDate, roomNumber,
                admittingDoctorId, bedNumber, dailyCharges);
        setEmergencyType(emergencyType);
        setArrivalMode(arrivalMode);
        setTriageLevel(triageLevel);
        setAdmittedViaER(admittedViaER);
    }

    public EmergencyPatient() {
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        if (HelperUtils.isValidString(emergencyType)) {
            this.emergencyType = emergencyType;
        } else {
            this.emergencyType = "Unknown";
            System.out.println("Invalid input, emergency type set to Unknown.");
        }
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        if (HelperUtils.isValidString(arrivalMode)) {
            this.arrivalMode = arrivalMode;
        } else {
            this.arrivalMode = "Unknown";
            System.out.println("Invalid input, arrival mode set to Unknown.");
        }
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        if (HelperUtils.isValidNumber(triageLevel, 1, 5)) {
            this.triageLevel = triageLevel;
        } else {
            this.triageLevel = 3;
            System.out.println("Invalid input, triage level set to 3 (default).");
        }
    }

    public Boolean getAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(Boolean admittedViaER) {
        if (HelperUtils.isNotNull(admittedViaER)) {
            this.admittedViaER = admittedViaER;
        } else {
            this.admittedViaER = false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Emergency Patient: " +
                        (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", Emergency Type: " + (HelperUtils.isNotNull(emergencyType) ? emergencyType : "N/A") +
                        ", Triage Level: " + triageLevel +
                        ", Arrival Mode: " + (HelperUtils.isNotNull(arrivalMode) ? arrivalMode : "N/A") +
                        ", ER Admission: " + (HelperUtils.isNotNull(admittedViaER) ? admittedViaER : false)
        );
    }

    @Override
    public String toString() {
        return "EmergencyPatient{" +
                "emergencyType='" + (HelperUtils.isNotNull(emergencyType) ? emergencyType : "N/A") + '\'' +
                ", arrivalMode='" + (HelperUtils.isNotNull(arrivalMode) ? arrivalMode : "N/A") + '\'' +
                ", triageLevel=" + triageLevel +
                ", admittedViaER=" + (HelperUtils.isNotNull(admittedViaER) ? admittedViaER : false) +
                '}';
    }
}