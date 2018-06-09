package senac.tcc.rodrigo.ondeReciclaAndroid;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private View rootView;
    private List<Categoria> lista;
    private Context context;
    @SuppressLint("ValidFragment")
    public FragmentCategorias(List<Categoria> lista, Context context) {
        this.lista = lista;
        this.context = context;

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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Categoria categoria = lista.get(position);
                Intent intent = new Intent(context, activity_empresa.class);
                intent.putExtra("categoria", categoria);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
