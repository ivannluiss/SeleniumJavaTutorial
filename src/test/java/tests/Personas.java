package tests;

public class Personas {

    private String nombre;
    private String apellido;
    public Personas(String nommbre,String apellido){
        this.nombre=nommbre;
        this.apellido=apellido;
    }
    public void saludar(){

        System.out.println("Hola "+this.nombre+" "+this.apellido);
    }
}
