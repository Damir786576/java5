public class CustomExceptions {
    public static class WrongLoginException extends Exception {
        public WrongLoginException(String message) {
            super(message);
        }
    }

    public static class WrongPasswordException extends Exception {
        public WrongPasswordException(String message) {
            super(message);
        }
    }
}