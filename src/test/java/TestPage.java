import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class TestPage {
    public static SitePage sitePage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        sitePage = new SitePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 5 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("page"));

    }

    @Test
    @Owner("Alexander L.")
    @Description("Filling out the registration form")
    public void Test() throws AWTException {
        //выполнение шага 1
        sitePage.enterFirstNameField();
        //выполнение шага 2
        sitePage.enterLastNameField();
        //выполнение шага 3
        sitePage.enterUserEmail();
        //выполнение шага 4
        sitePage.randomClickGender();
        //выполнение шага 5
        sitePage.enterMobileNumber();
        //выполнение шага 6
        sitePage.clickDateOfBirth();
        sitePage.randomClickMonth();
        sitePage.randomClickYear();
        sitePage.randomClickDay();
        //выполнение шага 7
        sitePage.enterSubjectsField();
        //выполнение шага 8
        sitePage.loadFile();
        //выполнение шага 9
        sitePage.enterCurrentAddress();
        //выполнение шага 10
        sitePage.randomClickState();
        //выполнение шага 11
        sitePage.randomClickCity();
        //выполнение шага 12
        sitePage.clickSubmit();
    }

    @AfterAll
    public static void tearDown() {
        //выключаем тестовый драйвер
        driver.quit();
    }
}



