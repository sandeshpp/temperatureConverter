package temperatureConverter.temperatureConverter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ripon on 11/28/2015.
 */
public class TemperatureConverterPage {
    private WebDriver driver;
    public TemperatureConverterPage(WebDriver driver){
        this.driver = driver;
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("from fahrenheit to celsius - Google Search")){
            throw new WrongPageException("Incorrect page for Temperature Conversion page");
        }
    }
    public void inputFahrenheit(double valueOfFahrenheit) throws InterruptedException{
        String s = Double.toString(valueOfFahrenheit);
        driver.findElement(By.xpath(".//*[@id=\"HG5Seb\"]/input")).clear();////*[@id="HG5Seb"]/input
        driver.findElement(By.xpath(".//*[@id=\"HG5Seb\"]/input")).sendKeys(s);
        Thread.sleep(2000);
    }
    public String actualResult(){
        String valueOfCelsius = driver.findElement(By.xpath(".//*[@id=\"NotFQb\"]/input")).getAttribute("value");////*[@id="NotFQb"]/input
        System.out.println(valueOfCelsius);
        return valueOfCelsius;
    }
    public String expectedResult(){
        return "37";
    }
}
