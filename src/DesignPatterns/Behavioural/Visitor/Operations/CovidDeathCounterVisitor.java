package DesignPatterns.Behavioural.Visitor.Operations;

import DesignPatterns.Behavioural.Visitor.MinistryOfHealth.*;

import java.util.List;

public class CovidDeathCounterVisitor implements Visitor {
    @Override
    public String visitorHospital(Hospital hospital) {
        return String.valueOf(countDeathsInHospitals(hospital));
    }

    @Override
    public String visitCity(City city) {
        return String.valueOf(countDeathsInCities(city));
    }

    @Override
    public String visitCountry(Country country) {
        return String.valueOf(countDeathsInCountries(country));
    }

    private int countDeathsInHospitals(Hospital hospital) {
        List<Patient> patientList = hospital.getPatients();
        int patientCount = 0;
        for (Patient patient : patientList) {
            if (patient.getPatientStatus() == DISEASE_STATUS.DEATH && patient.getPatientType() == TYPE_DISEASE.COVID)
                patientCount++;
        }
        return patientCount;
    }

    private int countDeathsInCities(City city) {
        List<Hospital> hospitalList = city.getHospitals();
        int patientCount = 0;
        for (Hospital hospital : hospitalList) {
            patientCount += countDeathsInHospitals(hospital);
        }
        return patientCount;
    }

    private int countDeathsInCountries(Country country) {
        List<City> cityList = country.getCities();
        int patientCount = 0;
        for (City city : cityList) {
            patientCount += countDeathsInCities(city);
        }
        return patientCount;
    }
}
