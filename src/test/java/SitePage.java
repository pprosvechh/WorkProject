import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    protected WebElement firstNameField;
    /**
     * определение локатора поля Last Name
     */
    @FindBy(css = "#lastName")
    protected WebElement lastNameField;
    /**
     * определение локатора поля Email
     */
    @FindBy(css = "#userEmail")
    protected WebElement userEmail;
    /**
     * определение локатора поля Mobile
     */
    @FindBy(id = "userNumber")
    protected WebElement userNumber;
    /**
     * определение локатора поля Subjects
     */
    @FindBy(id = "subjectsInput")
    protected WebElement subjects;
    /**
     * определение локатора поля Current Address
     */
    @FindBy(id = "currentAddress")
    protected WebElement currentAddress;
    /**
     * определение локатора поля Select State
     */
    @FindBy(xpath = "//*[@id=\"state\"]//div[@class=\" css-yk16xz-control\"]")
    protected WebElement selectState;
    /**
     * определение локатора поля Select City
     */
    @FindBy(xpath = "//*[@id=\"city\"]//div[@class=\" css-yk16xz-control\"]")
    protected WebElement selectCity;
    /**
     * определение локатора выпадающего поля выбора даты рождения
     */
    @FindBy(id = "dateOfBirthInput")
    protected WebElement dateOfBirth;
    /**
     * определение локатора кнопки Выберите файл
     */
    @FindBy(css = "#uploadPicture")
    protected WebElement loadButton;
    /**
     * определение локатора кнопки Submit
     */
    @FindBy(id = "submit")
    protected WebElement submit;
    /**
     * определение локатора дней для выбора даты рождения
     */
    @FindBy(xpath = "//div[@class=\"react-datepicker__month-container\"]")
    protected List<WebElement> days;
    /**
     * определение локатора месяцев для выбора даты рождения
     */
    @FindBy(xpath = "//select[@class=\"react-datepicker__month-select\"]/option")
    protected List<WebElement> months;
    /**
     * определение локатора годов для выбора даты рождения
     */
    @FindBy(xpath = "//select[@class=\"react-datepicker__year-select\"]/option")
    protected List<WebElement> years;
    /**
     * определение локатора городов для поля Select City
     */
    @FindBy(xpath = "//*[@id=\"city\"]//div[@class=\" css-26l3qy-menu\"]")
    protected List<WebElement> cities;
    /**
     * определение локатора стран для поля Select State
     */
    @FindBy(xpath = "//*[@id=\"state\"]//div[@class=\" css-26l3qy-menu\"]")
    protected List<WebElement> states;
    /**
     * определение локатора для переключателя Gender
     */
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]//label")
    protected List<WebElement> genders;
    /**
     * определение локатора для кнопки всплывающего окна Close
     */
    @FindBy(id = "closeLargeModal")
    protected WebElement close;
    /**
     * определение локатора названия заголовка всплывающего окна
     */
    @FindBy(id = "example-modal-sizes-title-lg")
    protected WebElement modalExample;
    /**
     * определение локатора всплывающего окна со значением First Name и Last Name
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(1) td:nth-child(2)")
    protected WebElement nameValue;
    /**
     * определение локатора всплывающего окна со значением Email
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(2) td:nth-child(2)")
    protected WebElement emailValue;
    /**
     * определение локатора всплывающего окна со значением Gender
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(3) td:nth-child(2)")
    protected WebElement genderValue;
    /**
     * определение локатора всплывающего окна со значением Mobile
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(4) td:nth-child(2)")
    protected WebElement mobileValue;
    /**
     * определение локатора всплывающего окна со значением даты рождения
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(5) td:nth-child(2)")
    protected WebElement dateOfBirthValue;
    /**
     * определение локатора всплывающего окна со значением Subjects
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(6) td:nth-child(2)")
    protected WebElement subjectsValue;
    /**
     * определение локатора всплывающего окна со значением Hobbies
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(7) td:nth-child(2)")
    protected WebElement hobbiesValue;
    /**
     * определение локатора всплывающего окна с названием загружаемого файла
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(8) td:nth-child(2)")
    protected WebElement pictureNameValue;
    /**
     * определение локатора всплывающего окна с текстом поля Current Address
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(9) td:nth-child(2)")
    protected WebElement currentAddressValue;
    /**
     * определение локатора всплывающего окна со значениями выбранной страны и выбранного города
     */
    @FindBy(css = "table[class=\"table table-dark table-striped table-bordered table-hover\"] tbody tr:nth-child(10) td:nth-child(2)")
    protected WebElement stateAndCityValue;
    /**
     * определение локатора со значением выбранной страны
     */
    @FindBy(css = "#state > div > div.css-1hwfws3 > div.css-1uccc91-singleValue")
    protected WebElement state;
    /**
     * определение локатора со значением выбранного города
     */
    @FindBy(css = "#city div:nth-child(1) div:nth-child(1) div:nth-child(1)")
    protected WebElement city;

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
}