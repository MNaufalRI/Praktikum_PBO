import java.util.ArrayList;
import java.util.Scanner;

class Kategori {
    String namaKategori;
    Kategori(String namaKategori) { this.namaKategori = namaKategori; }
}

class Ruangan {
    String namaRuangan;
    int lantai;
    Ruangan(String namaRuangan, int lantai) { 
        this.namaRuangan = namaRuangan; 
        this.lantai = lantai; 
    }
}

class Relik {
    String nama;
    String bahan;
    String eraDinasti;
    Kategori kategori;
    Ruangan lokasi;

    Relik(String nama, String bahan, String eraDinasti, Kategori kategori, Ruangan lokasi) {
        this.nama = nama;
        this.bahan = bahan;
        this.eraDinasti = eraDinasti;
        this.kategori = kategori;
        this.lokasi = lokasi;
    }

    void tampilkanData(int indeks) {
        System.out.printf("| %-3d | %-21s | %-14s | %-23s | %-12s | %-15s |\n", 
            indeks, nama, bahan, eraDinasti, kategori.namaKategori, lokasi.namaRuangan);
    }
}

public class SistemMuseumMesir {
    private static ArrayList<Relik> daftarRelik = new ArrayList<>();
    private static ArrayList<Kategori> daftarKategori = new ArrayList<>();
    private static ArrayList<Ruangan> daftarRuangan = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static String[] daftarEra = {
        "Early Dynastic Period", 
        "Old Kingdom", 
        "Middle Kingdom", 
        "Late Period & Ptolemaic"
    };

    public static void main(String[] args) {
        daftarKategori.add(new Kategori("Pemakaman"));
        daftarKategori.add(new Kategori("Perhiasan"));
        daftarRuangan.add(new Ruangan("Hall of Kings", 1));
        daftarRuangan.add(new Ruangan("Gold Room", 2));

        int pilihan;
        do {
            System.out.println("\n--- SISTEM MANAJEMEN RELIK MESIR KUNO ---");
            System.out.println("1. Tambah Relik");
            System.out.println("2. Lihat Koleksi");
            System.out.println("3. Ubah Data Relik)");
            System.out.println("4. Hapus Relik");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1: tambahRelik(); break;
                case 2: lihatRelik(); break;
                case 3: ubahRelik(); break;
                case 4: hapusRelik(); break;
                case 5: System.out.println("Sistem telah dimatikan. Ma'assalamah!"); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tambahRelik() {
        System.out.println("\n[ TAMBAH DATA RELIK ]");
        System.out.print("Nama Relik       : "); String nama = input.nextLine();
        System.out.print("Bahan Utama      : "); String bahan = input.nextLine();
        
        System.out.println("\nPilih Era/Dinasti:");
        for (int i = 0; i < daftarEra.length; i++) {
            System.out.println((i+1) + ". " + daftarEra[i]);
        }
        System.out.print("Masukkan pilihan : ");
        int pilEra = input.nextInt() - 1;
        String eraTerpilih = daftarEra[pilEra];

        System.out.println("\nPilih Kategori \n1. " + daftarKategori.get(0).namaKategori + 
                           "\n2. " + daftarKategori.get(1).namaKategori);
        System.out.print("Masukkan pilihan : ");
        int idKat = input.nextInt() - 1;

        System.out.println("\nPilih Ruangan \n1. " + daftarRuangan.get(0).namaRuangan + 
                           "\n2. " + daftarRuangan.get(1).namaRuangan);
        System.out.print("Masukkan pilihan : ");
        int idRuang = input.nextInt() - 1;

        daftarRelik.add(new Relik(nama, bahan, eraTerpilih, daftarKategori.get(idKat), daftarRuangan.get(idRuang)));
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
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

    private static void ubahRelik() {
        System.out.println("\n[ UBAH DATA RELIK ]");
        lihatRelik();
        if (daftarRelik.isEmpty()) return;
        
        System.out.print("Masukkan ID Relik yang ingin diubah: ");
        int id = input.nextInt();
        input.nextLine(); 

        if (id >= 0 && id < daftarRelik.size()) {
            System.out.print("Nama Baru       : "); daftarRelik.get(id).nama = input.nextLine();
            System.out.print("Bahan Baru      : "); daftarRelik.get(id).bahan = input.nextLine();
            
            System.out.println("\nPilih Era Baru:");
            for (int i = 0; i < daftarEra.length; i++) {
                System.out.println((i+1) + ". " + daftarEra[i]);
            }
            System.out.print("Masukkan pilihan : ");
            int pilEra = input.nextInt() - 1;
            daftarRelik.get(id).eraDinasti = daftarEra[pilEra];
            
            System.out.println("\nPilih Kategori Baru \n1. " + daftarKategori.get(0).namaKategori + 
                               "\n2. " + daftarKategori.get(1).namaKategori);
            System.out.print("Masukkan pilihan : ");
            int idKat = input.nextInt() - 1;
            daftarRelik.get(id).kategori = daftarKategori.get(idKat);

            System.out.println("\nPilih Ruangan Baru \n1. " + daftarRuangan.get(0).namaRuangan + 
                               "\n2. " + daftarRuangan.get(1).namaRuangan);
            System.out.print("Masukkan pilihan : ");
            int idRuang = input.nextInt() - 1;
            daftarRelik.get(id).lokasi = daftarRuangan.get(idRuang);
            
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
        System.out.printf("| ID  | %-21s | %-14s | %-23s | %-12s | %-15s |\n", 
            "Nama Relik", "Bahan", "Era / Dinasti", "Kategori", "Lokasi");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
}