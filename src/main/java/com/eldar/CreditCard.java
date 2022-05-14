package com.eldar;

import java.time.LocalDate;

public class CreditCard {

    private int id;
    private String holder;
    private String number;
    private String expirationDate;
    private Fee brand;

    public boolean isValidToOperate() {
        try {
            return LocalDate.now().isBefore(LocalDate.parse(expirationDate));
        } catch (Exception e) {
            System.out.println("Invalid date format");
            return false;
        }
    }

    public boolean operate(CreditCard creditCard, double amount){
        try {
            if (!this.isValidToOperate()) return false;
            if (amount > 1000) return false;
            return true;
        } catch (Exception e) {
            System.out.println("Invalid Operation");
            return false;
        }
    }

    public boolean compare(CreditCard creditCard1, CreditCard creditCard2){
        return creditCard1.equals(creditCard2);
    }


    public CreditCard() {
    }

    public CreditCard(int id, String holder, String number, String expirationDate, Fee brand) {
        this.id = id;
        this.holder = holder;
        this.number = number;
        this.expirationDate = expirationDate;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Fee getBrand() {
        return brand;
    }

    public void setBrand(Fee brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", holder='" + holder + '\'' +
                ", number='" + number + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", brand=" + brand.getName() +
                '}';
    }

}
