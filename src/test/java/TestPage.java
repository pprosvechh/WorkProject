import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestPage {
    public static SitePage sitePage;
    public static JsHelper jsHelper;
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
        jsHelper = new JsHelper(driver);
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
    public void Test() {
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
      //  sitePage.loadFile();
        //выполнение шага 9
        sitePage.enterCurrentAddress();
        //выполнение шага 10
        jsHelper.randomClickState();
        //выполнение шага 11
        jsHelper.randomClickCity();
        //выполнение шага 12
        jsHelper.clickSubmit();
        //Проверка названия заголовка всплывающего окна
        Assertions.assertEquals(sitePage.modalExample.getText(), "Thanks for submitting the form");
        //Проверка табличного значения выбранного First Name и Last Name
        Assertions.assertNotEquals(sitePage.nameValue.getText(), null);
        //Проверка табличного значения выбранного Email
        Assertions.assertNotEquals(sitePage.emailValue.getText(), null);
        //Проверка табличного значения выбранного Gender
        Assertions.assertNotNull(sitePage.genderValue.getText());
        //Проверка табличного значения выбранного Mobile
        Assertions.assertNotEquals(sitePage.mobileValue.getText(), null);
        //Проверка табличного значения выбранной даты рождения
        Assertions.assertNotEquals(sitePage.dateOfBirthValue.getText(), null);
        //Проверка табличного значения выбранного Subjects
        Assertions.assertNotNull(sitePage.subjectsValue.getText());
        //Проверка табличного значения выбранного Hobbies (его в тесте не выбирали)
        Assertions.assertNotEquals(sitePage.hobbiesValue.getText(), null);
        //Проверка табличного значения имени загружаемого файла с расширением
        Assertions.assertNotEquals(sitePage.pictureNameValue.getText(), null);
        //Проверка табличного значения выбранного зCurrent Address
        Assertions.assertNotEquals(sitePage.currentAddressValue.getText(), null);
        //Проверка табличных значений выбранной страны и выбранного города
        Assertions.assertNotEquals(sitePage.stateAndCityValue.getText(), null);
    }

    @AfterAll
    public static void tearDown() {
        //выключаем тестовый драйвер
        driver.quit();
    }
}