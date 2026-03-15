package com.museum.model;

public class Relik {
    protected String nama;        
    protected String bahan;       
    private String eraDinasti;    
    private Kategori kategori;
    private Ruangan lokasi;

    public Relik(String nama, String bahan, String eraDinasti, Kategori kategori, Ruangan lokasi) {
        this.nama = nama;
        this.bahan = bahan;
        this.eraDinasti = eraDinasti;
        this.kategori = kategori;
        this.lokasi = lokasi;
    }

    public String getNama() { 
        return nama; 
    }
    public void setNama(String nama) { 
        this.nama = nama; 
    }
    public String getBahan() { 
        return bahan; 
    }
    public void setBahan(String bahan) { 
        this.bahan = bahan; 
    }
    public String getEraDinasti() { 
        return eraDinasti; 
    }
    public void setEraDinasti(String eraDinasti) { 
        this.eraDinasti = eraDinasti; 
    }
    public Kategori getKategori() { 
        return kategori; 
    }
    public void setKategori(Kategori kategori) { 
        this.kategori = kategori; 
    }
    public Ruangan getLokasi() { 
        return lokasi; 
    }
    public void setLokasi(Ruangan lokasi) { 
        this.lokasi = lokasi; 
    }

    public void tampilkanData(int indeks) {
        System.out.printf("| %-3d | %-21s | %-14s | %-23s | %-12s | %-15s |\n", 
            indeks, nama, bahan, eraDinasti, kategori.getNamaKategori(), lokasi.getNamaRuangan());
    }
}