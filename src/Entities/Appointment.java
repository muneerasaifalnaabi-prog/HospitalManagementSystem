package Entities;

import Utils.Constants;
import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment implements Displayable {
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
        if (HelperUtils.isNotNull(appointmentId)) {
            this.appointmentId = appointmentId;
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isNotNull(patientId)) {
            this.patientId = patientId;
        }
    }
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isNotNull(doctorId)) {
            this.doctorId = doctorId;
        }
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        if (HelperUtils.isNotNull(appointmentDate)) {
            this.appointmentDate = appointmentDate;
        }
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        if (HelperUtils.isNotNull(appointmentTime)) {
            this.appointmentTime = appointmentTime;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (HelperUtils.isNotNull(status)) {
            this.status = status;
        }
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        if (HelperUtils.isNotNull(reason)) {
            this.reason = reason;
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (HelperUtils.isNotNull(notes)) {
            this.notes = notes;
        }
    }

    public void  reschedule(LocalDate newDate, String newTime){

        if (HelperUtils.isNotNull(status) && status.equals("Completed") || status.equals("Cancelled")){
            System.out.println(Constants.NOT_RESCHEDULE);
        }
        this.appointmentDate=newDate;
        this.appointmentTime=newTime;
        this.status="Rescheduled";
        System.out.println(
                Constants.RESCHEDULE_SUCCESSFULLY +"new Date:" +newDate + "Time :"+ newTime);

    }
    public void  cancel(){
        if (HelperUtils.isNotNull(status) && !status.equals("Completed")){
            this.status="Cancelled";
            System.out.println(Constants.CANCELLED);
        }

    }
    public void  complete(){
        this.status="Completed";
        System.out.println(Constants.COMPLETED);

    }
    @Override
    public  void displayInfo(){
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Appintment ID" +appointmentId +
                        "Patient Id "+patientId +
                        "Doctor Id " +doctorId +
                        "Date " + appointmentDate +
                        "Status " + status
        );

    }



    public void addNotes(String notes){
    this.notes=notes;
        System.out.println("Notes :"+ notes);
    }
    public void addNotes(String notes, String addedBy){
       this.notes=notes;
       System.out.println("Notes :"+ notes + "Added by :"+ addedBy);
    }
    public void addNotes(String notes, String addedBy, LocalDateTime timestamp){
       this.notes=notes;
       System.out.println("Notes :"+ notes + "Added by :"+ addedBy + "Time :"+ timestamp);
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + (appointmentId != null ? appointmentId : "N/A") + '\'' +
                ", patientId='" + (patientId != null ? patientId : "N/A") + '\'' +
                ", doctorId='" + (doctorId != null ? doctorId : "N/A") + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + (appointmentTime != null ? appointmentTime : "N/A") + '\'' +
                ", status='" + (status != null ? status : "N/A") + '\'' +
                ", reason='" + (reason != null ? reason : "N/A") + '\'' +
                ", notes='" + (notes != null ? notes : "N/A") + '\'' +
                '}';
    }
}
