package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Registration_Steps {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Given("A user must be able to visit the registration url")
    public void a_user_must_be_able_to_visit_the_registration_url() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @And("A user enter a unique first name")
    public void a_user_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Rehan");
    }
    @And("A user enter a unique last name")
    public void a_user_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Khan" );
    }
    @And("A user enter a unique email address")
    public void a_user_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
    }
    @And("A user enter a unique comment")
    public void a_user_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("This is my first registration in website");
    }

    @And("A user click on the submit button")
    public void a_user_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }
    @Then("A user should be able to see a message successfully")
    public void a_user_should_be_able_to_see_a_message_successfully() {
        WebElement submission = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(submission.getText(), "Thank You for your Message!");
    }

}
