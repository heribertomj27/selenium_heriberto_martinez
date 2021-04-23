package Clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {

    //Ejercicio 9 GitHub

    @Test
    public void fullRegistrationTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement elementoDays=driver.findElement(By.id("day"));
        Select day=new Select(elementoDays);
        day.selectByVisibleText("26");

        WebElement elementoMonths=driver.findElement(By.id("month"));
        Select month=new Select(elementoMonths);
        month.selectByVisibleText("jun");

        WebElement elementoYear=driver.findElement(By.id("year"));
        Select year=new Select(elementoYear);
        year.selectByVisibleText("1980");


        List<WebElement> listaGeneros=driver.findElements(By.name("sex"));
        WebElement genero=listaGeneros.get(1);
        genero.click();

        //Validamos que el test sea o no exitoso validando que el último campo del formulario este informado
        Assert.assertTrue(genero.isSelected());


    }




}
