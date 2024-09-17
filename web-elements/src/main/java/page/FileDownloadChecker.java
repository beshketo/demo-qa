package page;

import java.io.File;

public class FileDownloadChecker {
    public boolean checkDownloadedFile() {
        // Вкажіть шлях до папки завантажень
        String downloadPath = System.getProperty("user.home") + "/Downloads/";

        // Назва файлу, який ви очікуєте
        String expectedFileName = "sampleFile.jpeg";

        // Створюємо об'єкт File для перевірки існування файлу
        File file = new File(downloadPath + expectedFileName);

        boolean result;

        if (file.exists()) {
             result = true;
        } else {
             result = false;
        }

        return result;
    }
}

