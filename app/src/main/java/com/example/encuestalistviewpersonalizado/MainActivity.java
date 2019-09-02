package com.example.encuestalistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Entidades.Encuesta;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static List<Encuesta>ListaEncuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListaEncuestas=new ArrayList<Encuesta>();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDatos:{
                Intent intentoDatos=new Intent();
                intentoDatos.setClass(this,DatosPersonales.class);
                startActivity(intentoDatos);
            }break;
            case R.id.btnProcesar:{
                if(ListaEncuestas.size()>0){
                    Intent intentoProcesar=new Intent();
                    intentoProcesar.setClass(this,ResultadosLista.class);
                    startActivity(intentoProcesar);
                }else{
                    Toast.makeText(this,"Lista vacía...Realice encuestas",Toast.LENGTH_LONG).show();
                }
            }break;
            case R.id.btnDetalles:{
                Intent intentoDetalles=new Intent();
                intentoDetalles.setClass(this,DetallesActivity.class);
                startActivity(intentoDetalles);
            }break;
        }
    }
}
