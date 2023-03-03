package com.example.app2_conversortemperatura;

public class FahrenheitStrategy{

    public static FahrenheitStrategy instance = null;
    private FahrenheitStrategy(){};
    public static FahrenheitStrategy getIntance(){
        if(instance==null){
            instance = new FahrenheitStrategy();
        }
        return instance;
    }


    public double conversionFromCel(double temperaturaCel) {
        double fahrenheit;
        fahrenheit = (temperaturaCel*9/5) + 32;

        return fahrenheit;
    }

    public double conversionFromKelvin(double temperaturaK) {
        double fahrenheit;
        fahrenheit = ((temperaturaK -273.15) * 9/5 )+ 32;

        return fahrenheit;
    }


}
