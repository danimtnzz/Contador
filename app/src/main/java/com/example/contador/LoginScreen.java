package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    EditText username, password;
    Button buttonLogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        buttonLogin = (Button) findViewById(R.id.buttonSignIn1);

        DB = new DBHelper(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginScreen.this, "Por favor rellena todos los campos", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkUsernamePassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginScreen.this, "Sesión iniciada correctamente!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), PantallaInicio.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginScreen.this, "Credenciales inválidas!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}