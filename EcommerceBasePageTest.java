package Clase5.tests;

import Clase5.pages.EcommerceLandingPage;
import Clase5.pages.EcommerceMyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class EcommerceBasePageTest {

    public WebDriver driver;
    public EcommerceLandingPage ecommerceLandingPage;


    @FindBy(className = "login")
    public WebElement signInBtnMenuHome;

    @FindBy(id="email_create")
    public WebElement newEmailRegistredField;

    @FindBy(id="SubmitCreate")
    public WebElement createAccountBtn;

    @FindBy(id="email")
    public WebElement emailPreviewField;

    @FindBy(id="id_gender1")
    public WebElement maleRadioButton;

    @FindBy(id="customer_firstname")
    public WebElement firstNameField;

    @FindBy(id="customer_lastname")
    public WebElement lastNameField;

    @FindBy(id="passwd")
    public WebElement passwordField;

    @FindBy(id="days")
    public WebElement daysCbo;

    @FindBy(id="months")
    public WebElement monthsCbo;

    @FindBy(id="years")
    public WebElement yearsCbo;

    @FindBy(id="company")
    public WebElement companyField;

    @FindBy(id="address1")
    public WebElement address1Field;

    @FindBy(id="address2")
    public WebElement address2Field;

    @FindBy(id="city")
    public WebElement cityField;

    @FindBy(id="id_state")
    public WebElement stateCbo;

    @FindBy(id="postcode")
    public WebElement postCodeField;

    @FindBy(id="id_country")
    public WebElement countryCbo;

    @FindBy(id="other")
    public WebElement additionalInformationField;

    @FindBy(id="phone")
    public WebElement phoneField;

    @FindBy(id="phone_mobile")
    public WebElement phoneMobileField;

    @FindBy(id="alias")
    public WebElement addressAliasField;

    @FindBy(id="submitAccount")
    public WebElement registerAccountBtn;

    @FindBy(className="logout")
    public WebElement logOutBtn;

    @FindBy(className="account")
    public WebElement nameUserCreated;

    @FindBy(xpath ="//*[@href='http://automationpractice.com/index.php?controller=identity']")
    public WebElement myPersonalInformationBtn;

    @FindBy(className = "page-subheading")
    public WebElement titleH1MyPersonalInformation;

    @FindBy(id = "firstname")
    public WebElement nameRegisterMyPersonalInformation;

    @FindBy(id = "SubmitLogin")
    public WebElement signInAccountPreviewBtn;

    @FindBy(id = "email")
    public WebElement emailLoginPreviewField;

    @FindBy(name = "passwd")
    public WebElement passwordPreviewLoginField;


    @BeforeMethod
    public void setUP(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
        ecommerceLandingPage=new EcommerceLandingPage(driver);
    }

}
