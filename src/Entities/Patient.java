package Entities;

import Utils.Constants;
import Utils.HelperUtils;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person implements Displayable {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords;
    private List<String> appointments;

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email, String address,
                   String patientId, String bloodGroup, List<String> allergies,
                   String emergencyContact, LocalDate registrationDate, String insuranceId,
                   List<String> appointments, List<String> medicalRecords) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        setPatientId(patientId);
        setBloodGroup(bloodGroup);
        setAllergies(allergies);
        setEmergencyContact(emergencyContact);
        setRegistrationDate(registrationDate);
        setInsuranceId(insuranceId);
        setAppointments(appointments);
        setMedicalRecords(medicalRecords);
    }

    public Patient() {
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isValidString(patientId, 2)) {
            this.patientId = patientId;
        } else {
            this.patientId = HelperUtils.generateId("PAT");
        }
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        if (HelperUtils.isValidString(bloodGroup, 1)) {
            this.bloodGroup = bloodGroup;
        } else {
            this.bloodGroup = "Unknown";
        }
    }

    public List<String> getAllergies() {
        if (HelperUtils.isNull(allergies)) {
            allergies = new ArrayList<>();
        }
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        if (HelperUtils.isNotNull(allergies)) {
            this.allergies = allergies;
        } else {
            this.allergies = new ArrayList<>();
        }
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        if (HelperUtils.isNotNull(emergencyContact)) {
            this.emergencyContact = emergencyContact;
        } else {
            this.emergencyContact = "N/A";
        }
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (HelperUtils.isNotNull(registrationDate)) {
            this.registrationDate = registrationDate;
        } else {
            this.registrationDate = LocalDate.now();
        }
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        if (HelperUtils.isNotNull(insuranceId)) {
            this.insuranceId = insuranceId;
        } else {
            this.insuranceId = "N/A";
        }
    }

    public List<String> getMedicalRecords() {
        if (HelperUtils.isNull(medicalRecords)) {
            medicalRecords = new ArrayList<>();
        }
        return medicalRecords;
    }

    public void setMedicalRecords(List<String> medicalRecords) {
        if (HelperUtils.isNotNull(medicalRecords)) {
            this.medicalRecords = medicalRecords;
        } else {
            this.medicalRecords = new ArrayList<>();
        }
    }

    public List<String> getAppointments() {
        if (HelperUtils.isNull(appointments)) {
            appointments = new ArrayList<>();
        }
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        if (HelperUtils.isNotNull(appointments)) {
            this.appointments = appointments;
        } else {
            this.appointments = new ArrayList<>();
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Patient: " + (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", ID: " + (HelperUtils.isNotNull(patientId) ? patientId : "N/A") +
                        ", Blood Group: " + (HelperUtils.isNotNull(bloodGroup) ? bloodGroup : "N/A") +
                        ", Insurance: " + (HelperUtils.isNotNull(insuranceId) ? insuranceId : "N/A")
        );
    }

    public void addMedicalRecord(String medicalRecord) {
        if (HelperUtils.isValidString(medicalRecord)) {
            List<String> list = getMedicalRecords();
            if (!list.contains(medicalRecord)) {
                list.add(medicalRecord);
                System.out.println("Medical record added.");
            } else {
                System.out.println("Medical record already exists.");
            }
        } else {
            System.out.println("Invalid medical record.");
        }
    }

    public void addAppointment(String appointment) {
        if (HelperUtils.isValidString(appointment)) {
            List<String> list = getAppointments();
            if (!list.contains(appointment)) {
                list.add(appointment);
                System.out.println("Appointment added.");
            } else {
                System.out.println("Appointment already exists.");
            }
        } else {
            System.out.println("Invalid appointment.");
        }
    }

    public void updateInsurance(String updated) {
        if (HelperUtils.isNotNull(updated)) {
            this.insuranceId = updated;
            System.out.println(Constants.INSURANCE_UPDATE_SUCCESSFULLY);
        } else {
            System.out.println("Insurance ID cannot be empty");
        }
    }

    public void updateContact(String phone) {
        if (HelperUtils.isNotNull(phone)) {
            setPhoneNumber(phone);
            System.out.println("Phone number updated.");
        }
    }

    public void updateContact(String phone, String email) {
        if (HelperUtils.isNotNull(phone)) setPhoneNumber(phone);
        if (HelperUtils.isNotNull(email)) setEmail(email);
        System.out.println("Contact updated.");
    }

    public void updateContact(String phone, String email, String address) {
        if (HelperUtils.isNotNull(phone)) setPhoneNumber(phone);
        if (HelperUtils.isNotNull(email)) setEmail(email);
        if (HelperUtils.isNotNull(address)) setAddress(address);
        System.out.println("Contact updated.");
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + (HelperUtils.isNotNull(patientId) ? patientId : "N/A") + '\'' +
                ", bloodGroup='" + (HelperUtils.isNotNull(bloodGroup) ? bloodGroup : "N/A") + '\'' +
                ", allergies=" + (HelperUtils.isNotNull(allergies) ? allergies : "[]") +
                ", emergencyContact='" + (HelperUtils.isNotNull(emergencyContact) ? emergencyContact : "N/A") + '\'' +
                ", registrationDate=" + (HelperUtils.isNotNull(registrationDate) ? registrationDate : "N/A") +
                ", insuranceId='" + (HelperUtils.isNotNull(insuranceId) ? insuranceId : "N/A") + '\'' +
                ", medicalRecords=" + (HelperUtils.isNotNull(medicalRecords) ? medicalRecords : "[]") +
                ", appointments=" + (HelperUtils.isNotNull(appointments) ? appointments : "[]") +
                '}';
    }
}