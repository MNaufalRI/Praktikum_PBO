package com.museum.model;

public class Ruangan {
    private String namaRuangan;
    private int lantai;

    public Ruangan(String namaRuangan, int lantai) { 
        this.namaRuangan = namaRuangan; 
        this.lantai = lantai; 
    }

    public String getNamaRuangan() { 
        return namaRuangan; 
    }
    public void setNamaRuangan(String namaRuangan) { 
        this.namaRuangan = namaRuangan; 
    }
    public int getLantai() { 
        return lantai; 
    }
    public void setLantai(int lantai) { 
        this.lantai = lantai; 
    }
}