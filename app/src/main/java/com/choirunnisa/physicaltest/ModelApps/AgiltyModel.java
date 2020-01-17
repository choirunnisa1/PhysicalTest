package com.choirunnisa.physicaltest.ModelApps;

public class AgiltyModel {
    private int no;
    private String Nama;
    private String Prespu;
    private String Prespi;

    public AgiltyModel(int no, String nama, String prespu, String prespi) {
        this.no = no;
        Nama = nama;
        Prespu = prespu;
        Prespi = prespi;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getPrespu() {
        return Prespu;
    }

    public void setPrespu(String prespu) {
        Prespu = prespu;
    }

    public String getPrespi() {
        return Prespi;
    }

    public void setPrespi(String prespi) {
        Prespi = prespi;
    }


}
