package Clase15.EjerciciosOrangeHRM;

import org.openqa.selenium.WebDriver;

public class OrangeHRMTimeSheetToApprove {

    public WebDriver driver;

    public OrangeHRMTimeSheetToApprove(WebDriver remoteDriver){
        driver=remoteDriver;

    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }






}
