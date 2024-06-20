import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class addToCart {
  WebDriver driver;
  WebDriverWait wait;

  @Before
  public void setup() {
        driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  @Test
  public void Cart() {
    driver.get("https://theconnectedshop.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));


    WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"section-header\"]/div/div[1]/nav/ul/li[4]/a"));
    acceptButton.click();


    WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"section-header\"]/div/div[1]/nav/ul/li[4]/a")));
    search.click();


    WebElement products = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"section-list-collections-template\"]/div/a[1]/div/div[2]/header/div/span")));
    products.click();
    WebElement productTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='ProductItem__Title Heading']/a[@href='/collections/connected-home/products/fingerprint-door-lock']")));

    WebElement fingerPrintDoorLock = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"shopify-section-collection-template\"]/section/div[4]/div[1]/div[2]/div[1]/div/div[3]/div/div/div/h2/a")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fingerPrintDoorLock);
    fingerPrintDoorLock = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shopify-section-collection-template\"]/section/div[4]/div[1]/div[2]/div[1]/div/div[3]/div/div/div/h2/a")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fingerPrintDoorLock);

   WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"product_form_6198418636972\"]/button")));
      WebElement addToCartButton1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"product_form_6198418636972\"]/button")));
   addToCartButton.click();


   if (addToCartButton.isDisplayed()) {

          addToCartButton.click();
          Assert.assertTrue(addToCartButton.isDisplayed());
          Assert.assertFalse(addToCartButton.isEnabled());
          assertEquals("addToCartButton is inactive after click", false, addToCartButton.isEnabled());
          assertEquals("addToCartButton is displayed",true,addToCartButton.isDisplayed());
          assertNotNull (addToCartButton);
          assertNotSame(addToCartButton,addToCartButton1);
           assertEquals("submit", addToCartButton.getAttribute("type"));
          assertEquals("add-to-cart", addToCartButton.getAttribute("data-action"));
         String spanText = addToCartButton.getTagName();
         assertEquals("button",spanText);


       System.out.println("Product title was added to Cart");
    } else {
      System.out.println("Product title wasn't added to Cart ");
    }
  }


  }
