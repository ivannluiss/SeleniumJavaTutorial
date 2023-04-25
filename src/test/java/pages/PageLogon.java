package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {
    private WebDriver driver;
    private By titleText;
    private By titleTextMercury;
    public PageLogon (WebDriver driver){
        this.driver=driver;
        titleText=By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/div/div[1]/div/div");
        titleTextMercury=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b");
    }
    public void assertLogonPage(){
       Assert.assertTrue(driver.findElement(titleText).getText().contains("ivansuarez83@gmail.com"));
       //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/div/div[1]/div/div")).getText().contains("ivansuarez83@gmail.com"));
    }
    public void assertLogonMercury(){
        Assert.assertTrue(driver.findElement(titleTextMercury).getText().contains("Thank you for Loggin."));
        //Assert.assertTrue(driver.findElement(titleTextMercury).getText().contains("Ivanluis."));
    }
}
