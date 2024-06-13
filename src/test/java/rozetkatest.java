import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class rozetkatest {
    private  WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test

    public void searchElement () {

        driver.get("https://www.rozetka.com.ua");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        WebElement notebooks = driver.findElement(By.name("search"));
        notebooks.click();
        notebooks.sendKeys("iphone");
        WebElement findButton = driver.findElement(By.xpath("/html/body/rz-app-root/div/div/rz-header/rz-main-header/header/div/div/div/rz-search-suggest/form/button"));
        findButton.click();


    }



}

