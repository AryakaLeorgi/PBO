import java.util.List;

public class Fox extends Animal {
    public Fox(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }

            // Mencari makanan (misalnya, kelinci)
            Location foodLocation = findFood();
            if (foodLocation != null) {
                setLocation(foodLocation);
            }
        }
    }

    // Metode untuk mencari makanan (kelinci)
    private Location findFood() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        for (Location loc : adjacent) {
            Object animal = getField().getObjectAt(loc);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                rabbit.setDead();  // Kelinci mati setelah dimakan
                return loc;
            }
        }
        return null;
    }
}

