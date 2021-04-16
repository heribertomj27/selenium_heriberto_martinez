package Clase9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio14 {

    @Test
    public void validacionesSitioNetflix(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.netflix.com/uy/");

        //Mostrar los elementos h1 y h2 que hay en la página
        List<WebElement> listaH1=driver.findElements(By.tagName("h1"));
        System.out.println("**********Imprimiendo los títulos h1**********");
        for(WebElement h1: listaH1){
            System.out.println("Título H1: "+h1.getText());
        }
        List<WebElement> listaH2=driver.findElements(By.tagName("h2"));
        System.out.println("**********Imprimiendo los títulos h2**********");
        for(WebElement h2: listaH2){
            System.out.println("Título h2: "+h2.getText());
        }
        //Refrescar la página
        driver.navigate().refresh();

        //Mostrar el texto de los botones que se encuentran en la página
        List<WebElement> listaBotones=driver.findElements(By.tagName("button"));
        System.out.println("**********Imprimiendo los botones de la página**********");
        for(WebElement button: listaBotones){
            System.out.println("Botón: "+button.getText());
        }

        //Mostrar la cantidad de elementos div que contiene el sitio
        List<WebElement> listaDiv=driver.findElements(By.tagName("div"));
        int contadorDiv=0;
        for(WebElement div: listaDiv){
            contadorDiv++;
        }
        System.out.println("*************************************************");

        System.out.println("La cantidad de elementos div que hay en la página es de: "+contadorDiv);

        System.out.println("*************************************************");
        //Obtener y mostrar el título de la página
        System.out.println("El título de la página es: "+driver.getTitle());

        //Mostrar la cantidad de elementos de tipos link

        List<WebElement> listaA=driver.findElements(By.tagName("a"));
        int contadorLinks=0;
        for(WebElement a: listaA){
            contadorLinks++;
        }
        System.out.println("*************************************************");
        System.out.println("La cantidad de links que hay en la página es de: "+contadorLinks);

    }

}
