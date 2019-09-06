package com.example.encuestalistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adaptadores.AdaptadorResultados;
import Entidades.Resultados;

public class ResultadosLista extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ListView listViewResultados;
    Button btnAceptar;
    TextView txtCant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_lista);
        ProcesarResultados();
        btnAceptar=findViewById(R.id.btnAceptarResultados);
        listViewResultados=findViewById(R.id.ListViewResultados);
        listViewResultados.setAdapter(
                new AdaptadorResultados(this,R.layout.la_resultados,MainActivity.ListaResultados)
        );
        listViewResultados.setOnItemClickListener(this);
        btnAceptar.setOnClickListener(this);
    }

    private void ProcesarResultados(){
        int pos=0;
/*        ArrayList ComidasAgregadas=new ArrayList();
        ComidasAgregadas.add("Pizza");
        ComidasAgregadas.add("Alitas Buffalo");
        ComidasAgregadas.add("Hamburguesas");
        ComidasAgregadas.add("Subway");
        ComidasAgregadas.add("Pupusas");
        ComidasAgregadas.add("Yuca Frita");
        ComidasAgregadas.add("Pasteles de papa");
        ComidasAgregadas.add("Sopa de patas");
        ComidasAgregadas.add("Mariscada de bolos");
        ComidasAgregadas.add("Camarones al ajillo");
        ComidasAgregadas.add("Cocteles");
        ComidasAgregadas.add("Pescado frito");*/
//String VectorComidas[]=new String[]{"Pizza","Alitas Buffalo","Hamburguesas","Subway","Pupusas","Yuca Frita","Pasteles de papa","Sopa de patas","Mariscada de bolos","Camarones al ajillo","Cocteles","Pescado frito"};
        //        String VectorCategorias[]=new String[]{"COMIDA RAPIDA","COMIDA TIPICA","MARISCOS"};
        MainActivity.ListaResultados.clear();
        for(int i=0;i<MainActivity.ListaEncuestas.size();i++){
            pos=PosicionComidaEnListaResultados(MainActivity.ListaEncuestas.get(i).getComida());//La comida que estoy tomando en cuenta
            if(pos >- 1){
                Resultados tempExistente=(Resultados) MainActivity.ListaResultados.get(pos);
                tempExistente.AumentarCantidadUsuarioEnUno();
                tempExistente.SetGenerosParaConteo(MainActivity.ListaEncuestas.get(i).getGenero());
                tempExistente.AgregarLugar(MainActivity.ListaEncuestas.get(i).getUbicacion());
                tempExistente.AgregarEdadAlaLista(MainActivity.ListaEncuestas.get(i).getEdad());
                MainActivity.ListaResultados.add(pos,tempExistente);
               // tempExistente.setPlatillo(MainActivity.ListaEncuestas.get(i).getComida());
/*                MainActivity.ListaResultados.get(pos).AumentarCantidadUsuarioEnUno();
                MainActivity.ListaResultados.get(pos).SetGenerosParaConteo(MainActivity.ListaEncuestas.get(i).getGenero());
                MainActivity.ListaResultados.get(pos).AgregarLugar(MainActivity.ListaEncuestas.get(i).getUbicacion());
                MainActivity.ListaResultados.get(pos).AgregarEdadAlaLista(MainActivity.ListaEncuestas.get(i).getEdad());
                MainActivity.ListaResultados.get(pos).setPlatillo(MainActivity.ListaEncuestas.get(i).getComida());*/
            }else{
                Resultados temp=new Resultados(MainActivity.ListaEncuestas.get(i).getCategoria(),MainActivity.ListaEncuestas.get(i).getComida());
                temp.SetGenerosParaConteo(MainActivity.ListaEncuestas.get(i).getGenero());
                temp.AgregarEdadAlaLista(MainActivity.ListaEncuestas.get(i).getEdad());
                temp.AgregarLugar(MainActivity.ListaEncuestas.get(i).getUbicacion());
//                temp.setPlatillo(MainActivity.ListaEncuestas.get(i).getComida());
                temp.AumentarCantidadUsuarioEnUno();
                MainActivity.ListaResultados.add(temp);
            }
        }
    }

    private int PosicionComidaEnListaResultados(String comida){ //En la lista de Resultados
        int pos=-1;
        if(MainActivity.ListaResultados.size()>0){
            for(int c=0;c<MainActivity.ListaResultados.size();c++){
                if(MainActivity.ListaResultados.get(c).getPlatillo().equals(comida)){
                    pos=c;
                }
            }
        }
        return pos;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,MainActivity.ListaEncuestas.size()+" cantidad",Toast.LENGTH_SHORT).show();
    }
}
