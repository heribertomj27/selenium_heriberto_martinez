package Clase15.EjerciciosOrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMTimeSheetToApprove {

    public WebDriver driver;

    public OrangeHRMTimeSheetToApprove(WebDriver remoteDriver){
        driver=remoteDriver;

    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public String validaElementosADesplegar(){

        WebElement elementosADesplegar =driver.findElement(By.xpath("//li[@class='summary']"));
        return elementosADesplegar.getText();
    }






}
