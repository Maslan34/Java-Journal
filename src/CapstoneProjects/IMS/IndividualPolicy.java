package CapstoneProjects.IMS;

public class IndividualPolicy extends Account{

    final double PROFIT_MARGIN = 1.05; // Profit margin for enterprise

    public IndividualPolicy(User user) {
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
