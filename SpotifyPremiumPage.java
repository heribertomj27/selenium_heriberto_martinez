package Clase15.EjerciciosSpotify;

import org.openqa.selenium.WebDriver;

public class SpotifyPremiumPage {
    public WebDriver driver;


    public SpotifyPremiumPage(WebDriver remoteDriver){
        driver=remoteDriver;

    }

    public String getTitle(){
        return driver.getTitle();

    }

    public String getURL(){

        return driver.getCurrentUrl();
    }






}
