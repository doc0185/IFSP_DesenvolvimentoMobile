package com.example.app2_conversortemperatura;

public class CelsiusStrategy{

    public static CelsiusStrategy instance = null;
    private CelsiusStrategy(){};
    public static CelsiusStrategy getIntance(){
        if(instance==null){
            instance = new CelsiusStrategy();
        }
        return instance;
    }


    public double conversionFromFah(double temperaturaFah) {
        double celsius;
        celsius = (temperaturaFah - 32)*5/9;

        return celsius;
    }

    public double conversionFromKelvin(double temperaturaK){
        double celsius;
        celsius = temperaturaK - 273.15;

        return celsius;
    }
}
