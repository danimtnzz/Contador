package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class PantallaMejora extends AppCompatActivity {

    TextView textoContador2;
    Button botonMejora, botonTiempo;
    MiAplicación miAplicación;
    int cantidadMejoras = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mejora);
        botonMejora = findViewById(R.id.botonmultiplicador);
        botonTiempo = findViewById(R.id.botonTiempo);
        textoContador2 = findViewById(R.id.textoContador2);
        Bundle param = getIntent().getExtras();
        textoContador2.setText(param.getString("monedas"));
        botonMejora.setOnClickListener(v -> {
            cantidadMejoras++;
            actualizarMejorasEnDB(String.valueOf(cantidadMejoras));
            Intent intent = new Intent();
            intent.putExtra("mejora", "multiplicacion");
            setResult(PantallaMejora.RESULT_OK, intent);
            finish();
        });
        botonTiempo.setOnClickListener(v -> {
            cantidadMejoras++;
            actualizarMejorasEnDB(String.valueOf(cantidadMejoras));
            Intent intent = new Intent();
            intent.putExtra("mejora", "nuevoTiempo");
            setResult(PantallaMejora.RESULT_OK, intent);
            finish();
        });
    }
    private void actualizarMejorasEnDB(String cantidadMejoras) {
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.actualizarMejorasUsuario(miAplicación.getCurrentUsername(), cantidadMejoras);

    }



    public void irPantallaInicio(View v){
        //cambiar de activity
        //Intent i = new Intent(this, PantallaInicio.class);
        //startActivity(i);

        Intent data = new Intent();
        setResult(RESULT_CANCELED, data);

        finish();
    }


}