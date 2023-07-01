package tests;

import helpers.Screenshooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CondicionesComunes {

    //private WebDriver driver;
    // se tiene que declarar como Protected la variable para ser heredado por las otras clases
    protected WebDriver driver;
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
        System.setProperty("webdriver.chrome.driver",driverByos);
        driver = new ChromeDriver();
        // driver.navigate().to("https://demoqa.com/text-box");
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void TearDown(ITestResult result){ //
        System.out.println("El Test "+ result.getMethod().getDescription()+ " resulto: "+result.getStatus());
        if (!result.isSuccess()){
            Screenshooter.takeScreenshots("Error",driver);
        }
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

}
