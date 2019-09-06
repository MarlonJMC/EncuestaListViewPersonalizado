package com.example.encuestalistviewpersonalizado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Entidades.Encuesta;

public class SeleccionComida extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView titulo,Seleccion;
    List<String> PosiblesSelecciones;
    String categoria;
    ListView listView;
    int PosSeleccionActual;
    Encuesta FinalEncuestaObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_comida);
        PosSeleccionActual=-1;
        titulo=findViewById(R.id.Titulo);
        Seleccion=findViewById(R.id.Seleccionado);
        PosiblesSelecciones=new ArrayList<String>();
        categoria=getIntent().getStringExtra("Categoria");
        titulo.setText(categoria);
        LLenarPosiblesSelecciones(categoria);

        listView=findViewById( R.id.ListViewSeleccion);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,PosiblesSelecciones));
        listView.setOnItemClickListener(this);
//        listView.deferNotifyDataSetChanged();

        Bundle objetoRecibido=getIntent().getExtras();//Recibo Objeto encuesta desde la anterior
        FinalEncuestaObject=null;
        if (objetoRecibido!=null){
            FinalEncuestaObject=(Encuesta) objetoRecibido.getSerializable("Encuesta");
        }
    }

    private void LLenarPosiblesSelecciones(String Categoria){
        switch (Categoria){
            case "COMIDA RAPIDA":{
                this.PosiblesSelecciones.add("Pizza");
                this.PosiblesSelecciones.add("Alitas Buffalo");
                this.PosiblesSelecciones.add("Hamburguesas");
                this.PosiblesSelecciones.add("Subway");
            }break;

            case "COMIDA TIPICA":{
                this.PosiblesSelecciones.add("Pupusas");
                this.PosiblesSelecciones.add("Yuca Frita");
                this.PosiblesSelecciones.add("Pasteles de papa");
                this.PosiblesSelecciones.add("Sopa de patas");
            }break;

            case "MARISCOS":{
                this.PosiblesSelecciones.add("Mariscada de bolos");
                this.PosiblesSelecciones.add("Camarones al ajillo");
                this.PosiblesSelecciones.add("Cocteles");
                this.PosiblesSelecciones.add("Pescado frito");
            }break;

            default:{//Tipicos por defecto
                this.PosiblesSelecciones.add("Pupusas");
                this.PosiblesSelecciones.add("Yuca Frita");
                this.PosiblesSelecciones.add("Pasteles de papa");
                this.PosiblesSelecciones.add("Sopa de patas");
            }
                break;
        }
    }

    @Override
    public void onClick(View view){

        AlertDialog.Builder Abuilder= new AlertDialog.Builder(SeleccionComida.this);
        Abuilder.setTitle("Datos almacenados con éxito");
        Abuilder.setMessage("¿Desea Mantener sus datos ingresados para realizar otra encuesta a continuación ?");
        Abuilder.setPositiveButton("Si", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                FinalEncuestaObject.setComida(PosiblesSelecciones.get(PosSeleccionActual).toString());
//                MainActivity.ListaEncuestas;
                MainActivity.nuevoEncuestaActual();
                MainActivity.ListaEncuestas.add(FinalEncuestaObject);
                MainActivity.EncuestaActual.setEdad(FinalEncuestaObject.getEdad());
                MainActivity.EncuestaActual.setGenero(FinalEncuestaObject.getGenero());
                MainActivity.EncuestaActual.setUbicacion(FinalEncuestaObject.getUbicacion());
//                Encuesta tem=FinalEncuestaObject;
//                MainActivity.EncuestaActual=FinalEncuestaObject;
//              tem.setComida("");
//                MainActivity.EncuestaActual=tem;
//                FinalEncuestaObject.setComida("");
                finish();
            }
        });

        Abuilder.setNegativeButton("NO", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FinalEncuestaObject.setComida(PosiblesSelecciones.get(PosSeleccionActual).toString());
                MainActivity.ListaEncuestas.add(FinalEncuestaObject);
                MainActivity.EncuestaActual=null;
                  finish();
            }
        });
        Abuilder.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        this.PosSeleccionActual=i;
        this.Seleccion.setText("Has seleccionado: "+PosiblesSelecciones.get(i).toString());
    }
}
