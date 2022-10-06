package Simulation;

import java.util.HashSet;
import java.util.Set;

public class Tower {
    private Set<Flyable> observers;

    Tower() {
        this.observers = new HashSet<Flyable>();
    }

    public void register(Flyable flyable) {
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for ( Flyable flyable : this.observers ) {
            flyable.updateConditions();
        }
    }
}
