import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test13 {

    @Test

    public void LessonTestNg () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");

    }


}
