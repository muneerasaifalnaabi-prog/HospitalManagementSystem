package Services;

import Entities.MedicalRecord;
import Utils.HelperUtils;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService extends BaseService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    static List<MedicalRecord> medicalRecords = new ArrayList<>();

    public void addMedicalRecords() {
        while (true) {
            MedicalRecord record = addMedicalRecord();
            if (HelperUtils.isNotNull(record)) {
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

        String recordId = HelperUtils.generateId("MR");

        System.out.println("Generated Record ID: " + recordId);

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
    public void editMedicalRecord(String recordId) {

        MedicalRecord record = getMedicalRecordById(recordId);

        if (HelperUtils.isNotNull(record)) {

            System.out.println("Enter new Diagnosis:");
            record.setDiagnosis(scanner.nextLine());

            System.out.println("Enter new Prescription:");
            record.setPrescription(scanner.nextLine());

            System.out.println("Enter new Test Results:");
            record.setTestResults(scanner.nextLine());

            System.out.println("Enter new Notes:");
            record.setNotes(scanner.nextLine());

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

        for (MedicalRecord record : medicalRecords) {

            if (record.getPatientId().equals(patientId)) {
                result.add(record);
            }
        }

        return result;
    }
    public List<MedicalRecord> getMedicalRecordsByDoctorId(String doctorId) {

        List<MedicalRecord> result = new ArrayList<>();

        for (MedicalRecord record : medicalRecords) {

            if (record.getDoctorId().equals(doctorId)) {
                result.add(record);
            }
        }

        return result;
    }
    public void displayPatientHistory(String patientId) {

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
        for (MedicalRecord record : medicalRecords) {
            System.out.println(record);
        }
    }


    @Override
    public void add(Object entity) {

        if (entity instanceof MedicalRecord record) {
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

        for (MedicalRecord record : medicalRecords) {
            System.out.println(record);
        }
    }
    @Override
    public void search(String keyword) {

        boolean found = false;

        for (MedicalRecord record : medicalRecords) {

            if (record.getPatientId().equalsIgnoreCase(keyword)
                    || record.getDoctorId().equalsIgnoreCase(keyword)
                    || record.getDiagnosis().equalsIgnoreCase(keyword)) {

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
}
