package Clase8;

public class Persona {

    protected String nombre;
    protected String apellidoP;
    protected String apellidoM;
    protected int codigoPersona;

    public Persona(String unNombre,String unApellidoP ,String unApellidoM, int unCodigo){

        this.nombre=unNombre;
        this.apellidoP=unApellidoP;
        this.apellidoM=unApellidoM;
        this.codigoPersona=unCodigo;



    }

    public String getNombre(){
        return this.nombre;

    }

    public void setNombre(String unNombre){
        this.nombre=unNombre;

    }


    public String getApellidoP(){
        return this.apellidoP;

    }

    public void setApellidoP(String unApellidoP){
        this.apellidoP=unApellidoP;

    }


    public String getApellidoM(){
        return this.apellidoM;

    }

    public void setApellidoM(String unApellidoM){
        this.apellidoM=unApellidoM;

    }

    public int getCodigoPersona(){
        return this.codigoPersona;

    }

    public void setCodigoPersona(int unCodigo){
        this.codigoPersona=unCodigo;

    }

    public String toString(){
        return this.nombre+" "+this.apellidoP+" "+this.apellidoM+ " tiene clave "+this.codigoPersona;

    }




}
