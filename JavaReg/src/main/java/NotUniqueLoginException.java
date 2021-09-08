public class NotUniqueLoginException extends Exception{
    NotUniqueLoginException(String massage, String login) {
        super(massage + login);
    }
}
