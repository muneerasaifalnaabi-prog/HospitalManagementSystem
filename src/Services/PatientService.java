package Services;

import Entities.Patient;

import java.util.ArrayList;
import java.util.List;


public class PatientService {
    private List<Patient>patients =new ArrayList<>();
    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    public void  addPatient(Patient patient) {
        if (!patient.equals(null)) {
            patients.add(patient);
        }
    }



}
