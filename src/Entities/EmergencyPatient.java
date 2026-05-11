package Entities;

public class EmergencyPatient {
    private String emergencyType;
    private String arrivalMode;
    private int triageLevel;
    private Boolean admittedViaER;

    public EmergencyPatient(String emergencyType, String arrivalMode, int triageLevel, Boolean admittedViaER) {
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
