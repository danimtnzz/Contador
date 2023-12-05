package com.example.contador;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    private MediaPlayer mediaPlayer;

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            (result) -> {
                if (result.getResultCode() == RESULT_OK) {
                    String mejora = result.getData().getStringExtra("mejora");
                    switch (mejora) {
                        case "multiplicacion":
                            multiplicador();
                            break;
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.textoContador);
        botonmultiplicador = findViewById(R.id.botonmultiplicador);
        imageView2 = findViewById(R.id.imageView2);
        mediaPlayer = MediaPlayer.create(this, R.raw.sonido_moneda);
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
        //incrementar monedas y actualizar contador
        cont = cont.add(BigInteger.valueOf(valorsuma));
        actualizarTextoContador();
        // Llamar al método para actualizar las monedas en la base de datos
        actualizarMonedasEnDB(String.valueOf(cont));
        mediaPlayer.start();
    }
    private void actualizarMonedasEnDB(String cantidadMonedas) {
        DBHelper dbHelper = new DBHelper(this);
        boolean actualizado = dbHelper.actualizarMonedasUsuario("nombre_de_usuario", cantidadMonedas);

        if (actualizado) {
            // La cantidad de monedas se ha actualizado correctamente en la base de datos
        } else {
            // Hubo un error al actualizar las monedas en la base de datos
        }
    }

    public void multiplicador() {
        if (cont.compareTo(BigInteger.valueOf(valorMejora)) >= 0) {
            cont = cont.subtract(BigInteger.valueOf(valorMejora));
            valorsuma *= 2;
            valorMejora += 20;
            actualizarMonedasEnDB(String.valueOf(cont));
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
    public void irPantallaRanking(View v) {
        Intent i = new Intent(this, Ranking.class);
        i.putExtra("monedas", contador.getText().toString());
        startActivity(i);
    }
    public void irPantallaMejora(View v){
        //cambiar de activity
        Intent i = new Intent(this, PantallaMejora.class);
        i.putExtra("monedas", contador.getText());
        i.putExtra("cont", cont);
        i.putExtra("valorsuma", valorsuma);
        launcher.launch(i);
    }
}