package Clase5.tests;

import Clase3.Constants;
import Clase5.pages.EcommerceAuthenticationPage;
import Clase5.pages.EcommerceMyAccountPage;
import Clase5.pages.EcommerceRegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EcommerceHelper extends EcommerceBasePageTest {
    public WebDriver driver;

    public EcommerceHelper(WebDriver remoteDriver){
        driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    public void completeRegistrationAccount() throws InterruptedException {
        //**************Ingresamos al botón de iniciar sesión************
        EcommerceAuthenticationPage ecommerceAuthenticationPage=ecommerceLandingPage.signInBtnMenuHomeClick();

        //Validamos assert para validar que nos encontramos en la página correcta
        Assert.assertEquals(ecommerceAuthenticationPage.getTitleAuthenticationPage(),"Login - My Store","El título no es el esperado");
        Assert.assertEquals(ecommerceAuthenticationPage.getURLAuthenticationPage(),"http://automationpractice.com/index.php?controller=authentication&back=my-account","Se esperaba otra url");

        //Se ingrese el correo con el cual se registrará la cuenta
        ecommerceAuthenticationPage.fillEmailAuthenticationCreateAccount();

        //Damos click en botón de Create an account y avanzamos a la pantalla para llenar el formulario con los campos
        EcommerceRegistrationPage ecommerceRegistrationPage=ecommerceAuthenticationPage.createAccountBtnClick();

        //Validamos asserts para validar que nos encontramos en la página correcta
        Assert.assertEquals(ecommerceRegistrationPage.getTitleRegistrationPage(),"Login - My Store","El título no es el esperado");
        Assert.assertTrue(ecommerceRegistrationPage.getURLRegistrationPage().contains("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"));

        Thread.sleep(7000);

        //Mopnstramos en pantalla el correo que se muestra prellenado en el campo email
        System.out.println("===>"+ecommerceRegistrationPage.getEmailPreviewRegistrationPage());

        //Validamos que el email que se ingreso correcponde con el email prellenado
        Assert.assertEquals(ecommerceRegistrationPage.getEmailPreviewRegistrationPage(),Constants.EMAIL_REGISTRED,"Los emails no coinciden");

        //Se realiza el llenado de campos del formulario de registro
        ecommerceRegistrationPage.fieldFillingRegistrationPage();

        //Damos click en botón para dar de alta la cuenta con los datos registrados y avanzar ala pantalla de My Account
        EcommerceMyAccountPage ecommerceMyAccountPage=ecommerceRegistrationPage.registerAccountBtnClick();

       }

}
