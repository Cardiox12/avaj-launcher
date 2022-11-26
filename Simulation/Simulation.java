package Simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

// import Simulation.Aircraft.Aircraft;
// import Simulation.Aircraft.Flyable;
import Simulation.Exceptions.ScenarioIOException;
import Simulation.Exceptions.ScenarioInstructionException;
import Simulation.Exceptions.ScenarioIterationNotValid;
import Simulation.Exceptions.ScenarioNotFoundException;
import Simulation.Exceptions.SimulationException;

public class Simulation {
    private int iterations;
    private Vector<Instruction> instructions;

    public Simulation() {
        this.iterations = 0;
        this.instructions = new Vector<Instruction>();
    }

    public void readScenario(String path) throws SimulationException {
        File file = new File(path);
        String line;
        BufferedReader br = null;
        Instruction instruction;
        int line_number = 1;

        try { 
            br = new BufferedReader(new FileReader(file));
    
            line = br.readLine();
            if ( !line.matches("^\\d*$") ){
                throw new ScenarioIterationNotValid();
            }
            this.iterations = Integer.parseInt(line);
            line_number++;

            while ((line = br.readLine()) != null) {
                instruction = new Instruction(line);
                instruction.parseInstruction();
                this.instructions.add(instruction);
                ++line_number;
            }
        } catch (FileNotFoundException e) {
            throw new ScenarioNotFoundException();
        } catch (IOException e) {
            throw new ScenarioIOException();
        } catch (ScenarioInstructionException e) {
            throw new ScenarioInstructionException(line_number);
        } finally {
            try {
                if ( br != null ) {
                    br.close();
                }
            } catch (IOException e){
                throw new ScenarioIOException();
            }
        }
    }

    public void execute() {
        AircraftFactory factory = new AircraftFactory();
        WeatherTower tower = new WeatherTower();
        Flyable flyable;

        for ( Instruction instruction : this.instructions ) {
            Coordinates coordinates = instruction.getCoordinates();
            
            flyable = factory.newAircraft(
                instruction.getType(), 
                instruction.getName(), 
                coordinates.getLongitude(), 
                coordinates.getLatitude(), 
                coordinates.getHeight()
            );
            flyable.registerTower(tower);
            tower.register(flyable);
        }
        for ( int i = 0 ; i < this.iterations ; ++i ) {
            tower.conditionsChanged();
        }
    }

    public void show() {
        for ( Instruction instruction : this.instructions ) {
            System.out.println(instruction);
        }
    }
}
