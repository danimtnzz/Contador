package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }

    public void irMainActivity(View v){
        //cambiar de activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void irInfo(View v){
        //cambiar de activity
        Intent i = new Intent(this, Pantalla2.class);
        startActivity(i);
    }
    public void irOpciones(View v){
        //cambiar de activity
        Intent i = new Intent(this, Opciones.class);
        startActivity(i);
    }

    public void cerrarApp(View v){
        finish();
    }

}