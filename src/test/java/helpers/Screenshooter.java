package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshooter {

    public static void takeScreenshots(String screenName, WebDriver driver){

        File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(myScreenshot,new File(screenName+"_"+System.currentTimeMillis()+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
