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
        boolean found = false;
        int totalAppointment = 0;
        int totalCompleted = 0;
        int totalCancelled = 0;

        for (Appointment a : AppointmentService.appointments) { // Direct access
            if (a.getAppointmentDate() != null && a.getAppointmentDate().equals(localDate)) {
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
            totalAppointment++;
            if (a.getStatus() != null) {
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
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (HelperUtils.isNull(doctor)) {
            System.out.println("Doctor not found.");
            return;
        }

        List<Appointment> doctorAppointments = appointmentService.getAppointmentsByDoctor(doctorId);
        List<MedicalRecord> records = medicalRecordService.getMedicalRecordsByDoctorId(doctorId);
        int completed = 0;
        for (Appointment a : doctorAppointments) {
            if (a.getStatus() != null && a.getStatus().equalsIgnoreCase("Completed")) {
                completed++;
            }
        }

        System.out.println("\n--- Doctor Details ---");
        doctor.displayInfo();
        System.out.println("\n--- Performance Summary ---");
        System.out.println("Total Appointments: " + doctorAppointments.size());
        System.out.println("Completed Appointments: " + completed);
        System.out.println("Medical Records Created: " + records.size());
        System.out.println("Assigned Patients: " + (doctor.getAssignedPatients() != null ? doctor.getAssignedPatients().size() : 0));
    }

    public void departmentOccupancyReport() {
        System.out.println("==== Department Occupancy Report ====");
        if (DepartmentService.departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        for (Department department : DepartmentService.departments) {
            int occupiedBeds = department.getBedCapacity() - department.getAvailableBeds();
            System.out.println("\n--- Department: " + department.getDepartmentName() + " ---");
            department.displaySummary();
            System.out.println("Bed Capacity: " + department.getBedCapacity());
            System.out.println("Available Beds: " + department.getAvailableBeds());
            System.out.println("Occupied Beds: " + occupiedBeds);
            System.out.println("Occupancy Rate: " + (department.getBedCapacity() > 0 ?
                    (occupiedBeds * 100 / department.getBedCapacity()) : 0) + "%");
            System.out.println("-----------------------------------");
        }
    }

    public void patientStatisticsReport() {
        System.out.println("==== Patient Statistics Report ====");
        int totalAppointments = AppointmentService.appointments.size();
        int totalMedicalRecords = MedicalRecordService.medicalRecords.size();
        int uniquePatients = (int) AppointmentService.appointments.stream()
                .map(Appointment::getPatientId)
                .distinct()
                .count();

        System.out.println("Total Appointments: " + totalAppointments);
        System.out.println("Total Medical Records: " + totalMedicalRecords);
        System.out.println("Unique Patients with Appointments: " + uniquePatients);
        System.out.println("\nDetailed Patient List (from appointments):");
        AppointmentService.appointments.stream()
                .map(Appointment::getPatientId)
                .distinct()
                .forEach(pid -> System.out.println("  - Patient ID: " + pid));
    }

    public void emergencyPatientsReport() {
        System.out.println("==== Emergency Patients Report ====");
        boolean found = false;
        for (Appointment a : AppointmentService.appointments) {
            if (a.getReason() != null && a.getReason().equalsIgnoreCase("Emergency")) {
                if (!found) {
                    System.out.println("\n--- Emergency Appointments ---");
                    found = true;
                }
                System.out.println("Appointment ID: " + a.getAppointmentId());
                System.out.println("Patient ID: " + a.getPatientId());
                System.out.println("Doctor ID: " + a.getDoctorId());
                System.out.println("Date: " + a.getAppointmentDate());
                System.out.println("Status: " + a.getStatus());
                System.out.println("Reason: " + a.getReason());
                System.out.println("Notes: " + a.getNotes());
                System.out.println("-----------------------------------");
            }
        }
        if (!found) {
            System.out.println("No emergency patient cases found.");
        }
    }

    public void ReportHandler() {
        System.out.println("==== Report Handler ====");
        System.out.println(MenuMessege.REPORT_MENU_MESSEGE);
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
            default -> {
                System.out.println("Invalid choice. Please try again.");
                ReportHandler();
            }
        }
    }
}