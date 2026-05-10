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
    public void editPatient(String patientId, Patient updatedPatient){

    }



}
