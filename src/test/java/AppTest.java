import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest {


    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver;

    @BeforeTest
    void setup() {
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    void Fb(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        user.sendKeys("harshilpatel1029@gmail.com");

        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass")));
        pass.sendKeys("harshil29");

      WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
      login.click();

    }
}