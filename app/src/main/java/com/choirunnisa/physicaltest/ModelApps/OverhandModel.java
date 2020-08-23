package com.choirunnisa.physicaltest.ModelApps;

public class OverhandModel {
    private int no;
    private String kategori;
    private String skore;

    public OverhandModel(int no, String kategori, String skore) {
        this.no = no;
        this.kategori = kategori;
        this.skore = skore;
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

    public String getSkore() {
        return skore;
    }

    public void setSkore(String skore) {
        this.skore = skore;
    }

}
