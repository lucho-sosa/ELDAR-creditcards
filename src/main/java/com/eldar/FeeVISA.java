package com.eldar;

import java.time.LocalDate;

public class FeeVISA extends Fee {

    public FeeVISA() {
        super("VISA");
    }

    @Override
    public Float calculateFee() {
        try {
            int year = LocalDate.now().getYear() % 100;
            int month = LocalDate.now().getMonthValue();
            float fee = year/month;
            if (fee > 5) return 0.05f;
            if (fee < 0.3) return 0.003f;
            return fee/100;
        } catch (Exception e) {
            System.out.println("Invalid date format");
            return 0f;
        }
    }

}
