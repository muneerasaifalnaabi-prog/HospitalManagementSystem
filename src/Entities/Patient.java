package Entities;


import Utils.Constants;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person implements Displayable {
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
    public Patient() {

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<String> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }

    @Override
    public void displayInfo(){
        System.out.println(this.toString());

    }
    public void addMedicalRecord(String medicalRecord) {
        if (medicalRecords == null) {
            medicalRecords = new java.util.ArrayList<>();
        }
        medicalRecords.add(medicalRecord);
    }
    public void addAppointment(String appointment){
        appointments.add(appointment);
    }
    public void updateInsurance(String updated) {
        if (updated != null && !updated.isEmpty()) {
            this.insuranceId = updated;
            System.out.println(Constants.INSURANCE_UPDATE_SUCCESSFULLY);
        } else {
            System.out.println("Insurance ID cannot be empty");
        }
    }
    public void updateContact(String phone){
        this.setPhoneNumber(phone);

    }
    public void updateContact(String phone, String email){
        
        this.setPhoneNumber(phone);
        this.setEmail(email);
    }
    public void updateContact(String phone, String email, String address){
        this.setPhoneNumber(phone);
        this.setEmail(email);
        this.setAddress(address);
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
