package com.example.app2_conversortemperatura;

public class KelvinStrategy {
    public static KelvinStrategy instance = null;
    private KelvinStrategy(){};
    public static KelvinStrategy getIntance(){
        if(instance==null){
            instance = new KelvinStrategy();
        }
        return instance;
    }


    public double conversionFromCel(double temperaturaCel) {
        double kelvin;
        kelvin = temperaturaCel + 273.15;

        return kelvin;
    }

    public double conversionFromFahrenheit(double temperaturaFah) {
        double kelvin;
        kelvin = ((temperaturaFah - 32) * 5/9) + 273.15;

        return kelvin;
    }
}
