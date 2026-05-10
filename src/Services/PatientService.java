package Services;

import Entities.Patient;

import java.util.ArrayList;
import java.util.List;


public class PatientService {
    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    private List<Patient>patients =new ArrayList<>();

}
