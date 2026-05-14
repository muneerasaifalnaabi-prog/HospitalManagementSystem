package Services;

import Entities.Appointment;
import Entities.Department;
import Utils.HelperUtils;
import Utils.InputHandler;
import Utils.MenuMessege;
import interfaces.Appointable;
import interfaces.Manageable;
import interfaces.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService extends BaseService implements Manageable, Searchable , Appointable {
    static Scanner scanner = new Scanner(System.in);
    public static List<Appointment> appointments = new ArrayList<>();

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
        String doctorId = InputHandler.getStringInput("Doctor ID");
        LocalDate appointmentDate = InputHandler.getLocalDateInput("Date of Appointment");
        String appointmentTime = InputHandler.getStringInput("Time of Appointment");
        String status = InputHandler.getStringInput("Status");
        String reason = InputHandler.getStringInput("Reason");
        String notes =InputHandler.getStringInput("Notes");

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

            if (a.getAppointmentId() != null && a.getAppointmentId().equals(appointmentId)) {

                return a;
            }
        }

        return null;
    }
    public void editAppointment(String appointment) {
        Appointment existingAppointment = getAppointmentById(appointment);

        if (HelperUtils.isNull(existingAppointment)) {
            System.out.println("Appointment Not Found");
            return;
        }
        String newAppointmentTime = InputHandler.getStringInput("Enter new Time of Appointment");
        if (HelperUtils.isValidString(newAppointmentTime)) {
            existingAppointment.setAppointmentTime(newAppointmentTime);
        }
        String newStatus = InputHandler.getStringInput("Enter new Status of Appointment");
        if (HelperUtils.isValidString(newStatus)) {
            existingAppointment.setStatus(newStatus);
        }
        String newReason = InputHandler.getStringInput("Enter new Reason of Appointment");
        if (HelperUtils.isValidString(newReason)) {
            existingAppointment.setReason(newReason);
        }
        String newNotes = InputHandler.getStringInput("Enter new Notes of Appointment");
        existingAppointment.setNotes(newNotes);

        System.out.println("Appointment Edited Successfully");
    }
    public void deleteAppointment(String appointmentId) {
        Appointment existingAppointment = getAppointmentById(appointmentId);

        if (HelperUtils.isNotNull(existingAppointment)) {

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
            if (a.getPatientId() != null && a.getPatientId().equals(patient)) {
                appointmentList.add(a);
            }
        }
        return appointmentList;
    }
    public List<Appointment> getAppointmentsByDoctor(String doctor) {
        List<Appointment> appointmentList = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getDoctorId() != null && a.getDoctorId().equals(doctor)) {
                appointmentList.add(a);
            }
        }
        return appointmentList;
    }
    public List<Appointment> getAppointmentsByDate(LocalDate date){
        List<Appointment> appointmentList = new ArrayList<>();

        if (HelperUtils.isNull(date)) {
            return appointmentList;
        }

        for (Appointment a : appointments) {

            if (a.getAppointmentDate() != null && a.getAppointmentDate().equals(date)) {

                appointmentList.add(a);
            }
        }

        return appointmentList;
    }

    public void rescheduleAppointments(String appointmentId,LocalDate date,String newTime) {
        Appointment existingAppointment = getAppointmentById(appointmentId);

        if (HelperUtils.isNotNull(existingAppointment)) {
            existingAppointment.reschedule(date, newTime);
        }
        else {
            System.out.println("Appointment Not Found");
        }
    }
    public void cancelAppointments(String appointmentId,LocalDate date,String newTime) {
        Appointment existingAppointment = getAppointmentById(appointmentId);
        if (HelperUtils.isNotNull(existingAppointment)) {
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
    public void createAppointment(Appointment appointment) {
        if (HelperUtils.isNotNull(appointment) &&
                HelperUtils.isNotNull(appointment.getDoctorId()) &&
                HelperUtils.isNotNull(appointment.getPatientId())) {
            appointments.add(appointment);
            System.out.println("Appointment added.");
        } else {
            System.out.println("Invalid appointment - missing doctor or patient ID.");
        }
    }

    @Override
    public void scheduleAppointment(Appointment appointment) {
        if (HelperUtils.isNull(appointment)) {
            System.out.println("Invalid appointment");
            return;
        }
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully");

    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        if (HelperUtils.isNull(appointment)) {
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
            if (a.getAppointmentDate() != null && a.getAppointmentDate().equals(date)) {
                System.out.println(a);
            }
        }
    }
    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate){
        for (Appointment a : appointments) {
            if (a.getDoctorId() != null && a.getDoctorId().equals(doctorId) &&
                    !a.getAppointmentDate().isBefore(startDate) &&
                    !a.getAppointmentDate().isAfter(endDate)) {
                System.out.println(a);
            }
        }
    }
    public void displayAppointmentsByPatient(){
        String patientId =InputHandler.getStringInput("Enter Patient ID");
        List<Appointment> patientAppo =getAppointmentsByPatient(patientId);
        if (HelperUtils.isNotNull(patientAppo)) {
            for (Appointment a : patientAppo) {
                System.out.println(a);
            }
        }
    }
    public void displayAppointmentsByDate(){
        LocalDate date = InputHandler.getLocalDateInput("Enter Date");
        List<Appointment> patientAppo = getAppointmentsByDate(date);
        if (HelperUtils.isNotNull(patientAppo)) {
            for (Appointment a : patientAppo) {
                System.out.println(a);
            }
        }
    }
    public void displayAppointmentsByDoctor(){
        String doctorId =InputHandler.getStringInput("Enter Doctor ID");
        List<Appointment> doctorAppo =getAppointmentsByDoctor(doctorId);
        if (HelperUtils.isNotNull(doctorAppo)) {
            for (Appointment a : doctorAppo) {
                System.out.println(a);
            }
        }
    }
    public void upcomingAppointment(){
        LocalDate date = LocalDate.now();
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().isAfter(date) || a.getAppointmentDate().equals(date)) {
                System.out.println(a);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No upcoming appointment");
        }
    }

    public void handleAppointmentService(){
        System.out.println("====Appointment service ====");
        int choice = InputHandler.getIntInput("Enter choice");
        switch (choice) {
            case 1->{
                Appointment appointment = addAppointment();
                scheduleAppointment(appointment);
                handleAppointmentService();
            }
            case 2->{
                displayAppointments();
                handleAppointmentService();
            }
            case 3->{
                displayAppointmentsByPatient();
                handleAppointmentService();

            }
            case 4->{
                displayAppointmentsByDoctor();
                handleAppointmentService();
            }
            case 5->{
                displayAppointmentsByDate();
                handleAppointmentService();
            }
            case 6->{
                rescheduleAppointment(InputHandler.getStringInput("Enter appointment Id"),InputHandler.getLocalDateInput("Enter New Date"));
                handleAppointmentService();
            }
            case 7->{
                Appointment appointment = appointments.get(InputHandler.getIntInput("Enter appointment Id"));
                cancelAppointment(appointment);
                handleAppointmentService();
            }
            case 8->{
                Appointment appointment = new Appointment();
                appointment.cancel();
                appointments.add(appointment);
                handleAppointmentService();
            }
            case 9->{
                upcomingAppointment();
                handleAppointmentService();

            }
            case 10 ->{
                System.out.println("Extitng from Appointment Service ...");
                return;
            }
            default -> System.out.println("Invalid choice");
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

        if (HelperUtils.isNotNull(appointment)){
            System.out.println(appointment);
        }
        else{
            System.out.println("Appointment not found");
        }

    }

    }
