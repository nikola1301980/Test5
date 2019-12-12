package com.example.test5;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView ispis, main_tooltext;
    Button main_back, main_plus;


    String tx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        tx=intent.getStringExtra(LoginActivity.TXT);


        ispis=(TextView) findViewById(R.id.main_ispis);
        ispis.setText("Welcome "+tx);

        main_tooltext=(TextView) findViewById(R.id.main_tooltext);
        main_back=(Button) findViewById(R.id.main_back);
        main_plus=(Button) findViewById(R.id.main_plus);

        main_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
                }
            }
        );

        main_plus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showDialogAlert();
                }
            }
        );


    }

    public void showDialogAlert(){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.alert_dialog, null);

        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setView(view).create();
        alertDialog.show();
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
