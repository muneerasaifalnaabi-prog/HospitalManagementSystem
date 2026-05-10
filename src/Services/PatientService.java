package Services;

import Entities.Patient;
import Utiles.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PatientService {
    static Scanner scanner = new Scanner(System.in);
    static List<Patient>patients =new ArrayList<>();

    public void  addPatient(Patient patient) {
        System.out.println("========= Added New Patient =====");
        System.out.println("Enter Patient id :");
        String id = scanner.nextLine();
        Patient p =getPatientById(id);
        if (!patient.equals(null)) {
            patients.add(patient);
            System.out.println(Constants.PATIENT_ASSIGN_SUCCESSFULLY);
        }
    }
    public Patient  getPatientById(String patientId){
        for (Patient p :patients){
            if (p.getId().equals(patientId)){
                return p;
            }
        }
        return null;
    }
    public void editPatient(String patientId, Patient updatedPatient) {
        if (patientId != null) {
            for (int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getId().equals(patientId)) {
                    patients.set(i, updatedPatient);
                    System.out.println(Constants.PATIENT_UPDATED);
                }
            }
        }
    }
        public void removePatient(String patientId){
        Patient p = getPatientById(patientId);
        if (p.getId().equals(patientId)){
            patients.remove(p);
            System.out.println(Constants.REMOVE_PATIENT_SUCCESSFULLY);
        }
            System.out.println("Pation not found");

        }
        public List<Patient> searchPatientsByName(String name) {
            System.out.println("Search Results:");
            for (Patient p : patients) {
                if (p.getFirstName().toLowerCase().contains(name.toLowerCase())) {
                    p.displayInfo();
                }
            }
            return null;
        }
        public  void displayAllPatients(){
            System.out.println("===== All Patient =====");
            for (Patient p :patients){
                p.displayInfo();
            }

        }


    }




