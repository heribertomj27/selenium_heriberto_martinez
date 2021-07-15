package Clase5.pages;

import Clase3.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EcommerceRegistrationPage extends EcommerceBasePage{

    public WebDriver driver;

    public EcommerceRegistrationPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    public String getTitleRegistrationPage(){
        return driver.getTitle();
    }

    public String getURLRegistrationPage(){
        return driver.getCurrentUrl();
    }

    //Este método obtiene el mail registrado que se se muestra prellenado
    public String getEmailPreviewRegistrationPage(){
        return emailPreviewField.getAttribute("value");
    }

    public void fieldFillingRegistrationPage(){
        maleRadioButton.click();
        firstNameField.sendKeys(Constants.FIRST_NAME);
        lastNameField.sendKeys(Constants.LAST_NAME);
        passwordField.sendKeys(Constants.PASSWORD);

        Select days=new Select(daysCbo);
        days.selectByValue(Constants.BIRTH_DAY);

        Select months=new Select(monthsCbo);
        months.selectByValue(Constants.MONTH_DAY);

        Select years=new Select(yearsCbo);
        years.selectByValue(Constants.YEAR_DAY);

        companyField.sendKeys("Real de oro");
        address1Field.sendKeys("La esperanza 123");
        address2Field.sendKeys("Las vegas 80");
        cityField.sendKeys("La patagonia");

        Select states=new Select(stateCbo);
        states.selectByValue("5");

        postCodeField.sendKeys("20000");

        Select countries=new Select(countryCbo);
        countries.selectByValue("21");

        additionalInformationField.sendKeys("Holliwood Nevada");
        phoneField.sendKeys("12345678");
        phoneMobileField.sendKeys("123456789");
        additionalInformationField.sendKeys("Vivienda principal");
    }

    public EcommerceMyAccountPage registerAccountBtnClick(){
        registerAccountBtn.click();
        EcommerceMyAccountPage nextEcommerceMyAccountPage=new EcommerceMyAccountPage(driver);
        return nextEcommerceMyAccountPage;
    }

}
