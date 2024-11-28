// Subclass FirstClassTicket
public class FirstClassTicket extends Ticket {

    public FirstClassTicket(String passengerName, String destination, double baseFare) {
        super(passengerName, destination, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.5; // Tambahan biaya 50%
    }

    @Override
    public String getClassType() {
        return "First Class";
    }

    @Override
    public String getFacilities() {
        return "Hiburan eksklusif, makanan minuman premium, kursi bisa diubah menjadi datar, wi-fi tanpa batas";
    }
}