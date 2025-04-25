package CapstoneProjects.IMS;

import java.util.Date;

public class CarInsurance extends Insurance {

    Double rate;
    @Override
    public Double calculate() {
        return getInsurancePrice()+(getInsurancePrice()*this.rate);
    }

    public CarInsurance(String insuranceName,Double insurancePrice,Date insuranceStartDate,Date insuranceEndDate,Double rate) {
        super(insuranceName,insurancePrice,insuranceStartDate,insuranceEndDate);
        this.rate=rate;
    }
}
