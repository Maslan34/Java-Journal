package CapstoneProjects.IMS;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Insurance {

    String insuranceName;
    Double insurancePrice;
    Date insuranceStartDate;
    Date insuranceEndDate;

    public Insurance(String insuranceName, Double insurancePrice, Date insuranceStartDate, Date insuranceEndDate) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.insuranceStartDate = insuranceStartDate;
        this.insuranceEndDate = insuranceEndDate;
    }

    public abstract Double calculate();
    public void informInsurance() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String startDateStr = insuranceStartDate != null ? sdf.format(insuranceStartDate) : "N/A";
        String endDateStr = insuranceEndDate != null ? sdf.format(insuranceEndDate) : "N/A";
        String priceStr = insurancePrice != null ? String.format("%.2f", insurancePrice) + "₺" : "N/A";

        String info = String.format(
                "\n%-25s: %s" +
                        "\n%-25s: %s" +
                        "\n%-25s: %s" +
                        "\n%-25s: %s\n",
                "Insurance Name", insuranceName,
                "Insurance Price", priceStr,
                "Start Date", startDateStr,
                "End Date", endDateStr
        );

        System.out.println(info);
    }

    public Double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(Double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }
}
