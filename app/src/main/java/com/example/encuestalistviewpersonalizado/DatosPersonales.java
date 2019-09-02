package com.example.encuestalistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.VectorEnabledTintResources;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import Entidades.Encuesta;

public class DatosPersonales extends AppCompatActivity implements View.OnClickListener {

    TextView txtNoEncuesta;
    Encuesta primerosDatos;
    EditText edtEdad;
    EditText edtUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);
        txtNoEncuesta=findViewById(R.id.noEncuesta);
        txtNoEncuesta.setText("No. Encuesta: "+MainActivity.ListaEncuestas.size()+1);
        edtEdad=findViewById(R.id.Edad);
        edtUbicacion=findViewById(R.id.Ubicacion);
        primerosDatos=new Encuesta();
    }

    @Override
    public void onClick(View view){
        if(DatosSonValidos()){
            String edad=edtEdad.getText().toString();
            String Ubicacion=edtUbicacion.getText().toString();
            primerosDatos.setGenero(getGeneroSeleccionado());
            primerosDatos.setEdad(edad);
            primerosDatos.setUbicacion(Ubicacion);

            Intent intentoSiguiente=new Intent();
            Bundle bundleEncuesta=new Bundle();
            bundleEncuesta.putSerializable("Encuesta", primerosDatos);
            intentoSiguiente.setClass(DatosPersonales.this,CategoriasComidas.class);
            intentoSiguiente.putExtras(bundleEncuesta);
            intentoSiguiente.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentoSiguiente);
            finish();
        } else {
            Toast.makeText(this,"Favor proporcionar todos los datos ",Toast.LENGTH_SHORT).show();
        }
    }


    private boolean DatosSonValidos(){
        boolean valido=false;
        RadioButton rbM=findViewById(R.id.RbMasculino);
        RadioButton rbF=findViewById(R.id.RbFemenino);
        RadioButton rbO=findViewById(R.id.RbOtro);
        if(edtEdad.getText().toString().length()>0 && edtUbicacion.getText().toString().length()>0){
            if(rbF.isChecked() || rbM.isChecked() || rbO.isChecked()){
                valido=true;
            }else{
                valido=false;
            }
        }
        return valido;
    }

    private String getGeneroSeleccionado(){
        RadioButton rbM=findViewById(R.id.RbMasculino),rbF=findViewById(R.id.RbFemenino),rbO=findViewById(R.id.RbOtro);
        String radioSelecto="";
        if(rbM.isChecked()){
            radioSelecto=rbM.getText().toString();
        }

        if(rbF.isChecked()){
            radioSelecto=rbF.getText().toString();
        }

        if(rbO.isChecked()){
            radioSelecto=rbO.getText().toString();
        }
        return radioSelecto;
    }

}
