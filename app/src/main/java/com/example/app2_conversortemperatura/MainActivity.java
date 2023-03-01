package com.example.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valorEditText;
    private Button coverterPCelsius;

    private Button coverterPFahrenheit;
    private TextView valorConvertidoTextView;

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

    }

    @Override
    public void onClick(View view) {
        if(view == coverterPCelsius){
            double valorEscrito = getValue();
            double valorCelsius;
            valorCelsius = CelsiusStrategy.getIntance().getConversion(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f ºC", valorCelsius));
        }

        if (view == coverterPFahrenheit){
            double valorEscrito = getValue();
            double valorFahrenheit;
            valorFahrenheit = FahrenheitStrategy.getIntance().getConversion(valorEscrito);

            valorConvertidoTextView.setText(String.format("%.2f ºF", valorFahrenheit));
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