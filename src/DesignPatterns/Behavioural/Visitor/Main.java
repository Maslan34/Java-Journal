package DesignPatterns.Behavioural.Visitor;

import DesignPatterns.Behavioural.Visitor.MinistryOfHealth.*;
import DesignPatterns.Behavioural.Visitor.Operations.CovidDeathCounterVisitor;
import DesignPatterns.Behavioural.Visitor.Operations.CovidRecoveredCounterVisitor;
import DesignPatterns.Behavioural.Visitor.Operations.PatientCounterVisitor;




// Behavioural
// Visitor :Bir nesne yapısında gezinmek ve her nesne türü için
// belirli bir işlem gerçekleştirmek isteyen bir "ziyaretçi" (visitor) sınıfı tanımlar.
// Her nesne, kendi sınıfını ziyaretçiye bildirerek ilgili işlemin çalışmasını sağlar.
// Bu desenle, yeni işlemleri nesne sınıflarını değiştirmeden eklenebilir.
// Genellikle nesne yapısının sabit ama operasyonların sık değiştiği durumlarda kullanılır.

// Avantajları
// Açık-Kapalı ilkesine uygundur: yeni işlem eklemek kolaydır.
//İşlem mantığını nesnelerden ayırır (ayrıştırma sağlar).
//Kodun yeniden kullanılabilirliğini artırır.

// Dezavantajları
// Her yeni Class için Visitor arayüzü güncellenmelidir.


public class Main {
    public static void main(String[] args) {

        Country turkey = new Country("Türkiye");
        City istanbul = new City("Istanbul");
        Hospital  gata = new Hospital("GATA");
        Patient berk = new Patient("Berk", DISEASE_STATUS.ISOLATION, TYPE_DISEASE.COVID);
        Patient meryem = new Patient("Meryem", DISEASE_STATUS.ISOLATION, TYPE_DISEASE.COVID);
        Patient tugce = new Patient("Tugce", DISEASE_STATUS.ISOLATION, TYPE_DISEASE.COVID);
        Patient fuat = new Patient("Fuat", DISEASE_STATUS.ISOLATION, TYPE_DISEASE.COVID);
        Patient asli = new Patient("Aslı", DISEASE_STATUS.RECOVERED, TYPE_DISEASE.COVID);
        Patient ekrem = new Patient("Ekrem", DISEASE_STATUS.RECOVERED, TYPE_DISEASE.COVID);

        turkey.addCity(istanbul);
        istanbul.addHospital(gata);
        gata.addPatient(meryem);
        gata.addPatient(tugce);
        gata.addPatient(fuat);
        gata.addPatient(berk);
        gata.addPatient(asli);
        gata.addPatient(ekrem);

        getReport(turkey);

    }

    public static void getReport(Country country) {

        PatientCounterVisitor patientCounterVisitor = new PatientCounterVisitor();
        String patientCount =patientCounterVisitor.visitCountry(country);

        CovidDeathCounterVisitor covidDeathCounterVisitor = new CovidDeathCounterVisitor();
        String covidDeathCount =covidDeathCounterVisitor.visitCountry(country);

        CovidRecoveredCounterVisitor covidRecoveredCounterVisitor = new CovidRecoveredCounterVisitor();
        String covidRecoveredCount =covidRecoveredCounterVisitor.visitCountry(country);

        System.out.println("Isolation Count: "+patientCount);
        System.out.println("Death Count: "+covidDeathCount);
        System.out.println("Recovered Count: "+covidRecoveredCount);


    }
}
