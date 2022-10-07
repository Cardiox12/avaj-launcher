package Simulation.Exceptions;

public class ScenarioNotFoundException extends SimulationException {
    public ScenarioNotFoundException() {
        super("Scenario not found");
    }
}
