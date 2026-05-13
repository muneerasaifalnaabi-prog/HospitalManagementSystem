package Services;

import Entities.Appointment;
import Utils.InputHandler;

import java.time.LocalDate;

public class ReportService {
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

}
