package pattern.zad4;

import pattern.observator.Observable;
import pattern.observator.Observator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LoggingObserver implements Observator{


    private final static Path LOGGING_PATH = Paths.get("logger.log");
    @Override
    public void update(Object event) {
        try {
            String logMessage = event.toString() + System.lineSeparator();
            Files.write(LOGGING_PATH, logMessage.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
