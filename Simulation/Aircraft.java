package Simulation;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    private String type;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }

    private long nextId() {
        return Aircraft.idCounter++;
    }

    public void announce(String message) {
        System.out.printf("%s: %s\n", this.toString(), message);
    }

    public String toString() {
        return String.format("%s#%s(%d)", this.type, this.name, this.id);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
