package Clase3;

import com.github.javafaker.Faker;

public class Constants {
    public static final String PASSWORD="Testing123";
    public static final String BIRTH_DAY="10";
    public static final String MONTH_DAY="12";
    public static final String YEAR_DAY="1990";

    private static Faker FAKER=new Faker();
    public static final String FIRST_NAME=FAKER.name().firstName();
    public static final String LAST_NAME=FAKER.name().lastName();

    public static String EMAIL_REGISTRED;

}
