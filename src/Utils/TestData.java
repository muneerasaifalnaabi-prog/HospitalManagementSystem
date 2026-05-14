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
       // testOverloadedMethod();
    }

    public static void loadData() {

        // ========================= PATIENT SAMPLE DATA =========================

        Patient p1 = new Patient(
                "SYS-P001",
                "Said",
                "Al-Hasani",
                LocalDate.of(1985, 6, 15),
                "Male",
                "+96892123456",
                "said@email.com",
                "Muscat",
                "PAT-001",
                "O+",
                new ArrayList<>(Arrays.asList("Dust")),
                "+96899881234",
                LocalDate.now(),
                "INS001",
                new ArrayList<>(),
                new ArrayList<>()
        );

        Patient p2 = new Patient(
                "SYS-P002",
                "Mariam",
                "Al-Rawahi",
                LocalDate.of(1990, 3, 22),
                "Female",
                "+96892345678",
                "mariam@email.com",
                "Salalah",
                "PAT-002",
                "A-",
                new ArrayList<>(Arrays.asList("Penicillin")),
                "+96899112345",
                LocalDate.now(),
                "INS002",
                new ArrayList<>(),
                new ArrayList<>()
        );

        OutPatient p3 = new OutPatient(
                "SYS-P003",
                "Abdullah",
                "Al-Balushi",
                LocalDate.of(2018, 11, 5),
                "Male",
                "+96893456789",
                "abdullah@email.com",
                "Sohar",
                "PAT-003",
                "B+",
                new ArrayList<>(Arrays.asList("Peanuts")),
                "+96899229988",
                LocalDate.now(),
                "INS003",
                new ArrayList<>(),
                new ArrayList<>(),
                3,
                LocalDate.of(2026,5,10),
                "DOC-006"
        );

        InPatient p4 = new InPatient(
                "SYS-P004",
                "Khalid",
                "Al-Maskari",
                LocalDate.of(1975, 12, 1),
                "Male",
                "+96895678901",
                "khalid@email.com",
                "Nizwa",
                "PAT-004",
                "O-",
                new ArrayList<>(),
                "+96899445566",
                LocalDate.now(),
                "INS004",
                new ArrayList<>(),
                new ArrayList<>(),
                LocalDate.of(2026,4,1),
                LocalDate.of(2026,4,10),
                "Room-101",
                "DOC-001",
                "Bed-1",
                150.0
        );

        InPatient p5 = new InPatient(
                "SYS-P005",
                "Aisha",
                "Al-Busaidi",
                LocalDate.of(1970, 11, 30),
                "Female",
                "+96898901234",
                "aisha@email.com",
                "Sur",
                "PAT-005",
                "A+",
                new ArrayList<>(Arrays.asList("Sulfa")),
                "+96899553344",
                LocalDate.now(),
                "INS005",
                new ArrayList<>(),
                new ArrayList<>(),
                LocalDate.of(2026,4,5),
                LocalDate.of(2026,4,15),
                "Room-202",
                "DOC-003",
                "Bed-2",
                180.0
        );

        EmergencyPatient p6 = new EmergencyPatient(
                "SYS-P006",
                "Yusuf",
                "Al-Hinai",
                LocalDate.of(2000, 1, 10),
                "Male",
                "+96899012345",
                "yusuf@email.com",
                "Muscat",
                "PAT-006",
                "AB-",
                new ArrayList<>(),
                "+96899778899",
                LocalDate.now(),
                "INS006",
                new ArrayList<>(),
                new ArrayList<>(),
                LocalDate.of(2026,5,1),
                LocalDate.of(2026,5,4),
                "ER-01",
                "DOC-002",
                "ER-BED-1",
                200.0,
                "Accident",
                "Ambulance",
                1,
                true
        );

        EmergencyPatient p7 = new EmergencyPatient(
                "SYS-P007",
                "Fatima",
                "Al-Zadjali",
                LocalDate.of(1988, 9, 18),
                "Female",
                "+96896789012",
                "fatima@email.com",
                "Muscat",
                "PAT-007",
                "A+",
                new ArrayList<>(),
                "+96899337777",
                LocalDate.now(),
                "INS007",
                new ArrayList<>(),
                new ArrayList<>(),
                LocalDate.of(2026,5,2),
                LocalDate.of(2026,5,3),
                "ER-02",
                "DOC-002",
                "ER-BED-2",
                250.0,
                "Chest Pain",
                "Walk-in",
                2,
                true
        );

        OutPatient p8 = new OutPatient(
                "SYS-P008",
                "Zainab",
                "Al-Lawati",
                LocalDate.of(1992, 6, 12),
                "Female",
                "+96899123456",
                "zainab@email.com",
                "Rustaq",
                "PAT-008",
                "A-",
                new ArrayList<>(),
                "+96899886677",
                LocalDate.now(),
                "INS008",
                new ArrayList<>(),
                new ArrayList<>(),
                5,
                LocalDate.of(2026,5,15),
                "DOC-005"
        );

        Patient p9 = new Patient(
                "SYS-P009",
                "Mohammed",
                "Al-Saadi",
                LocalDate.of(1995, 4, 25),
                "Male",
                "+96897890123",
                "mohammed@email.com",
                "Ibri",
                "PAT-009",
                "B-",
                new ArrayList<>(),
                "+96899001122",
                LocalDate.now(),
                "INS009",
                new ArrayList<>(),
                new ArrayList<>()
        );

        InPatient p10 = new InPatient(
                "SYS-P010",
                "Hana",
                "Nasser",
                LocalDate.of(2014, 8, 22),
                "Female",
                "+96897777777",
                "hana@email.com",
                "Nizwa",
                "PAT-010",
                "O+",
                new ArrayList<>(),
                "+96895989659",
                LocalDate.now(),
                "INS010",
                new ArrayList<>(),
                new ArrayList<>(),
                LocalDate.of(2026,2,2),
                LocalDate.of(2026,2,20),
                "Room-05",
                "DOC-001",
                "Bed-5",
                170.0
        );

        patientService.add(p1);
        patientService.add(p2);
        patientService.add(p3);
        patientService.add(p4);
        patientService.add(p5);
        patientService.add(p6);
        patientService.add(p7);
        patientService.add(p8);
        patientService.add(p9);
        patientService.add(p10);



        // Doctors sample data

        Consultant d1 = new Consultant(
                "D001",
                "Ahmed",
                "Salim",
                LocalDate.of(1980, 5, 12),
                "Male",
                "91111111",
                "ahmed@hospital.com",
                "Muscat",
                "DOC001",
                "Cardiology",
                "MBBS",
                15,
                "DEP01",
                25.0,
                new ArrayList<>(Arrays.asList("9:00 AM", "10:00 AM")),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList("Heart Consultation")),
                45,
                true
        );

        Consultant d2 = new Consultant(
                "D002",
                "Mariam",
                "Ali",
                LocalDate.of(1985, 3, 20),
                "Female",
                "92222222",
                "mariam@hospital.com",
                "Seeb",
                "DOC002",
                "Dermatology",
                "MD",
                12,
                "DEP02",
                20.0,
                new ArrayList<>(Arrays.asList("11:00 AM")),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList("Skin Consultation")),
                30,
                false
        );

        GeneralPractitioner d3 = new GeneralPractitioner(
                "D003",
                "Hassan",
                "Khalid",
                LocalDate.of(1978, 9, 15),
                "Male",
                "93333333",
                "hassan@hospital.com",
                "Nizwa",
                "DOC003",
                "General Medicine",
                "MBBS",
                18,
                "DEP03",
                18.5,
                new ArrayList<>(Arrays.asList("8:00 AM")),
                new ArrayList<>(),
                true,
                true,
                true
        );

        GeneralPractitioner d4 = new GeneralPractitioner(
                "D004",
                "Fatma",
                "Saeed",
                LocalDate.of(1990, 11, 25),
                "Female",
                "94444444",
                "fatma@hospital.com",
                "Sohar",
                "DOC004",
                "Family Medicine",
                "MBBS",
                8,
                "DEP03",
                15.0,
                new ArrayList<>(Arrays.asList("1:00 PM")),
                new ArrayList<>(),
                true,
                false,
                true
        );

        Surgeon d5 = new Surgeon(
                "D005",
                "Salem",
                "Nasser",
                LocalDate.of(1975, 1, 30),
                "Male",
                "95555555",
                "salem@hospital.com",
                "Muscat",
                "DOC005",
                "Orthopedic Surgery",
                "PhD",
                20,
                "DEP04",
                40.0,
                new ArrayList<>(Arrays.asList("3:00 PM")),
                new ArrayList<>(),
                350,
                new ArrayList<>(Arrays.asList("Knee Surgery")),
                true
        );

        Surgeon d6 = new Surgeon(
                "D006",
                "Noor",
                "Hamed",
                LocalDate.of(1988, 7, 14),
                "Female",
                "96666666",
                "noor@hospital.com",
                "Sur",
                "DOC006",
                "Neurosurgery",
                "MD",
                10,
                "DEP04",
                50.0,
                new ArrayList<>(Arrays.asList("4:00 PM")),
                new ArrayList<>(),
                120,
                new ArrayList<>(Arrays.asList("Brain Surgery")),
                true
        );

        Consultant d7 = new Consultant(
                "D007",
                "Omar",
                "Rashid",
                LocalDate.of(1982, 6, 18),
                "Male",
                "97777777",
                "omar@hospital.com",
                "Ibri",
                "DOC007",
                "Pediatrics",
                "MBBS",
                14,
                "DEP05",
                22.0,
                new ArrayList<>(Arrays.asList("12:00 PM")),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList("Child Consultation")),
                40,true
        );

        GeneralPractitioner d8 = new GeneralPractitioner(
                "D008",
                "Aisha",
                "Mohammed",
                LocalDate.of(1992, 2, 8),
                "Female",
                "98888888",
                "aisha@hospital.com",
                "Barka",
                "DOC008",
                "General Practice",
                "MBBS",
                6,
                "DEP03",
                17.0,
                new ArrayList<>(Arrays.asList("5:00 PM")),
                new ArrayList<>(),
                false,
                true,
                false
        );

        doctorService.add(d1);
        doctorService.add(d2);
        doctorService.add(d3);
        doctorService.add(d4);
        doctorService.add(d5);
        doctorService.add(d6);
        doctorService.add(d7);
        doctorService.add(d8);
// Nurses sample data

        Nurse n1 = new Nurse(
                "N001",
                "Layla",
                "Ahmed",
                LocalDate.of(1995, 4, 10),
                "Female",
                "91112222",
                "layla@hospital.com",
                "Muscat",
                "N001",
                "DEP01",
                "Morning",
                "BSc Nursing",
                new ArrayList<>()
        );

        Nurse n2 = new Nurse(
                "N002",
                "Khalid",
                "Salim",
                LocalDate.of(1992, 8, 21),
                "Male",
                "92223333",
                "khalid@hospital.com",
                "Seeb",
                "N002",
                "DEP02",
                "Night",
                "Diploma Nursing",
                new ArrayList<>()
        );

        Nurse n3 = new Nurse(
                "N003",
                "Maha",
                "Nasser",
                LocalDate.of(1998, 1, 15),
                "Female",
                "93334444",
                "maha@hospital.com",
                "Nizwa",
                "N003",
                "DEP03",
                "Evening",
                "BSc Nursing",
                new ArrayList<>()
        );

        Nurse n4 = new Nurse(
                "N004",
                "Saeed",
                "Ali",
                LocalDate.of(1990, 11, 5),
                "Male",
                "94445555",
                "saeed@hospital.com",
                "Sohar",
                "N004",
                "DEP01",
                "Morning",
                "MSc Nursing",
                new ArrayList<>()
        );

        Nurse n5 = new Nurse(
                "N005",
                "Huda",
                "Mohammed",
                LocalDate.of(1997, 6, 30),
                "Female",
                "95556666",
                "huda@hospital.com",
                "Sur",
                "N005",
                "DEP02",
                "Night",
                "BSc Nursing",
                new ArrayList<>()
        );

        nurseService.add(n1);
        nurseService.add(n2);
        nurseService.add(n3);
        nurseService.add(n4);
        nurseService.add(n5);

// Department sample data

        Department dep1 = new Department(
                "DEP01",
                "Cardiology",
                "D001",
                new ArrayList<>(),
                new ArrayList<>(),
                50,
                35
        );

        Department dep2 = new Department(
                "DEP02",
                "Dermatology",
                "D002",
                new ArrayList<>(),
                new ArrayList<>(),
                30,
                20
        );

        Department dep3 = new Department(
                "DEP03",
                "General Medicine",
                "D003",
                new ArrayList<>(),
                new ArrayList<>(),
                70,
                45
        );

        departmentService.add(dep1);
        departmentService.add(dep2);
        departmentService.add(dep3);


// Appointment sample data

        Appointment a1 = new Appointment(
                "A001",
                "P001",
                "D001",
                LocalDate.of(2026, 5, 15),
                "09:00 AM",
                "Scheduled",
                "Heart Checkup",
                "Patient experiencing chest pain"
        );

        Appointment a2 = new Appointment(
                "A002",
                "P002",
                "D002",
                LocalDate.of(2026, 5, 16),
                "11:30 AM",
                "Completed",
                "Skin Allergy",
                "Prescribed allergy medication"
        );

        Appointment a3 = new Appointment(
                "A003",
                "P003",
                "D003",
                LocalDate.of(2026, 5, 17),
                "02:00 PM",
                "Scheduled",
                "General Fever",
                "Follow-up after medication"
        );

        Appointment a4 = new Appointment(
                "A004",
                "P005",
                "D004",
                LocalDate.of(2026, 5, 18),
                "10:15 AM",
                "Cancelled",
                "Routine Checkup",
                "Patient cancelled due to travel"
        );

        Appointment a5 = new Appointment(
                "A005",
                "P008",
                "D005",
                LocalDate.of(2026, 5, 19),
                "01:00 PM",
                "Scheduled",
                "Knee Surgery Consultation",
                "MRI results attached"
        );

        Appointment a6 = new Appointment(
                "A006",
                "P004",
                "D001",
                LocalDate.of(2026, 5, 20),
                "09:30 AM",
                "Scheduled",
                "Asthma Checkup",
                "Follow-up on inhaler usage"
        );

        Appointment a7 = new Appointment(
                "A007",
                "P006",
                "D002",
                LocalDate.of(2026, 5, 21),
                "10:00 AM",
                "Completed",
                "Back Pain Review",
                "Improvement observed"
        );

        Appointment a8 = new Appointment(
                "A008",
                "P007",
                "D003",
                LocalDate.of(2026, 5, 22),
                "11:00 AM",
                "Scheduled",
                "Cold & Fever",
                "Initial consultation"
        );

        Appointment a9 = new Appointment(
                "A009",
                "P008",
                "D004",
                LocalDate.of(2026, 5, 23),
                "12:00 PM",
                "Scheduled",
                "Injury Follow-up",
                "Check healing progress"
        );

        Appointment a10 = new Appointment(
                "A010",
                "P009",
                "D005",
                LocalDate.of(2026, 5, 24),
                "01:30 PM",
                "Completed",
                "Anemia Check",
                "Iron levels improving"
        );

        Appointment a11 = new Appointment(
                "A011",
                "P010",
                "D006",
                LocalDate.of(2026, 5, 25),
                "02:15 PM",
                "Scheduled",
                "Fracture Review",
                "X-ray follow-up needed"
        );

        Appointment a12 = new Appointment(
                "A012",
                "P003",
                "D007",
                LocalDate.of(2026, 5, 26),
                "03:00 PM",
                "Cancelled",
                "General Checkup",
                "Patient unavailable"
        );

        Appointment a13 = new Appointment(
                "A013",
                "P002",
                "D008",
                LocalDate.of(2026, 5, 27),
                "09:00 AM",
                "Scheduled",
                "Skin Review",
                "Monitor allergy reaction"
        );

        Appointment a14 = new Appointment(
                "A014",
                "P001",
                "D002",
                LocalDate.of(2026, 5, 28),
                "10:45 AM",
                "Completed",
                "Hypertension Follow-up",
                "Blood pressure stable"
        );

        Appointment a15 = new Appointment(
                "A015",
                "P005",
                "D003",
                LocalDate.of(2026, 5, 29),
                "11:30 AM",
                "Scheduled",
                "General Consultation",
                "Routine checkup"
        );

        appointmentService.add(a1);
        appointmentService.add(a2);
        appointmentService.add(a3);
        appointmentService.add(a4);
        appointmentService.add(a5);
        appointmentService.add(a6);
        appointmentService.add(a7);
        appointmentService.add(a8);
        appointmentService.add(a9);
        appointmentService.add(a10);
        appointmentService.add(a11);
        appointmentService.add(a12);
        appointmentService.add(a13);
        appointmentService.add(a14);
        appointmentService.add(a15);


// Medical records sample data

        MedicalRecord mr1 = new MedicalRecord(
                "MR001",
                "P001",
                "D001",
                LocalDate.of(2026, 5, 1),
                "Hypertension",
                "Amlodipine 5mg",
                "Blood pressure slightly high",
                "Patient advised to reduce salt intake"
        );

        MedicalRecord mr2 = new MedicalRecord(
                "MR002",
                "P002",
                "D002",
                LocalDate.of(2026, 5, 2),
                "Skin Allergy",
                "Antihistamine tablets",
                "Allergy test positive",
                "Avoid seafood and dust exposure"
        );

        MedicalRecord mr3 = new MedicalRecord(
                "MR003",
                "P003",
                "D003",
                LocalDate.of(2026, 5, 3),
                "Viral Fever",
                "Paracetamol 500mg",
                "Blood test normal",
                "Rest and hydration recommended"
        );

        MedicalRecord mr4 = new MedicalRecord(
                "MR004",
                "P005",
                "D004",
                LocalDate.of(2026, 5, 4),
                "Migraine",
                "Ibuprofen",
                "CT scan normal",
                "Patient should avoid stress"
        );

        MedicalRecord mr5 = new MedicalRecord(
                "MR005",
                "P008",
                "D005",
                LocalDate.of(2026, 5, 5),
                "Knee Injury",
                "Pain relief medication",
                "MRI shows ligament tear",
                "Surgery may be required"
        );

        MedicalRecord mr6 = new MedicalRecord(
                "MR006",
                "P006",
                "D006",
                LocalDate.of(2026, 5, 6),
                "Back Pain",
                "Muscle Relaxant",
                "X-ray normal",
                "Physiotherapy recommended"
        );

        MedicalRecord mr7 = new MedicalRecord(
                "MR007",
                "P007",
                "D007",
                LocalDate.of(2026, 5, 7),
                "Common Cold",
                "Cough Syrup",
                "Temperature slightly elevated",
                "Drink warm fluids"
        );

        MedicalRecord mr8 = new MedicalRecord(
                "MR008",
                "P009",
                "D008",
                LocalDate.of(2026, 5, 8),
                "Anemia",
                "Iron Supplements",
                "Hemoglobin level low",
                "Follow-up after one month"
        );

        MedicalRecord mr9 = new MedicalRecord(
                "MR009",
                "P010",
                "D005",
                LocalDate.of(2026, 5, 9),
                "Fracture",
                "Painkillers",
                "X-ray confirms arm fracture",
                "Cast applied successfully"
        );

        MedicalRecord mr10 = new MedicalRecord(
                "MR010",
                "P001",
                "D003",
                LocalDate.of(2026, 5, 10),
                "Diabetes",
                "Metformin",
                "Blood sugar elevated",
                "Daily exercise advised"
        );

        MedicalRecord mr11 = new MedicalRecord(
                "MR011",
                "P004",
                "D001",
                LocalDate.of(2026, 5, 11),
                "Asthma",
                "Inhaler",
                "Breathing test abnormal",
                "Avoid dust and smoke"
        );

        MedicalRecord mr12 = new MedicalRecord(
                "MR012",
                "P002",
                "D004",
                LocalDate.of(2026, 5, 12),
                "Vitamin D Deficiency",
                "Vitamin D Capsules",
                "Vitamin D level low",
                "Sun exposure recommended"
        );

        medicalRecordService.add(mr1);
        medicalRecordService.add(mr2);
        medicalRecordService.add(mr3);
        medicalRecordService.add(mr4);
        medicalRecordService.add(mr5);
        medicalRecordService.add(mr6);
        medicalRecordService.add(mr7);
        medicalRecordService.add(mr8);
        medicalRecordService.add(mr9);
        medicalRecordService.add(mr10);
        medicalRecordService.add(mr11);
        medicalRecordService.add(mr12);


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



        //Test interface Method that  overloaded  :

    }



}