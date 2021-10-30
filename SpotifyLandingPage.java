package Clase15.EjerciciosSpotify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpotifyLandingPage {

    public WebDriver driver;

    public SpotifyLandingPage(WebDriver remoteDriver){
        driver=remoteDriver;

    }

    public String getTitle(){

        return driver.getTitle();
    }

    public String getURL(){
        return driver.getCurrentUrl();

    }

    public SpotifyRegistrationPage btnRegistrarseOnclick(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/mx/signup/']")).click();
        SpotifyRegistrationPage spotifyRegistrationPage=new SpotifyRegistrationPage(driver);
        return spotifyRegistrationPage;

    }

    public SpotifyPremiumPage btnPremiumOnClick(){

        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/mx/premium/']")).click();
        SpotifyPremiumPage spotifyPremiumPage=new SpotifyPremiumPage(driver);
        return spotifyPremiumPage;

    }






}
