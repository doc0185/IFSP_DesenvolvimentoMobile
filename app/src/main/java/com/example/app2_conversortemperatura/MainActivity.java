package com.example.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valorEditText;
    private Button coverterPCelsius;

    private Button coverterPFahrenheit;

    private Button coverterPKelvin;

    private int tipoTemperatura;
    private TextView valorConvertidoTextView;

    private CheckBox celsius;
    private CheckBox fahrenheit;
    private CheckBox kelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorEditText = findViewById(R.id.edittext_valor);
        valorConvertidoTextView = findViewById(R.id.text_temp_convertida);

        coverterPCelsius = findViewById(R.id.button_converter_p_celsius);
        coverterPCelsius.setOnClickListener(this);

        coverterPFahrenheit = findViewById(R.id.button_converter_p_fahrenheit);
        coverterPFahrenheit.setOnClickListener(this);

        coverterPKelvin = findViewById(R.id.button_converter_p_kelvin);
        coverterPKelvin.setOnClickListener(this);

        celsius = findViewById(R.id.checkbox_celsius);
        fahrenheit = findViewById(R.id.checkbox_fahr);
        kelvin = findViewById(R.id.checkbox_kelvin);

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_celsius:
                if (checked){
                    tipoTemperatura = 1;
                    fahrenheit.setChecked(false);
                    kelvin.setChecked(false);
                }
                break;
            case R.id.checkbox_fahr:
                if (checked){
                    tipoTemperatura = 2;
                    celsius.setChecked(false);
                    kelvin.setChecked(false);
                }
                break;
            case R.id.checkbox_kelvin:
                if (checked){
                    tipoTemperatura = 3;
                    celsius.setChecked(false);
                    fahrenheit.setChecked(false);
                }
                break;

        }
    }
    @Override
    public void onClick(View view) {

        if(view == coverterPCelsius && tipoTemperatura==1){
            double valorEscrito = getValue();

            valorConvertidoTextView.setText(String.format("%.2f ºC", valorEscrito));
        }

        if(view == coverterPCelsius && tipoTemperatura==2){
            double valorEscrito = getValue();
            double valorCelsius;
            valorCelsius = CelsiusStrategy.getIntance().conversionFromFah(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f ºC", valorCelsius));
        }

        if(view == coverterPCelsius && tipoTemperatura==3){
            double valorEscrito = getValue();
            double valorCelsius;
            valorCelsius = CelsiusStrategy.getIntance().conversionFromKelvin(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f ºC", valorCelsius));
        }

        if (view == coverterPFahrenheit && tipoTemperatura==1){
            double valorEscrito = getValue();
            double valorFahrenheit;
            valorFahrenheit = FahrenheitStrategy.getIntance().conversionFromCel(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f ºF", valorFahrenheit));
        }

        if(view == coverterPFahrenheit && tipoTemperatura==2){
            double valorEscrito = getValue();

            valorConvertidoTextView.setText(String.format("%.2f ºF", valorEscrito));
        }

        if (view == coverterPFahrenheit && tipoTemperatura==3){
            double valorEscrito = getValue();
            double valorFahrenheit;
            valorFahrenheit = FahrenheitStrategy.getIntance().conversionFromKelvin(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f ºF", valorFahrenheit));
        }

        if (view == coverterPKelvin && tipoTemperatura==1){
            double valorEscrito = getValue();
            double valorKelvin;
            valorKelvin = KelvinStrategy.getIntance().conversionFromCel(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f K", valorKelvin));
        }

        if (view == coverterPKelvin && tipoTemperatura==2){
            double valorEscrito = getValue();
            double valorKelvin;
            valorKelvin = KelvinStrategy.getIntance().conversionFromFahrenheit(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f K", valorKelvin));
        }

        if(view == coverterPKelvin && tipoTemperatura==3){
            double valorEscrito = getValue();

            valorConvertidoTextView.setText(String.format("%.2f K", valorEscrito));
        }
    }

    private double getValue(){
        double value;
        String valueString;

        valueString = valorEditText.getText().toString();

        try {
            value = Double.valueOf(valueString);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido.", Toast.LENGTH_SHORT).show();
            value = 0;
        }
        return value;
    }
}