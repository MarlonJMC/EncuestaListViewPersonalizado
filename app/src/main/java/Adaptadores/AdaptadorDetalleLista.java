package Adaptadores;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.encuestalistviewpersonalizado.MainActivity;

public class AdaptadorDetalleLista extends BaseAdapter{

    AdaptadorDetalleLista(){

    }

    @Override
    public int getCount() {
       return MainActivity.ListaEncuestas.size();
    }

    @Override
    public Object getItem(int position) {
       return MainActivity.ListaEncuestas.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View myview, ViewGroup viewGroup) {
        if(myview==null){

        }
        return myview;
    }
}
