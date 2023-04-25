package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageReservation {

    private By passengersDrop;
    private By fromDrop;
    private By titleText;
    private By toDrop;
    private WebDriver driver;


    public PageReservation(WebDriver driver) {
        this.driver=driver;
        titleText= By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font/text()");
        passengersDrop= By.name("passCount");
        fromDrop=By.name("fromPort");
        toDrop=By.name("toPort");
    }

    public void assertPage(){
        Assert.assertTrue(driver.findElement(titleText).getText().contains("Flight Finder to search"));
    }
    public void selectPassengers(int cant){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
        //dropdwn son los select --- lista desplegable
        Select selectPasajeros = new Select(cantidadPasajeros);
        selectPasajeros.selectByVisibleText(Integer.toString(cant));
    }

    public void selectFromPort(int index){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement partiendo = wait.until(ExpectedConditions.presenceOfElementLocated(fromDrop));
        Select selectFrom = new Select(partiendo);
        selectFrom.selectByIndex(index);
    }
    public void selectToPort(String city){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement llegando = wait.until(ExpectedConditions.presenceOfElementLocated(toDrop));
        //Select selectTo = new Select(driver.findElement(toDrop));
        Select selectTo = new Select(llegando);
        selectTo.selectByValue(city);
    }

}
