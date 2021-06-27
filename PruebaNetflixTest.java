package ExamenSelenium;

import Clase14.DataGenerator;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {

    public WebDriver driver;

    @BeforeMethod

    public void setUP(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@data-uia='close-button']")).click();

    }

    @Test
    public void iniciarSesionPageTest(){
        Assert.assertEquals(driver.getTitle(),"Netflix México: Ve series online, ve películas online","Titulo no es correcto");
      driver.findElement(By.xpath("//*[@href='/login']")).click();

      Assert.assertEquals(driver.getTitle(),"Netflix","El titulo no es el correcto");

      boolean tituloInicia=false;
        List<WebElement> listaH1=driver.findElements(By.tagName("h1"));
        for(WebElement h1:listaH1){
          if(h1.getText().equals("Inicia sesión"));{
              System.out.println(h1.getText());
                    tituloInicia=true;
            }


        }

        Assert.assertTrue(tituloInicia,"No existe el título Inia sesión");
        WebElement textofacebook=driver.findElement(By.xpath("//*[@class='fbBtnText']"));
        System.out.println(textofacebook.getText());

        Assert.assertEquals(textofacebook.getText(),"Iniciar sesión con Facebook","No existe la de iniciar sesion con facebook");


    }


    @Test

    public void fakeEmailTest(){

        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        System.out.println( driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),"La url no contiene el texto signup");


    }

    @Test(dataProvider="email",dataProviderClass = DataProvider.class)
    public void dataProviderEmailTest(String email){

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }



    @Test
    public void printTagsTest (String parametro){

        parametro="h1";
        List<WebElement> listaH1=driver.findElements(By.tagName(parametro));

    }





}
