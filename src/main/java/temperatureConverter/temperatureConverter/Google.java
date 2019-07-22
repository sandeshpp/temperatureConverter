package temperatureConverter.temperatureConverter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ripon on 11/28/2015.
 */
public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver){
        this.driver = driver;
        baseURL = "https://www.google.com/";
        driver.get(baseURL);
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("Google")){
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }
    public TemperatureConverterPage goToTemperatureConversionPage(){
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("from fahrenheit to celsius");
        driver.findElement(By.name("btnK")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new TemperatureConverterPage(driver);
    }
}
