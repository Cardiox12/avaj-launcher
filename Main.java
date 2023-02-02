import Simulation.Logger;
import Simulation.Simulation;
import Simulation.Exceptions.SimulationException;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        try {
            simulation.readScenario("scenario.txt");
            simulation.execute();
        } catch (SimulationException e) {
            System.out.println(e.toString());
        } finally {
            Logger.logger.close();
        }
    }
}