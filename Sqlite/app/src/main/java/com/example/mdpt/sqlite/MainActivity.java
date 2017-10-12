package com.example.mdpt.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConexioSqliteHelper conx = new ConexioSqliteHelper(this, "bd_contactos", null, 1);

    }

    public void onClick(View view) {
        Intent miIntent = null;
        switch (view.getId()){
            case R.id.btn_tres:
                miIntent = new Intent(MainActivity.this, Consultar.class);
                break;
            case R.id.btn_inserta:
                miIntent = new Intent(MainActivity.this, RegistraContactosActivity.class);
                break;
        }
        startActivity(miIntent);
    }

    /**
     * Created by MDPT on 11/10/2017.
     */

    public static class Consultar {

    }
}
