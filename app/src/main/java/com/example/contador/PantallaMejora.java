package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class PantallaMejora extends AppCompatActivity {

    TextView textoContador2;
    Button botonMejora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mejora);
        botonMejora = (Button) findViewById(R.id.botonmultiplicador);
        textoContador2 = (TextView) findViewById(R.id.textoContador2);
        Bundle param = getIntent().getExtras();
        textoContador2.setText(param.getString("monedas"));
    }
    public void irPantallaInicio(View v){
        //cambiar de activity
        //Intent i = new Intent(this, PantallaInicio.class);
        //startActivity(i);
        finish();
    }


}