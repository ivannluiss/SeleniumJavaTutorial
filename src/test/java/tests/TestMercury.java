package tests;

import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        //Para identificar el sistema operativo que se ejecuta
        String driverByos="";
        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").equals("Windows 10")){
            driverByos = "src/test/resources/driver/chromedriver.exe";
        }else {
            driverByos="src/test/resources/driver/chromedriver";
        }
        //DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver",driverByos);

        //Ejecución de Chrome sin entorno visual
       // ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("--headless");
       // driver = new ChromeDriver(chromeOptions);

        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(200,200));
        //driver.manage().window().setPosition(new Point(500,500));

        // driver.navigate().to("https://demoqa.com/text-box");
        driver.get("https://demo.guru99.com/test/newtours/index.php");

        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        //String googleWindow = "window.open('https://google.com')";
        //javascriptExecutor.executeScript(googleWindow);

        //tabs = new ArrayList<String>(driver.getWindowHandles()); // getWindowHandles tenemos todos los tabs

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // Helpers helper = new Helpers();
       // helper.sleepSeconds(5);
    }
    @Test(description = "Login Mercury")
    public void pruebaUnoMercury(){
        WebDriverManager.setWindowSize(driver,"maximized");
      //  driver.switchTo().window(tabs.get(1)).navigate().to("https://www.youtube.com/user/Draculinio");
      //  driver.switchTo().window(tabs.get(0));
        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.loginMercury("ivan","ivan");
        pageLogon.assertLogonMercury();

    }
    @Test(description = "Reservación")
    public void ReservationMercury(){
        WebDriverManager.setWindowSize(driver,"maximized");
      //  driver.switchTo().window(tabs.get(1)).navigate().to("https://www.youtube.com/user/Draculinio");
      //  driver.switchTo().window(tabs.get(0));

        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.loginMercuryFlights("ivan","ivan");
        pageReservation.selectPassengers(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");

    }

    @Test(description = "Verificar la cantidad de campos que tiene el login")
    public void PruebaCantidadCampos(){
        PageLogin pageLogin=new PageLogin(driver);
        pageLogin.verifyFields();
    }
    @Test(description = "Verificar los campos de login ingresados")
    public void PruebaCampos(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.fields_login("ivan","ivan");
    }
    @Test(description = "Verifica el titulo correcto en el login")
    public void pruebaTituloEnUsuario(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.putTitleInUserField();
    }
    @AfterMethod
    public void TearDown(ITestResult result){ //
        System.out.println("El Test "+ result.getMethod().getDescription()+ " resulto: "+result.getStatus());
        if (!result.isSuccess()){
            Screenshooter.takeScreenshots("Error",driver);
        }
       // driver.switchTo().window(tabs.get(1)).close();
       // driver.switchTo().window(tabs.get(0)).close();
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
