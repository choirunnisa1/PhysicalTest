package com.choirunnisa.physicaltest.ModelApps;

public class Model {
   private String id, nama, jenis, jkel, input, hasil, waktu;

    public Model(String id, String nama, String jenis, String jkel, String input, String hasil, String waktu) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.jkel = jkel;
        this.input = input;
        this.hasil = hasil;
        this.waktu = waktu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJkel() {
        return jkel;
    }

    public void setJkel(String jkel) {
        this.jkel = jkel;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}