package Services;

import Entities.Appointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
    static Scanner scanner = new Scanner(System.in);
    static List<Appointment> appointments = new ArrayList<>();
    public void addAppointments() {

        while (true) {

            Appointment appointment = addAppointment();

            if (appointment != null) {

                appointments.add(appointment);

                System.out.println("Appointment Added Successfully");
            }

            System.out.println("Press q to quit");

            if (scanner.nextLine().equalsIgnoreCase("q")) {
                return;
            }
        }
    }

    public Appointment addAppointment() {

        System.out.println("======= Add New Appointment =======");

        System.out.println("Enter Appointment ID:");
        String appointmentId = scanner.nextLine();

        Appointment existingAppointment = getAppointmentById(appointmentId);

        if (existingAppointment != null) {

            System.out.println("Appointment ID already exists");

            return null;
        }

        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();

        System.out.println("Enter Doctor ID:");
        String doctorId = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate appointmentDate = null;

        boolean valid = false;

        while (!valid) {

            System.out.println("Enter Appointment Date (dd-MM-yyyy):");

            String input = scanner.nextLine();

            try {

                appointmentDate = LocalDate.parse(input, formatter);

                valid = true;

            } catch (DateTimeParseException e) {

                System.out.println("Invalid Date Format");
            }
        }

        System.out.println("Enter Appointment Time:");
        String appointmentTime = scanner.nextLine();

        System.out.println("Enter Status:");
        String status = scanner.nextLine();

        System.out.println("Enter Reason:");
        String reason = scanner.nextLine();

        System.out.println("Enter Notes:");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment(
                patientId,
                appointmentId,
                doctorId,
                appointmentDate,
                appointmentTime,
                status,
                reason,
                notes
        );

        return appointment;
    }

    public Appointment getAppointmentById(String appointmentId) {

        for (Appointment a : appointments) {

            if (a.getAppointmentId().equals(appointmentId)) {

                return a;
            }
        }

        return null;
    }
    public void editAppointment(String appointment) {
        Appointment existingAppointment = getAppointmentById(appointment);
        if (existingAppointment != null) {
            System.out.println("Enter new Appointment Time (dd-MM-yyyy):");
            String newAppointmentTime = scanner.nextLine();
            existingAppointment.setAppointmentTime(newAppointmentTime);

            System.out.println("Enter new Status:");
            String newStatus = scanner.nextLine();
            existingAppointment.setStatus(newStatus);
            System.out.println("Enter new Reason:");
            String newReason = scanner.nextLine();
            existingAppointment.setReason(newReason);
            System.out.println("Enter new Notes:");
            String newNotes = scanner.nextLine();
            existingAppointment.setNotes(newNotes);
            System.out.println("Appointment Edited Successfully");
        }
        else  {
            System.out.println("Appointment Not Found");
        }
    }
    public void deleteAppointment(String appointmentId) {
        Appointment existingAppointment = getAppointmentById(appointmentId);
        if (existingAppointment != null) {
            appointments.remove(existingAppointment);
            System.out.println("Appointment Deleted Successfully");
        }
        else {
            System.out.println("Appointment Not Found");

        }
    }
    public List<Appointment> getAppointmentsByPatient(String patient) {
        List<Appointment> appointmentList = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatientId().equals(patient)) {
                appointmentList.add(a);
            }
        }
        return appointmentList;
    }
    public List<Appointment> getAppointmentsByDoctor(String doctor) {
        List<Appointment> appointmentList = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getDoctorId().equals(doctor)) {
                appointmentList.add(a);
            }
        }
        return appointmentList;
    }
    public List<Appointment> getAppointmentsByDate(LocalDate date){
        List<Appointment> appointmentList = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(date)) {
                appointmentList.add(a);
            }
        }
        return appointmentList;
    }
    public List<Appointment> rescheduleAppointments(String appointmentId,LocalDate date,String newTime) {
        List<Appointment> appointmentList = new ArrayList<>();
        if (appointmentId != null) {
            appointmentList.reschedule(newDate, newTime);
        }
    }


}
