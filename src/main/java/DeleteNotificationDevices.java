import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteNotificationDevices {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "resources2/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://www.alarm.com/login.aspx");

        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(100));

        // Wait for the cookies pop-up to be clickable and click it to accept all cookies
        WebElement cookiesPopupAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("ctl00$cookieBanner$acceptCookies")));
        cookiesPopupAcceptButton.click();

        // Wait for the username field to be clickable and enter the username
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("ctl00$ContentPlaceHolder1$loginform$txtUserName")));
        usernameField.sendKeys("simontest");

        // Wait for the password field to be clickable and enter the password
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.name("txtPassword")));
        passwordField.sendKeys("QEmobile12!");

        // Wait for the login button to be clickable and click it to log in
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInButton")));
        loginButton.click();

        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-menu")));
        menuButton.click();

        driver.manage().window().maximize();

        WebElement notificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app-nav > div > nav > ul > li:nth-child(4)")));
        notificationButton.click();

        WebElement pushDevicesButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app-header-sub > ul > li:nth-child(2) > a")));
        pushDevicesButton.click();

        for(int i=0; i<3; i++) {


            WebElement firstDevice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app-content > div.page-view > div > div > section:nth-child(2) > button:nth-child(2) > div > div")));
            firstDevice.click();

            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/main/div[2]/div/div/section[2]/button/div[1]/span")));
            deleteButton.click();

            WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.modal-host > div.modal-top > div > div > div > div > div.ui-modal-footer > button.simple-btn.is-async.btn-color-danger > span.btn-contents")));
            confirmDeleteButton.click();
        }
    }
}
