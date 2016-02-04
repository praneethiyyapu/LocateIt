package com.example.prane.mymaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by prane on 2/2/2016.
 */
public class Login extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void onLogin(View view){
            if (view.getId()==R.id.loginButton){
                EditText et1 = (EditText)findViewById(R.id.editTextUsername);
                String str1 = et1.getText().toString();
                EditText et2 = (EditText)findViewById(R.id.editTextPassword);
                String str2 = et2.getText().toString();
                if((str1.equals("Admin")) && (str2.equals("Admin"))) {
                    Intent i = new Intent(this, MapsActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Login.this, "Incorrect username or password!",
                            Toast.LENGTH_SHORT).show();
                }
            }

    }
}





