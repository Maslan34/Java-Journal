package DesignPatterns.Behavioural.Visitor.Operations;

import DesignPatterns.Behavioural.Visitor.MinistryOfHealth.*;

import java.util.List;

public class CovidRecoveredCounterVisitor implements Visitor {
    @Override
    public String visitorHospital(Hospital hospital) {
        return String.valueOf(countRecoveredInHospitals(hospital));
    }

    @Override
    public String visitCity(City city) {
        return  String.valueOf(countRecoveredInCities(city));
    }

    @Override
    public String visitCountry(Country country) {
        return String.valueOf(countRecoveredInCountries(country));
    }

    private int countRecoveredInHospitals(Hospital hospital) {
        List<Patient> patientList = hospital.getPatients();
        int patientCount = 0;
        for (Patient patient : patientList) {
            if (patient.getPatientStatus() == DISEASE_STATUS.RECOVERED && patient.getPatientType() == TYPE_DISEASE.COVID)
                patientCount++;
        }
        return patientCount;
    }

    private int countRecoveredInCities(City city) {
        List<Hospital> hospitalList = city.getHospitals();
        int patientCount = 0;
        for (Hospital hospital : hospitalList) {
            patientCount += countRecoveredInHospitals(hospital);
        }
        return patientCount;
    }

    private int countRecoveredInCountries(Country country) {
        List<City> cityList = country.getCities();
        int patientCount = 0;
        for (City city : cityList) {
            patientCount += countRecoveredInCities(city);
        }
        return patientCount;
    }
}
