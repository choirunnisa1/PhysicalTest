package com.choirunnisa.physicaltest.ModelApps;

public class MedicineModel {
    private int no;
    private String kategori;
    private String skorePria;
    private String skoreWanita;

    public MedicineModel(int no, String kategori, String skorePria, String skoreWanita) {
        this.no = no;
        this.kategori = kategori;
        this.skorePria = skorePria;
        this.skoreWanita = skoreWanita;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getSkorePria() {
        return skorePria;
    }

    public void setSkorePria(String skorePria) {
        this.skorePria = skorePria;
    }

    public String getSkoreWanita() {
        return skoreWanita;
    }

    public void setSkoreWanita(String skoreWanita) {
        this.skoreWanita = skoreWanita;
    }
}
