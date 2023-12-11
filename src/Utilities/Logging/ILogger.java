package Utilities.Logging;

public interface ILogger {
    /**
     * writes a log to the logs file
     * @param log: String message to be written to the log
     */
    void writeLog(String log);

    /**
     * writes error to the error file
     * @param stackTrace: String containing the stack trace of the error
     */
    void writeError(String stackTrace);
}
