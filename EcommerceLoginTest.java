package Clase5.tests;

import Clase3.Constants;
import Clase4.EcommerceHelper;
import Clase5.pages.EcommerceAuthenticationPage;
import Clase5.pages.EcommerceMyAccountPage;
import Clase5.pages.EcommerceMyPersonalInformationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceLoginTest extends EcommerceBasePageTest {

    @Test
    public void loginTest() throws InterruptedException {
        //Se realiza el registro de la cuenta
        EcommerceHelper helper=new EcommerceHelper(driver);
        helper.completeRegistrationAccount();

        //Imprimimos el correo y la contraseña con las que se registro la cuenta
        System.out.println("========> "+ Constants.EMAIL_REGISTRED);
        System.out.println("========>"+Constants.PASSWORD);

        //Creamos un objeto de tipo EcommerceMyaccountPage
        EcommerceMyAccountPage ecommerceMyAccountPage= new EcommerceMyAccountPage(driver);
        ecommerceMyAccountPage.getTextLogOutBtn();

        //Validamos asserts par avalidar que nos encontramos logueados
        String userRegistred=Constants.FIRST_NAME+ " "+Constants.LAST_NAME;
        Assert.assertEquals(ecommerceMyAccountPage.getTextLogOutBtn(),"Sign out","Se esperaba otra opción");
        Assert.assertEquals(ecommerceMyAccountPage.getNameUserCreated(),userRegistred,"El usuario registrado no es el correcto");

        //Seleccionamos el botón de YOUR PERSONAL INFORMATION
        EcommerceMyPersonalInformationPage newEcommerceMyPersonalInformationPage= ecommerceMyAccountPage.myPersonalInformationBtnClick();

        //Validamos que se encuentra el titulo de YOUR PERSONAL INFORMATION
        Assert.assertEquals(newEcommerceMyPersonalInformationPage.getTitleH1MyPersonalInformation(),"YOUR PERSONAL INFORMATION","Se  esperaba otro título");

        //Validamos que el nombre del usuario corresponde al que se registro
        Assert.assertEquals(newEcommerceMyPersonalInformationPage.getNameRegisterMyPersonalInformation(),Constants.FIRST_NAME,"El nombre del usuario no es el correcto");

        //Cerramos sesion
        EcommerceAuthenticationPage actualEcommerceAuthenticationPage= newEcommerceMyPersonalInformationPage.signOutBtnClick();
        Assert.assertEquals(actualEcommerceAuthenticationPage.getNameSignInBtn(),"Sign in", "El nombre del botón no es el correcto");

        //Validamos el login con la cuenta creada al inicio
        actualEcommerceAuthenticationPage.fillEmailPasswordLoginAuthentication();

        //Realizamos el log in
        EcommerceMyAccountPage loginEcommerceMyAccountPage=actualEcommerceAuthenticationPage.userCreatedSignInLoginBtn();

        Thread.sleep(3000);
        //Validamos asserts para validar que estamos logueados con la cuenta creada
        Assert.assertEquals(loginEcommerceMyAccountPage.getTextLogOutBtn(),"Sign out","Se esperaba otra opción");
        Assert.assertEquals(loginEcommerceMyAccountPage.getNameUserCreated(),userRegistred,"El usuario registrado no es el correcto");
        //driver.close();
    }
}
