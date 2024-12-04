import java.util.ArrayList;
import java.util.Random;

public class Rabbit extends Animal {
    public Rabbit(Field field, int row, int col) {
        super(field, row, col);
    }

    @Override
    public void act() {
        ArrayList<int[]> adjacent = field.getAdjacent(row, col);
        Random rand = new Random();
        if (!adjacent.isEmpty()) {
            int[] newLocation = adjacent.get(rand.nextInt(adjacent.size()));
            int newRow = newLocation[0];
            int newCol = newLocation[1];
            if (field.getObjectAt(newRow, newCol) == null) {
                System.out.println("Rabbit at (" + row + ", " + col + ") moved to (" + newRow + ", " + newCol + ").");
                move(newRow, newCol);
            }
        }
    }
}
