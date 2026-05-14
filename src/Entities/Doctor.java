package Entities;

import Utils.Constants;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private Double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctor() {
    }

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;

    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (HelperUtils.isValidString(specialization, 3)) {
            this.specialization = specialization;
        }
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        if (HelperUtils.isValidString(qualification, 2)) {
            this.qualification = qualification;
        }
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if (HelperUtils.isPositive(experienceYears)) {
            this.experienceYears = experienceYears;
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId, 2)) {
            this.departmentId = departmentId;
        }
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        if (HelperUtils.isPositive(consultationFee)) {
            this.consultationFee = consultationFee;
        }
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        if (HelperUtils.isNotNull(availableSlots)) {
            this.availableSlots = availableSlots;
        }
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        if (HelperUtils.isNotNull(assignedPatients)) {
            this.assignedPatients = assignedPatients;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(this.toString());


    }

    @Override
    public void displaySummary() {
        System.out.println(
                "Doctor: Dr. " + getFirstName() + " " + getLastName() +
                        ", Specialization: " + specialization +
                        ", Experience: " + experienceYears + " years" +
                        ", Fee: " + consultationFee
        );

    }

    public void assignPatient(String patient) {
        if (HelperUtils.isValidString(patient, 2)) {
            assignedPatients.add(patient);
            System.out.println(Constants.PATIENT_ASSIGN_SUCCESSFULLY);

        }
    }

    public void removePatient(String rempatientId) {
        if (HelperUtils.isValidString(rempatientId) && assignedPatients.contains(rempatientId)) {
            assignedPatients.remove(rempatientId);
            System.out.println(Constants.REMOVE_PATIENT_SUCCESSFULLY);
        } else {
            System.out.println("Patient not found in list");
        }
    }

    public void updateAvailability(List<String> newslot) {
        if (HelperUtils.isNotNull(newslot)) {
            this.availableSlots = new ArrayList<>(newslot);
            System.out.println("Availability has been updated");
        }
    }

    public void updateFee(double fee) {
        if (HelperUtils.isPositive(fee)) {
            this.consultationFee = fee;
        }
    }

    public void updateFee(double fee, String reason) {
        if (HelperUtils.isPositive(fee) && HelperUtils.isValidString(reason)) {
            this.consultationFee = fee;
            System.out.println("Fee has been updated" + fee);
            System.out.println(reason);
        }
    }

    public void addAvailability(String slot) {
        if (HelperUtils.isValidString(slot)) {
            availableSlots.add(slot);
            System.out.println("Availability slot has been added");
        }
    }

    public void addAvailability(List<String> slots) {
        if (HelperUtils.isNotNull(slots)) {
            this.availableSlots.addAll(slots);
            System.out.println("All Availability slot has been added");
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                ", experienceYears=" + experienceYears +
                ", departmentId='" + departmentId + '\'' +
                ", consultationFee=" + consultationFee +
                ", availableSlots=" + availableSlots +
                ", assignedPatients=" + assignedPatients +
                '}';
    }
}
