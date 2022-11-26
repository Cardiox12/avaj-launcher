package Simulation;

import java.util.HashSet;
import java.util.Set;

public class Tower {
    private Set<Flyable> observers;

    Tower() {
        this.observers = new HashSet<Flyable>();
    }

    public void register(Flyable flyable) {
        Aircraft aircraft = (Aircraft)flyable;

        this.announce(aircraft, "registered to weather tower");
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        this.announce((Aircraft)flyable, "unregistered from weather tower");
        this.observers.remove(flyable);
    }

    private void announce(Aircraft aircraft, String message) {
        System.out.printf("Tower says: %s %s\n", aircraft.toString(), message);
    }

    protected void conditionsChanged() {
        for ( Flyable flyable : this.observers ) {
            flyable.updateConditions();
        }
    }
}
