package com.choirunnisa.physicaltest.ModelApps;

public class FitnesModel {
    private String No;
    private String Kat;
    private String UsiaA;
    private String UsiaB;
    private String UsiaC;
    private String UsiaD;

    public FitnesModel(String no,String kat, String usiaA, String usiaB, String usiaC, String usiaD) {
        No = no;
        Kat = kat;
        UsiaA = usiaA;
        UsiaB = usiaB;
        UsiaC = usiaC;
        UsiaD = usiaD;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getKat() {
        return Kat;
    }

    public void setKat(String kat) {
        Kat = kat;
    }

    public String getUsiaA() {
        return UsiaA;
    }

    public void setUsiaA(String usiaA) {
        UsiaA = usiaA;
    }

    public String getUsiaB() {
        return UsiaB;
    }

    public void setUsiaB(String usiaB) {
        UsiaB = usiaB;
    }

    public String getUsiaC() {
        return UsiaC;
    }

    public void setUsiaC(String usiaC) {
        UsiaC = usiaC;
    }

    public String getUsiaD() {
        return UsiaD;
    }

    public void setUsiaD(String usiaD) {
        UsiaD = usiaD;
    }
}
