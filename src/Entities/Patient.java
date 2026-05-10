package Entities;


import java.time.LocalDate;
import java.util.List;

public class Patient extends Person{
    private String patientId ;
    private String bloodGroup ;
    private List<String> allergies ;
    private String emergencyContact ;
    private LocalDate registrationDate ;
    private String  insuranceId ;
    private List<String> medicalRecords;
    private List<String> appointments;

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> appointments, List<String> medicalRecords) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.appointments = appointments;
        this.medicalRecords = medicalRecords;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        toString();


    }
    public void addMedicalRecord(String medicalRecord ){

    }
    public void addAppointment(){


    }
    public void updateInsurance(){


    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", allergies=" + allergies +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", registrationDate=" + registrationDate +
                ", insuranceId='" + insuranceId + '\'' +
                ", medicalRecords=" + medicalRecords +
                ", appointments=" + appointments +
                '}';
    }
}
