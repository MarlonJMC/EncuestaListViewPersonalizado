package com.example.encuestalistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.AdaptadorResultados;
import Entidades.Resultados;

public class ResultadosLista extends AppCompatActivity {

    ListView listViewResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_lista);
        ProcesarResultados();
        Toast.makeText(this,MainActivity.ListaResultados.size()+" Cant Resultados",Toast.LENGTH_SHORT).show();
/*        listViewResultados=findViewById(R.id.ListViewResultados);
        listViewResultados.setAdapter(
                new AdaptadorResultados(this,R.layout.la_resultados,MainActivity.ListaResultados)
        );*/

    }

    private void ProcesarResultados(){
        ArrayList ComidasAgregadas=new ArrayList();
        String VectorComidas[]=new String[]{"Pizza","Alitas Buffalo","Hamburguesas","Subway","Pupusas","Yuca Frita","Pasteles de papa","Sopa de patas","Mariscada de bolos","Camarones al ajillo","Cocteles","Pescado frito"};
//        String VectorCategorias[]=new String[]{"COMIDA RAPIDA","COMIDA TIPICA","MARISCOS"};
        MainActivity.ListaResultados.clear();
        for(int i=0;i<MainActivity.ListaEncuestas.size();i++){
            for(int con=0;con<VectorComidas.length;con++){

            }
        }
//        for(int j=0;j<VectorComidas.length;j++){

  //      }
    }

    private int PosicionComida(String comida){ //En la lista de Resultados
        int pos=-1;
        if(MainActivity.ListaEncuestas.size()>0){
            for(int c=0;c<MainActivity.ListaEncuestas.size();c++){
                if(MainActivity.ListaEncuestas.get(c).getComida()==comida){
                    pos=c;
                }
            }
        }
        return pos;
    }
}
