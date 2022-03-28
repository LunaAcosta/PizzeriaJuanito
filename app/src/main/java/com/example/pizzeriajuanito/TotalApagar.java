package com.example.pizzeriajuanito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalApagar extends AppCompatActivity {

    private Button vol;

    private TextView nombredelCliente;
    private TextView ordenSelecionada;
    private TextView TotalApagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_apagar);

        nombredelCliente=findViewById(R.id.txtrnombre);
        ordenSelecionada=findViewById(R.id.txtProduct);
        TotalApagar=findViewById(R.id.txttotal);

        Bundle extra = getIntent().getExtras();

        String clientes =  extra.getString("nombrecliente");
        String orden = extra.getString("productodelcliente");
        Double totales = extra.getDouble("total");

        nombredelCliente.setText(String.valueOf("ESTIMADO CLIENTE:  " + clientes));
        ordenSelecionada.setText(String.valueOf("SU ORDEN SELECIONADA ES:  " + orden));
        TotalApagar.setText(String.valueOf("TOTAL APAGAR ES: $ " + totales));

        vol=findViewById(R.id.btnvolver);
        vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atraPantalla = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(atraPantalla);
            }
        });
    }
}