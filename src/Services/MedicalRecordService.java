package Services;

import Entities.MedicalRecord;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessege;
import interfaces.Manageable;
import interfaces.Searchable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService extends BaseService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    public static List<MedicalRecord> medicalRecords = new ArrayList<>();

    public void addMedicalRecords() {
        while (true) {
            MedicalRecord record = addMedicalRecord();
            if (HelperUtils.isNotNull(record)) {
                add(record);
                System.out.println("Medical Record added successfully.");
            }
            System.out.println("Press q to go back to menu or press Enter to add another record:");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                return;
            }
        }
    }

    public MedicalRecord addMedicalRecord() {
        System.out.println("========= Added New Medical Record =====");

        String recordId = HelperUtils.generateId("MR");
        System.out.println("Generated Record ID: " + recordId);

        MedicalRecord existRecord = getMedicalRecordById(recordId);
        if (HelperUtils.isNotNull(existRecord)) {
            System.out.println("Record ID already exists");
            return null;
        }

        String patientId = InputHandler.getStringInput("Enter Patient ID: ");
        if (!HelperUtils.isValidString(patientId)) {
            System.out.println("Invalid Patient ID.");
            return null;
        }

        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid Doctor ID.");
            return null;
        }

        LocalDate visitDate = InputHandler.getLocalDateInput("Enter Visit Date: ");
        if (HelperUtils.isNull(visitDate)) {
            System.out.println("Invalid visit date.");
            return null;
        }

        String diagnosis = InputHandler.getStringInput("Enter Diagnosis: ");
        if (!HelperUtils.isValidString(diagnosis)) {
            System.out.println("Diagnosis cannot be empty.");
            return null;
        }

        String testResults = InputHandler.getStringInput("Enter Test Results: ");
        String prescription = InputHandler.getStringInput("Enter Prescription: ");
        String notes = InputHandler.getStringInput("Enter Notes: ");

        MedicalRecord medicalRecord = new MedicalRecord(
                recordId, patientId, doctorId, visitDate,
                diagnosis, testResults, prescription, notes
        );
        return medicalRecord;
    }

    public MedicalRecord getMedicalRecordById(String recordId) {
        if (HelperUtils.isNull(recordId)) return null;
        for (MedicalRecord record : medicalRecords) {
            if (HelperUtils.isNotNull(record.getRecordId()) && record.getRecordId().equals(recordId)) {
                return record;
            }
        }
        return null;
    }

    public void editMedicalRecord(String recordId) {
        MedicalRecord record = getMedicalRecordById(recordId);
        if (HelperUtils.isNotNull(record)) {
            record.setDiagnosis(InputHandler.getStringInput("Enter Diagnosis: "));
            record.setPrescription(InputHandler.getStringInput("Enter Prescription: "));
            record.setTestResults(InputHandler.getStringInput("Enter Test Results: "));
            record.setNotes(InputHandler.getStringInput("Enter Notes: "));
            System.out.println("Medical Record updated successfully.");
        } else {
            System.out.println("Record Not Found");
        }
    }

    public void deleteMedicalRecord(String recordId) {
        MedicalRecord record = getMedicalRecordById(recordId);
        if (HelperUtils.isNotNull(record)) {
            medicalRecords.remove(record);
            System.out.println("Medical Record deleted successfully.");
        } else {
            System.out.println("Record Not Found");
        }
    }

    public List<MedicalRecord> getMedicalRecordsByPatientId(String patientId) {
        List<MedicalRecord> result = new ArrayList<>();
        if (HelperUtils.isNull(patientId)) return result;
        for (MedicalRecord record : medicalRecords) {
            if (HelperUtils.isNotNull(record.getPatientId()) && record.getPatientId().equals(patientId)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<MedicalRecord> getMedicalRecordsByDoctorId(String doctorId) {
        List<MedicalRecord> result = new ArrayList<>();
        if (HelperUtils.isNull(doctorId)) return result;
        for (MedicalRecord record : medicalRecords) {
            if (HelperUtils.isNotNull(record.getDoctorId()) && record.getDoctorId().equals(doctorId)) {
                result.add(record);
            }
        }
        return result;
    }

    public void displayPatientHistory(String patientId) {
        if (HelperUtils.isNull(patientId)) {
            System.out.println("Patient ID cannot be null.");
            return;
        }
        List<MedicalRecord> records = getMedicalRecordsByPatientId(patientId);
        if (records.isEmpty()) {
            System.out.println("No medical records found");
            return;
        }
        for (MedicalRecord record : records) {
            System.out.println(record);
        }
    }

    public void displayAllMedicalRecords() {
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records found.");
            return;
        }
        for (MedicalRecord record : medicalRecords) {
            System.out.println(record);
        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof MedicalRecord record) {
            if (HelperUtils.isNull(record.getRecordId())) {
                record.setRecordId(HelperUtils.generateId("MR"));
            }
            medicalRecords.add(record);
            System.out.println("Medical record added successfully");
        } else {
            System.out.println("Invalid entity type");
        }
    }

    @Override
    public void remove(String id) {
        MedicalRecord record = getMedicalRecordById(id);
        if (HelperUtils.isNotNull(record)) {
            medicalRecords.remove(record);
            System.out.println("Medical record removed successfully");
        } else {
            System.out.println("Record not found");
        }
    }

    @Override
    public void getAll() {
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records found");
            return;
        }
        displayAllMedicalRecords();
    }

    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(keyword)) return;
        boolean found = false;
        for (MedicalRecord record : medicalRecords) {
            if ((HelperUtils.isNotNull(record.getPatientId()) && record.getPatientId().equalsIgnoreCase(keyword)) ||
                    (HelperUtils.isNotNull(record.getDoctorId()) && record.getDoctorId().equalsIgnoreCase(keyword)) ||
                    (HelperUtils.isNotNull(record.getDiagnosis()) && record.getDiagnosis().equalsIgnoreCase(keyword))) {
                System.out.println(record);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No records found");
        }
    }

    @Override
    public void searchById(String id) {
        MedicalRecord record = getMedicalRecordById(id);
        if (HelperUtils.isNotNull(record)) {
            System.out.println(record);
        } else {
            System.out.println("Record not found");
        }
    }

    public void MedicalRecordHandler() {
        System.out.println("==== Medical Record Handler ===");
        int choice = InputHandler.getIntInput("Enter choice: ");
        switch (choice) {
            case 1 -> {
                addMedicalRecord();
                MedicalRecordHandler();
            }
            case 2 -> {
                displayAllMedicalRecords();
                MedicalRecordHandler();
            }
            case 3 -> {
                getMedicalRecordsByPatientId(InputHandler.getStringInput("Enter PatientId: "));
                MedicalRecordHandler();
            }
            case 4 -> {
                getMedicalRecordsByDoctorId(InputHandler.getStringInput("Enter DoctorId: "));
                MedicalRecordHandler();
            }
            case 5 -> {
                editMedicalRecord(InputHandler.getStringInput("Enter Medical Record ID: "));
                MedicalRecordHandler();
            }
            case 6 -> {
                deleteMedicalRecord(InputHandler.getStringInput("Enter Medical Record ID to delete: "));
                MedicalRecordHandler();
            }
            case 7 -> {
                displayPatientHistory(InputHandler.getStringInput("Enter PatientId: "));
                MedicalRecordHandler();
            }
            case 8 -> {
                System.out.println("Exiting from Medical Record Registration");
                return;
            }
            default -> System.out.println("Invalid choice");
        }
    }
}