package Clase5.pages;

import Clase3.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EcommerceAuthenticationPage extends EcommerceBasePage {

    public WebDriver driver;

    public EcommerceAuthenticationPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);

    }

    public String getTitleAuthenticationPage(){
        return driver.getTitle();

    }

    public String getURLAuthenticationPage(){
        return driver.getCurrentUrl();

    }

    public void fillEmailAuthenticationCreateAccount(){
        Constants.EMAIL_REGISTRED ="selenium"+Math.random()+"@gmail.com";

        newEmailRegistredField.sendKeys(Constants.EMAIL_REGISTRED);
    }

    public String getNameSignInBtn(){
       return signInAccountPreviewBtn.getText();

    }


    public EcommerceRegistrationPage createAccountBtnClick(){
        createAccountBtn.click();
        EcommerceRegistrationPage nextEcommerceRegistrationPage=new EcommerceRegistrationPage(driver);
        return nextEcommerceRegistrationPage;


    }

    public void fillEmailPasswordLoginAuthentication(){
        emailLoginPreviewField.sendKeys(Constants.EMAIL_REGISTRED);
        passwordPreviewLoginField.sendKeys(Constants.PASSWORD);

    }

    public EcommerceMyAccountPage userCreatedSignInLoginBtn(){
        signInAccountPreviewBtn.click();
        EcommerceMyAccountPage nextEcommerceMyAccountPage= new EcommerceMyAccountPage(driver);
        return nextEcommerceMyAccountPage;
    }

    public void fillEmailUserUnique(){
        newEmailRegistredField.sendKeys(Constants.EMAIL_REGISTRED);
    }

    public void createAccountPreexistingBtn(){
        createAccountBtn.click();
    }

    public String getMessageErrorUniqueEmail(){

        return messageErrorAccount.getText();
    }




}
