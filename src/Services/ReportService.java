package Services;

import Entities.Appointment;
import Utils.InputHandler;

import java.time.LocalDate;

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

    }
    public void DoctorPerformanceReport() {
        System.out.println("====Doctor Performance Report=====");
       String doctorId = InputHandler.getStringInput("Enter Doctor ID");
        int totalAppointment =0;
        int totalComplete =0;
        int cancelled =0;
        for (Appointment a :AppointmentService.appointments){
            if (a.getDoctorId().equals(doctorId)){
                totalAppointment++;
            }
            if (a.getStatus().equalsIgnoreCase("Completed")){
                totalComplete++;
            }
            if (a.getStatus().equalsIgnoreCase("Cancelled")){
                cancelled++;
            }
            System.out.println("Doctor :"+a.getDoctorId()+"/n Appointment :"+totalAppointment +"/n Complete :"+totalComplete +"/n cancelled :"+cancelled);
        }
    }

}
