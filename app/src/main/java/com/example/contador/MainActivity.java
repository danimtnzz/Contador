package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    BigInteger cont = BigInteger.ZERO;
    int valorsuma = 1;
    Button botonmultiplicador;
    ImageView imageView2;
    int valorMejora = 100;
    int incrementoAutomatico = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.textoContador);
        botonmultiplicador = findViewById(R.id.botonmultiplicador);
        imageView2 = findViewById(R.id.imageView2);
        contador.setText(String.valueOf(cont));
        ejecutarHilo();


    }

    private void ejecutarHilo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            //Background work here
            while (true){
                try {
                    Thread.sleep( 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cont = cont.add(BigInteger.valueOf(incrementoAutomatico));

                handler.post(() -> {
                    //UI Thread work here
                    contador.setText(actualizarTextoContador());
                });}
        });
    }

    public void sumar(View v) {
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        imageView2.startAnimation(fade_in);
        cont = cont.add(BigInteger.valueOf(valorsuma));
        actualizarTextoContador();
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

    private String actualizarTextoContador() {
        String textoContador;
        if (cont.compareTo(BigInteger.valueOf(1000)) >= 0) {
            BigInteger mil = BigInteger.valueOf(1000);

            textoContador = cont + " mil";
        } else {
            textoContador = cont.toString();
        }
        contador.setText(textoContador);
        return textoContador;
    }
    public void irPantallaInicio(View v){
        //cambiar de activity
        //Intent i = new Intent(this, PantallaInicio.class);
        //startActivity(i);
        finish();
    }
    public void irPantallaMejora(View v){
        //cambiar de activity
        Intent i = new Intent(this, PantallaMejora.class);
        i.putExtra("monedas", contador.getText());
        i.putExtra("cont", cont);
        startActivity(i);
    }
}