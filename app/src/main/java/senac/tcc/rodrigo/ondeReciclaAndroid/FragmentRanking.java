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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

import senac.tcc.rodrigo.GridAdapter;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Categoria;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Deposito;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Ranking;
import senac.tcc.rodrigo.onderecicla.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRanking extends Fragment {

    private View rootView;
    private ListView listView;
    private List<Deposito> lista;
    private Context context;

    @SuppressLint("ValidFragment")
    public FragmentRanking(List<Deposito> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }
    public FragmentRanking() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return montaView(inflater,container);

    }
    public View montaView(LayoutInflater inflater, ViewGroup container){

        rootView = inflater.inflate(R.layout.fragment_fragment_ranking2, container, false);

        listView = (ListView) rootView.findViewById(R.id.listaRanking);
        RankingAdapter rankingAdapter = new RankingAdapter(lista, getContext());
        listView.setAdapter(rankingAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return rootView;
    }

}
