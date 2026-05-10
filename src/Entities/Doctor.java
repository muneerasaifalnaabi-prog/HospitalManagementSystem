package Entities;

import java.time.LocalDate;
import java.util.List;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int  experienceYears;
    private String departmentId;
    private Double consultationFee;
    private List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, Double consultationFee, String departmentId, List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.consultationFee = consultationFee;
        this.departmentId = departmentId;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

}
