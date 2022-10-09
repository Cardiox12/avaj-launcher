package Simulation;

import Simulation.Exceptions.ScenarioCoordinatesOutOfBoundException;
import Simulation.Exceptions.ScenarioInstructionException;
import Simulation.Exceptions.SimulationException;

public class Instruction {
    private static final String regex = "^(\\w*)(\\s+)(\\w{1}\\d+)(\\s+)(\\d+\\s+){2}(\\d+)$";
    private String type;
    private String name;
    private Coordinates coordinates;
    private String instruction;
    private InstructionChecker checker;

    public Instruction(String instruction) {
        this.instruction = instruction;
        this.checker = new InstructionChecker();

        this.checker.add("Baloon")
                    .add("Helicopter")
                    .add("JetPlane");
    }

    public void parseInstruction() throws SimulationException {
        if ( !this.isValid() ) {
            throw new ScenarioInstructionException();
        }
        String[] tokens = this.instruction.split("\\s");
        int longitude;
        int latitude;
        int height;

        this.type = new String(tokens[0]);
        this.name = new String(tokens[1]);
        longitude = Integer.parseInt(tokens[2]) % SimulationConstants.MAX_LONGITUDE;
        latitude = Integer.parseInt(tokens[3]) % SimulationConstants.MAX_LATITUDE;
        height = Integer.parseInt(tokens[4]);

        if ( height < 0 || height > SimulationConstants.MAX_HEIGHT ) {
            throw new ScenarioCoordinatesOutOfBoundException();
        }
        this.coordinates = new Coordinates(longitude, latitude, height);
    }

    public boolean isValid() {
        return this.checker.matches(instruction);
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String toString() {
        return String.format("Type=%s Name=%s (%d %d %d)", 
            this.type, 
            this.name, 
            this.coordinates.getLongitude(), 
            this.coordinates.getLatitude(), this.coordinates.getHeight()
        );
    }
}
