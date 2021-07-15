package Clase5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EcommerceMyPersonalInformationPage extends EcommerceBasePage{

    public WebDriver driver;

    public EcommerceMyPersonalInformationPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    public String getTitleH1MyPersonalInformation(){
        return titleH1MyPersonalInformation.getText();
    }

    public String getNameRegisterMyPersonalInformation(){
        String nameActual=nameRegisterMyPersonalInformation.getAttribute("value");
        return nameActual;
    }

    public EcommerceAuthenticationPage signOutBtnClick(){
        logOutBtn.click();
        EcommerceAuthenticationPage nextEcommerceAuthenticationPage=new EcommerceAuthenticationPage(driver);
        return nextEcommerceAuthenticationPage;
    }
}