package com.example.marta.examenpmdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Subactivity extends AppCompatActivity {
    // Variables:
    private TextView txtDest, txtAsun, txtMsg;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);

        txtDest = findViewById(R.id.destinatario);
        txtAsun = findViewById(R.id.asunto);
        txtMsg = findViewById(R.id.mensaje);

        btnCerrar = findViewById(R.id.btnCerrar);

        //Posem les dades rebudes des del Bundle
        Bundle datos = getIntent().getExtras();
        // Si los datos no son nulos coge los datos.
        if(datos != null){
            txtDest.setText(datos.getString("Destinatario"));
            txtAsun.setText( datos.getString("Asunto"));
            txtMsg.setText( datos.getString("Mensaje"));

        }

        // Para cerrar la pestaña:
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

    }


}
