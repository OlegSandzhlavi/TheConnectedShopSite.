import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.devtools.v123.dom.DOM.querySelector;

public class addToCart {
  WebDriver driver;
  WebDriverWait wait;

  @Before
  public void setup() {
    driver = new ChromeDriver();
  }

  @Test

  public void Cart() {
    driver.get("https://theconnectedshop.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    driver.findElement(By.className("shopify-pc__banner__btn-accept")).click();


    WebElement search = driver.findElement(By.xpath("//*[@id=\"section-header\"]/div/div[1]/nav/ul/li[4]/a"));
    search.click();
    WebElement products = driver.findElement(By.xpath("//*[@id=\"section-list-collections-template\"]/div/a[1]/div/div[2]/header/div/span"));
    products.click();

    WebElement smartDoorLock = driver.findElement(By.xpath("//*[@id=\"shopify-section-collection-template\"]/section/div[4]/div[1]/div[2]/div[1]/div/div[3]/div/div/div/h2/a"));
    WebElement productTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='ProductItem__Title Heading']/a[@href='/collections/connected-home/products/smart-door-lock-slim']")));
    if (productTitle != null) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productTitle);


      productTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='ProductItem__Title Heading']/a[@href='/collections/connected-home/products/smart-door-lock-slim']")));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productTitle);

      assertEquals("Smart Door Lock Slim", productTitle.getText());
      assertEquals("/collections/connected-home/products/smart-door-lock-slim", productTitle.getAttribute("href"));
    } else {
      System.out.println("Product title with link not found");
    }
  } }