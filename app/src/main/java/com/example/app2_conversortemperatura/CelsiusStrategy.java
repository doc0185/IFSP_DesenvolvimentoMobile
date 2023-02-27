package com.example.app2_conversortemperatura;

public class CelsiusStrategy implements ConversorTemperatura{

    public static CelsiusStrategy instance = null;
    private CelsiusStrategy(){};
    public static CelsiusStrategy getIntance(){
        if(instance==null){
            instance = new CelsiusStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperaturaFah) {
        double celsius;
        celsius = (temperaturaFah - 32)*5/9;

        return celsius;
    }
}
