package Services;

import Entities.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    static List<Doctor> doctors= new ArrayList<Doctor>();
    static Scanner scanner=new Scanner(System.in);
    public static List<Doctor> searchPatientsByName(String searchName) {

    }
    public Doctor getDoctorById(int id){
        for (Doctor doctor:doctors){

        }
    }

    public void addDoctor(Doctor doctor){
        System.out.println("===== Added Doctor =====");
        System.out.println("Enter id of Doctor");
        int id=scanner.nextInt();



    }


    
}
