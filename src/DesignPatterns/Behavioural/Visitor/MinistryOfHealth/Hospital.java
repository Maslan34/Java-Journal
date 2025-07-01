package DesignPatterns.Behavioural.Visitor.MinistryOfHealth;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private String hospitalName;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.patients = new ArrayList<Patient>();
    }

    public String accept(Visitor visitor) {
        return visitor.visitorHospital(this);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
