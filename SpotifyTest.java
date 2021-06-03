package Clase15.EjerciciosSpotify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.security.auth.kerberos.KeyTab;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyTest {
    public WebDriver driver;
    public String SPOTIFY_URL="https://www.spotify.com/";


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(SPOTIFY_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testsSpotifyRegistrationPage(){
        SpotifyLandingPage spotifyLandingPage=new SpotifyLandingPage(driver);
        spotifyLandingPage.getTitle();
        Assert.assertEquals(spotifyLandingPage.getTitle(),"Escuchar es todo - Spotify","El título no es el correcto");
        spotifyLandingPage.getURL();
        Assert.assertEquals(spotifyLandingPage.getURL(),"https://www.spotify.com/mx/","La url no es la correcta");

        SpotifyRegistrationPage spotifyRegistrationPage=spotifyLandingPage.btnRegistrarseOnclick();
        spotifyRegistrationPage.getTitle();
        Assert.assertEquals(spotifyRegistrationPage.getTitle(),"Registrarte - Spotify","El título de la página no es el correcto");

        spotifyRegistrationPage.getURL();
        Assert.assertEquals(spotifyRegistrationPage.getURL(),"https://www.spotify.com/mx/signup/","El título de la página no es el cor");

        spotifyRegistrationPage.fillEmailField("@@@.com");
        spotifyRegistrationPage.fillConfirmEmailField("@@@.com");

        WebElement msgError=driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
        Assert.assertEquals(msgError.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com","El mensaje de error no es correcto");

    }
    @Test
    public void testsSpotifyPremiumPage(){
        SpotifyLandingPage spotifyLandingPage=new SpotifyLandingPage(driver);
        SpotifyPremiumPage spotifyPremiumPage=spotifyLandingPage.btnPremiumOnClick();

        System.out.println(spotifyPremiumPage.getTitle());
        System.out.println(spotifyPremiumPage.getURL());

        Assert.assertEquals(spotifyPremiumPage.getTitle(),"Spotify Premium - Spotify (MX)");
        Assert.assertEquals(spotifyPremiumPage.getURL(),"https://www.spotify.com/mx/premium/");

        List<WebElement> listH1=driver.findElements(By.tagName("h1"));
        boolean validaH1PremiumGratis=false;
        boolean validaH1Beneficios=false;
        System.out.println("*****Imprimiento titulos H1*****");
        for(WebElement h1:listH1){
            if(h1.getText().equals("Disfruta 3 meses de Premium gratis")){
                validaH1PremiumGratis=true;
            }else if(h1.getText().equals("Beneficios de Premium")){
                validaH1Beneficios=true;
            }

            System.out.println("=====> "+h1.getText());

        }
        Assert.assertTrue(validaH1PremiumGratis,"No se encontro el título *Pásate a Premium gratis por 1 mes* en titulos H1");
        Assert.assertTrue(validaH1Beneficios,"No se encontro el título *Beneficios de Premium* en titulos H1");

    }

    }





