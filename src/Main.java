import Menu.Menue;
import Services.PatientService;
import Utiles.MenuMessege;


import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static PatientService patientService =new PatientService();
   static Menue menue =new Menue();
    public static void main(String[] args) {
        handelMenu();

        }

        public static void handelMenu(){
        menue.displayMenu();
        int choice=input.nextInt();
        switch(choice){
            case 1->{
                System.out.println(MenuMessege.PATIENT_MENU_MESSEGE);
                patientService.handelPatientServic();
                handelMenu();

            }
        }

        }
    }
