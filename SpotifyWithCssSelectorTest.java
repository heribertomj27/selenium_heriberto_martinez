package Clase11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {

    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");

        Thread.sleep(4000);

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("pruebatesting@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("pruebatesting@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("Pruebatest123");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("15");
        Select mes=new Select(driver.findElement(By.cssSelector("select#month")));
        mes.selectByVisibleText("Diciembre");
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("2001");
        driver.findElement(By.cssSelector("label[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("label[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("label[for='third-party-checkbox']")).click();

        WebElement botonRegistrarse=driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(botonRegistrarse.getText().equals("Registrarte"),"********** El botón no tiene el texto 'Registrarte', validar con equipo de desarrollo **********");
        System.out.println("********** Se valido de forma correcta el llenado del formulario y el copy correcto del botón para crear un nuevo registro **********");


    }



}
