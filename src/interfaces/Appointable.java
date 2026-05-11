package interfaces;

import Entities.Appointment;

import java.time.LocalDate;

public interface Appointable {
    public void scheduleAppointment(Appointment appointment);
    public void cancelAppointment(Appointment appointment);
    public void rescheduleAppointment(String appointmentId, LocalDate newDate);



}
