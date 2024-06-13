import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class openSite {
    private WebDriver driver;
    @Before
    public void setup () {
        driver= new ChromeDriver( );
        driver.manage().window().maximize();



    }
@Test

    public void checkTitle ()
{
    driver.get("https://theconnectedshop.com/" );

    String expectedTitle = "The Connected Shop - Smart Locks, Smart Sensors, Smart Home & Office";
    String actualTitle = driver.getTitle();
    assertEquals(actualTitle,expectedTitle);
    WebElement element = driver.findElement(By.id("shopify-section-popup"));
    WebElement element1 = driver.findElement(By.className("NewsletterPopup"));

}
@Test

public void checkUrl () {
    driver.get("https://theconnectedshop.com/" );
        String expectedUrl = "https://theconnectedshop.com/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl,expectedUrl);

}



@Test

public void contacts () {
    driver.get("https://theconnectedshop.com/" );
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    WebElement contactLink = driver.findElement(By.xpath("//a[@href='/pages/contact-us' and @class='Heading u-h6']"));

    contactLink.click();
    //WebElement username = driver.findElement(By.className("Form__Input"));
    WebElement name = driver.findElement(By.name("contact[name]"));
    name.sendKeys("Oleg");
    String enteredText = name.getAttribute("value");
    assertEquals("Oleg", enteredText);
    WebElement email = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/div[1]/div[2]/input"));
    email.sendKeys("osandzlavi@gmail.com");
    WebElement phone = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/div[2]/input"));
    phone.sendKeys("0935592020");
    WebElement textField = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/div[3]/textarea"));
    textField.sendKeys("Hello, i am Oleg");
    assertNotNull("Contact link should be present on the page", contactLink);
    assertEquals("text", name.getAttribute("type"));
    assertEquals("Form__Input", name.getAttribute("class"));
    assertEquals("contact[name]", name.getAttribute("name"));
    assertEquals("Your name", name.getAttribute("aria-label"));
    assertEquals("Your name", name.getAttribute("placeholder"));
    assertTrue("Name input should be required", Boolean.parseBoolean(name.getAttribute("required")));


}
@Test

    public void Cart () {
    driver.get("https://theconnectedshop.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"section-header\"]/div/div[3]/nav/ul/li[3]/a"));
    cartButton.click();

}

@Test
        public void checkShoping () {

    driver.get("https://theconnectedshop.com/");


    driver.findElement(By.xpath("//*[@id=\"section-header\"]/div/div[1]/nav/ul/li[3]")).click();
    driver.findElement(By.xpath("//*[@id=\"section-list-collections-template\"]/div/a[1]/div/div[2]/header/div/span")).click();
    driver.findElement(By.xpath("//*[@id=\"shopify-section-collection-template\"]/section/div[4]/div[1]/div[2]/div/div/div[1]/div/div/a/div/img[2]"));


}



}
