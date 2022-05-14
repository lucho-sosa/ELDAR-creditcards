package com.eldar;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    private List<CreditCard> creditCards = new ArrayList<CreditCard>();
    private List<Fee> fees = new ArrayList<Fee>();

    public void addFee(Fee fee) {
        fees.add(fee);
    }

    public List<Fee> getFees() {
        return fees;
    }

    public ArrayList<CreditCard> listCards(){
        return (ArrayList<CreditCard>) creditCards;
    }

    public void addCard(CreditCard creditCard){
        creditCards.add(creditCard);
    }

    public void removeCard(CreditCard creditCard){
        creditCards.remove(creditCard);
    }

    public void removeCard(int index){
        creditCards.remove(index);
    }

    public void removeCard(String number){
        for (CreditCard creditCard : creditCards) {
            if (creditCard.getNumber().equals(number)){
                creditCards.remove(creditCard);
                break;
            }
        }
    }

    public CreditCard getCard(int index){
        return creditCards.get(index);
    }

    public CreditCard getCard(String number){
        for (CreditCard creditCard : creditCards) {
            if (creditCard.getNumber().equals(number)){
                return creditCard;
            }
        }
        return null;
    }

    //EXERCISES

    //1.- Show info about a credit card
    public String creditCardInfo(CreditCard creditCard){
        return creditCard.toString();
    }
    //2.- Check if a credit card is valid using the current date
    public String isValidToOperate(CreditCard creditCard){
        if (creditCard.isValidToOperate()) return "Valid";
        return "Invalid";
    }
    //3.- Check if a operation is valid using the current date and amount
    public String operate(CreditCard creditCard, double amount){
        if (creditCard.operate(creditCard, amount)) return "Success";
        return "Failed";
    }
    //4.- Compare two credit cards
    public String compare(CreditCard creditCard1, CreditCard creditCard2){
        if (creditCard1.compare(creditCard1, creditCard2)) return "Equal";
        return "Not Equal";
    }
    //5.- Show all fees for a credit card 
    public void calculateFee(Fee fee, Float amount){
        try {
            //using collection.stream to iterate over the list of fees show name of fee and amount * calulateFee
            fees.stream().forEach(f -> System.out.println(f.getName() + ": " + f.calculateFee()*amount + " tasa para el monto " + amount));
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }

    }

    public static void main( String[] args )
    {
        CreditCard cc1;
        CreditCard cc2;
        CreditCard cc3;

        cc1 = new CreditCard(1,
        "John Does",
        "1234567890123456",
        "2025-12-01",
        new FeeVISA());
        cc2 = new CreditCard(2,
        "Johnas Doe",
        "2234567890123456",
        "2026-12-01",
        new FeeVISA());
        cc3 = new CreditCard(3,
        "Johny Dole",
        "3234567890123456",
        "2027-12-01",
        new FeeVISA());
       

        App app = new App();

        app.addCard(cc1);
        app.addCard(cc2);
        app.addCard(cc3);

        System.out.println(app.creditCardInfo(cc1));
        System.out.println(app.creditCardInfo(cc2));
        System.out.println(app.creditCardInfo(cc3));

        System.out.println(app.operate(cc1, 500));
        System.out.println(app.operate(cc2, 1000));
        System.out.println(app.operate(cc3, 1500));
        
        System.out.println(app.isValidToOperate(cc1));
        System.out.println(app.isValidToOperate(cc2));
        System.out.println(app.isValidToOperate(cc3));

        System.out.println(app.compare(cc1, cc2));
        System.out.println(app.compare(cc1, cc3));
        System.out.println(app.compare(cc2, cc3));

        Fee visa = new FeeVISA();
        Fee nara = new FeeNARA();
        Fee amex = new FeeAMEX();

        app.addFee(visa);
        app.addFee(nara);
        app.addFee(amex);

        app.calculateFee(visa, 2000f);
        
    }
}
