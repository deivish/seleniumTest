import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {

        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/forgot_password");

    }

    @Test
    void shouldLoginEmailWhenForgotPassword() {
        WebElement user = driver.findElement(By.name("email"));

        WebElement loginButton = driver.findElement(By.tagName("button"));

        user.clear();

        user.sendKeys("herrera.15cortes@gmail.com");

        loginButton.click();

    }

    @AfterEach
    void tearDown() {

        driver.quit();

    }
}
