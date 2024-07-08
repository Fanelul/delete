import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AlarmDelete {

        public static void main(String[] args) throws InterruptedException {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "resources2/chromedriver.exe");

            // Create a new instance of the Chrome driver
            WebDriver driver = new ChromeDriver();

            // Navigate to the login page
            driver.get("https://www.alarm.com/login.aspx");

            // Create a WebDriverWait instance
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

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

            WebElement settingsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app-nav > div > nav > ul > li:nth-child(9) > a > svg")));
            settingsButton.click();

            WebElement PlacesButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app-content > div.page-view > div > div > ul > li:nth-child(4) > a")));
            PlacesButton.click();

            WebElement closeIssues = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ember21")));
            closeIssues.click();

           // WebElement firstDevice = wait.until(ExpectedConditions.elementToBeClickable(By.className("deviceNormal")));
           // firstDevice.click();

            // Switch to the iframe that contains the firstDevice element
            String iframe=  "ember28";
            driver.switchTo().frame(iframe);

            for(int i=0; i<5; i++){
                WebElement firstDevice = wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_phBody_rptDevices_ctl00_lblDevice")));
                firstDevice.click();

                WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ctl00_phBody_lbRemoveDevice")));
                deleteButton.click();
                //close alert pop-up
                driver.switchTo().alert().accept();
            }
// interact with elements inside the iframe


         //   WebElement firstDevice = wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_phBody_rptDevices_ctl00_lblDevice")));
         //   firstDevice.click();



        //    WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ctl00_phBody_lbRemoveDevice")));
         //   deleteButton.click();
//close alert pop-up
          //  driver.switchTo().alert().accept();


            // Switch back to the default content after you're done interacting with elements inside the iframe
           // driver.switchTo().defaultContent();
        }
}
