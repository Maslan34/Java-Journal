package Practices;
import java.util.Scanner;


public class ValueAddedTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float taxRate;
        float ValueAddedTaxPrice;
        float finalPrice=0;

        while(true){
            System.out.println("Please Enter Your Price of Your Goods: ");
            float price = input.nextFloat();
            if( (price>=0.0f) ){
                if (price>=1000.0f){
                    taxRate=0.08f;
                    ValueAddedTaxPrice= price*taxRate;
                    finalPrice=ValueAddedTaxPrice+price;
                    System.out.println("Your Price with Value Added Tax is: "+finalPrice+" your value added tax price:"+ValueAddedTaxPrice+" and your tax rate is: "+taxRate);
                    break;
                }
                else{
                    taxRate=0.18f;
                    ValueAddedTaxPrice= price*taxRate;
                    finalPrice+=ValueAddedTaxPrice+price;
                    System.out.println("Your Price with Value Added Tax is: "+finalPrice+" your value added tax price:"+ValueAddedTaxPrice+" and your tax rate is: "+taxRate);
                    break;
                }
            }
            else {
                System.out.println("Price of Goods Can not Be Negative");
            }
        }
    }
}
