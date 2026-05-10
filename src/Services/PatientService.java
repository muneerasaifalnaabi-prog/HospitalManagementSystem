package Services;

import Entities.Patient;
import Utiles.Constants;

import java.util.ArrayList;
import java.util.List;


public class PatientService {
    static List<Patient>patients =new ArrayList<>();

    public void  addPatient(Patient patient) {
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
        public List<Patient> searchPatientsByName(String name){

        }
        public  void displayAllPatients(){
            System.out.println("===== All Patient =====");
            for (Patient p :patients){
                p.displayInfo();
            }

        }


    }




