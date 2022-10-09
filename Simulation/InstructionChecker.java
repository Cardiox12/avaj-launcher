package Simulation;

import java.util.Vector;

public class InstructionChecker {
    private Vector<String> aircrafts;

    public InstructionChecker() {
        this.aircrafts = new Vector<>();
    }

    public InstructionChecker add(String aircraft) {
        this.aircrafts.add(aircraft);
        return this;
    }

    private String getAircraftRegex() {
        String aircraftsChecker = String.join("|", this.aircrafts);

        return String.format("^(%s)(\\s+)(\\w{1}\\d+)(\\s+)(\\d+\\s+){2}(\\d+)$", aircraftsChecker);
    }

    public boolean matches(String s) {
        return s.matches(this.getAircraftRegex());
    }
}
