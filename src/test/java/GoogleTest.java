import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    private WebDriver driver;

    @BeforeEach
    void seUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void ShouldOpenGooglePage(){

        WebElement searchbox = driver.findElement(By.name("q"));

        searchbox.clear();
        searchbox.sendKeys("HOLA");

        searchbox.submit();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        assertEquals("HOLA - Buscar con Google", driver.getTitle());

    }

    @AfterEach
    public void tearDown(){
        System.out.println("Exit");
        driver.quit();
    }
}
