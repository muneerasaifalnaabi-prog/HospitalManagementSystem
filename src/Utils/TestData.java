package Utils;

import Entities.*;
import Services.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TestData {
    static PatientService patientService =new PatientService();
    static AppointmentService appointmentService =new AppointmentService();
    static DoctorService doctorService =new DoctorService();
    static NurseService nurseService =new NurseService();
    static ReportService reportService =new ReportService();
    static DepartmentService departmentService =new DepartmentService();
    static MedicalRecordService medicalRecordService =new MedicalRecordService();
    public static void main(String[] args) {
        loadData();
        testOverloadedMethod();
    }

    public static void loadData() {
        // Clear existing data
        PatientService.getPatients().clear();
        DoctorService.doctors.clear();
        NurseService.Nurses.clear();
        DepartmentService.departments.clear();
        AppointmentService.appointments.clear();
        MedicalRecordService.medicalRecords.clear();

        // ========================= PATIENTS =========================
        Patient p1 = new Patient(
                "SYS-P001", "Said", "Al-Hasani", LocalDate.of(1985, 6, 15), "Male",
                "+968 92123456", "said.alhasani@email.om", "Muscat, Al Ghubra",
                "PAT-001", "O+", new ArrayList<>(), "+968 99881234",
                LocalDate.of(2024, 1, 10), "INS-OM-001", new ArrayList<>(), new ArrayList<>()
        );
        Patient p2 = new Patient(
                "SYS-P002", "Mariam", "Al-Rawahi", LocalDate.of(1990, 3, 22), "Female",
                "+968 92345678", "mariam.rawahi@email.om", "Salalah, Al Dahariz",
                "PAT-002", "A-", new ArrayList<>(Arrays.asList("Penicillin")), "+968 99112345",
                LocalDate.of(2024, 1, 15), "INS-OM-002", new ArrayList<>(), new ArrayList<>()
        );
        Patient p3 = new Patient(
                "SYS-P003", "Abdullah", "Al-Balushi", LocalDate.of(2018, 11, 5), "Male",
                "+968 93456789", "abdullah.family@email.om", "Sohar, Al Hail",
                "PAT-003", "B+", new ArrayList<>(Arrays.asList("Peanuts")), "+968 99229988",
                LocalDate.of(2024, 2, 20), "INS-OM-003", new ArrayList<>(), new ArrayList<>()
        );

        InPatient p4 = new InPatient(
                "SYS-P004", "Khalid", "Al-Maskari", LocalDate.of(1975, 12, 1), "Male",
                "+968 95678901", "khalid.maskari@email.om", "Nizwa, Birkat Al Mouz",
                "PAT-004", "O-", new ArrayList<>(), "+968 99445566",
                LocalDate.of(2024, 3, 12), "INS-OM-004", new ArrayList<>(), new ArrayList<>(),
                LocalDate.of(2024, 4, 1), null, "Room 105", "DOC-001", "Bed 2", 180.0
        );
        InPatient p5 = new InPatient(
                "SYS-P005", "Aisha", "Al-Busaidi", LocalDate.of(1970, 11, 30), "Female",
                "+968 98901234", "aisha.busaidi@email.om", "Sur, Ash Sharqiyah",
                "PAT-005", "O+", new ArrayList<>(Arrays.asList("Sulfa")), "+968 99553344",
                LocalDate.of(2024, 3, 20), "INS-OM-005", new ArrayList<>(), new ArrayList<>(),
                LocalDate.of(2024, 4, 5), null, "Room 202", "DOC-001", "Bed 8", 150.0
        );

        EmergencyPatient p6 = new EmergencyPatient(
                "SYS-P006", "Yusuf", "Al-Hinai", LocalDate.of(2000, 1, 10), "Male",
                "+968 99012345", "yusuf.hinai@email.om", "Muscat, Bausher",
                "PAT-006", "AB-", new ArrayList<>(), "+968 99778899",
                LocalDate.of(2024, 4, 1), "INS-OM-006", new ArrayList<>(), new ArrayList<>(),
                LocalDate.of(2024, 4, 2), LocalDate.of(2024, 4, 3), "ER-03", "DOC-002", "ER Bed 2", 200.0,
                "Fracture", "Ambulance", 4, true
        );
        EmergencyPatient p7 = new EmergencyPatient(
                "SYS-P007", "Fatima", "Al-Zadjali", LocalDate.of(1988, 9, 18), "Female",
                "+968 96789012", "fatima.zadjali@email.om", "Muscat, Al Amerat",
                "PAT-007", "A+", new ArrayList<>(), "+968 99337777",
                LocalDate.of(2024, 3, 15), "INS-OM-007", new ArrayList<>(), new ArrayList<>(),
                LocalDate.of(2024, 3, 15), LocalDate.of(2024, 3, 16), "ER-02", "DOC-002", "ER Bed 1", 200.0,
                "Chest Pain", "Walk-in", 3, true
        );

        Patient p8 = new Patient(
                "SYS-P008", "Zainab", "Al-Lawati", LocalDate.of(1992, 6, 12), "Female",
                "+968 99123456", "zainab.lawati@email.om", "Rustaq, Al Batinah",
                "PAT-008", "A-", new ArrayList<>(), "+968 99886677",
                LocalDate.of(2024, 4, 5), "INS-OM-008", new ArrayList<>(), new ArrayList<>()
        );
        Patient p9 = new Patient(
                "SYS-P009", "Mohammed", "Al-Saadi", LocalDate.of(1995, 4, 25), "Male",
                "+968 97890123", "mohammed.saadi@email.om", "Ibri, Al Dhahirah",
                "PAT-009", "B-", new ArrayList<>(), "+968 99001122",
                LocalDate.of(2024, 2, 1), "INS-OM-009", new ArrayList<>(), new ArrayList<>()
        );
        InPatient p10 = new InPatient(
                "SYS-P010", "Hana", "Nasser", LocalDate.of(2014, 8, 22), "Female",
                "+968 97777777", "hana@gmail.com", "Nizwa",
                "PAT-010", "O+", new ArrayList<>(), "+968 95989659",
                LocalDate.now(), "INS-010", new ArrayList<>(), new ArrayList<>(),
                LocalDate.of(2026, 2, 2), LocalDate.of(2026, 2, 20), "Room-05", "DOC-001", "Bed-1", 150.0
        );

        PatientService.getPatients().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

        // ========================= DOCTORS =========================
        Consultant doc1 = new Consultant(
                "DOC-001", "Ahmed", "Al-Hasani", LocalDate.of(1975, 5, 12), "Male",
                "+968 99223344", "ahmed.alhasani@royalhospital.om", "Muscat, Al Khuwair",
                "DOC-001", "Cardiology", "FRCS", 18, "DEPT-001", 65.0,
                new ArrayList<>(Arrays.asList("Mon 9-11", "Wed 10-12")), new ArrayList<>(),
                Arrays.asList("Bypass", "Valve Replacement"), 45, true
        );
        Consultant doc2 = new Consultant(
                "DOC-002", "Mariam", "Al-Rawahi", LocalDate.of(1980, 8, 23), "Female",
                "+968 99335566", "mariam.alrawahi@khoula.om", "Muscat, Madinat Sultan Qaboos",
                "DOC-002", "Emergency Medicine", "MD", 15, "DEPT-002", 50.0,
                new ArrayList<>(Arrays.asList("Mon 8-12", "Thu 8-12")), new ArrayList<>(),
                Arrays.asList("Trauma", "Critical Care"), 60, true
        );
        Surgeon doc3 = new Surgeon(
                "DOC-003", "Yousuf", "Al-Maskari", LocalDate.of(1972, 7, 19), "Male",
                "+968 99663344", "yousuf.maskari@ortho.om", "Nizwa, Farq",
                "DOC-003", "Orthopedic Surgery", "FRCS", 20, "DEPT-003", 70.0,
                new ArrayList<>(Arrays.asList("Tue 10-13", "Thu 10-13")), new ArrayList<>(),
                200, Arrays.asList("Knee Replacement", "Fracture Fixation"), true
        );
        Surgeon doc4 = new Surgeon(
                "DOC-004", "Rashid", "Al-Shanfari", LocalDate.of(1982, 2, 28), "Male",
                "+968 99991122", "rashid.shanfari@surgery.om", "Salalah, Al Haffa",
                "DOC-004", "General Surgery", "FRCS", 12, "DEPT-003", 65.0,
                new ArrayList<>(Arrays.asList("Mon 15-17", "Thu 15-17")), new ArrayList<>(),
                85, Arrays.asList("Appendectomy", "Hernia Repair"), true
        );
        Doctor doc5 = new Doctor(
                "DOC-005", "Khalid", "Al-Balushi", LocalDate.of(1978, 11, 2), "Male",
                "+968 99447788", "khalid.albalushi@noor.om", "Salalah, Al Dahariz",
                "DOC-005", "Neurology", "MD", 12, "DEPT-002", 55.0,
                new ArrayList<>(Arrays.asList("Tue 9-12", "Fri 9-11")), new ArrayList<>()
        );
        Doctor doc6 = new Doctor(
                "DOC-006", "Nadia", "Al-Siyabi", LocalDate.of(1985, 3, 15), "Female",
                "+968 99551122", "nadia.siyabi@royalhospital.om", "Sohar, Al Hail",
                "DOC-006", "Pediatrics", "MBBS", 10, "DEPT-001", 48.0,
                new ArrayList<>(Arrays.asList("Mon 14-16", "Wed 14-16")), new ArrayList<>()
        );
        Doctor doc7 = new Doctor(
                "DOC-007", "Fatima", "Al-Hinai", LocalDate.of(1988, 9, 10), "Female",
                "+968 99778899", "fatima.hinai@hospital.om", "Muscat, Al Ghubra",
                "DOC-007", "General Medicine", "MBBS", 8, "DEPT-002", 40.0,
                new ArrayList<>(Arrays.asList("Mon 9-12", "Fri 9-12")), new ArrayList<>()
        );
        Consultant doc8 = new Consultant(
                "DOC-008", "Said", "Al-Harthi", LocalDate.of(1979, 12, 1), "Male",
                "+968 99880011", "said.harthi@heart.om", "Muscat, Azaiba",
                "DOC-008", "Cardiology", "MD", 14, "DEPT-001", 60.0,
                new ArrayList<>(Arrays.asList("Wed 13-16", "Thu 13-16")), new ArrayList<>(),
                Arrays.asList("Echocardiography", "Stress Test"), 60, true
        );
        DoctorService.doctors.addAll(Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6, doc7, doc8));

        // ========================= NURSES =========================
        Nurse n1 = new Nurse(
                "SYS-N001", "Fatima", "Al-Kindi", LocalDate.of(1995, 4, 10), "Female",
                "+968 97112233", "fatima.kindi@hospital.om", "Muscat", "NUR-001", "DEPT-001", "Morning", "BNSc", new ArrayList<>()
        );
        Nurse n2 = new Nurse(
                "SYS-N002", "Amira", "Al-Balushi", LocalDate.of(1992, 8, 21), "Female",
                "+968 97223344", "amira.balushi@hospital.om", "Seeb", "NUR-002", "DEPT-002", "Evening", "RN", new ArrayList<>()
        );
        Nurse n3 = new Nurse(
                "SYS-N003", "Shamsa", "Al-Mazroui", LocalDate.of(1998, 1, 15), "Female",
                "+968 97334455", "shamsa.mazroui@hospital.om", "Nizwa", "NUR-003", "DEPT-003", "Night", "BSN", new ArrayList<>()
        );
        Nurse n4 = new Nurse(
                "SYS-N004", "Nawal", "Al-Riyami", LocalDate.of(1990, 11, 5), "Female",
                "+968 97445566", "nawal.riyami@hospital.om", "Sohar", "NUR-004", "DEPT-001", "Morning", "RN", new ArrayList<>()
        );
        Nurse n5 = new Nurse(
                "SYS-N005", "Mona", "Al-Habsi", LocalDate.of(1997, 6, 30), "Female",
                "+968 97556677", "mona.habsi@hospital.om", "Sur", "NUR-005", "DEPT-002", "Evening", "BNSc", new ArrayList<>()
        );
        NurseService.Nurses.addAll(Arrays.asList(n1, n2, n3, n4, n5));

        // ========================= DEPARTMENTS =========================
        Department dep1 = new Department(
                "DEPT-001", "Cardiology", "DOC-001", new ArrayList<>(), new ArrayList<>(), 50, 30
        );
        Department dep2 = new Department(
                "DEPT-002", "Emergency Medicine", "DOC-002", new ArrayList<>(), new ArrayList<>(), 40, 15
        );
        Department dep3 = new Department(
                "DEPT-003", "Orthopedics", "DOC-003", new ArrayList<>(), new ArrayList<>(), 45, 25
        );
        Department dep4 = new Department(
                "DEPT-004", "Neurology", "DOC-005", new ArrayList<>(), new ArrayList<>(), 30, 20
        );
        DepartmentService.departments.addAll(Arrays.asList(dep1, dep2, dep3, dep4));

        // ========================= APPOINTMENTS =========================
        Appointment a1 = new Appointment("PAT-001", "APP-001", "DOC-001", LocalDate.of(2026, 5, 15), "09:00 AM", "Scheduled", "Heart Checkup", "Chest pain");
        Appointment a2 = new Appointment("PAT-002", "APP-002", "DOC-002", LocalDate.of(2026, 5, 16), "11:30 AM", "Completed", "Skin Allergy", "Prescribed medication");
        Appointment a3 = new Appointment("PAT-003", "APP-003", "DOC-005", LocalDate.of(2026, 5, 17), "02:00 PM", "Scheduled", "General Fever", "Follow-up");
        Appointment a4 = new Appointment("PAT-004", "APP-004", "DOC-003", LocalDate.of(2026, 5, 18), "10:15 AM", "Cancelled", "Knee Surgery", "Patient cancelled");
        Appointment a5 = new Appointment("PAT-005", "APP-005", "DOC-001", LocalDate.of(2026, 5, 19), "01:00 PM", "Scheduled", "Asthma", "Inhaler check");
        Appointment a6 = new Appointment("PAT-006", "APP-006", "DOC-002", LocalDate.of(2026, 5, 20), "09:30 AM", "Scheduled", "Fracture", "X-ray needed");
        Appointment a7 = new Appointment("PAT-007", "APP-007", "DOC-007", LocalDate.of(2026, 5, 21), "10:00 AM", "Completed", "Back Pain", "Physiotherapy");
        Appointment a8 = new Appointment("PAT-008", "APP-008", "DOC-006", LocalDate.of(2026, 5, 22), "11:00 AM", "Scheduled", "Cold & Fever", "Initial visit");
        Appointment a9 = new Appointment("PAT-009", "APP-009", "DOC-008", LocalDate.of(2026, 5, 23), "12:00 PM", "Scheduled", "Cardiac eval", "ECG ordered");
        Appointment a10 = new Appointment("PAT-010", "APP-010", "DOC-004", LocalDate.of(2026, 5, 24), "01:30 PM", "Completed", "Anemia", "Iron levels low");
        Appointment a11 = new Appointment("PAT-001", "APP-011", "DOC-005", LocalDate.of(2026, 5, 25), "02:15 PM", "Scheduled", "Migraine", "Prescribed medication");
        Appointment a12 = new Appointment("PAT-002", "APP-012", "DOC-006", LocalDate.of(2026, 5, 26), "03:00 PM", "Cancelled", "Routine", "Patient unavailable");
        Appointment a13 = new Appointment("PAT-003", "APP-013", "DOC-002", LocalDate.of(2026, 5, 27), "09:00 AM", "Scheduled", "Allergy", "Follow-up");
        Appointment a14 = new Appointment("PAT-004", "APP-014", "DOC-001", LocalDate.of(2026, 5, 28), "10:45 AM", "Scheduled", "Hypertension", "BP check");
        Appointment a15 = new Appointment("PAT-005", "APP-015", "DOC-003", LocalDate.of(2026, 5, 29), "11:30 AM", "Scheduled", "Post-op", "Surgery follow-up");
        AppointmentService.appointments.addAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15));

        // ========================= MEDICAL RECORDS =========================
        MedicalRecord mr1 = new MedicalRecord("MR-001", "PAT-001", "DOC-001", LocalDate.of(2026, 5, 1), "Hypertension", "Normal", "Amlodipine 5mg", "Reduce salt");
        MedicalRecord mr2 = new MedicalRecord("MR-002", "PAT-002", "DOC-002", LocalDate.of(2026, 5, 2), "Skin Allergy", "Allergy test positive", "Antihistamine", "Avoid seafood");
        MedicalRecord mr3 = new MedicalRecord("MR-003", "PAT-003", "DOC-005", LocalDate.of(2026, 5, 3), "Viral Fever", "Blood test normal", "Paracetamol", "Rest");
        MedicalRecord mr4 = new MedicalRecord("MR-004", "PAT-004", "DOC-003", LocalDate.of(2026, 5, 4), "Knee Injury", "MRI shows tear", "Pain relief", "Surgery option");
        MedicalRecord mr5 = new MedicalRecord("MR-005", "PAT-005", "DOC-001", LocalDate.of(2026, 5, 5), "Asthma", "Breathing test abnormal", "Inhaler", "Avoid dust");
        MedicalRecord mr6 = new MedicalRecord("MR-006", "PAT-006", "DOC-002", LocalDate.of(2026, 5, 6), "Fracture", "X-ray confirms", "Painkillers", "Cast applied");
        MedicalRecord mr7 = new MedicalRecord("MR-007", "PAT-007", "DOC-007", LocalDate.of(2026, 5, 7), "Back Pain", "X-ray normal", "Muscle relaxant", "Physio");
        MedicalRecord mr8 = new MedicalRecord("MR-008", "PAT-008", "DOC-006", LocalDate.of(2026, 5, 8), "Common Cold", "Temperature elevated", "Cough syrup", "Hydrate");
        MedicalRecord mr9 = new MedicalRecord("MR-009", "PAT-009", "DOC-008", LocalDate.of(2026, 5, 9), "Arrhythmia", "ECG abnormal", "Beta-blocker", "Follow-up");
        MedicalRecord mr10 = new MedicalRecord("MR-010", "PAT-010", "DOC-004", LocalDate.of(2026, 5, 10), "Anemia", "Hemoglobin low", "Iron supplements", "Diet change");
        MedicalRecord mr11 = new MedicalRecord("MR-011", "PAT-001", "DOC-005", LocalDate.of(2026, 5, 11), "Diabetes", "Blood sugar elevated", "Metformin", "Exercise");
        MedicalRecord mr12 = new MedicalRecord("MR-012", "PAT-002", "DOC-006", LocalDate.of(2026, 5, 12), "Vitamin D Deficiency", "Vitamin D low", "Capsules", "Sun exposure");
        MedicalRecordService.medicalRecords.addAll(Arrays.asList(mr1, mr2, mr3, mr4, mr5, mr6, mr7, mr8, mr9, mr10, mr11, mr12));

        // ========================= PRINT ALL DATA =========================
        System.out.println(" LOADED SAMPLE DATA-------------------");


        // Print Patients
        System.out.println("\n PATIENTS (" + PatientService.getPatients().size() + " records):");
        for (Patient p : PatientService.getPatients()) {
            p.displayInfo();
        }

        // Print Doctors
        System.out.println("\n DOCTORS (" + DoctorService.doctors.size() + " records):");
        for (Doctor d : DoctorService.doctors) {
            d.displayInfo();
        }
        // Print Nurses
        System.out.println("\n NURSES (" + NurseService.Nurses.size() + " records):");
        for (Nurse n : NurseService.Nurses) {
            n.displayInfo();
        }

        // Print Departments
        System.out.println("\n DEPARTMENTS (" + DepartmentService.departments.size() + " records):");
        for (Department dept : DepartmentService.departments) {
            dept.displayInfo();
        }

        // Print Appointments
        System.out.println("\n APPOINTMENTS (" + AppointmentService.appointments.size() + " records):");
        for (Appointment a : AppointmentService.appointments) {
            a.displayInfo();
        }

        // Print Medical Records
        System.out.println("\nMEDICAL RECORDS (" + MedicalRecordService.medicalRecords.size() + " records):");
        for (MedicalRecord mr : MedicalRecordService.medicalRecords) {
            mr.displayInfo();
        }

        System.out.println("Sample data loaded and printed successfully!........");
    }
    public static  void testOverloadedMethod(){


/*
        // addPatient(String, String, String)
        patientService.addPatient("Omar", "Al-Busaidi", "98880011");
        System.out.println("✓ addPatient(String, String, String)");

        // addPatient(String, String, String, String, String)
        ps.addPatient("Laila", "Al-Hinai", "97770022", "A-", "laila@email.com");
        System.out.println("✓ addPatient(String, String, String, String, String)");

        // addPatient(Patient)
        Patient temp = new Patient();
        ps.addPatient(temp);
        System.out.println("✓ addPatient(Patient)");

        displayPatients() / displayPatients(String) / displayPatients(int)
        ps.displayPatients();                        // all
        ps.displayPatients("Male");                  // filter by gender
        ps.displayPatients(2);                       // limit 2
        System.out.println("✓ displayPatients() overloaded");

        // searchPatients(String) and searchPatients(String, String)
        List<Patient> byKeyword = ps.searchPatients("Al-Hasani");
        System.out.println("✓ searchPatients(keyword) found " + byKeyword.size());
        List<Patient> byFullName = ps.searchPatients("Said", "Al-Hasani");
        System.out.println("✓ searchPatients(firstName, lastName) found " + byFullName.size());

 */
            DoctorService ds = new DoctorService();
      //  ---------- DoctorService overloads ----------

        // addDoctor(String, String, String)
        ds.addDoctor("Dr. Samira", "Pediatrics", "96661122");
        System.out.println("✓ addDoctor(String, String, String)");

        // addDoctor(String, String, String, double)
        ds.addDoctor("Dr. Nasser", "Cardiology", "95552233", 120.0);
        System.out.println("✓ addDoctor(String, String, String, double)");

        // addDoctor(Doctor)
        Doctor d = new Doctor();
        ds.addDoctor(d);
        System.out.println("✓ addDoctor(Doctor)");

        // updateFee (Doctor instance methods – need a real doctor)
        Doctor sampleDoctor = DoctorService.doctors.get(0);
        sampleDoctor.updateFee(150.0);
        sampleDoctor.updateFee(160.0, "Annual increase");
        System.out.println("✓ Doctor.updateFee() overloaded");

        // addAvailability (Doctor instance)
        sampleDoctor.addAvailability("Tue 10:00");
        sampleDoctor.addAvailability(Arrays.asList("Wed 14:00", "Fri 09:00"));
        System.out.println("✓ Doctor.addAvailability() overloaded");

        // ---------- AppointmentService overloads ----------
        AppointmentService as = new AppointmentService();

        // createAppointment(String, String, LocalDate)
        as.createAppointment("PAT-001", "DOC-001", LocalDate.now().plusDays(1));
        System.out.println("✓ createAppointment(patientId, doctorId, date)");

        // createAppointment(String, String, LocalDate, String)
        as.createAppointment("PAT-002", "DOC-002", LocalDate.now().plusDays(2), "11:00");
        System.out.println("✓ createAppointment(patientId, doctorId, date, time)");

        // createAppointment(Appointment)
        Appointment a = new Appointment();
        as.createAppointment(a);
        System.out.println("✓ createAppointment(Appointment)");

        // rescheduleAppointment (overloaded in AppointmentService)
        as.rescheduleAppointment("APP-001", LocalDate.now().plusDays(10));
        as.rescheduleAppointment("APP-002", LocalDate.now().plusDays(10), "14:30");
        Appointment mockApp = new Appointment();
        as.rescheduleAppointment(mockApp, LocalDate.now(), "09:00", "Test reason");
        System.out.println("✓ AppointmentService.rescheduleAppointment() overloaded");

        // displayAppointments overloads (one with date, one with doctor+date range)
        as.displayAppointments();                           // all
        as.displayAppointments(LocalDate.now());            // by date (note: implementation prints all, but it's overloaded)
        as.displayAppointments("DOC-001", LocalDate.now(), LocalDate.now().plusDays(7));
        System.out.println("✓ displayAppointments() overloaded");

        // ---------- Appointment entity overloaded addNotes ----------
        Appointment app = new Appointment();
        app.addNotes("First note");
        app.addNotes("Second note", "Dr. Ahmed");
        app.addNotes("Third note", "Dr. Fatima", LocalDateTime.now());
        System.out.println("✓ Appointment.addNotes() overloaded");

        System.out.println("Overloaded methods test completed.");
    }



}