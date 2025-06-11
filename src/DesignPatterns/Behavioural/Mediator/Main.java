package DesignPatterns.Behavioural.Mediator;



// Behavioural
// Mediator :Mediator deseni, birden fazla nesnenin birbirleriyle doğrudan iletişim kurmak yerine,
// iletişimi tek bir merkezi nesne (mediator) üzerinden gerçekleştirmesini sağlar.
// Nesneler arası gevşek bağlılık (loose coupling) sağlar.
//İletişim kontrolü tek yerde olduğu için yönetilebilirlik artar.

public class Main {
    public static void main(String[] args) {

        TomatoMediator tomatoMediator = new TomatoMediator();
        TomatoFarmer muharremFarmer = new TomatoFarmer("Muharrem",12.50,tomatoMediator);
        TomatoFarmer yusufFarmer = new TomatoFarmer("Yusuf",11.50,tomatoMediator);


        TomatoWholesaler ahmetWholeSaler = new TomatoWholesaler("Ahmet",14.50,tomatoMediator);
        TomatoWholesaler mehmetWholeSaler = new TomatoWholesaler("Mehmet",16.50,tomatoMediator);

        tomatoMediator.addFarmer(yusufFarmer);
        tomatoMediator.addFarmer(muharremFarmer);
        tomatoMediator.addWholesaler(ahmetWholeSaler);
        tomatoMediator.addWholesaler(mehmetWholeSaler);

        muharremFarmer.sellVegatables();
        mehmetWholeSaler.purchaseVegatables();

    }
}
