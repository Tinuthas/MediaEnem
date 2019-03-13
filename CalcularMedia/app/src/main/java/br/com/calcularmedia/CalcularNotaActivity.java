package br.com.calcularmedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalcularNotaActivity extends AppCompatActivity {


    EditText notaCHT;
    EditText notaCNT;
    EditText notaLCT;
    EditText notaMT;
    EditText notaR;

    TextView media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_nota);



        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    notaCHT = findViewById(R.id.txtCHT);
                    notaCNT = findViewById(R.id.txtCNT);
                    notaLCT = findViewById(R.id.txtLCT);
                    notaMT = findViewById(R.id.txtMT);
                    notaR = findViewById(R.id.txtR);
                    media = findViewById(R.id.txtMedia);

                    DomainNota nota = new DomainNota(
                            transformar(notaCHT), transformar(notaCNT),
                            transformar(notaLCT),transformar(notaMT),transformar(notaR));
                /*
                            Double.valueOf(notaCHT.getText().toString()),
                            Double.valueOf(notaCNT.getText().toString()),
                            Double.valueOf(notaLCT.getText().toString()),
                            Double.valueOf(notaMT.getText().toString()),
                            Double.valueOf(notaR.getText().toString()));

                 */
                    Intent intent = new Intent(CalcularNotaActivity.this, MediaActivity.class);
                    intent.putExtra("media", String.format("%.2f", nota.calcularNotas()));
                    startActivity(intent);
                    //media.setText(String.format("%.2f", nota.calcularNotas()));


                } catch (Exception e) {
                    media.setText(e.getMessage());
                    e.printStackTrace();
                }
            }
        });






    }

    public double transformar(EditText nota) {

        if(nota.getText().toString() == null || nota.getText().toString().isEmpty()) {
            return 0;
        }
        return Double.valueOf(nota.getText().toString());
    }
}
