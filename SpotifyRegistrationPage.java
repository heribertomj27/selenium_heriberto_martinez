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

    public String getTitle()
    {
        return driver.getTitle();
    }

    public String getURL(){

        return driver.getCurrentUrl();
    }

    public void fillEmailField(String anEmail){
        driver.findElement(By.id("email")).sendKeys(anEmail);

    }

    public void fillConfirmEmailField(String anConfirmEmail){
        driver.findElement(By.id("confirm")).sendKeys(anConfirmEmail);

    }

    public void fillPasswordField(String anPassword){
        driver.findElement(By.id("password")).sendKeys(anPassword);

    }

    public void fillDisplayNameField(String anDisplayName){
        driver.findElement(By.id("displayname")).sendKeys(anDisplayName);
    }

    public void fillDayField(String anDay){
        driver.findElement(By.id("day")).sendKeys(anDay);

    }

    public void selectMonthField(String anMoth){
        WebElement listMonths=driver.findElement(By.id("month"));
        Select months=new Select(listMonths);
        months.selectByValue(anMoth);

    }

    public void fillYearField(String anYear){

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

    public String mensajeEmailInvalido(){

        WebElement msgError=driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
        return msgError.getText();
    }








}
