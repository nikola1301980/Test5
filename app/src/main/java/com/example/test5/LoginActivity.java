package com.example.test5;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    public static final String TXT="";

    Button login;
    EditText username, password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (login(username.getText().toString(), password.getText().toString())){

                    String txt=username.getText().toString();
                    Intent intent=new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra(TXT, txt);
                    startActivity(intent);

                }else {
                    Toast.makeText(getApplicationContext(), "Please enter correct Username and password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean login(String us, String pw){
        if (us.equals("Pop") && pw.equals("Nik")){
            return true;
        }else {
            return false;
        }
    }

    public void showAlertDialogButtonClicked() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dialog box");
        builder.setMessage("Kliknuli ste Login");
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}
