package Clase15.EjerciciosOrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrangeHRMTest {

    public WebDriver driver;
    public String ORANGE_URL="https://orangehrm-demo-6x.orangehrmlive.com/";


    @BeforeMethod

    public void setUP(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(ORANGE_URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void validaQuickActions(){

        OrangeHRMLoginPage orangeHRMLoginPage=new OrangeHRMLoginPage(driver);

        System.out.println(orangeHRMLoginPage.getTitle());
        System.out.println(orangeHRMLoginPage.getURL());
        Assert.assertEquals(orangeHRMLoginPage.getTitle(),"OrangeHRM","El título de la página no es el correcto");
        Assert.assertEquals(orangeHRMLoginPage.getURL(),"https://orangehrm-demo-6x.orangehrmlive.com/","La URL de la página no es la correcta");

        OrangeHRMDashboardPage orangeHRMDashboardPage= orangeHRMLoginPage.btnLoginSubmitOnClick();
        Assert.assertTrue(orangeHRMDashboardPage.QuickActionsList().size()==8,"La lista de QuickActions no es e 8");

    }

    @Test
    public void testsTimeSheetsPage(){
        OrangeHRMLoginPage orangeHRMLoginPage=new OrangeHRMLoginPage(driver);
        OrangeHRMDashboardPage orangeHRMDashboardPage= orangeHRMLoginPage.btnLoginSubmitOnClick();
        OrangeHRMTimeSheetToApprove orangeHRMTimeSheetToApprove= orangeHRMDashboardPage.btnDashboardTimeSheetsOnClick();

        System.out.println(orangeHRMTimeSheetToApprove.getTitle());
        System.out.println(orangeHRMTimeSheetToApprove.getURL());

        Assert.assertEquals(orangeHRMTimeSheetToApprove.getTitle(),"Employee Timesheets","El título de la página no es el correcto");
        Assert.assertEquals(orangeHRMTimeSheetToApprove.getURL(),"https://orangehrm-demo-6x.orangehrmlive.com/client/#/time/employee_timesheets","La URL de la página no es la correcta");

        WebElement elementosADesplegar =driver.findElement(By.xpath("//li[@class='summary']"));

        System.out.println("Elementos a mostrar: "+elementosADesplegar.getText());


    }







}
