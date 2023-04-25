package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {
    private int numeroUno = 5;
    private int numeroDos = 3;

    @Test
    public void testNumeroVerdadero(){
        Assert.assertTrue(numeroUno==numeroDos+1,"El nro. no es verdadero: "+ String.valueOf(numeroUno));
    }

    @Test
    public void testNumeroFalso(){
        Assert.assertFalse(numeroUno!=numeroDos,"Ambos nros. no son Iguales");
    }

    @Test
    public void testNumerosIguales(){
        Assert.assertEquals(numeroUno+10,numeroDos+12);
    }

    @Test
    public void testNumerosNoIguales(){
        Assert.assertNotEquals(numeroUno-1,numeroDos+2);
    }
    @Test
    public void testDeNoNulo(){
        Personas personas=new Personas("Pepe","Gonzalez");
        Assert.assertNotNull(personas);
    }

    @Test
    public void testDeNulo(){
        Personas personas=null;
        Assert.assertNull(personas);
    }

    @Test
    public void noMismoObjeto(){
        // dos objetos que tienen lo mismo
        Personas personaUno = new Personas("Pepe","Gonzalez");
        Personas personaDos = new Personas("Pepe","Gonzalez");

        Assert.assertNotSame(personaUno,personaDos);
    }
    @Test
    public void mismoObjeto(){
        // dos objetos que tienen lo mismo
        Personas personaUno = new Personas("Pepe","Gonzalez");
        Personas personaDos = personaUno;

        Assert.assertSame(personaUno,personaDos);
    }

    @Test
    public void mismoObjetoEqual(){
        // dos objetos que tienen lo mismo
        Personas personaUno = new Personas("Pepe","Gonzalez");
        Personas personaDos = new Personas("Pepe","Gonzalez");

        Assert.assertEquals(personaUno,personaDos);
    }

}
