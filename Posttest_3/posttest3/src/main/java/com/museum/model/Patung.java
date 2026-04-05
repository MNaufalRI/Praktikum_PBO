package com.museum.model;

public class Patung extends Relik {
    private double tinggi; 

    public Patung(String nama, String bahan, String eraDinasti, Kategori kategori, Ruangan lokasi, double tinggi) {
        super(nama, bahan, eraDinasti, kategori, lokasi); 
        this.tinggi = tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;}

    @Override
    public String getInfoDetail() {
        return "Tinggi Patung : " + tinggi + " cm";
    }
}