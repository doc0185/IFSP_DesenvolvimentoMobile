package com.example.app2_conversortemperatura;

public class FahrenheitStrategy implements ConversorTemperatura{

    public static FahrenheitStrategy instance = null;
    private FahrenheitStrategy(){};
    public static FahrenheitStrategy getIntance(){
        if(instance==null){
            instance = new FahrenheitStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperaturaCel) {
        double fahrenheit;
        fahrenheit = (temperaturaCel*9/5) + 32;

        return fahrenheit;
    }

}
