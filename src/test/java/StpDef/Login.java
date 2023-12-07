package StpDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;


    @Given("Open web url {string}")
    public void openWebUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "/home/krisna/github/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);

        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo'][contains(.,'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("Input username {string} and password {string}")
    public void inputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Should success Login and redirected to homepage")
    public void shouldSuccessLoginAndRedirectedToHomepage() {
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='app_logo'][contains(.,'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
        driver.quit();
    }

    @Then("Failed login and showing message")
    public void failedLoginAndShowingMessage() {
        WebElement element = driver.findElement(By.xpath("//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]"));
        element.isDisplayed();
        driver.close();
        driver.quit();
    }
}
