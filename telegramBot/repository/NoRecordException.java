package telegramBot.repository;

public class NoRecordException extends RuntimeException {

    public NoRecordException(int id) {
        super("No record with such ID: " + id);
    }

}