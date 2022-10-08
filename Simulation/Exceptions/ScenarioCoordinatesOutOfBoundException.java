package Simulation.Exceptions;

public class ScenarioCoordinatesOutOfBoundException extends SimulationException {
    public ScenarioCoordinatesOutOfBoundException() {
        super("Coordinate is out of bound");
    }
}
