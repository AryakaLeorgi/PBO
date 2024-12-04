import java.util.ArrayList;

public class Simulator {
    private Field field;
    private ArrayList<Animal> animals;

    public Simulator(int rows, int cols) {
        field = new Field(rows, cols);
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public Field getField() {
        return field;
    }

    public void simulate(int steps) {
        for (int step = 1; step <= steps; step++) {
            System.out.println("Step " + step + ":");
            for (Animal animal : new ArrayList<>(animals)) {
                animal.act();
            }
            System.out.println();
        }
    }
}
