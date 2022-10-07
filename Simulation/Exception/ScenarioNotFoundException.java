package Simulation.Exception;

public class ScenarioNotFoundException extends SimulationException {
    public ScenarioNotFoundException() {
        super("Scenario file not found!");
    }
}
