package Entities;

import Utiles.Constants;

import java.time.LocalDate;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String  status;
    private String reason;
    private String notes;
public  Appointment(){

}
    public Appointment(String patientId, String appointmentId, String doctorId, LocalDate appointmentDate, String appointmentTime, String status, String reason, String notes) {
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.notes = notes;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void  reschedule(LocalDate newDate, String newTime){
        if (status.equals("Completed") || status.equals("Cancelled")){
            System.out.println(Constants.NOT_RESCHEDULE);
        }
        this.appointmentDate=newDate;
        this.appointmentTime=newTime;
        this.status="Rescheduled";
        System.out.println(
                Constants.RESCHEDULE_SUCCESSFULLY +"new Date:" +newDate + "Time :"+ newTime);

    }
    public void  cancel(){
        if (!status.equals("Completed")){
            this.status="Cancelled";
            System.out.println(Constants.CANCELLED);
        }

    }
    public void  complete(){
        this.status="Completed";
        System.out.println(Constants.COMPLETED);

    }
    public  void displayInfo(){
        toString();
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
