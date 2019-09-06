package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuestalistviewpersonalizado.DatosPersonales;
import com.example.encuestalistviewpersonalizado.MainActivity;
import com.example.encuestalistviewpersonalizado.R;

import java.util.List;

import Entidades.Encuesta;

public class AdaptadorDetalleLista extends BaseAdapter{

    List<Encuesta> DataSources;
    int idPlantilla;
    Context ctx;

    public AdaptadorDetalleLista(Context context, int idLayout, List<Encuesta> sources){
        ctx=context;
        idPlantilla=idLayout;
        DataSources=sources;
    }

    @Override
    public int getCount() {
       return MainActivity.ListaEncuestas.size();
    }

    @Override
    public Encuesta getItem(int position) {
       return MainActivity.ListaEncuestas.get(position);
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View ConvertView, ViewGroup viewGroup){
        if(ConvertView==null){
            LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(this.ctx.LAYOUT_INFLATER_SERVICE);
            //Le damos vida al archivo xml ahora es un Layout
            ConvertView = inflater.inflate(this.idPlantilla,null);

            TextView txtCategoria,txtEdad,txtGenero,txtUbicacion;
            ImageView img=ConvertView.findViewById(R.id.imgLista);
            txtCategoria=ConvertView.findViewById(R.id.Categoria);
            txtEdad=ConvertView.findViewById(R.id.Edad);
            txtGenero=ConvertView.findViewById(R.id.Genero);
            txtUbicacion=ConvertView.findViewById(R.id.Ubicacion);

            txtGenero.setText("Genero: "+DataSources.get(i).getGenero());
            txtEdad.setText("Edad: "+DataSources.get(i).getEdad());
            txtCategoria.setText("Categoria: "+DataSources.get(i).getCategoria());
            txtUbicacion.setText("Lugar: "+DataSources.get(i).getUbicacion());
            String categoria= DataSources.get(i).getCategoria();

            if(categoria.equals("COMIDA RAPIDA")){
                img.setImageResource(R.drawable.letterr);
            }else {
                if(categoria.equals("MARISCOS")){
                    img.setImageResource(R.drawable.letterm);
                }else {
                    img.setImageResource(R.drawable.lettert);
                }
            }

        }
        return ConvertView;
    }
}
