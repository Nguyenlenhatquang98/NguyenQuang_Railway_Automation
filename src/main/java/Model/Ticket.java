package Model;

import Common.Constant.Constant;

public class Ticket {
    private String DEPARTDATE;
    private String DEPARTFROM;
    private String ARRIVEAT;
    private String SEATTYPE;


    public Ticket() {
        this.DEPARTDATE = Constant.DEPART_DATE;
        this.DEPARTFROM = Constant.DEPART_FROM;
        this.ARRIVEAT = Constant.ARRIVE_AT;
        this.SEATTYPE = Constant.SEAT_TYPE;
    }

    public Ticket(String DEPARTFROM, String ARRIVEAT){
        this.DEPARTDATE = Constant.DEPART_DATE;
        this.DEPARTFROM = DEPARTFROM;
        this.ARRIVEAT = ARRIVEAT;
        this.SEATTYPE = Constant.SEAT_TYPE;
    }

    public String getDEPARTDATE() {
        return this.DEPARTDATE;
    }

    public String getDEPARTFROM() {
        return this.DEPARTFROM;
    }

    public String getARRIVEAT() {
        return this.ARRIVEAT;
    }

    public String getSEATTYPE() {
        return this.SEATTYPE;
    }
}
