import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class searchTest {
    private WebDriver driver;

    @Before
    public void setup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

        @Test
    public void searchExistedProduct () {
            driver.get("https://theconnectedshop.com/");
            WebElement acceptButton = driver.findElement(By.id("shopify-pc__banner__btn-accept"));
            assertNotNull("Accept button should be present on the page", acceptButton);

            acceptButton.click();
            WebElement searchLink = driver.findElement(By.xpath("//a[@href='/search' and @class='Heading Link Link--primary Text--subdued u-h8' and @data-action='toggle-search']"));
            assertNotNull("Search link should be present on the page", searchLink);


            assertEquals("https://theconnectedshop.com/search", searchLink.getAttribute("href"));
            assertEquals("Heading Link Link--primary Text--subdued u-h8", searchLink.getAttribute("class"));
            assertEquals("toggle-search", searchLink.getAttribute("data-action"));


            assertEquals("SEARCH", searchLink.getText());

            WebElement linkElement = driver.findElement(By.xpath("//a[@href='/search' and @class='Heading Link Link--primary Text--subdued u-h8']"));
            linkElement.click();



        }

            @Test
                    public void searchNotExistedProduct () {
                driver.get("https://theconnectedshop.com/");
                WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"section-header\"]/div/div[3]/nav/ul/li[2]/a"));

                searchButton.click();


                WebElement searchField= driver.findElement(By.xpath("//*[@id=\"Search\"]/div/div[1]/form/input[1]"));
                searchField.sendKeys("SAT DR"  );

                System.out.println("No results could be found");





            }






        }


