import java.time.LocalDate;
enum STATUSE{
    Scheduled,
    Completed,
    Cancelled,
    Rescheduled
}
public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private STATUSE status;
    private String reason;
    private String notes;

}
