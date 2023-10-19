package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.math.BigInteger;

public class PantallaMejora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mejora);
    }
    public void irPantallaInicio(View v){
        //cambiar de activity
        //Intent i = new Intent(this, PantallaInicio.class);
        //startActivity(i);
        finish();
    }
    public void multiplicador(View v) {
        if (cont.compareTo(BigInteger.valueOf(valorMejora)) >= 0) {
            cont = cont.subtract(BigInteger.valueOf(valorMejora));
            valorsuma *= 2;
            valorMejora += 20;
            botonmultiplicador.setText("La mejora cuesta " + valorMejora + " coins");
            actualizarTextoContador();
        }
    }

}