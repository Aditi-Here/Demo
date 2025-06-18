import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Practice1 {
    static WebDriver driver;
    @BeforeAll
    public static void startBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:/Drive_D/Job/CodingTemple/Java & Selenium - Module 7/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();

        // Open website
        driver.get("https://demoqa.com/radio-button");

        // Maximize the screen
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);");
    }
    @Test
    public void yesButtonTest(){
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        WebElement result = driver.findElement(By.xpath("//span[@class='text-success']"));

        Assertions.assertEquals("Yes", result.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
