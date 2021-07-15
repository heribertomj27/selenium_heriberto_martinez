package Clase5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EcommerceLandingPage extends EcommerceBasePage {

    public WebDriver driver;
    public EcommerceLandingPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);


    }

    public EcommerceAuthenticationPage signInBtnMenuHomeClick(){
        signInBtnMenuHome.click();
        EcommerceAuthenticationPage nextEcommerceAuthenticationPage=new EcommerceAuthenticationPage(driver);
        return nextEcommerceAuthenticationPage;

    }



}
