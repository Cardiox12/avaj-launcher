package Simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

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

    public void execute(String path) throws SimulationException {
        File file = new File(path);
        String line;
        BufferedReader br = null;
        Instruction instruction;
        int line_number = 1;

        // TODO: Verify same id
        // TODO: verify height
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
}
