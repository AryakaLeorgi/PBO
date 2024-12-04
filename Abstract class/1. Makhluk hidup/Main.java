public class Main {
    public static void main(String[] args) {
        MakhlukHidup manusia = new Manusia();
        MakhlukHidup hewan = new Hewan();
        MakhlukHidup tumbuhan = new Tumbuhan();

        System.out.println("=== Manusia ===");
        manusia.makan();
        manusia.bernafas();
        manusia.berkembangBiak();

        System.out.println("\n=== Hewan ===");
        hewan.makan();
        hewan.bernafas();
        hewan.berkembangBiak();

        System.out.println("\n=== Tumbuhan ===");
        tumbuhan.makan();
        tumbuhan.bernafas();
        tumbuhan.berkembangBiak();
    }
}
