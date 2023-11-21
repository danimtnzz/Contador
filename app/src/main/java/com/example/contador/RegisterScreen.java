package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterScreen extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.buttonSignUp);
        signin = (Button) findViewById(R.id.buttonSignIn);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(RegisterScreen.this, "Porfavor rellena todos los campos", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.checkUsername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if (insert==true){
                                Toast.makeText(RegisterScreen.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), PantallaInicio.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterScreen.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(RegisterScreen.this, "Usuario ya existente! Por favor inicia sesión", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterScreen.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
            }
        });
    }
}