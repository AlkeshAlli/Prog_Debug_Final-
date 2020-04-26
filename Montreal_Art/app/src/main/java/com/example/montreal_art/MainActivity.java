package com.example.montreal_art;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.montreal_art.Retro.Node_Interface;
import com.example.montreal_art.Retro.Retrofit_Client;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText e_email,e_pass;
    Button b_login,b_singnup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_email = findViewById(R.id.editText);
        e_pass = findViewById(R.id.editText2);
        b_login= findViewById(R.id.button);
        b_singnup= findViewById(R.id.button2);
        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data_email = e_email.getText().toString();
                String data_pass = e_pass.getText().toString();
                check_login(data_email,data_pass);
            }
        });
        b_singnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }

    private void check_login(String data_email, String data_pass) {

        String email=data_email;
        String password = data_pass;
        if (data_email.isEmpty()) {
            e_email.setError("Email Field Empty");
            e_email.requestFocus();

        } else if (!Patterns.EMAIL_ADDRESS.matcher(data_email).matches()) {
            e_email.setError("Enter Valid Email");
            e_email.requestFocus();

        } else if (data_pass.isEmpty()) {
            e_pass.setError("Password Field Empty");
            e_pass.requestFocus();


        } else if (data_pass.length() <=8) {
            e_pass.setError("Enter valid Password (>=8)");
            e_pass.requestFocus();
        } else {
            Call<ResponseBody> call = Retrofit_Client.getInstance().getApi().login(email, password);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {

                        String s = response.body().string();
                        Intent intent=new Intent(MainActivity.this,Art_home.class);
                        startActivity(intent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Login Failed Try Again!", Toast.LENGTH_LONG).show();

                }
            });
        }
    }

}
