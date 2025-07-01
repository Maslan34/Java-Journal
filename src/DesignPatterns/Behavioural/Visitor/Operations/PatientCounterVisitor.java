package DesignPatterns.Behavioural.Visitor.Operations;

import DesignPatterns.Behavioural.Visitor.MinistryOfHealth.*;

import java.util.List;

public class PatientCounterVisitor implements Visitor {

    @Override
    public String visitorHospital(Hospital hospital) {
        int patientCount = countPatientsInHospitals(hospital);
        return String.valueOf(patientCount);
    }


    @Override
    public String visitCity(City city) {
        int patientCount = countPatientsInCities(city);
        return String.valueOf(patientCount);
    }


    @Override
    public String visitCountry(Country country) {
        int patientCount = countPatientsInCountries(country);
        return String.valueOf(patientCount);
    }


    private int countPatientsInHospitals(Hospital hospital) {
        List<Patient> patientList = hospital.getPatients();
        int patientCount = 0;
        for (Patient patient : patientList) {
            if (patient.getPatientStatus() == DISEASE_STATUS.ISOLATION && patient.getPatientType()==TYPE_DISEASE.COVID)
                patientCount++;
        }
        return patientCount;
    }

    private int countPatientsInCities(City city) {
        List<Hospital> hospitalList = city.getHospitals();
        int patientCount = 0;
        for (Hospital hospital : hospitalList) {
            patientCount += countPatientsInHospitals(hospital);
        }
        return patientCount;
    }

    private int countPatientsInCountries(Country country) {
        List<City> cityList = country.getCities();
        int patientCount = 0;
        for (City city : cityList) {
            patientCount += countPatientsInCities(city);
        }
        return patientCount;
    }


}
