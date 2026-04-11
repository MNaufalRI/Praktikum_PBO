package com.museum.model;

public class Patung extends Relik {
    private double tinggi;

    public Patung(String nama, String bahan, String eraDinasti, Kategori kategori, Ruangan lokasi, double tinggi) {
        super(nama, bahan, eraDinasti, kategori, lokasi);
        this.tinggi = tinggi;
    }

    public double getTinggi() { return tinggi; }
    public void setTinggi(double tinggi) { this.tinggi = tinggi; }

    @Override
    public String getInfoDetail() {
        return String.format("Tinggi Patung : %.1f cm", tinggi);
    }

    @Override
    public void tampilkanData(int indeks) {
        System.out.printf("| %-3d | %-21s | %-14s | %-23s | %-12s | %-15s |\n",
            indeks, nama, bahan, getEraDinasti(), getKategori().getNamaKategori(), getLokasi().getNamaRuangan());
        cetakGaris();
        System.out.printf("| %-3s |%-98s |\n", "   ", " Info Tambahan >> " + getInfoDetail());
        String kategoriUkuran;
        if (tinggi < 30) {
            kategoriUkuran = "Miniatur";
        } else if (tinggi < 100) {
            kategoriUkuran = "Kecil";
        } else if (tinggi < 300) {
            kategoriUkuran = "Sedang";
        } else {
            kategoriUkuran = "Monumental";
        }
        System.out.printf("| %-3s |%-98s |%n", "   ",
            String.format(" Kategori Ukuran >> %s (%.1f cm)", kategoriUkuran, tinggi));
        cetakGaris();
    }

    @Override
    public String toString() {
        return String.format("[Patung] %s | Bahan: %s | Tinggi: %.1f cm | Era: %s | Lokasi: %s",
            nama, bahan, tinggi, getEraDinasti(), getLokasi().getNamaRuangan());
    }
}