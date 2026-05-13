package Services;

import Entities.Appointment;
import Entities.Department;
import Entities.Doctor;
import Entities.MedicalRecord;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.List;

public class ReportService {
    AppointmentService appointmentService = new AppointmentService();
    DoctorService doctorService = new DoctorService();
    DepartmentService departmentService = new DepartmentService();
    MedicalRecordService medicalRecordService = new MedicalRecordService();
    public void DailyAppointmentsReport() {
        System.out.println("====Daily Appointments Report=====");
        LocalDate localDate = InputHandler.getLocalDateInput("Enter Daily Appointment Date");
        boolean found = false;
       for (Appointment a :AppointmentService.appointments){
           if (a.getAppointmentDate().equals(localDate)){
               System.out.println("Appointment Information in Details");
               a.displayInfo();
               System.out.println("Summary of Appointment Information ");
               a.displaySummary();
               found = true;
           }
       }
       if (!found){
           System.out.println("Appointment Not Found");
       }
        int totalAppointment =0;
        int totalComplete =0;
        int cancelled =0;
        for (Appointment a :AppointmentService.appointments){
            System.out.println(a);
                totalAppointment++;
            if (a.getStatus().equalsIgnoreCase("Cancelled")){
                cancelled++;
            }
            System.out.println("Appointment :"+a.getAppointmentId()+"/n Appointment :"+totalAppointment +"/n Complete :"+totalComplete +"/n cancelled :"+cancelled);
        }

    }
    public void DoctorPerformanceReport() {
        System.out.println("====Doctor Performance Report=====");
       String doctorId = InputHandler.getStringInput("Enter Doctor ID");
       Doctor doctor = doctorService.getDoctorById(doctorId);
       if (HelperUtils.isNotNull(doctor)){
           System.out.println("Doctor Information in Details");
           List<Appointment> doctorAppointments = appointmentService.getAppointmentsByDoctor(doctorId);
           List<MedicalRecord> records =medicalRecordService.getMedicalRecordsByDoctorId(doctorId);
           int completed =0;
           for (Appointment a :doctorAppointments){
               if (a.getStatus().equalsIgnoreCase("Completed")){
                   completed++;
               }
           }
           System.out.println("Doctor name :" + doctor.getFirstName() + " " + doctor.getLastName() );
           System.out.println("Specialization  :" + doctor.getSpecialization());
           System.out.println("Total Appointment :" + doctorAppointments.size());
           System.out.println("Total Complete :" + completed);
           System.out.println("Medical Records Created :" + records.size());
           System.out.println("Assigned Patients :"+ doctor.getAssignedPatients());
       }
    }
    public void departmentOccupancyReport() {
        System.out.println("====Department Occupancy Report=====");
        if (DepartmentService.departments.isEmpty()) {
            System.out.println("Department Not Found");
            return;
        }
        for (Department department :DepartmentService.departments){
            int occupiedBeds = department.getBedCapacity() - department.getAvailableBeds();
            System.out.println("Department Occupancy Information in Details");
            department.displayInfo();
            System.out.println("Summary of Department Occupancy Information ");
            department.displaySummary();
            System.out.println("Bed Capacity :" + department.getBedCapacity());
            System.out.println("Available Bed Capacity :" + department.getAvailableBeds());
            System.out.println("Total Bed Capacity :" + department.getBedCapacity());
        }
    }
    public void patientStatisticsReport() {
        System.out.println("====Patient Statistics Report=====");
        int totalAppointments =AppointmentService.appointments.size();
        int totalMedicalRecords =medicalRecordService.medicalRecords.size();
        for (Appointment a :AppointmentService.appointments){
            System.out.println("Total Patient :" +a.getPatientId());
            System.out.println("Total Appointment :" +totalAppointments);
            System.out.println("Total Medical Records :" +totalMedicalRecords);
        }
    }
    public void emergencyPatientsReport() {
        System.out.println("====Emergency Patients Report=====");
    }

}
