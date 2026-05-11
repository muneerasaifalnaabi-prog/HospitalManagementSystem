package Services;

import Entities.MedicalRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService {
    static Scanner scanner = new Scanner(System.in);
    static List<MedicalRecord> medicalRecords = new ArrayList<>();

    public void addMedicalRecords() {

        while (true) {

            MedicalRecord record = addMedicalRecord();

            if (record != null) {
                medicalRecords.add(record);
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

        System.out.println("Enter Record ID:");
        String recordId = scanner.nextLine();

        MedicalRecord existRecord = getMedicalRecordById(recordId);

        if (existRecord != null) {
            System.out.println("Record ID already exists");
            return null;
        }

        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor ID:");
        String doctorId = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate visitDate = null;
        boolean valid = false;

        while (!valid) {

            System.out.print("Enter Visit Date (dd-MM-yyyy): ");
            String input = scanner.nextLine();

            try {
                visitDate = LocalDate.parse(input, formatter);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format or value. Please try again.");
            }
        }

        System.out.println("Enter Diagnosis:");
        String diagnosis = scanner.nextLine();

        System.out.println("Enter Test Results:");
        String testResults = scanner.nextLine();

        System.out.println("Enter Prescription:");
        String prescription = scanner.nextLine();

        System.out.println("Enter Notes:");
        String notes = scanner.nextLine();

        MedicalRecord medicalRecord = new MedicalRecord(
                recordId,
                patientId,
                doctorId,
                visitDate,
                diagnosis,
                testResults,
                prescription,
                notes
        );

        return medicalRecord;
    }

    public MedicalRecord getMedicalRecordById(String recordId) {

        for (MedicalRecord record : medicalRecords) {

            if (record.getRecordId().equals(recordId)) {
                return record;
            }
        }

        return null;
    }
    public void editMedicalRecord(MedicalRecord record) {
        MedicalRecord editedRecord = getMedicalRecordById(record.getRecordId());
        if (editedRecord != null) {
            System.out.println("Enter new Diagnosis:");
            String diagnosis = scanner.nextLine();
            record.setDiagnosis(diagnosis);
            System.out.println("Enter new Prescription:");
            String prescription = scanner.nextLine();
            record.setPrescription(prescription);
            System.out.println("Enter New Test Results:");
            String testResults = scanner.nextLine();
            record.setTestResults(testResults);

            System.out.println("Enter new Notes");
            String notes = scanner.nextLine();
            record.setNotes(notes);

            System.out.println("Medical Record added successfully.");
        }
        else  {
            System.out.println("Record Not Found");
        }
    }
    public void deleteMedicalRecord(String recordId) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordId().equals(recordId)) {
                medicalRecords.remove(record);
                System.out.println("Medical Record deleted successfully.");
            }
            else  {
                System.out.println("Record Not Found");
            }
        }
    }
    public List<MedicalRecord> getMedicalRecordsByPatientId(String patientId) {
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        for (MedicalRecord record : medicalRecords) {
            if (record.getPatientId().equals(patientId)) {
                medicalRecords.add(record);
                System.out.println("Medical Record added successfully.");
            }
        }
        return medicalRecords;

    }
    public List<MedicalRecord> getMedicalRecordsByDoctorId(String doctorId) {
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        for (MedicalRecord record : medicalRecords) {
            if (record.getDoctorId().equals(doctorId)) {
                medicalRecords.add(record);
                System.out.println("Medical Record added successfully.");
            }
        }
        return medicalRecords;
    }
    public void displayPatientHistory(String patientId) {
        List<MedicalRecord> medicalRecords = getMedicalRecordsByPatientId(patientId);
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records found");
            return;
        }
        for (MedicalRecord record : medicalRecords) {
            for (MedicalRecord medicalRecord : medicalRecords) {
                System.out.println(medicalRecords);
            }
        }
    }
    public void displayAllMedicalRecords() {
        for (MedicalRecord record : medicalRecords) {
            System.out.println(record);
        }
    }

}
