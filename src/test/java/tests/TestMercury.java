package tests;

import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestMercury {
    private WebDriver driver;
    ArrayList<String> tabs;

    @BeforeMethod
    public void setUpMer(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.navigate().to("https://demoqa.com/text-box");
        driver.get("https://demo.guru99.com/test/newtours/index.php");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        String googleWindow = "window.open('https://google.com')";
        javascriptExecutor.executeScript(googleWindow);

        tabs = new ArrayList<String>(driver.getWindowHandles()); // getWindowHandles tenemos todos los tabs

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // Helpers helper = new Helpers();
       // helper.sleepSeconds(5);
    }
    @Test
    public void pruebaUnoMercury(){
        WebDriverManager.setWindowSize(driver,"maximized");
        driver.switchTo().window(tabs.get(1)).navigate().to("https://www.youtube.com/user/Draculinio");
        driver.switchTo().window(tabs.get(0));
        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.loginMercury("ivan","ivan");
        pageLogon.assertLogonMercury();

    }
    @Test
    public void ReservationMercury(){
        WebDriverManager.setWindowSize(driver,"fullscreen");
      //  driver.switchTo().window(tabs.get(1));
      //  driver.switchTo().window(tabs.get(0));

        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.loginMercuryFlights("ivan","ivan");
        pageReservation.selectPassengers(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");

    }

    @Test
    public void PruebaCantidadCampos(){
        PageLogin pageLogin=new PageLogin(driver);
        pageLogin.verifyFields();
    }
    @AfterMethod
    public void TearDown(ITestResult result){ //
        if (!result.isSuccess()){
            Screenshooter.takeScreenshots("Error",driver);
        }
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0)).close();
        //driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }
}
