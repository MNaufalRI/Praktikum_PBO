Laporan ini mendokumentasikan pengembangan aplikasi manajemen inventaris museum digital berbasis Java yang menggunakan prinsip Object-Oriented Programming (OOP) dan struktur data ArrayList.

1. Analisis Program
Deskripsi Singkat
Program ini dirancang untuk mengelola data artefak sejarah di The Egyptian Museum. Sistem memungkinkan kurator museum untuk menambah, melihat, memperbarui, dan menghapus data relik dengan klasifikasi yang terorganisir berdasarkan Era, Kategori, dan Ruangan.

Struktur Kelas (OOP)
Untuk memenuhi standar pengembangan perangkat lunak, program ini menggunakan tiga kelas utama yang saling berelasi:

    a. Kelas Relik (Utama): Menyimpan atribut inti artefak (Nama, Bahan, Era).

    b. Kelas Kategori: Mengelompokkan relik (contoh: Pemakaman, Perhiasan).

    c. Kelas Ruangan: Menentukan lokasi fisik penyimpanan relik di dalam museum (contoh: Hall of Kings, Lantai 1).

2. Implementasi CRUD & Dokumentasi Output
Berikut adalah penjelasan dan visualisasi alur kerja program:

A. Menu Utama
Saat program dijalankan, pengguna akan disuguhkan menu interaktif yang berjalan di dalam looping do-while.

B. Create (Tambah Data)
Fitur ini menggunakan metode .add() dari ArrayList untuk memasukkan objek Relik baru.

C. Read (Lihat Koleksi)
Program menampilkan seluruh data dalam bentuk tabel yang rapi menggunakan System.out.printf().

D. Update (Ubah Data)
Fitur ini memungkinkan perubahan pada seluruh atribut relik berdasarkan ID indeksnya.

E. Delete (Hapus Data)
Menggunakan metode .remove(id) untuk menghapus data dari memori ArrayList.

3. Kesimpulan
Program ini berhasil menerapkan prinsip dasar manajemen data dengan struktur yang modular. Penggunaan referensi objek antar kelas (Relik memanggil Kategori dan Ruangan) menunjukkan pemahaman konsep Enkapsulasi dan Relasi Objek dalam bahasa pemrograman Java.

Cara Menggunakan README ini:
Buka aplikasi editor teks atau VS Code.

    1. Simpan teks di atas dengan nama file README.md.
    2. Jalankan program Java-mu, lalu ambil screenshot pada setiap tahap CRUD.
    3. Masukkan gambar tersebut ke dalam folder yang sama dan sesuaikan tautan gambarnya.
