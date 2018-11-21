package com.example.marta.examenpmdm;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.InteraccionConBotonera} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author marta
 *
 * Este Fragment sería correspondiente a la Botonera.
 */
public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Para aplicar la interfaz:
    private InteraccionConBotonera mListener;

    // Botones:
    Button btnEnviar;
    ImageButton btnPreferencias;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * Este método asigna los valores correspondientes del XML y trabaja con Listeners.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return v
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        // Aignamos los valores del xml a objetos java.
        btnEnviar = (Button) v.findViewById(R.id.btn_enviar);
        btnPreferencias = (ImageButton) v.findViewById(R.id.btn_configuracio);


        // Acciones de cada botón, listeners:
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.cargaDatosAlSubactivity(); // Llamamos al método que carga datos a la subactivity.
            }
        });

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.cargaPreferencias();  // Llamamos al método que abre las preferencias.
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    /**
     * Adaptado a la interfaz nueva.
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteraccionConBotonera) {
            mListener = (InteraccionConBotonera) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Interfaz para cargar datos al fragmento y a la subactivity.
     *
     * No terminado la comunicación entre activities.
     */
    public interface InteraccionConBotonera {

        void cargaDatosAlSubactivity();
        void cargaPreferencias();
        void enviaMsg();
    }
}
