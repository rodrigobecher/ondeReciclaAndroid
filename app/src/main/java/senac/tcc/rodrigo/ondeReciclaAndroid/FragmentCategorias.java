package senac.tcc.rodrigo.ondeReciclaAndroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import senac.tcc.rodrigo.GridAdapter;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.onderecicla.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategorias extends Fragment {
    private GridView gridView;
    private Cliente cliente;
    private  int [] imagens;
    private  String [] valores;

    public FragmentCategorias() {
        // Required empty public constructor
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] valores = new String[]{
                new String("teste")
        };
        imagens = new int[1];

        imagens[0] = 1;
        gridView = (GridView) gridView.findViewById(R.id.gridView);

        GridAdapter gridAdapter = new GridAdapter(this,valores, imagens);

        gridView.setAdapter(gridAdapter);
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] valores = new String[]{
                new String("teste"),
                new String("teste2"),
                new String("teste30")
        };

        imagens = new int[1];

        imagens[0] = 1;


        View rootView = inflater.inflate(R.layout.fragment_fragment_categorias, container, false);

        gridView = (GridView) rootView.findViewById(R.id.gridView);

        GridAdapter gridAdapter = new GridAdapter(getContext(),valores, imagens);

        gridView.setAdapter(gridAdapter);
        return rootView;
    }

}
