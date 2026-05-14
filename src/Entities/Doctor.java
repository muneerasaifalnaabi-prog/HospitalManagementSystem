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

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth,
                  String gender, String phoneNumber, String email, String address,
                  String doctorId, String specialization, String qualification,
                  int experienceYears, String departmentId, Double consultationFee,
                  List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        setDoctorId(doctorId);
        setSpecialization(specialization);
        setQualification(qualification);
        setExperienceYears(experienceYears);
        setDepartmentId(departmentId);
        setConsultationFee(consultationFee);
        setAvailableSlots(availableSlots);
        setAssignedPatients(assignedPatients);
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isValidString(doctorId, 2)) {
            this.doctorId = doctorId;
        } else {
            this.doctorId = HelperUtils.generateId("DOC");
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (HelperUtils.isValidString(specialization, 3)) {
            this.specialization = specialization;
        } else {
            this.specialization = "General";
        }
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        if (HelperUtils.isValidString(qualification, 2)) {
            this.qualification = qualification;
        } else {
            this.qualification = "Unknown";
        }
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if (HelperUtils.isPositive(experienceYears)) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId, 2)) {
            this.departmentId = departmentId;
        } else {
            this.departmentId = "N/A";
        }
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        if (HelperUtils.isPositive(consultationFee)) {
            this.consultationFee = consultationFee;
        } else {
            this.consultationFee = 0.0;
        }
    }

    public List<String> getAvailableSlots() {
        if (HelperUtils.isNull(availableSlots)) {
            availableSlots = new ArrayList<>();
        }
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        if (HelperUtils.isNotNull(availableSlots)) {
            this.availableSlots = availableSlots;
        } else {
            this.availableSlots = new ArrayList<>();
        }
    }

    public List<String> getAssignedPatients() {
        if (HelperUtils.isNull(assignedPatients)) {
            assignedPatients = new ArrayList<>();
        }
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        if (HelperUtils.isNotNull(assignedPatients)) {
            this.assignedPatients = assignedPatients;
        } else {
            this.assignedPatients = new ArrayList<>();
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
                "Doctor: Dr. " + (HelperUtils.isNotNull(getFirstName()) ? getFirstName() : "N/A") + " " +
                        (HelperUtils.isNotNull(getLastName()) ? getLastName() : "N/A") +
                        ", Specialization: " + (HelperUtils.isNotNull(specialization) ? specialization : "N/A") +
                        ", Experience: " + experienceYears + " years" +
                        ", Fee: " + (HelperUtils.isNotNull(consultationFee) ? consultationFee : 0.0)
        );
    }

    public void assignPatient(String patient) {
        if (HelperUtils.isValidString(patient, 2)) {
            if (HelperUtils.isNull(assignedPatients)) {
                assignedPatients = new ArrayList<>();
            }
            if (!assignedPatients.contains(patient)) {
                assignedPatients.add(patient);
                System.out.println(Constants.PATIENT_ASSIGN_SUCCESSFULLY);
            } else {
                System.out.println("Patient already assigned.");
            }
        } else {
            System.out.println("Invalid patient ID.");
        }
    }

    public void removePatient(String rempatientId) {
        if (HelperUtils.isValidString(rempatientId) && HelperUtils.isNotNull(assignedPatients) && assignedPatients.contains(rempatientId)) {
            assignedPatients.remove(rempatientId);
            System.out.println(Constants.REMOVE_PATIENT_SUCCESSFULLY);
        } else {
            System.out.println("Patient not found in list or invalid ID.");
        }
    }

    public void updateAvailability(List<String> newslot) {
        if (HelperUtils.isNotNull(newslot)) {
            if (HelperUtils.isNull(availableSlots)) {
                availableSlots = new ArrayList<>();
            }
            this.availableSlots = new ArrayList<>(newslot);
            System.out.println("Availability has been updated");
        } else {
            System.out.println("Invalid slot list.");
        }
    }

    public void updateFee(double fee) {
        if (HelperUtils.isPositive(fee)) {
            this.consultationFee = fee;
            System.out.println("Fee updated to: " + fee);
        } else {
            System.out.println("Fee must be positive.");
        }
    }

    public void updateFee(double fee, String reason) {
        if (HelperUtils.isPositive(fee) && HelperUtils.isValidString(reason)) {
            this.consultationFee = fee;
            System.out.println("Fee has been updated to " + fee);
            System.out.println("Reason: " + reason);
        } else {
            System.out.println("Invalid fee or reason.");
        }
    }

    public void addAvailability(String slot) {
        if (HelperUtils.isValidString(slot)) {
            if (HelperUtils.isNull(availableSlots)) {
                availableSlots = new ArrayList<>();
            }
            if (!availableSlots.contains(slot)) {
                availableSlots.add(slot);
                System.out.println("Availability slot has been added: " + slot);
            } else {
                System.out.println("Slot already exists.");
            }
        } else {
            System.out.println("Invalid slot.");
        }
    }

    public void addAvailability(List<String> slots) {
        if (HelperUtils.isNotNull(slots) && !slots.isEmpty()) {
            if (HelperUtils.isNull(availableSlots)) {
                availableSlots = new ArrayList<>();
            }
            for (String slot : slots) {
                if (HelperUtils.isValidString(slot) && !availableSlots.contains(slot)) {
                    availableSlots.add(slot);
                }
            }
            System.out.println("All availability slots have been added.");
        } else {
            System.out.println("Invalid slot list.");
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + (HelperUtils.isNotNull(doctorId) ? doctorId : "N/A") + '\'' +
                ", specialization='" + (HelperUtils.isNotNull(specialization) ? specialization : "N/A") + '\'' +
                ", qualification='" + (HelperUtils.isNotNull(qualification) ? qualification : "N/A") + '\'' +
                ", experienceYears=" + experienceYears +
                ", departmentId='" + (HelperUtils.isNotNull(departmentId) ? departmentId : "N/A") + '\'' +
                ", consultationFee=" + (HelperUtils.isNotNull(consultationFee) ? consultationFee : 0.0) +
                ", availableSlots=" + (HelperUtils.isNotNull(availableSlots) ? availableSlots : "[]") +
                ", assignedPatients=" + (HelperUtils.isNotNull(assignedPatients) ? assignedPatients : "[]") +
                '}';
    }
}