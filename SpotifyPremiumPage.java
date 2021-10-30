package Clase15.EjerciciosSpotify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public boolean existeTítuloPremiumGratis(){

        List<WebElement> listH1=driver.findElements(By.tagName("h1"));
        boolean validaH1PremiumGratis=false;
        System.out.println("*****Imprimiento titulos H1*****");
        for(WebElement h1:listH1){
            if(h1.getText().equals("Disfruta 3 meses de Premium gratis")){
                validaH1PremiumGratis=true;
            }
            System.out.println("=====> "+h1.getText());

        }
        return validaH1PremiumGratis;
    }



    public boolean existeTituloBeneficios(){
        List<WebElement> listH1=driver.findElements(By.tagName("h1"));
        boolean validaH1Beneficios=false;
        System.out.println("*****Imprimiento titulos H1*****");
        for(WebElement h1:listH1){
            if(h1.getText().equals("Beneficios de Premium")){
                validaH1Beneficios=true;
            }

            System.out.println("=====> "+h1.getText());

        }

        return validaH1Beneficios;

    }


}
