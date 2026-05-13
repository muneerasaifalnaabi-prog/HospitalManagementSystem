package Services;

import Entities.Appointment;
import Utils.HelperUtils;
import Utils.MenuMessege;
import interfaces.Appointable;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService extends BaseService implements Manageable, Searchable , Appointable {
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
    //
    public Appointment addAppointment() {

        System.out.println("======= Add New Appointment =======");

        String appointmentId = HelperUtils.generateId("APP");

        System.out.println("Generated Appointment ID : " + appointmentId);

        Appointment existingAppointment = getAppointmentById(appointmentId);

        if (existingAppointment != null) {

            System.out.println("Appointment ID already exists");

            return null;
        }
        String patientId;

        while (true) {

            System.out.println("Enter Patient ID:");

            patientId = scanner.nextLine();

            if (HelperUtils.isValidString(patientId, 2)) {
                break;
            }

            System.out.println("Invalid Patient ID");
        }
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
        if (HelperUtils.isNull(appointmentId)) {
            return null;
        }
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
    public void rescheduleAppointments(String appointmentId,LocalDate date,String newTime) {
        Appointment existingAppointment = getAppointmentById(appointmentId);
        if (existingAppointment != null) {
            existingAppointment.reschedule(date,newTime);
        }
        else {
            System.out.println("Appointment Not Found");
        }
    }
    public void cancelAppointments(String appointmentId,LocalDate date,String newTime) {
        Appointment existingAppointment = getAppointmentById(appointmentId);
        if (existingAppointment != null) {
            existingAppointment.cancel();
        }
        else
            System.out.println("Appointment Not Found");
    }
    public void displayAppointments() {
        for (Appointment a : appointments) {
            System.out.println(a);
        }


    }
    public void createAppointment(String patientId, String doctorId, LocalDate date){
        System.out.println("===new Appointment ===");
        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
    }
    public void createAppointment(String patientId, String doctorId, LocalDate date, String time){
        System.out.println("===new Appointment ===");
        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);
    }
    public void createAppointment(Appointment appointment){
        System.out.println("===new Appointment ===");
        appointments.add(appointment);
    }

    @Override
    public void scheduleAppointment(Appointment appointment) {
        if (appointment ==null){
            System.out.println("Invalid appointment");
            return;
        }
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully");

    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        if (appointment ==null){
            System.out.println("appointment not found");
            return;
        }
        appointment.setStatus("Cancelled");
        System.out.println("Appointment cancelled successfully");

    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate){
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setAppointmentDate(newDate);
                System.out.println("Appointment Updated Successfully to"+newDate);
                return;
            }
        }
        System.out.println("Appointment not found with ID: " + appointmentId);
    }
    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime){
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                System.out.println("Appointment Updated Successfully to"+newDate+" time :"+newTime);
                return;
            }
        }
        System.out.println("Appointment not found with ID: " + appointmentId);
    }
    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason){
       appointments.add(appointment);
       appointment.setAppointmentDate(newDate);
       appointment.setAppointmentTime(newTime);
       appointment.setReason(reason);
    }
    public void displayAppointments(LocalDate date){
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate){
        for (Appointment a : appointments) {
            if (a.getDoctorId().equals(doctorId)) {
                System.out.println(a);

            }
        }

    }


    //i will see later :
    public void handleAppointmentService(){
        System.out.println("====Appointment service ====");
        System.out.println(MenuMessege.APPOINTMENT_MENU_MESSEGE);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1->{
                    addAppointment();
                }
                case 2->{
                    System.out.println("Enter Appointment ID ");
                    String appointmentId = scanner.nextLine();
                    editAppointment(appointmentId);
                }
                case 3->{
                    System.out.println("Enter Appointment ID ");
                    String appointmentId = scanner.nextLine();
                    deleteAppointment(appointmentId);

                }
                case 4->{

                }
            }

        }
    }

    @Override
    public void add(Object entity) {
        if (entity instanceof Appointment appointment){
            appointments.add(appointment);
            System.out.println("Appointment added successfully");
        }
        else {
            System.out.println("Invalid entity type");
        }

    }

    @Override
    public void remove(String id) {
        Appointment appointment = getAppointmentById(id);

        if (appointment !=null){
            appointments.remove(appointment);
            System.out.println("Appointment removed successfully");
        }
        else {
            System.out.println("Appointment not found");
        }

    }

    @Override
    public void getAll() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println(a);
        }

    }

    @Override
    public void search(String keyword) {
        boolean found =false;
        for (Appointment a :appointments){
            if (a.getPatientId().equalsIgnoreCase(keyword)
                    || a.getDoctorId().equalsIgnoreCase(keyword)
                    || a.getStatus().equalsIgnoreCase(keyword)
            ){
                System.out.println(a);
                found =true;
            }
        }
        if (!found){
            System.out.println("No matching appointments found");
        }

    }

    @Override
    public void searchById(String id) {
        Appointment appointment =getAppointmentById(id);

        if (appointment != null){
            System.out.println(appointment);
        }
        else{
            System.out.println("Appointment not found");
        }

    }
}
