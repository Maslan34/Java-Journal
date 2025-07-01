package DesignPatterns.Behavioural.Visitor.MinistryOfHealth;

public interface Visitor {

    String visitorHospital(Hospital hospital);

    String visitCity(City city);
    // Daha sonradan ilçe gelicekse bunuda baştan tasarla sonra değiştirme diyor.
    // Bu design pattern

    String visitCountry(Country country);
}
