package com.museum.model;

public class Papirus extends Relik {
    private String jenisTulisan;

    public Papirus(String nama, String bahan, String eraDinasti, Kategori kategori, Ruangan lokasi, String jenisTulisan) {
        super(nama, bahan, eraDinasti, kategori, lokasi);
        this.jenisTulisan = jenisTulisan;
    }

    public String getJenisTulisan() { return jenisTulisan; }
    public void setJenisTulisan(String jenisTulisan) { this.jenisTulisan = jenisTulisan; }

    @Override
    public String getInfoDetail() {
        return "Jenis Tulisan : " + jenisTulisan;
    }

    @Override
    public void tampilkanData(int indeks) {
        System.out.printf("| %-3d | %-21s | %-14s | %-23s | %-12s | %-15s |\n",
            indeks, nama, bahan, getEraDinasti(), getKategori().getNamaKategori(), getLokasi().getNamaRuangan());
        cetakGaris();
        System.out.printf("| %-3s |%-98s |\n", "   ", " Info Tambahan >> " + getInfoDetail());
        String klasifikasi;
        String tulisanLower = jenisTulisan.toLowerCase();
        if (tulisanLower.contains("hieroglyph") || tulisanLower.contains("hieroglif")) {
            klasifikasi = "Tulisan Sakral (Hieroglif)";
        } else if (tulisanLower.contains("hieratic") || tulisanLower.contains("hieratik")) {
            klasifikasi = "Tulisan Administratif (Hieratik)";
        } else if (tulisanLower.contains("demotic") || tulisanLower.contains("demotik")) {
            klasifikasi = "Tulisan Rakyat (Demotik)";
        } else if (tulisanLower.contains("koptik") || tulisanLower.contains("coptic")) {
            klasifikasi = "Tulisan Koptik";
        } else {
            klasifikasi = "Sistem Tulisan Lainnya";
        }
        System.out.printf("| %-3s |%-98s |%n", "   ",
            String.format(" Sistem Tulisan   >> %s", klasifikasi));
        cetakGaris();
    }

    @Override
    public String toString() {
        return String.format("[Papirus] %s | Bahan: %s | Tulisan: %s | Era: %s | Lokasi: %s",
            nama, bahan, jenisTulisan, getEraDinasti(), getLokasi().getNamaRuangan());
    }
}