package com.eldar;

public abstract class Fee {
    private String name;

    public Fee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract Float calculateFee();
}
