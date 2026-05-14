package Utils;

public class MenuMessege {
    public static String MAIN_MENU_MESSEGE= """
            1. Patient Management
            2. Doctor Management
            3. Nurse Management
            4. Appointment Management
            5. Medical Records Management
            6. Department Management
            7. Reports and Statistics
            8. Exit
            """;
    public static String PATIENT_MENU_MESSEGE= """
           1.1 Register New Patient 
           1.2 Register InPatient
           1.3 Register OutPatient
           1.4 Register Emergency Patient
           1.5 View All Patients
           1.6 Search Patient
           1.7 Update Patient Information
           1.8 Remove Patient
           1.9 View Patient Medical History
           1.10 Back to Menu
           
    """;


public static String DOCTOR_MENU_MESSEGE= """
           2.1 Add Doctor
           2.2 Add Surgeon
           2.3 Add Consultant
           2.4 Add General Practitioner
           2.5 View All Doctors
           2.6 Search Doctor by Specialization
           2.7 View Available Doctors
           2.8 Assign Patient to Doctor
           2.9 Update Doctor Information
           2.10 Remove Doctor
           2.11 Back to Menu
    """;
    public static String NURSE_MENU_MESSEGE= """
            3.1 Add Nurse
            3.2 View All Nurses
            3.3 View Nurses by Department
            3.4 View Nurses by Shift
            3.5 Assign Nurse to Patient
            3.6 Update Nurse Information
            3.7 Remove Nurse
            3.8 Back to Menu
    """;
    public static String DEPARTMENT_MENU_MESSEGE= """
           6.1 Add Department
           6.2 View All Departments
           6.3 View Department Details
           6.4 Assign Doctor to Department
           6.5 Assign Nurse to Department
           6.6 Update Department Information
           6.7 View Department Statistics
           6.8 Back to Menu
    """;
    public static String APPOINTMENT_MENU_MESSEGE= """
             4.1 Schedule New Appointment
             4.2 View All Appointments
             4.3 View Appointments by Patient
             4.4 View Appointments by Doctor
             4.5 View Appointments by Date
             4.6 Reschedule Appointment
             4.7 Cancel Appointment
             4.8 Complete Appointment
             4.9 View Upcoming Appointments
             4.10 Back to Menu
            """;
    public static String MEDICALRECORD_MENU_MESSEGE= """
           5.1 Create Medical Record
           5.2 View All Records
           5.3 View Records by Patient
           5.4 View Records by Doctor
           5.5 Update Medical Record
           5.6 Delete Medical Record
           5.7 Generate Patient History Report
           5.8 Back to Menu
    """;
    public static String REPORT_MENU_MESSEGE= """
            7.1 Daily Appointments Report
            7.2 Doctor Performance Report
            7.3 Department Occupancy Report
            7.4 Patient Statistics
            7.5 Emergency Cases Report
            7.6 Back to Menu
    """;

}

