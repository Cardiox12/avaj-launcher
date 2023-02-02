package Simulation;

import java.io.PrintWriter;

public class Logger {
    public static PrintWriter logger;

    static {
        try {
            logger = new PrintWriter(SimulationConstants.LOG_FILENAME);
        } catch (Exception e) {
            System.err.println("LoggerException: fail to open log file");
            System.exit(0);
        }
    }
}
