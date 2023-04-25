package tests;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageLogon;


public class TestAutomatizacionTarea {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.navigate().to("https://demoqa.com/text-box");
        driver.get("https://statuscheckup.com/login");
        Helpers helper = new Helpers();
        helper.sleepSeconds(5);
    }
    @Test
    public void pruebaUno(){

        PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.login("ivansuarez83@gmail.com","123");
        pageLogon.assertLogonPage();
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/div/div[1]/div/div")).getText().contains("ivansuarez83@gmail.com"));
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[1]/div/a/h2")).getText().contains("https://elcomercio.pe/"));
    }

    @AfterMethod
    public void TearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
