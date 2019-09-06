package com.example.encuestalistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import Adaptadores.AdaptadorDetalleLista;

public class DetallesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listViewDetalles;
    TextView txtDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        listViewDetalles=findViewById(R.id.ListViewDetalles);
        listViewDetalles.setAdapter(new AdaptadorDetalleLista(this,R.layout.la_items_lista,MainActivity.ListaEncuestas));
        listViewDetalles.setOnItemClickListener(this);
        txtDetalles=findViewById(R.id.CantDetalles);
        txtDetalles.setText("Cantidad encuestas: "+listViewDetalles.getCount());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        Toast.makeText(this,"Preferencia: "+MainActivity.ListaEncuestas.get(i).getComida(),Toast.LENGTH_SHORT).show();
    }
}
