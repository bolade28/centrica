package com.bg;

public class Action {
    public static final String DEPART = "Depart";
    public static final String PARK = "Park";
    public static final String SMALLEST =  "Smallest";

    private String type;
    private String plateNumber;

    public  Action(String type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
    }

    public  Action(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public String getPlateNumber() { return plateNumber; }
}
