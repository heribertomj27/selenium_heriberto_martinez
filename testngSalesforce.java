package Clase12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testngSalesforce {

    public static final String SALEFORCE_URL="https://login.salesforce.com/?locale=eu";
    public WebDriver driver;

    @Test(groups={"successTests","failTest"})

    @BeforeTest
    public void setUpSaleForce(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(SALEFORCE_URL);
        driver.manage().window().maximize();

    }

    @Test(priority=1,groups={"failTest"})
    public void validateSalesforceLogoTest() throws InterruptedException {
        Thread.sleep(3000);
        WebElement logo=driver.findElement(By.id("logo"));
        System.out.println(logo.getTagName());
        System.out.println(logo.getAttribute("alt"));
        Thread.sleep(3000);
        Assert.assertTrue(logo.getAttribute("alt").contains("Salesforce"),"****** El copy del attributo 'alt' no es correcto validar con equipo de desarrollo ******");
    }

    @Test (priority=1,groups={"successTests"})
    public void RememberMeIsSelected() throws InterruptedException {
        Thread.sleep(3000);
        WebElement remember= driver.findElement(By.id("rememberUn"));
        remember.click();
        Assert.assertTrue(remember.isSelected(),"El campo remember no esta seleccionado");
        Thread.sleep(3000);


    }

    @Test(enabled=false, groups={"successTests"})

    public void FooterIsValid() throws InterruptedException {
        Thread.sleep(3000);
        WebElement footer=driver.findElement(By.id("footer"));
        Assert.assertTrue(footer.getText().contains("All rights reserved"),"No contiene Derechos reservados");
        System.out.println("La página tiene Derechos reservados");
        Thread.sleep(3000);
    }

    //**********Ejercicio GIT**********
    @Test(priority=3,groups={"successTests"})
    public void LoginFailureTest() throws InterruptedException {
        Thread.sleep(3000);
        WebElement logoSalesForce=driver.findElement(By.id("logo"));
        if(logoSalesForce.getAttribute("id").equals("logo")){
            System.out.println("El logo de SalesForce se encuentra en la página");
        }else{
            System.out.println("No se encontro el logo de Sales Forcce");
        }
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("123466");
        driver.findElement(By.id("Login")).click();
        WebElement mensajeErrorCredenciales=driver.findElement(By.id("error"));
        System.out.println(mensajeErrorCredenciales.getText());
        Assert.assertTrue(mensajeErrorCredenciales.getText().contains("Your access to salesforce.com has been disabled by your system administrator"),"********** El copy del mensaje no coincide verificar con equipo de desarrollo **********");
        Thread.sleep(3000);

    }


    @AfterClass
    public void closeNavegador() throws InterruptedException {
        Thread.sleep(6000);
        driver.close();

    }

    }
