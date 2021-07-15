package Clase5.pages;

import Clase5.tests.EcommerceBasePageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EcommerceMyAccountPage extends EcommerceBasePage {

    public WebDriver driver;

    public EcommerceMyAccountPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    public String getTitleMyAccountPage(){
        return driver.getTitle();
    }


    public String getURLMyAccountPage(){
        return driver.getCurrentUrl();
    }

    public EcommerceMyPersonalInformationPage myPersonalInformationBtnClick(){
        myPersonalInformationBtn.click();
        EcommerceMyPersonalInformationPage nextEcommerceMyPersonalnformationPage= new EcommerceMyPersonalInformationPage(driver);
        return nextEcommerceMyPersonalnformationPage;
    }

    //Este método obtiene el nombre del botón que cierra sesión
    public String getTextLogOutBtn(){
        return logOutBtn.getText();
    }

    //Este método obtiene el nombre del usuario loguado
    public String getNameUserCreated(){
        return nameUserCreated.getText();
    }


}
