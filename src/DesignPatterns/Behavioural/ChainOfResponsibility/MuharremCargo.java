package DesignPatterns.Behavioural.ChainOfResponsibility;

public class MuharremCargo {

    public static CargoCompany getFranchise(){

        AnkaraFranchise ankaraFranchise = new AnkaraFranchise();
        AntalyaFranchise antalyaFranchise = new AntalyaFranchise();
        IstanbulFranchise istanbulFranchise = new IstanbulFranchise();

        return istanbulFranchise
                .setNextStation(ankaraFranchise.setNextStation(antalyaFranchise));

    }
}
