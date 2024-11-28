import java.util.Scanner;

public class ReservasiTiket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double baseFare = 0; // Inisialisasi awal harga dasar

        while (true) {
            System.out.println("\n==== Sistem Reservasi Penerbangan ====");
            System.out.println("1. Tiket Ekonomi");
            System.out.println("2. Tiket Bisnis");
            System.out.println("3. Tiket First Class");
            System.out.println("4. Atur Harga Dasar");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            if (choice == 5) {
                System.out.println("Terima kasih telah menggunakan sistem!");
                break;
            }

            if (choice == 4) {
                System.out.print("Masukkan harga dasar baru: ");
                baseFare = scanner.nextDouble();
                System.out.println("Harga dasar berhasil diatur.");

                // Menampilkan semua harga tiket setelah harga dasar diatur
                System.out.println("\n==== Harga Tiket Setelah Mengatur Harga Dasar ====");
                
                // Menampilkan harga tiket untuk semua jenis tiket
                Ticket economyTicket = new EconomyTicket("Penumpang", "Tujuan", baseFare);
                Ticket businessTicket = new BusinessTicket("Penumpang", "Tujuan", baseFare);
                Ticket firstClassTicket = new FirstClassTicket("Penumpang", "Tujuan", baseFare);

                System.out.println("Harga Tiket Ekonomi: " + economyTicket.calculateFare());
                System.out.println("Harga Tiket Bisnis: " + businessTicket.calculateFare());
                System.out.println("Harga Tiket First Class: " + firstClassTicket.calculateFare());
                continue; // Kembali ke menu utama setelah menampilkan harga tiket
            }

            if (baseFare <= 0) {
                System.out.println("Silakan atur harga dasar terlebih dahulu (opsi 4).");
                continue;
            }

            System.out.print("Masukkan nama penumpang: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan tujuan: ");
            String destination = scanner.nextLine();

            Ticket ticket = null;

            switch (choice) {
                case 1:
                    ticket = new EconomyTicket(name, destination, baseFare);
                    break;
                case 2:
                    ticket = new BusinessTicket(name, destination, baseFare);
                    break;
                case 3:
                    ticket = new FirstClassTicket(name, destination, baseFare);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    continue;
            }

            if (ticket != null) {
                ticket.displayTicketInfo();
                System.out.println("Harga tiket: " + ticket.calculateFare());
            }
        }

        scanner.close();
    }
}
