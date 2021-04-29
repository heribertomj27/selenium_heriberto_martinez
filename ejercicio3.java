package Clase8;

import java.util.Scanner;

public class ejercicio3 {
    //1. Escribir un método que reciba un número y retorne su doble
    public static void main (String args[]){
     System.out.println("Ingrese un número");
     Scanner input=new Scanner(System.in);

     int num=input.nextInt();

     System.out.println("El doble del número "+num+" es "+dobleDeUnNumero(num));


    }

    public static int dobleDeUnNumero(int numero){
        return numero*2;

    }

}


