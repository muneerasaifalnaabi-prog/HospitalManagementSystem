import Entities.Department;
import Menu.Menue;
import Services.*;
import Utils.MenuMessege;
import Utils.TestData;


import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static PatientService patientService =new PatientService();
    static AppointmentService appointmentService =new AppointmentService();
    static DoctorService doctorService =new DoctorService();
    static NurseService nurseService =new NurseService();
    static ReportService reportService =new ReportService();
    static DepartmentService departmentService =new DepartmentService();
    static MedicalRecordService medicalRecordService =new MedicalRecordService();
   static Menue menue =new Menue();
    public static void main(String[] args) {
        System.out.println("*** Welcome to Hospital Management System... :>");
        TestData.loadData();

       //TestData.testOverloadedMethod();
       //TestData.testCRUD();
        System.out.println("=========================");
        handelMenu();

        }

        public static void handelMenu(){
        menue.displayMenu();
        int choice=input.nextInt();
        switch(choice){
            case 1->{
                System.out.println(MenuMessege.PATIENT_MENU_MESSEGE);
                patientService.HadlerPatient();
                handelMenu();
            }
            case 2->{
                System.out.println(MenuMessege.DOCTOR_MENU_MESSEGE);
                doctorService.handelDoctorService();
                handelMenu();
            }
            case 3->{
                System.out.println(MenuMessege.NURSE_MENU_MESSEGE);
                nurseService.NurseHandler();
                handelMenu();
            }
            case 4->{
                System.out.println(MenuMessege.APPOINTMENT_MENU_MESSEGE);
                appointmentService.handleAppointmentService();
                handelMenu();
            }
            case 5->{
                System.out.println(MenuMessege.MEDICALRECORD_MENU_MESSEGE);
                medicalRecordService.MedicalRecordHandler();
                handelMenu();
            }
            case 6->{
                System.out.println(MenuMessege.DEPARTMENT_MENU_MESSEGE);
                departmentService.DepartmentHandler();
                handelMenu();
            }
            case 7->{
                System.out.println(MenuMessege.REPORT_MENU_MESSEGE);
                reportService.ReportHandler();
                handelMenu();
            }
            case 8->{
                System.out.println("Exiting from Hospital Management System ....");
                return;
            }
            default ->  System.out.println("Invalid choice");
        }

        }
    }
