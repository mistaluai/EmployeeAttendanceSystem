package Utilities.Logging;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements ILogger{

    private final Date date = new Date();
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /**
     * Writes a log entry to the "Logs.log" file with the specified log message.
     * The log entry includes the timestamp of when the log was written.
     *
     * @param log: String message to be written to the log
     * @throws RuntimeException If an IOException occurs while writing the log.
     */
    @Override
    public void writeLog(String log) {
        try {
            FileWriter fw = new FileWriter("Logs.log", true);

            fw.write("On " + SDF.format(date.getTime()) + ": " + log + '\n');

            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes an error entry to the "Logs.log" file with the specified stack trace.
     * The error entry includes a timestamp and a formatted error message.
     *
     * @param stackTrace The stack trace of the error to be written.
     * @throws RuntimeException If an IOException occurs while writing the error.
     */
    @Override
    public void writeError(String stackTrace) {
        try {
            FileWriter fw = new FileWriter("Logs.log", true);

            fw.write('\n' + "-------------------------------------------------------------------------------------------------------------------" + '\n');
            fw.write("On " + SDF.format(date.getTime()) + ": The program failed to preform an action with The Error:" + '\n' + stackTrace  + '\n');
            fw.write("-------------------------------------------------------------------------------------------------------------------" + '\n' + '\n');


            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
