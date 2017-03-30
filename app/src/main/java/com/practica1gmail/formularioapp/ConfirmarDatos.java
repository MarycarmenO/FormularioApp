package com.practica1gmail.formularioapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity implements View.OnClickListener{

    private TextView Nombre1,Telefono1,Direccion1, FechaN1;
    private Button btnEditar,btnAceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirmar_datos);
        btnEditar = (Button)findViewById(R.id.buttoneditar);
        btnAceptar = (Button)findViewById(R.id.buttonAceptar);
        Nombre1=(TextView) findViewById(R.id.Nombre1);
        Direccion1=(TextView)findViewById(R.id.Direccion1);
        Telefono1=(TextView)findViewById(R.id.Telefono1);
        FechaN1=(TextView)findViewById(R.id.FechaN1);

        Intent intent;//Declaro el Intent

        intent = getIntent();
        Bundle extras=intent.getExtras();
        if (extras != null) {//ver si contiene datos

            String datoNombre=(String)extras.get("nombre");//Obtengo el nombre
            String datoDireccion= (String) extras.get("direccion");
            String datoTelefono= (String) extras.get("telefono");
            String datoFechaN=(String) extras.get("fecha");


            Nombre1.setText(datoNombre);
            Telefono1.setText(datoTelefono);
            Direccion1.setText(datoDireccion);
            FechaN1.setText(datoFechaN);

      }
        btnEditar.setOnClickListener(this);
        btnAceptar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnEditar){
            Intent intentE;
            intentE=new Intent(this,MainActivity.class);
            startActivity(intentE);
        }else if (v==btnAceptar){
            Intent intentE;
            intentE=new Intent(this,graciasC.class);
            startActivity(intentE);
        }
        }
        }

