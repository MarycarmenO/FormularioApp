package com.practica1gmail.formularioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnEnviar;
    private EditText editTextNombre, editTextDireccion, editTextTelefono;
    private String FechaNac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextDireccion = (EditText) findViewById(R.id.editTextDireccion);
        editTextTelefono = (EditText) findViewById(R.id.editTextTelefono);

        btnEnviar.setOnClickListener(this);

    } public String fecha(int anio,int mes,int dia){
        return  dia+"/"+mes+"/"+anio;
    }

    @Override
    public void onClick(View v) {

        Intent intent;//Declaro el Intent

        DatePicker fecha=(DatePicker) findViewById(R.id.datePicker2) ;
        //obtiene los datos de modo entero
        int anio=fecha.getYear();
        int mes=fecha.getMonth();
        int dia=fecha.getDayOfMonth();
        mes = mes+1;

         FechaNac=fecha(anio,mes,dia);

        //Instanciamos el Intent dandole:
        // el contexto y la clase a la cual a la q quiere ir
        intent = new Intent(this,ConfirmarDatos.class);
        String Nombre=editTextNombre.getText().toString();
        String Direccion=editTextDireccion.getText().toString();
        String Telefono=editTextTelefono.getText().toString();
        String FechaN = FechaNac;

        intent.putExtra("nombre",Nombre);
        intent.putExtra("direccion",Direccion);
        intent.putExtra("telefono",Telefono);
        intent.putExtra("fecha",FechaN);

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(intent);
    }
}
