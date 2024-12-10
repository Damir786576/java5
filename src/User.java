import java.util.regex.Pattern;

public class User {
    private static final int MAX_LENGTH = 20;
    private static final String VALID_CHARACTERS_REGEX = "^[a-zA-Z0-9_]+$";

    public static void validateCredentials(String login, String password, String confirmPassword)
            throws CustomExceptions.WrongLoginException, CustomExceptions.WrongPasswordException {

        validateLogin(login);
        validatePassword(password);
        validatePasswordMatch(password, confirmPassword);
    }

    private static void validateLogin(String login) throws CustomExceptions.WrongLoginException {
        if (isInvalid(login)) {
            throw new CustomExceptions.WrongLoginException("Неверный логин. " +
                    "Он должен состоять не более чем из 20 символов и содержать только латинские буквы," +
                    " цифры и символы подчеркивания.");
        }
    }

    private static void validatePassword(String password) throws CustomExceptions.WrongPasswordException {
        if (isInvalid(password)) {
            throw new CustomExceptions.WrongPasswordException("Неверный пароль. " +
                    "Он должен состоять не более чем из 20 символов и содержать только латинские буквы," +
                    " цифры и символы подчеркивания.");
        }
    }

    private static void validatePasswordMatch(String password, String confirmPassword) throws CustomExceptions.WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new CustomExceptions.WrongPasswordException("Пароли не совпадают");
        }
    }

    private static boolean isInvalid(String input) {
        return input == null || input.length() > MAX_LENGTH || !Pattern.matches(VALID_CHARACTERS_REGEX, input);
    }
}
