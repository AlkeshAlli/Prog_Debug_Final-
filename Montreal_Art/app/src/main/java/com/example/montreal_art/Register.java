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

import com.example.montreal_art.Retro.Retrofit_Client;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText e_mail,e_password,e_name,e_phone;
    Button b_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e_mail = findViewById(R.id.editText3);
        e_password = findViewById(R.id.editText4);
        e_name = findViewById(R.id.editText5);
        e_phone = findViewById(R.id.editText6);
        b_signup = findViewById(R.id.button3);

        final String s_mail,s_password,s_name,s_phone;

        b_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, phone,name ;
                email = e_mail.getText().toString();
                password = e_password.getText().toString();
                name = e_name.getText().toString();
                phone = e_phone.getText().toString();

                if(name.isEmpty()){
                    e_name.setError("name field empty");
                    e_name.requestFocus();
                    return;
                }

                if(email.isEmpty()){
                    e_mail.setError("email field empty");
                    e_mail.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    e_mail.setError("Enter Valid Email");
                    e_mail.requestFocus();
                    return;
                }
                if(password .isEmpty() && password.length()<=8){
                    e_password.setError("Enter a valid Password");
                    e_password.requestFocus();
                    return;
                }

                if(phone.isEmpty()) {
                    e_phone.setError("phone field empty");
                    e_phone.requestFocus();
                    return;
                }
                Call<ResponseBody> call = Retrofit_Client.getInstance().getApi().register(email,name,password,phone);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String s = response.body().string();
                            Intent intent=new Intent(Register.this,MainActivity.class);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(Register.this, "Regsitrartion Failed Try Again!", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });
    }
}
