package com.example.pizzeriajuanito;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;

    private RadioButton pequeña;
    private RadioButton mediana;
    private RadioButton familiar;

    private CheckBox carne;
    private CheckBox peperoni;
    private CheckBox toxino;
    private CheckBox champiñon;
    private CheckBox tomate;
    private CheckBox choclo;
    private CheckBox aceituna;

    private Button aceptar;

    private double precio = 0;
    private String ncliente;
    private String orden;
    private String intregientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txtnombre);
        pequeña = findViewById(R.id.rbpequeña);
        mediana = findViewById(R.id.rbmedia);
        familiar = findViewById(R.id.rbfamilia);

        carne = findViewById(R.id.cbcar);
        peperoni = findViewById(R.id.cbpeperoni);
        toxino = findViewById(R.id.cbtoxino);
        champiñon = findViewById(R.id.cbcham);
        tomate = findViewById(R.id.cbtomate);
        choclo = findViewById(R.id.cbchoclo);
        aceituna = findViewById(R.id.cbAce);

        aceptar= findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HacerPedido();
            }
        });

    }
    public void HacerPedido(){
        if (pequeña.isChecked()==true){
            orden= "Pequeña $ 15.00";
            precio = precio + 15;
        }
        if (mediana.isChecked()==true){
            orden= "Mediana $ 20.00";
            precio = precio + 20;
        }
        if (familiar.isChecked()==true){
            orden= "Famaliar $ 30.00";
            precio = precio + 30;
        }
        if (carne.isChecked()==true){
            precio = precio + 5;
        }
        if (peperoni.isChecked()==true){
            precio = precio + 6;
        }
        if (toxino.isChecked()==true){
            precio = precio + 4.25;
        }
        if (champiñon.isChecked()==true){
            precio = precio + 3.50;
        }
        if (tomate.isChecked()==true){
            precio = precio + 2.75;
        }
        if (choclo.isChecked()==true){
            precio = precio + 3.50;
        }
       if (aceituna.isChecked()==true){
           precio = precio + 2;
       }
        else{
            ncliente = nombre.getText().toString();
            Intent resut = new Intent(getApplicationContext(),TotalApagar.class);
            resut.putExtra("nombrecliente",ncliente);
            resut.putExtra("productodelcliente",orden);
            resut.putExtra("total",precio);
            startActivity(resut);
            precio = 0;
            orden = "";
        }
    }
}