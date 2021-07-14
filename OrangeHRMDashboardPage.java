package Clase15.EjerciciosOrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangeHRMDashboardPage {

    public WebDriver driver;

    public OrangeHRMDashboardPage(WebDriver remoteDriver){
        driver =remoteDriver;

    }

    public String getTtitle(){

        return driver.getTitle();

    }

    public String getURL(){
        return driver.getCurrentUrl();

    }

    public List<WebElement> QuickActionsList(){
        List<WebElement> listaQuickActions=driver.findElements(By.xpath("//span[@class='quick-access-icon-container']"));
        return listaQuickActions;

    }

    public OrangeHRMTimeSheetToApprovePage btnDashboardTimeSheetsOnClick(){
        driver.findElement(By.xpath("//*[contains(text(),'Timesheets to Approve')]")).click();
        OrangeHRMTimeSheetToApprovePage orangeHRMTimeSheetToApprove= new OrangeHRMTimeSheetToApprovePage(driver);
        return orangeHRMTimeSheetToApprove;


    }




}
