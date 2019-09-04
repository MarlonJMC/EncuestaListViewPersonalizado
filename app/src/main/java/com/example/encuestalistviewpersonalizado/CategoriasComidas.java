package com.example.encuestalistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import Entidades.Encuesta;

public class CategoriasComidas extends AppCompatActivity  implements View.OnClickListener {

    Encuesta encuestaRecibida;
    TextView txtCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_comidas);

        Bundle objetoRecibido=getIntent().getExtras();
        encuestaRecibida=null;
        if (objetoRecibido!=null){
            encuestaRecibida=(Encuesta) objetoRecibido.getSerializable("Encuesta");
        }
    }


    @Override
    public void onClick(View view){
        Bundle bundleEncuesta=new Bundle();
        switch (view.getId()){
            case R.id.LaTipicos:{
                Intent intento1 = new Intent();
                intento1.putExtra("Categoria","COMIDA TIPICA");
                this.encuestaRecibida.setCategoria("COMIDA TIPICA");
                bundleEncuesta.putSerializable("Encuesta",encuestaRecibida);
                intento1.putExtras(bundleEncuesta);
                intento1.setClass(CategoriasComidas.this,SeleccionComida.class);
                intento1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intento1);
                finish();
            }break;

            case R.id.LaMariscos:{
                Intent intento2 = new Intent();
                intento2.putExtra("Categoria","MARISCOS");
                this.encuestaRecibida.setCategoria("MARISCOS");
                bundleEncuesta.putSerializable("Encuesta",encuestaRecibida);
                intento2.putExtras(bundleEncuesta);
                intento2.setClass(CategoriasComidas.this,SeleccionComida.class);
                intento2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intento2);
                finish();
            }break;

            case R.id.LaRapida:{
                Intent intento3 = new Intent();
                intento3.putExtra("Categoria","COMIDA RAPIDA");
                this.encuestaRecibida.setCategoria("COMIDA RAPIDA");
                bundleEncuesta.putSerializable("Encuesta",encuestaRecibida);
                intento3.putExtras(bundleEncuesta);
                intento3.setClass(CategoriasComidas.this,SeleccionComida.class);
                intento3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intento3);
                finish();
            }break;
        }
    }
}
