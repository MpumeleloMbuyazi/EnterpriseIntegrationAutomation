package Base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.with;

public class baseClass {

    public static WebDriver driver;
    public static Properties prop;


    public baseClass() {

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("Resources" + File.separator + "config.properties");
            //Load properties file
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /********************* Launch Browser Function ************************/
    public void launchBrowser(String browserName) throws Exception {

        try {
            //Read browser name from properties file
            if (browserName.equalsIgnoreCase("Chrome")) {

                //Create Chrome driver Instance
                System.setProperty("webdriver.chrome.driver", "Resources" + File.separator + "chromedriver.exe");
                driver = new ChromeDriver();
              //  reportPass(browserName + " Opened successfully");

            } else if (browserName.equalsIgnoreCase("Firefox")){

                //Create Firefox driver Instance
                System.setProperty("webdriver.gecko.driver", "Resources" + File.separator + "geckodriver.exe");
                driver = new FirefoxDriver();
            }
        } catch (Exception e) {
           e.getMessage();
        }

        //Maximizes window and waits for the page to load
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        //Read URL from properties file
        try {
            String URL = prop.getProperty("URL");
            driver.get(URL);
            //reportPass(URL + " Identified successfully");
        } catch (Exception e) {
            e.getMessage();
        }

        WebDriverWait wait = new WebDriverWait(driver, 75);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));

        //Login to LeanUI
        driver.findElement(By.name("loginfmt")).sendKeys("mpumelelo.dube@multichoice.co.za");
        driver.findElement(By.id("idSIButton9")).click();
        driver.findElement(By.name("passwd")).sendKeys("Summer@54321");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(15000);
        driver.findElement(By.id("idSubmit_SAOTCC_Continue")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        driver.findElement(By.id("idSIButton9")).click();
    }
}
