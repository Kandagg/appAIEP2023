package cl.ico.appaiep2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Semana05 extends AppCompatActivity {
    EditText lat1, lat2, long1, long2;
    TextView distancia;
    Button limpiar, calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana05);
        lat1 = (EditText) findViewById(R.id.txtLat1);
        lat2 = (EditText) findViewById(R.id.txtLat2);
        long1 = (EditText) findViewById(R.id.txtLong1);
        long2 = (EditText) findViewById(R.id.txtLong2);
        limpiar = (Button) findViewById(R.id.btnLimpiar2);
        calcular = (Button) findViewById(R.id.btnCalcular2);
        distancia = (TextView) findViewById(R.id.lbl_distancia);

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lat1.setText("");
                lat2.setText("");
                long1.setText("");
                long2.setText("");
                distancia.setText("0");
                lat1.requestFocus();
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                distancia.setText(CalculoDistancia(lat1.getText().toString(), lat2.getText().toString(), long1.getText().toString(), long2.getText().toString()));

            }
        });

    }


    private String CalculoDistancia(String l1,String l2, String lo1,String lo2)
    {
          String dist="";

          return dist;

    }
}