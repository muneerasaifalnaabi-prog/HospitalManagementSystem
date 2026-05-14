package Entities;

import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;

public class MedicalRecord implements Displayable {

    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate,
                         String diagnosis, String testResults, String prescription, String notes) {
        setRecordId(recordId);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setVisitDate(visitDate);
        setDiagnosis(diagnosis);
        setTestResults(testResults);
        setPrescription(prescription);
        setNotes(notes);
    }

    public MedicalRecord() {
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        if (HelperUtils.isNotNull(recordId)) {
            this.recordId = recordId;
        } else {
            this.recordId = HelperUtils.generateId("MR");
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isNotNull(patientId)) {
            this.patientId = patientId;
        } else {
            this.patientId = "N/A";
        }
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isNotNull(doctorId)) {
            this.doctorId = doctorId;
        } else {
            this.doctorId = "N/A";
        }
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        if (HelperUtils.isNotNull(visitDate)) {
            this.visitDate = visitDate;
        } else {
            this.visitDate = LocalDate.now();
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (HelperUtils.isValidString(diagnosis)) {
            this.diagnosis = diagnosis;
        } else {
            this.diagnosis = "No diagnosis provided";
        }
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        if (HelperUtils.isValidString(prescription)) {
            this.prescription = prescription;
        } else {
            this.prescription = "No prescription";
        }
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        if (HelperUtils.isValidString(testResults)) {
            this.testResults = testResults;
        } else {
            this.testResults = "No test results";
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (HelperUtils.isValidString(notes)) {
            this.notes = notes;
        } else {
            this.notes = "No additional notes";
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Medical Record ID: " + (HelperUtils.isNotNull(recordId) ? recordId : "N/A") +
                        ", Patient ID: " + (HelperUtils.isNotNull(patientId) ? patientId : "N/A") +
                        ", Doctor ID: " + (HelperUtils.isNotNull(doctorId) ? doctorId : "N/A") +
                        ", Visit Date: " + (HelperUtils.isNotNull(visitDate) ? visitDate : "N/A") +
                        ", Diagnosis: " + (HelperUtils.isNotNull(diagnosis) ? diagnosis : "N/A")
        );
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId='" + (HelperUtils.isNotNull(recordId) ? recordId : "N/A") + '\'' +
                ", patientId='" + (HelperUtils.isNotNull(patientId) ? patientId : "N/A") + '\'' +
                ", doctorId='" + (HelperUtils.isNotNull(doctorId) ? doctorId : "N/A") + '\'' +
                ", visitDate=" + (HelperUtils.isNotNull(visitDate) ? visitDate : "N/A") +
                ", diagnosis='" + (HelperUtils.isNotNull(diagnosis) ? diagnosis : "N/A") + '\'' +
                ", prescription='" + (HelperUtils.isNotNull(prescription) ? prescription : "N/A") + '\'' +
                ", testResults='" + (HelperUtils.isNotNull(testResults) ? testResults : "N/A") + '\'' +
                ", notes='" + (HelperUtils.isNotNull(notes) ? notes : "N/A") + '\'' +
                '}';
    }
}