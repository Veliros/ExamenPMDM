package com.example.marta.examenpmdm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceActivity;

/**
 * Preferencias o "Settings", configuración.
 */
public class Preferencias extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    SharedPreferences preferenciasUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

        // Leer preferencias y actualizar summaries.
        actualitzaSummaries();
    }

    /**
     *
     * @param sharedPreferences
     * @param key
     */
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("nombre")) {
            Preference pref = findPreference(key);
            pref.setSummary(sharedPreferences.getString(key, "Ninguno").toString());
        }
        if(key.equals("color_fondo")) {
            Preference pref = findPreference(key);
            pref.setSummary(sharedPreferences.getString(key, "Ninguno").toString());
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    /**
     * Actualiza los summaries haciendo que lo de abajo obtenga un valor distinto.
     */
    public void actualitzaSummaries(){
        preferenciasUsuario = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Preference pref;
        // Usuario:
        pref = findPreference("nombre");
        pref.setSummary(preferenciasUsuario.getString("nombre","Ninguno"));
        // Color:
        pref = findPreference("color_fondo");
        pref.setSummary(preferenciasUsuario.getString("color_fondo", "Ninguno").toString());


    }

}
