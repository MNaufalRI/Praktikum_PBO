package com.museum.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.museum.model.Kategori;
import com.museum.model.Papirus;
import com.museum.model.Patung;
import com.museum.model.Relik;
import com.museum.model.Ruangan;

public class SistemMuseumMesir {
    private static ArrayList<Relik> daftarRelik = new ArrayList<>();
    private static ArrayList<Kategori> daftarKategori = new ArrayList<>();
    private static ArrayList<Ruangan> daftarRuangan = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    
    private static String[] daftarEra = {
        "Early Dynastic Period", "Old Kingdom", "Middle Kingdom", "New Kingdom", "Late Period & Ptolemaic"
    };

    public static void main(String[] args) {
        daftarKategori.add(new Kategori("Pemakaman"));
        daftarKategori.add(new Kategori("Religius"));
        daftarKategori.add(new Kategori("Keseharian"));
        daftarKategori.add(new Kategori("Militer"));
        daftarRuangan.add(new Ruangan("Hall of Kings", 1));
        daftarRuangan.add(new Ruangan("Gold Room", 2));

        int pilihan;
        do {
            System.out.println("\n--- SISTEM MANAJEMEN RELIK MESIR KUNO ---");
            System.out.println("1. Tambah Relik\n2. Lihat Koleksi\n3. Ubah Data Relik\n4. Hapus Relik\n5. Keluar");
            System.out.print("Pilih Menu : ");
            pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1 -> tambahRelik();
                case 2 -> lihatRelik();
                case 3 -> ubahRelik();
                case 4 -> hapusRelik();
                case 5 -> System.out.println("Sistem telah dimatikan. Ma'assalamah!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tambahRelik() {
        System.out.println("\n[ TAMBAH DATA RELIK ]");
        System.out.println("Tipe Relik :\n1. Patung\n2. Papirus");
        System.out.print("Pilih Tipe : ");
        int tipe = input.nextInt(); 
        input.nextLine();

        System.out.print("Nama Relik : "); String nama = input.nextLine();
        System.out.print("Bahan Utama : "); String bahan = input.nextLine();
        
        System.out.println("\nPilih Era/Dinasti :");
        for (int i = 0; i < daftarEra.length; i++) System.out.println((i+1) + ". " + daftarEra[i]);
        System.out.print("Masukkan pilihan : ");
        int pilEra = input.nextInt() - 1;

        System.out.println("\nPilih Kategori :");
        for (int i = 0; i < daftarKategori.size(); i++) System.out.println((i+1) + ". " + daftarKategori.get(i).getNamaKategori());
        System.out.print("Masukkan pilihan : ");
        int idKat = input.nextInt() - 1;
        
        System.out.println("\nPilih Ruangan :");
        for (int i = 0; i < daftarRuangan.size(); i++) System.out.println((i+1) + ". " + daftarRuangan.get(i).getNamaRuangan());
        System.out.print("Masukkan pilihan : ");
        int idRuang = input.nextInt() - 1;
        input.nextLine();

        if (tipe == 1) {
            System.out.print("Tinggi Patung (cm) : ");
            double tinggi = input.nextDouble();
            daftarRelik.add(new Patung(nama, bahan, daftarEra[pilEra], daftarKategori.get(idKat), daftarRuangan.get(idRuang), tinggi));
        } else {
            System.out.print("Jenis Tulisan : ");
            String tulisan = input.nextLine();
            daftarRelik.add(new Papirus(nama, bahan, daftarEra[pilEra], daftarKategori.get(idKat), daftarRuangan.get(idRuang), tulisan));
        }
        
        System.out.println(">> Berhasil mendaftarkan '" + nama + "' ke dalam sistem.");
    }

    private static void lihatRelik() {
        if (daftarRelik.isEmpty()) {
            System.out.println("\n>> Database museum masih kosong.");
            return;
        }
        tampilkanHeader();
        for (int i = 0; i < daftarRelik.size(); i++) {
            daftarRelik.get(i).tampilkanData(i);
        }
    }

    private static void ubahRelik() {
        System.out.println("\n[ UBAH DATA RELIK ]");
        lihatRelik();
        if (daftarRelik.isEmpty()) return;
        
        System.out.print("Masukkan ID Relik yang ingin diubah: ");
        int id = input.nextInt();
        input.nextLine(); 

        if (id >= 0 && id < daftarRelik.size()) {
            Relik r = daftarRelik.get(id);
            System.out.print("Nama Baru : "); r.setNama(input.nextLine());
            System.out.print("Bahan Baru : "); r.setBahan(input.nextLine());
            
            System.out.println("\nPilih Era Baru :");
            for (int i = 0; i < daftarEra.length; i++) System.out.println((i+1) + ". " + daftarEra[i]);
            System.out.print("Masukkan Pilihan : ");
            r.setEraDinasti(daftarEra[input.nextInt() - 1]);
            
            System.out.println("\nPilih Kategori Baru :");
            for (int i = 0; i < daftarKategori.size(); i++) System.out.println((i+1) + ". " + daftarKategori.get(i).getNamaKategori());
            System.out.print("Masukkan Pilihan : ");
            r.setKategori(daftarKategori.get(input.nextInt() - 1));
            
            System.out.println("\nPilih Ruangan Baru :");
            for (int i = 0; i < daftarRuangan.size(); i++) System.out.println((i+1) + ". " + daftarRuangan.get(i).getNamaRuangan());
            System.out.print("Masukkan Pilihan : ");
            r.setLokasi(daftarRuangan.get(input.nextInt() - 1));
            input.nextLine();

            if (r instanceof Patung) {
                Patung p = (Patung) r; 
                System.out.print("Tinggi Baru (cm) : ");
                p.setTinggi(input.nextDouble());
                input.nextLine(); 
            } 
            else if (r instanceof Papirus) {
                Papirus pap = (Papirus) r; 
                System.out.print("Jenis Tulisan Baru : ");
                pap.setJenisTulisan(input.nextLine());
            }
            
            System.out.println(">> Data berhasil diperbarui.");
        } else {
            System.out.println(">> ID tidak ditemukan.");
        }
    }

    private static void hapusRelik() {
        System.out.println("\n[ HAPUS DATA RELIK ]");
        lihatRelik();
        if (daftarRelik.isEmpty()) return;
        System.out.print("Masukkan ID Relik yang ingin dihapus: ");
        int id = input.nextInt();
        if (id >= 0 && id < daftarRelik.size()) {
            daftarRelik.remove(id);
            System.out.println(">> Relik berhasil dihapus.");
        } else {
            System.out.println(">> ID tidak ditemukan.");
        }
    }

    private static void tampilkanHeader() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------------");
        System.out.printf("| ID  | %-21s | %-14s | %-23s | %-12s | %-15s |\n", "Nama Relik", "Bahan", "Era / Dinasti", "Kategori", "Lokasi");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
}