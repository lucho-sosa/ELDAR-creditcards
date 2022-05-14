package com.eldar;

import java.time.LocalDate;

public class FeeNARA extends Fee{

    public FeeNARA() {
        super("NARA");
    }

    @Override
    public Float calculateFee() {
        try {
            int day = LocalDate.now().getDayOfMonth();
            if (day > 10) return 0.05f;
            return day * 0.5f;
        } catch (Exception e) {
            System.out.println("Invalid Operation");
            return 0f;
        }
    }

    
}