package Clase8;

public class Moral extends Persona{

    private String condicion;

    public Moral(String nombre,String aP,String aM,int codigo,String condicion){
        super(nombre,aP,aM,codigo);
        this.condicion=condicion;

    }

    public String getCondicion(){
        return this.condicion;

    }

    public void setCondicion(String unaCondicion){

        this.condicion=unaCondicion;
    }


    public String toString(){
        return super.toString()+ " tiene condición MORAL";

    }


}
