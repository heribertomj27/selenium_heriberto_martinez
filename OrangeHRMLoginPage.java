package Clase15.EjerciciosOrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLoginPage {

    public WebDriver driver;

    public OrangeHRMLoginPage(WebDriver remoteDriver){
        driver=remoteDriver;
    }

    public String getTitle(){

        return driver.getTitle();
    }

    public String getURL(){

        return driver.getCurrentUrl();
    }

    public OrangeHRMDashboardPage btnLoginSubmitOnClick(){
        driver.findElement(By.name("Submit")).click();
        OrangeHRMDashboardPage orangeHRMDashboardPage= new OrangeHRMDashboardPage(driver);
        return orangeHRMDashboardPage;
    }



}
