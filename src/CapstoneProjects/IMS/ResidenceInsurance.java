package CapstoneProjects.IMS;

import java.util.Date;

public class ResidenceInsurance extends Insurance {

    Double rate;

    public ResidenceInsurance(String insuranceName, Double insurancePrice, Date insuranceStartDate, Date insuranceEndDate,Double rate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceEndDate);
        this.rate=rate;
    }

    @Override
    public Double calculate() {
        return getInsurancePrice()+(getInsurancePrice()*rate);
    }
}
