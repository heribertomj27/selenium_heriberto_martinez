package Clase15.EjerciciosSpotify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SpotifyRegistrationPage {

    public WebDriver driver;

    public SpotifyRegistrationPage(WebDriver remoteDriver){

        driver=remoteDriver;

    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getURL(){

        return driver.getCurrentUrl();
    }

    public void FillEmailField(String anEmail){
        driver.findElement(By.id("email")).sendKeys(anEmail);

    }

    public void FillConfirmEmailField(String anConfirmEmail){
        driver.findElement(By.id("confirm")).sendKeys(anConfirmEmail);

    }

    public void FillPasswordField(String anPassword){
        driver.findElement(By.id("password")).sendKeys(anPassword);

    }

    public void FillDisplayNameField(String anDisplayName){
        driver.findElement(By.id("displayname")).sendKeys(anDisplayName);
    }

    public void FillDayField(String anDay){
        driver.findElement(By.id("day")).sendKeys(anDay);

    }

    public void SelectMonthField(String anMoth){
        WebElement listMonths=driver.findElement(By.id("month"));
        Select months=new Select(listMonths);
        months.selectByValue(anMoth);

    }

    public void FillYearField(String anYear){

        driver.findElement(By.id("year")).sendKeys(anYear);

    }

    public void selectGenderField(Integer numberGender){
        List<WebElement> listGender=driver.findElements(By.name("gender"));
        WebElement selectGender= listGender.get(numberGender);
        selectGender.click();

    }

    public void selectMarketingCheck(){
        driver.findElement(By.cssSelector("label[for='marketing-opt-checkbox']")).click();

    }
    public void selectThirdCheck(){

        driver.findElement(By.cssSelector("label[for='third-party-checkbox']")).click();
    }








}
