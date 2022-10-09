package Simulation.Exceptions;

public class ScenarioInstructionException extends SimulationException {
    public ScenarioInstructionException() {
        super("");
    }

    public ScenarioInstructionException(int line) {
        super(String.format("Instruction not valid at line %d", line));
    }
}
