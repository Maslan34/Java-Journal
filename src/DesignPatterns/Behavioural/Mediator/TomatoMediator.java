package DesignPatterns.Behavioural.Mediator;

import java.util.ArrayList;
import java.util.List;

public class TomatoMediator implements Mediator {

    private List<Farmer> farmers;
    private List<Wholesaler> wholesalers;

    public TomatoMediator() {
        this.farmers = new ArrayList<>();
        this.wholesalers = new ArrayList<>();
    }


    @Override
    public void addWholesaler(Wholesaler wholesaler) {
        wholesalers.add(wholesaler);
    }

    @Override
    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    @Override
    public void getVegatablesFromFarmer(Farmer farmer) {

        Wholesaler w = getBestWholeSalerForProduct(farmer.getVegatable());
        System.out.println(farmer.getName() + " named farmer sold " + farmer.getVegatable() + " to " + w.getName() + " named wholesaler.");

    }

    @Override
    public void sellVegatablesToWholesaler(Wholesaler wholesaler) {

        Farmer f = getBestFarmerForProduct(wholesaler.getVegatable());
        System.out.println(wholesaler.getName() + " named wholesaler bought " + f.getVegatable() + " from " + f.getName() + ", a farmer.");

    }


    private Farmer getBestFarmerForProduct(VEGATABLES vegatable) {
        Farmer bestFarmer = null;
        double bestFarmerPrice = Double.MAX_VALUE;
        for (Farmer f : farmers) {
            if (f.getVegatable() == vegatable) {
                if (f.getPrice() < bestFarmerPrice) {
                    bestFarmer = f;
                    bestFarmerPrice = f.getPrice();
                }
            }

        }
        return bestFarmer;
    }

    private Wholesaler getBestWholeSalerForProduct(VEGATABLES vegatable) {
        Wholesaler bestWholeSaler = null;
        double bestWholesalerPrice = Double.MIN_VALUE;
        for (Wholesaler w : wholesalers) {
            if(w.getVegatable() == vegatable) {
                if (w.getPrice() > bestWholesalerPrice) {
                    bestWholeSaler = w;
                    bestWholesalerPrice = w.getPrice();
                }
            }

        }
        return bestWholeSaler;
    }
}
