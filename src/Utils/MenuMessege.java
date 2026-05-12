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
    """;
    public static String NURSE_MENU_MESSEGE= """
           1. Add Nurse 
           2. edit Nurse
           3. remove Nurse
           4. Search Nurses By Department
           5. Search Nurses By Shift
           6. Display All Nurses
           7. exit Nurse
    """;
    public static String DEPARTMENT_MENU_MESSEGE= """
           1. Add Department 
           2. edit Department
           3. remove Department
           4. Search Department By id
           5. Display All Departments
           6. Assign Doctor To Department
           7. exit Department
    """;
    public static String APPOINTMENT_MENU_MESSEGE= """
             1. Add Appointment
             2. Edit Appointment
             3. Delete Appointment
             4. Display All Appointments
             5. Search By Patient ID
             6. Search By Doctor ID
             7. Search By Date
             8. Reschedule Appointment
             9. Cancel Appointment
             10. Exit
            """;
    public static String MEDICALRECORD_MENU_MESSEGE= """
           1. Add Medical Record 
           2. edit Medical Record
           3. remove Medical Record
           4. Search By Patient ID
           5. Search By Doctor ID
           6. Display Patient History
           7. Display All Medical Records
           8. exit Medical Record
    """;

}

