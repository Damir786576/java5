public class Main {
    public static void main(String[] args) {
        testValidation("java_skypro", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        testValidation("this_login_longgggggggggggg", "12345", "12345");
        testValidation("valid_login1", "Invalid@Password", "Invalid@Password");
        testValidation("valid_login2", "0", "1");
    }

    private static void testValidation(String login, String password, String confirmPassword) {
        try {
            User.validateCredentials(login, password, confirmPassword);
            System.out.println("Проверка прошла успешно: " + login);
        } catch (CustomExceptions.WrongLoginException | CustomExceptions.WrongPasswordException e) {
            System.out.println("Проверка не прошла: " + e.getMessage());
        }
    }
}

