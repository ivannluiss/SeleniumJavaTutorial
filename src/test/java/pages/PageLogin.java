package pages;

import helpers.Helpers;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageLogin {

    private WebDriver driver;

    @FindBy(how = How.NAME,using = "userName")
    private WebElement userFieldMerElement;
    @FindBy(how = How.NAME,using = "password")
    private WebElement passwordFieldMerElement;
    @FindBy(how = How.NAME,using = "submit")
    private WebElement loginButtonMerElement;

    @FindBy(how = How.TAG_NAME,using = "input")
    private List<WebElement> fields;

    private By userField;
    private By passwordField;
    private By loginButton;

    //private By userFieldMer;
    //private By passwordFieldMer;
    //private By loginButtonMer;

    private By buttonFlights;

    //private By fields;



    public PageLogin(WebDriver driver){
        this.driver=driver;
        userField=By.id("usernameOrEmail");
        passwordField=By.id("password");
        loginButton=By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/form/div[3]/button");

       // userFieldMer=By.name("userName");
       // passwordFieldMer=By.name("password");
      //  loginButtonMer=By.name("submit");
        buttonFlights=By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
       // fields = By.tagName("input");
        PageFactory.initElements(driver,this);
    }

    public void login(String user,String pass){
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//permite verificar unn limite de tiempo de carga de la pagina
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(5);
    }

    public void loginMercury(String user,String pass){
        userFieldMerElement.sendKeys(user);
        //driver.findElement(userFieldMer).sendKeys(user);
        passwordFieldMerElement.sendKeys(pass);
        //driver.findElement(passwordFieldMer).sendKeys(pass);
        loginButtonMerElement.click();
       // driver.findElement(loginButtonMer).click();
       /*File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(myScreenshot,new File("LOGIN "+System.currentTimeMillis()+".png"));
        }catch (IOException e){ //mvn Commons IO 2.6
            e.printStackTrace();
        }*/
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(5);
    }
    public void loginMercuryFlights(String user,String pass){
        userFieldMerElement.sendKeys(user);
        //driver.findElement(userFieldMer).sendKeys(user);
        passwordFieldMerElement.sendKeys(pass);
        //driver.findElement(passwordFieldMer).sendKeys(pass);

        driver.findElement(buttonFlights).click();
       /*File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       try{
            FileUtils.copyFile(myScreenshot,new File("LOGIN "+System.currentTimeMillis()+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Helpers helper = new Helpers();
        //helper.sleepSeconds(5);
    }
    public void fields_login(String user,String pass){
        //List<WebElement> loginFields = driver.findElements(fields);
        fields.get(1).sendKeys(user);
        fields.get(2).sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    public void verifyFields(){
       // List<WebElement> loginFields = driver.findElements(fields);
        System.out.println("Número de objetos Tipo input son: "+fields.size());
        Assert.assertTrue(fields.size()==4);
    }

}
