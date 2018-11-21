package com.example.marta.examenpmdm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GuardarDatosDeMensajes} interface
 * to handle interaction events.
 * Use the {@link Fragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author marta
 * Este fragment es el correspondiente a lo que sería el E-Mail.
 */
public class Fragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // VARIABLES CREADAS:
    // Campos de texto en fragment:
    private EditText etDestino, etAsunto, etMsg;
    // Datos del usuario:
    private String destinatario, asunto, msg;

    // Crea un objeto del tipo de la interfaz creada más abajo del todo.
    private GuardarDatosDeMensajes mListener;

    public Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment newInstance(String param1, String param2) {
        Fragment fragment = new Fragment();
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
     * Método editado:
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_, container, false);
        // Asignamos los valores del XMl a objetos de JAVA.
        etDestino = (EditText) v.findViewById(R.id.tv_destinatari);
        etAsunto = (EditText) v.findViewById(R.id.tv_assumpte);
        etMsg = (EditText) v.findViewById(R.id.tv_missatge);

        // Inflate the layout for this fragment
        return v;
    }

    /**
     * Método para comprobar los datos introducidos en los campos de texto.
     */
    private void comprobarDatos() {
        // Si los campos no están vacíos:
        if (!String.valueOf(etDestino.getText()).isEmpty() && !String.valueOf(etAsunto.getText()).isEmpty()
                && !String.valueOf(etMsg.getText()).isEmpty()) {
            destinatario = etDestino.getText().toString();
            asunto = etAsunto.getText().toString();
            msg = etMsg.getText().toString();

            // Para comprobar si se guardaron:
            if (mListener.guardarDatos(destinatario, asunto, msg))
                Toast.makeText(getActivity(), "Datos guardados con éxito", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity(), "Error al guardar los datos.", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     *  Editado para acoplar la nueva interfaz correctamente.
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GuardarDatosDeMensajes) {
            mListener = (GuardarDatosDeMensajes) context;
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
     *  Interfaz para poder guardar toda la info de los mensajes y reescribirla.
     */
    public interface GuardarDatosDeMensajes {

        boolean guardarDatos(String dest, String asun, String msg);
    }
}


