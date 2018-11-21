package com.example.marta.examenpmdm;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;

/**
 * @author marta
 */
public class MainActivity extends AppCompatActivity implements
        com.example.marta.examenpmdm.Fragment.GuardarDatosDeMensajes, Fragment2.InteraccionConBotonera{

    // Atributos:
    private FragmentManager fm;
    private com.example.marta.examenpmdm.Fragment.GuardarDatosDeMensajes gdm;
    private Fragment2.InteraccionConBotonera icb;

    private Fragment f1, f2;
    private String dest, asun, msg;
    // Constante con código de subactivity.
    private final int COD_SUBACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        f1 = (com.example.marta.examenpmdm.Fragment) fm.findFragmentById(R.id.fragment);
        f2 = (Fragment2) fm.findFragmentById(R.id.fragment2);
    }

    @Override
    public boolean guardarDatos(String dest, String asun, String msg) {
        this.asun = asun;
        this.dest = dest;
        this.msg = msg;

        return true;
    }

    @Override
    public void cargaDatosAlSubactivity() {
        Intent i = new Intent(this,Subactivity.class);
        Bundle datosAPasarAlSubactivity = new Bundle();
        datosAPasarAlSubactivity.putString("Destinatario",this.dest);
        datosAPasarAlSubactivity.putString("Asunto",this.asun);
        datosAPasarAlSubactivity.putString("Mensaje",this.msg);

        i.putExtras(datosAPasarAlSubactivity);

        startActivityForResult(i,COD_SUBACTIVITY); // Llamamos al subactivity.

    }

    @Override
    public void cargaPreferencias() {
        Intent i = new Intent(getApplicationContext(),Preferencias.class);
        startActivity(i);

    }

    @Override
    public void enviaMsg() {

    }


}
