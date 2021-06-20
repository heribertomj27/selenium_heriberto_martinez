package ExamenSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterviewQuestionSiteTest {

    public WebDriver driver;

    @BeforeMethod

    public void setUP(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://allstq.com/most-popular-testng-interview-questions/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void landingPageTest(){
     WebElement tituloH1= driver.findElement(By.className("entry-title"));
     System.out.println(tituloH1.getText());
     int contador=0;

        List<WebElement> listaTitulos=driver.findElements(By.tagName("h3"));
        for(WebElement titulos: listaTitulos){
            contador++;
            if(contador<=7){
                if(titulos.getText().equals("")){

                }else{
                    System.out.println(titulos.getText());
                }
            }
        }


        Assert.assertEquals(driver.getTitle(),"Most popular TestNG interview questions - Software Testing Questions","Titulo incorrecto");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://allstq.com/most-popular-testng-interview-questions/"),"La url no es la correcta");

        boolean selenium=false;
        boolean java=false;
        List<WebElement> listaLinks=driver.findElements(By.tagName("a"));

        for(WebElement link:listaLinks){
            System.out.println(link.getText());
            if(link.getText().equals("Selenium")){
                selenium=true;
            }
            if(link.getText().equals("Java")){
                java=true;
            }

        }

        Assert.assertTrue(selenium,"No existe la opción de Selenium en el menú");
        Assert.assertTrue(java,"No existe la opción de Java en el menú");




        }






}
