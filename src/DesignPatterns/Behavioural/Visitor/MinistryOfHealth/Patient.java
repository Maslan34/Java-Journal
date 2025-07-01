package DesignPatterns.Behavioural.Visitor.MinistryOfHealth;

public class Patient {

    private String patientName;
    private DISEASE_STATUS patientStatus;
    private TYPE_DISEASE patientType;


    public Patient(String patientName, DISEASE_STATUS patientStatus, TYPE_DISEASE patientType) {
        this.patientName = patientName;
        this.patientStatus = patientStatus;
        this.patientType = patientType;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public DISEASE_STATUS getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(DISEASE_STATUS patientStatus) {
        this.patientStatus = patientStatus;
    }

    public TYPE_DISEASE getPatientType() {
        return patientType;
    }

    public void setPatientType(TYPE_DISEASE patientType) {
        this.patientType = patientType;
    }
}
