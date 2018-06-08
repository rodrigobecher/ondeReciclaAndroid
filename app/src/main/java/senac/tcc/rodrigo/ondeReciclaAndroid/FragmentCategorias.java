package senac.tcc.rodrigo.ondeReciclaAndroid;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senac.tcc.rodrigo.GridAdapter;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit.RetrofitConfig;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Categoria;
import senac.tcc.rodrigo.onderecicla.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategorias extends Fragment {
    private GridView gridView;
    private  int [] imagens;
    private View rootView;
    private  String [] valores;
    private List<Categoria> lista;

    @SuppressLint("ValidFragment")
    public FragmentCategorias(List<Categoria> lista) {
        this.lista = lista;

    }
    public FragmentCategorias(){}



    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        return montaView(inflater,container);
    }

    public View montaView(LayoutInflater inflater, ViewGroup container){

        rootView = inflater.inflate(R.layout.fragment_fragment_categorias, container, false);

        gridView = (GridView) rootView.findViewById(R.id.gridView);

        GridAdapter gridAdapter = new GridAdapter(getContext(),lista);

        gridView.setAdapter(gridAdapter);
        return rootView;
    }

}
