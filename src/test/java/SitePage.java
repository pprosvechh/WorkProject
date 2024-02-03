import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SitePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public SitePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля First Name
     */
    @FindBy(css = "#firstName")
    private WebElement firstNameField;
    /**
     * определение локатора поля Last Name
     */
    @FindBy(css = "#lastName")
    private WebElement lastNameField;

    /**
     * определение локатора поля Email
     */
    @FindBy(css = "#userEmail")
    private WebElement userEmail;

    /**
     * определение локатора поля Mobile
     */
    @FindBy(id = "userNumber")
    private WebElement userNumber;
    /**
     * определение локатора поля Subjects
     */
    @FindBy(id = "subjectsInput")
    private WebElement subjects;

    /**
     * определение локатора поля Current Address
     */
    @FindBy(id = "currentAddress")
    private WebElement currentAddress;
    /**
     * определение локатора поля Select State
     */
    @FindBy(xpath = "//*[@id=\"state\"]//div[@class=\" css-yk16xz-control\"]")
    private WebElement selectState;
    /**
     * определение локатора поля Select City
     */
    @FindBy(xpath = "//*[@id=\"city\"]//div[@class=\" css-yk16xz-control\"]")
    private WebElement selectCity;
    /**
     * определение локатора выпадающего поля выбора даты рождения
     */
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;
    /**
     * определение локатора кнопки Выберите файл
     */
    @FindBy(css = "#uploadPicture")
    private WebElement loadButton;
    /**
     * определение локатора кнопки Submit
     */
    @FindBy(id = "submit")
    private WebElement submit;
    /**
     * определение локатора дней для выбора даты рождения
     */
    @FindBy(xpath = "//div[@class=\"react-datepicker__month-container\"]")
    private List<WebElement> days;
    /**
     * определение локатора месяцев для выбора даты рождения
     */
    @FindBy(xpath = "//select[@class=\"react-datepicker__month-select\"]/option")
    private List<WebElement> months;
    /**
     * определение локатора годов для выбора даты рождения
     */
    @FindBy(xpath = "//select[@class=\"react-datepicker__year-select\"]/option")
    private List<WebElement> years;
    /**
     * определение локатора городов для поля Select City
     */
    @FindBy(xpath = "//*[@id=\"city\"]//div[@class=\" css-26l3qy-menu\"]")
    private List<WebElement> cities;
    /**
     * определение локатора стран для поля Select State
     */
    @FindBy(xpath = "//*[@id=\"state\"]//div[@class=\" css-26l3qy-menu\"]")
    private List<WebElement> states;
    /**
     * определение локатора для переключателя Gender
     */
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]//label")
    private List<WebElement> genders;

    /**
     * метод ввода First Name (10 букв и/или цифр)
     */
    public SitePage enterFirstNameField() {
        firstNameField.sendKeys(RandomStringUtils.randomAlphanumeric(10));
        return this;
    }

    /**
     * метод ввода Last Name (10 букв и/или цифр)
     */
    public SitePage enterLastNameField() {
        lastNameField.sendKeys(RandomStringUtils.randomAlphanumeric(10));
        return this;
    }

    /**
     * метод ввода Email (4 буквы и/или цифры, после которых @example.com)
     */
    public SitePage enterUserEmail() {
        userEmail.sendKeys(RandomStringUtils.randomAlphanumeric(4) + "@example.com");
        return this;
    }

    /**
     * метод выбора случайного переключателя Gender
     */
    public SitePage randomClickGender() {
        int indexOfRandomGender = new Random().ints(0, genders.size())
                .findFirst()
                .getAsInt();
        genders.get(indexOfRandomGender).click();
        return this;
    }

    /**
     * метод ввода Mobile (10 цифр)
     */
    public SitePage enterMobileNumber() {
        userNumber.sendKeys(RandomStringUtils.randomNumeric(10));
        return this;
    }

    /**
     * метод нажатия левой кнопкой мыши на Date of Birth
     */
    public SitePage clickDateOfBirth() {
        dateOfBirth.click();
        return this;
    }

    /**
     * метод выбора месяца даты рождения
     */
    public SitePage randomClickMonth() {
        int indexOfRandomMonth = new Random().ints(0, months.size())
                .findFirst()
                .getAsInt();
        months.get(indexOfRandomMonth).click();
        return this;
    }

    /**
     * метод выбора года даты рождения
     */
    public SitePage randomClickYear() {
        int indexOfRandomYear = new Random().ints(0, years.size())
                .findFirst()
                .getAsInt();
        years.get(indexOfRandomYear).click();
        return this;
    }

    /**
     * метод выбора дня даты рождения
     */
    public SitePage randomClickDay() {
        int indexOfRandomDay = new Random().ints(0, days.size())
                .findFirst()
                .getAsInt();
        days.get(indexOfRandomDay).click();
        return this;
    }

    /**
     * метод ввода Subjects (50 букв и/или цифр)
     */
    public SitePage enterSubjectsField() {
        subjects.sendKeys(RandomStringUtils.randomAlphanumeric(50));
        return this;
    }

    /**
     * метод загрузки изображения в поле Picture
     */
    public SitePage loadFile() {
        //определение пути до изображения
        loadButton.sendKeys(ConfProperties.getProperty("picture"));
        return this;
    }

    /**
     * метод ввода Current Address (50 букв и/или цифр)
     */
    public SitePage enterCurrentAddress() {
        currentAddress.sendKeys(RandomStringUtils.randomAlphanumeric(50));
        return this;
    }

    /**
     * метод выбора значения Select State
     */
    public SitePage randomClickState() {
        //скролл страницы вниз до видимости поля Select State
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectState);
        selectState.click();
        int indexOfRandomState = new Random().ints(0, states.size())
                .findFirst()
                .getAsInt();
        states.get(indexOfRandomState).click();
        return this;
    }

    /**
     * метод выбора значения Select City
     */
    public SitePage randomClickCity() {
        //скролл страницы вниз до видимости поля Select City
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectCity);
        selectCity.click();
        int indexOfRandomCity = new Random().ints(0, cities.size())
                .findFirst()
                .getAsInt();
        cities.get(indexOfRandomCity).click();
        return this;
    }

    /**
     * метод нажатия левой кнопкой мыши на кнопку Submit
     */
    public SitePage clickSubmit() throws AWTException {
        Robot robot = new Robot();
        //уменьшение масштаба страницы для получения видимости кнопки Submit
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        //нажатие левой кнопкой мыши на кнопку Submit
        submit.click();
        //ожидание появления кнопки всплывающего окна Close (до 10 секунд)
        WebElement close = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"closeLargeModal\"]")));
        //увеличение масштаба страницы после появления всплывающего окна с видимостью кнопки Close
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        return this;
    }

}

