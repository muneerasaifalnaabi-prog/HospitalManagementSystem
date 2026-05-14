package Services;

import Entities.Appointment;
import Entities.Department;
import Entities.Doctor;
import Entities.MedicalRecord;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessege;

import java.time.LocalDate;
import java.util.List;

public class ReportService {
    AppointmentService appointmentService = new AppointmentService();
    DoctorService doctorService = new DoctorService();
    MedicalRecordService medicalRecordService = new MedicalRecordService();

    public void DailyAppointmentsReport() {
        System.out.println("==== Daily Appointments Report ====");
        LocalDate localDate = InputHandler.getLocalDateInput("Enter Appointment Date: ");
        if (HelperUtils.isNull(localDate)) {
            System.out.println("Invalid date.");
            return;
        }

        boolean found = false;
        int totalAppointment = 0;
        int totalCompleted = 0;
        int totalCancelled = 0;

        for (Appointment a : AppointmentService.appointments) {
            totalAppointment++;
            if (HelperUtils.isNotNull(a.getAppointmentDate()) && a.getAppointmentDate().equals(localDate)) {
                if (!found) {
                    System.out.println("\n--- Appointments for " + localDate + " ---");
                    found = true;
                }
                System.out.println("Appointment Information:");
                a.displayInfo();
                System.out.println("Summary:");
                a.displaySummary();
                System.out.println("-----------------------------------");
            }
            if (HelperUtils.isNotNull(a.getStatus())) {
                if (a.getStatus().equalsIgnoreCase("Completed")) totalCompleted++;
                if (a.getStatus().equalsIgnoreCase("Cancelled")) totalCancelled++;
            }
        }

        if (!found) {
            System.out.println("No appointments found for date: " + localDate);
        } else {
            System.out.println("\n--- Summary for " + localDate + " ---");
            System.out.println("Total Appointments (all dates): " + totalAppointment);
            System.out.println("Completed (all dates): " + totalCompleted);
            System.out.println("Cancelled (all dates): " + totalCancelled);
        }
    }

    public void DoctorPerformanceReport() {
        System.out.println("==== Doctor Performance Report ====");
        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid Doctor ID.");
            return;
        }

        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (HelperUtils.isNull(doctor)) {
            System.out.println("Doctor not found.");
            return;
        }

        List<Appointment> doctorAppointments = appointmentService.getAppointmentsByDoctor(doctorId);
        List<MedicalRecord> records = medicalRecordService.getMedicalRecordsByDoctorId(doctorId);

        int completed = 0;
        for (Appointment a : doctorAppointments) {
            if (HelperUtils.isNotNull(a.getStatus()) && a.getStatus().equalsIgnoreCase("Completed")) {
                completed++;
            }
        }

        System.out.println("\n--- Doctor Details ---");
        doctor.displayInfo();
        System.out.println("\n--- Performance Summary ---");
        System.out.println("Total Appointments: " + (HelperUtils.isNotNull(doctorAppointments) ? doctorAppointments.size() : 0));
        System.out.println("Completed Appointments: " + completed);
        System.out.println("Medical Records Created: " + (HelperUtils.isNotNull(records) ? records.size() : 0));
        System.out.println("Assigned Patients: " + (HelperUtils.isNotNull(doctor.getAssignedPatients()) ? doctor.getAssignedPatients().size() : 0));
    }

    public void departmentOccupancyReport() {
        System.out.println("==== Department Occupancy Report ====");
        if (DepartmentService.departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        for (Department department : DepartmentService.departments) {
            if (HelperUtils.isNull(department)) continue;
            int bedCapacity = department.getBedCapacity();
            int availableBeds = department.getAvailableBeds();
            int occupiedBeds = bedCapacity - availableBeds;
            System.out.println("\n--- Department: " + (HelperUtils.isNotNull(department.getDepartmentName()) ? department.getDepartmentName() : "N/A") + " ---");
            department.displaySummary();
            System.out.println("Bed Capacity: " + bedCapacity);
            System.out.println("Available Beds: " + availableBeds);
            System.out.println("Occupied Beds: " + occupiedBeds);
            System.out.println("Occupancy Rate: " + (bedCapacity > 0 ? (occupiedBeds * 100 / bedCapacity) : 0) + "%");
            System.out.println("-----------------------------------");
        }
    }

    public void patientStatisticsReport() {
        System.out.println("==== Patient Statistics Report ====");
        int totalAppointments = AppointmentService.appointments.size();
        int totalMedicalRecords = MedicalRecordService.medicalRecords.size();

        long uniquePatients = AppointmentService.appointments.stream()
                .filter(a -> HelperUtils.isNotNull(a.getPatientId()))
                .map(Appointment::getPatientId)
                .distinct()
                .count();

        System.out.println("Total Appointments: " + totalAppointments);
        System.out.println("Total Medical Records: " + totalMedicalRecords);
        System.out.println("Unique Patients with Appointments: " + uniquePatients);
        System.out.println("\nDetailed Patient List (from appointments):");
        AppointmentService.appointments.stream()
                .filter(a -> HelperUtils.isNotNull(a.getPatientId()))
                .map(Appointment::getPatientId)
                .distinct()
                .forEach(pid -> System.out.println("  - Patient ID: " + pid));
    }

    public void emergencyPatientsReport() {
        System.out.println("==== Emergency Patients Report ====");
        boolean found = false;
        for (Appointment a : AppointmentService.appointments) {
            if (HelperUtils.isNotNull(a.getReason()) && a.getReason().equalsIgnoreCase("Emergency")) {
                if (!found) {
                    System.out.println("\n--- Emergency Appointments ---");
                    found = true;
                }
                System.out.println("Appointment ID: " + (HelperUtils.isNotNull(a.getAppointmentId()) ? a.getAppointmentId() : "N/A"));
                System.out.println("Patient ID: " + (HelperUtils.isNotNull(a.getPatientId()) ? a.getPatientId() : "N/A"));
                System.out.println("Doctor ID: " + (HelperUtils.isNotNull(a.getDoctorId()) ? a.getDoctorId() : "N/A"));
                System.out.println("Date: " + (HelperUtils.isNotNull(a.getAppointmentDate()) ? a.getAppointmentDate() : "N/A"));
                System.out.println("Status: " + (HelperUtils.isNotNull(a.getStatus()) ? a.getStatus() : "N/A"));
                System.out.println("Reason: " + (HelperUtils.isNotNull(a.getReason()) ? a.getReason() : "N/A"));
                System.out.println("Notes: " + (HelperUtils.isNotNull(a.getNotes()) ? a.getNotes() : "N/A"));
                System.out.println("-----------------------------------");
            }
        }
        if (!found) {
            System.out.println("No emergency patient cases found.");
        }
    }

    public void ReportHandler() {
        System.out.println("==== Report Handler ====");
        int choice = InputHandler.getIntInput("Enter choice: ");

        switch (choice) {
            case 1 -> {
                DailyAppointmentsReport();
                ReportHandler();
            }
            case 2 -> {
                DoctorPerformanceReport();
                ReportHandler();
            }
            case 3 -> {
                departmentOccupancyReport();
                ReportHandler();
            }
            case 4 -> {
                patientStatisticsReport();
                ReportHandler();
            }
            case 5 -> {
                emergencyPatientsReport();
                ReportHandler();
            }
            case 6 -> {
                System.out.println("Exiting from Report");
                return;
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                ReportHandler();
            }
        }
    }
}