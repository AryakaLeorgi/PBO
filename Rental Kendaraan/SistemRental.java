import java.util.ArrayList;
import java.util.Scanner;

public class SistemRental {
    private static final ArrayList<Kendaraan> kendaraanTersedia = new ArrayList<>();
    private static final ArrayList<Penyewa> penyewaList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== Sistem Rental ===");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tambah Penyewa");
            System.out.println("3. Lihat Daftar Kendaraan");
            System.out.println("4. Lihat Daftar Penyewa");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            handleMenuSelection(pilihan);
        } while (pilihan != 5);
    }

    private static void handleMenuSelection(int pilihan) {
        switch (pilihan) {
            case 1 -> tambahKendaraan();
            case 2 -> tambahPenyewa();
            case 3 -> tampilkanKendaraanTersedia();
            case 4 -> tampilkanPenyewa();
            case 5 -> System.out.println("Terima kasih telah menggunakan sistem rental.");
            default -> System.out.println("Opsi tidak valid. Silakan coba lagi.");
        }
    }

    private static void tambahKendaraan() {
        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.println("3. Sepeda");
        System.out.print("Pilih opsi: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan merk: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan model: ");
        String model = scanner.nextLine();
        System.out.print("Masukkan tahun produksi: ");
        int tahunProduksi = scanner.nextInt();
        scanner.nextLine();
        switch (jenis) {
            case 1 -> {
                System.out.print("Masukkan jumlah roda: ");
                int jumlahRoda = scanner.nextInt();
                kendaraanTersedia.add(new Mobil(merk, model, tahunProduksi, jumlahRoda));
            }
            case 2 -> {
                System.out.print("Masukkan jumlah roda: ");
                int jumlahRoda = scanner.nextInt();
                kendaraanTersedia.add(new Motor(merk, model, tahunProduksi, jumlahRoda));
            }
            case 3 -> {
                System.out.print("Masukkan jenis sepeda (misalnya BMX, balap): ");
                String jenisSepeda = scanner.nextLine();
                kendaraanTersedia.add(new Sepeda(merk, model, tahunProduksi, jenisSepeda));
            }
            default -> System.out.println("Jenis kendaraan tidak valid.");
        }
        System.out.println("Kendaraan berhasil ditambahkan!");
    }

    private static void tambahPenyewa() {
        if (kendaraanTersedia.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang tersedia untuk disewa.");
            return;
        }
        System.out.print("Masukkan nama penyewa: ");
        String nama = scanner.nextLine();
        System.out.println("Pilih kendaraan yang ingin disewa:");
        for (int i = 0; i < kendaraanTersedia.size(); i++) {
            System.out.println((i + 1) + ". " + kendaraanTersedia.get(i).getInfo());
        }
        System.out.print("Pilih nomor kendaraan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        if (pilihan > 0 && pilihan <= kendaraanTersedia.size()) {
            Kendaraan kendaraanDipilih = kendaraanTersedia.get(pilihan - 1);
            penyewaList.add(new Penyewa(nama, kendaraanDipilih));
            System.out.println("Penyewa berhasil ditambahkan!");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private static void tampilkanKendaraanTersedia() {
        System.out.println("Daftar Kendaraan Tersedia:");
        if (kendaraanTersedia.isEmpty()) {
            System.out.println("Belum ada kendaraan yang tersedia.");
        } else {
            for (int i = 0; i < kendaraanTersedia.size(); i++) {
                System.out.println((i + 1) + ". " + kendaraanTersedia.get(i).getInfo());
            }
        }
    }

    private static void tampilkanPenyewa() {
        System.out.println("Daftar Penyewa:");
        if (penyewaList.isEmpty()) {
            System.out.println("Belum ada penyewa yang terdaftar.");
        } else {
            for (Penyewa penyewa : penyewaList) {
                System.out.println(penyewa.getDetailSewa());
            }
        }
    }
}
