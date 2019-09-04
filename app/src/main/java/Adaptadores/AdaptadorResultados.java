package Adaptadores;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EdgeEffect;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuestalistviewpersonalizado.MainActivity;
import com.example.encuestalistviewpersonalizado.R;

import java.util.List;
import java.util.zip.Inflater;

import Entidades.Resultados;

public class AdaptadorResultados extends BaseAdapter {

    private int idPlantilla;
    private List<Resultados>DataSources;
    private Context cntx;

    public AdaptadorResultados(Context context, int Id_plantilla, List<Resultados> sources){
        this.idPlantilla=Id_plantilla;
        this.DataSources=sources;
        this.cntx=context;
    }

    @Override
    public int getCount() {
        return this.DataSources.size();
    }

    @Override
    public Resultados getItem(int position){
        return DataSources.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup viewGroup){
        if(ConvertView==null){
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            //Le damos vida al archivo xml ahora es un Layout
            ConvertView = inflater.inflate(this.idPlantilla,null);
            //Declaraciones e inicializacion de variables...
            TextView txtComida,txtCategoria,txtTotal,txtM,txtF,txtO,txtLugares;
            txtComida=ConvertView.findViewById(R.id.ResultadoComida);
            txtCategoria=ConvertView.findViewById(R.id.ResultadoCategoria);
            txtTotal=ConvertView.findViewById(R.id.ResultadoCantidadTotal);
            txtM=ConvertView.findViewById(R.id.RCantidadM);
            txtF=ConvertView.findViewById(R.id.RCantidadF);
            txtO=ConvertView.findViewById(R.id.RCantidadO);
            ImageView img=ConvertView.findViewById(R.id.ResultadoImgSegunCategoria);
            txtLugares=ConvertView.findViewById(R.id.ResultadoLugares);

            //Asignacion de datos...
            txtCategoria.setText(DataSources.get(position).getCategoria());
            txtComida.setText(DataSources.get(position).getPlatillo());
            txtTotal.setText("Total de encuestados: "+DataSources.get(position).getCantidadUsuarios());
            txtF.setText("Femeninos:"+DataSources.get(position).getcF());
            txtM.setText("Masculinos:"+DataSources.get(position).getcM());
            txtO.setText("Otros:"+DataSources.get(position).getcO());
            txtLugares.setText(DataSources.get(position).DevolverLugares());
            if(txtCategoria.getText().toString()=="COMIDA RAPIDA"){
                img.setImageResource(R.drawable.letterr);
            }else {
                if(txtCategoria.getText().toString()=="MARISCOS"){
                    img.setImageResource(R.drawable.letterm);
                }else {
                    img.setImageResource(R.drawable.lettert);
                }
            }
        }
        return ConvertView;
    }
}
