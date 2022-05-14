package com.eldar;

import java.time.LocalDate;

public class FeeAMEX extends Fee {
    public FeeAMEX() {
        super("AMEX");
    }

    @Override
    public Float calculateFee() {
        try {
            int month = LocalDate.now().getMonthValue();
            if (month < 3) return 0.03f;
            return month * 0.1f;
        } catch (Exception e) {
            System.out.println("Invalid date format");
            return 0f;
        }
    }
}
