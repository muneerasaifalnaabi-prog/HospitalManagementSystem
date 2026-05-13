package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;

public class MedicalRecord implements Displayable {
    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Medical Record ID: " + recordId +
                        ", Patient ID: " + patientId +
                        ", Doctor ID: " + doctorId +
                        ", Visit Date: " + visitDate +
                        ", Diagnosis: " + diagnosis
        );

    }

    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate, String diagnosis, String testResults, String prescription, String notes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.testResults = testResults;
        this.prescription = prescription;
        this.notes = notes;
    }

    public MedicalRecord() {
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        if (HelperUtils.isNotNull(recordId)) {
            this.recordId = recordId;
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isNotNull(patientId)) {
            this.patientId = patientId;

        }
    }


    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isNotNull(doctorId)) {
            this.doctorId = doctorId;
        }
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        if (HelperUtils.isValidDate(String.valueOf(visitDate))) {
            this.visitDate = visitDate;
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (HelperUtils.isValidString(diagnosis)) {
            this.diagnosis = diagnosis;
        }
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        if (HelperUtils.isValidString(prescription)) {
            this.prescription = prescription;
        }
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        if (HelperUtils.isValidString(testResults)) {
            this.testResults = testResults;
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (HelperUtils.isValidString(notes)) {

        }
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId='" + recordId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", visitDate=" + visitDate +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", testResults='" + testResults + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
