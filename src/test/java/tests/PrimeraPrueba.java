package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeraPrueba {
    public static void main (String args []){

        //primero la llave y luego donde se ubica el valor
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Abrir web
        driver.get("https://demoqa.com/text-box");

        //realizar acciones del proyecto
        driver.findElement(By.id("userName")).sendKeys("Ivan");
        driver.findElement(By.id("userEmail")).sendKeys("ivan123@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Lima Calle los testers 111");
        driver.findElement(By.id("permanentAddress")).sendKeys("Lima calle los testers 321");
        //driver.findElement(By.id("submit")).click();

        //Limpiar Cookies
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        //Cerrar proyecto
        //driver.close();

    }
}
