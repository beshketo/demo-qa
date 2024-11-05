package page;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    // URL сторінки реєстрації
    private final String REGISTER_PAGE_URL = "https://demoqa.com/register";

    // Відкриваємо сторінку реєстрації
    public void openPage() {
        open(REGISTER_PAGE_URL);  // Метод Selenide для відкриття сторінки
    }

    // Заповнюємо форму реєстрації
    public void fillOutForm(String firstName, String lastName, String userName, String password) {
        $("#firstname").setValue(firstName);  // Вводимо ім'я
        $("#lastname").setValue(lastName);  // Вводимо прізвище
        $("#userName").setValue(userName);  // Вводимо ім'я користувача
        $("#password").setValue(password);  // Вводимо пароль
    }

    // Встановлюємо чекбокс reCAPTCHA
    public void solveCaptcha() {
        $("#recaptcha-anchor").click();  // Вибираємо капчу
    }

    // Натискаємо кнопку "Register"
    public void submitForm() {
        $("#register").click();  // Натискаємо кнопку реєстрації
    }
}
