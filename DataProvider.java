package ExamenSelenium;

public class DataProvider {

    @org.testng.annotations.DataProvider(name="email")
    public Object[][] dataEmail(){
        return new Object[][]{
                {"pruebatest@gmail.com"},
                {"prueba2test@gmail.com"},
                {"prueba3test@gmail.com"}

        };


    }


}
