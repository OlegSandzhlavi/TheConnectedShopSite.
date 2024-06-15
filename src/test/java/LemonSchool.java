import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class LemonSchool {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void open() {
        driver.get("https://lemon.school/");
        String expectedTitle = "IT курси Київ, ІТ освіта з працевлаштуванням в Києві, АйТі навчання з нуля в школі LemonSchool";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle);

        WebElement element = driver.findElement(By.cssSelector("#courses"));
        driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/nav/ul/li[1]/a")).click();

    }


    @Test
    public void check() {

        driver.get("https://lemon.school/");

        WebElement courses = driver.findElement(By.xpath("//*[@id=\"courses_0\"]/div/div/div[6]/div[1]/a"));
        courses.click();
    }






    }





