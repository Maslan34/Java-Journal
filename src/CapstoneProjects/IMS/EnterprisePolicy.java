package CapstoneProjects.IMS;

public class EnterprisePolicy extends Account{

    final double PROFIT_MARGIN = 1.15; // Profit margin for enterprise

    public EnterprisePolicy(User user) {
        this.user = user;
        this.setAccountNumber(Account.getAccountNumberForRegister());
    }

    @Override
    public int compareTo(Account o) {
        return this.getAccountNumber().compareTo(o.getAccountNumber());
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurance.calculate();
        insurance.setInsurancePrice(insurance.getInsurancePrice() * PROFIT_MARGIN);
        this.getInsurances().add(insurance);
    }
}
