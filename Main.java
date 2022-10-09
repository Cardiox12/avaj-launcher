import java.io.IOException;

import Simulation.Simulation;
import Simulation.Exceptions.SimulationException;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        try {
            simulation.readScenario("scenario.txt");
        } catch (SimulationException e) {
            System.out.println(e.toString());
        }
    }
}