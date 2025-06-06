package DesignPatterns.Behavioural.ChainOfResponsibility;




// Behavioural
// ChainOfResponsibility : Bu desen, bir isteği (request) işleyebilecek bir dizi nesne (handler) oluşturur
// ve isteğin bu nesneler zinciri boyunca ilerlemesine olanak tanır.
// Her nesne isteği işleyebilir veya bir sonraki nesneye iletebilir.
//  Open/Closed ilkesine fayda sağlar.


public class Main {
    public static void main(String[] args) {
        CargoCompany cargoCompany = MuharremCargo.getFranchise();


        cargoCompany.ship(CITIES.EDIRNE);
        cargoCompany.ship(CITIES.ANTALYA);
        cargoCompany.ship(CITIES.ISTANBUL);
        cargoCompany.ship(CITIES.AGRI);
    }
}
