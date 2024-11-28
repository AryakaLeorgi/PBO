// Superclass Ticket
public class Ticket {
    protected String passengerName;
    protected String destination;
    protected double baseFare;

    public Ticket(String passengerName, String destination, double baseFare) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    public double calculateFare() {
        return baseFare;
    }

    public String getClassType() {
        return "Kelas Tidak Diketahui";
    }

    public String getFacilities() {
        return "Fasilitas standar.";
    }

    public void displayTicketInfo() {
        System.out.println("\n==== Informasi Tiket ====");
        System.out.println("Nama Penumpang: " + passengerName);
        System.out.println("Tujuan: " + destination);
        System.out.println("Jenis Kelas: " + getClassType());
        System.out.println("Harga Akhir: " + calculateFare());
        System.out.println("Fasilitas: " + getFacilities());
    }
}
