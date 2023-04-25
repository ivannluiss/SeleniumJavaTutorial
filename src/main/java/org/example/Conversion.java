package org.example;

public class Conversion {
    public double temCoversion (double temperatura, String unit){
        if (unit.equals("F"))
            return (temperatura - 32)*(5.0/9.0);
        else
            return (temperatura * (9.0/5.0)) + 32;
    }

}
