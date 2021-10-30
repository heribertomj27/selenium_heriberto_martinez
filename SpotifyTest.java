package Clase15.EjerciciosSpotify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void testMensajeEmailInvalidoSpotifyRegistrationPage(){
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

        Assert.assertEquals(spotifyRegistrationPage.mensajeEmailInvalido(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com","El mensaje de error no es correcto");

    }
    @Test
    public void testsValidaExisteTitulosSpotifyPremiumPage(){
        SpotifyLandingPage spotifyLandingPage=new SpotifyLandingPage(driver);
        SpotifyPremiumPage spotifyPremiumPage=spotifyLandingPage.btnPremiumOnClick();

        System.out.println(spotifyPremiumPage.getTitle());
        System.out.println(spotifyPremiumPage.getURL());

        Assert.assertEquals(spotifyPremiumPage.getTitle(),"Spotify Premium - Spotify (MX)");
        Assert.assertEquals(spotifyPremiumPage.getURL(),"https://www.spotify.com/mx/premium/");

        Assert.assertTrue(spotifyPremiumPage.existeTítuloPremiumGratis(),"No se encontro el título *Disfruta 3 meses de Premium gratis* en titulos H1");
        Assert.assertTrue(spotifyPremiumPage.existeTituloBeneficios(),"No se encontro el título *Beneficios de Premium* en titulos H1");

    }

    }
