package Simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Simulation.Exceptions.ScenarioIOException;
import Simulation.Exceptions.ScenarioNotFoundException;
import Simulation.Exceptions.SimulationException;

public class Simulation {
    public void execute(String path) throws SimulationException {
        File file = new File(path);
        String line;

        try { 
            BufferedReader br = new BufferedReader(new FileReader(file));
    
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new ScenarioNotFoundException();
        } catch (IOException e) {
            throw new ScenarioIOException();
        }
    }
}
