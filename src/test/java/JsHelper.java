import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.time.Duration;
import java.util.Random;

public class JsHelper extends SitePage {
    public JsHelper(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * метод выбора значения Select State
     */
    public JsHelper randomClickState() {
        //скролл страницы вниз до видимости поля Select State
        js.executeScript("arguments[0].scrollIntoView(true);", selectState);
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
    public JsHelper randomClickCity() {
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
    public JsHelper clickSubmit() {
        //уменьшение масштаба страницы для получения видимости кнопки Submit
        js.executeScript("document.body.style.zoom = '0.75'");
        //нажатие левой кнопкой мыши на кнопку Submit
        js.executeScript("arguments[0].click();", submit);
        //ожидание появления кнопки всплывающего окна Close (до 5 секунд)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //увеличение масштаба страницы после появления всплывающего окна с видимостью кнопки Close
        js.executeScript("document.body.style.zoom = '1'");
        return this;
    }
}