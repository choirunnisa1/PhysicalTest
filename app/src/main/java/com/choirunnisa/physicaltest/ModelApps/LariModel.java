package com.choirunnisa.physicaltest.ModelApps;

public class LariModel {
    private int no;
    private String Angka;
    private String Kategori;

    public LariModel(int no, String angka, String kategori) {
        this.no = no;
        Angka = angka;
        Kategori = kategori;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAngka() {
        return Angka;
    }

    public void setAngka(String angka) {
        Angka = angka;
    }

    public String getKategori() {
        return Kategori;
    }

    public void setKategori(String kategori) {
        Kategori = kategori;
    }

}
