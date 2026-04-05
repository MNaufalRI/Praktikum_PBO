package com.museum.model;

public class Papirus extends Relik {
    private String jenisTulisan; 

    public Papirus(String nama, String bahan, String eraDinasti, Kategori kategori, Ruangan lokasi, String jenisTulisan) {
        super(nama, bahan, eraDinasti, kategori, lokasi);
        this.jenisTulisan = jenisTulisan;
    }

    public void setJenisTulisan(String jenisTulisan) {
        this.jenisTulisan = jenisTulisan;
    }

    @Override
    public String getInfoDetail() {
        return "Jenis Tulisan : " + jenisTulisan;
    }
}