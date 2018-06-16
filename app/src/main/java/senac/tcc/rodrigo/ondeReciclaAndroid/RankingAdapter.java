package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Deposito;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Ranking;
import senac.tcc.rodrigo.onderecicla.R;

/**
 * Created by Christian on 26/05/2018.
 */

public class RankingAdapter extends BaseAdapter {

    private Context context;
    private List<Deposito> lista;

    public RankingAdapter(List<Deposito> lista, Context context){
        this.lista = lista;
         this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Deposito deposito = lista.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_ranking, null);
        }

        TextView textViewNome = (TextView) convertView.findViewById(R.id.item_nome);
        TextView textViewPontuacao = (TextView) convertView.findViewById(R.id.item_pontuacao);
        if(deposito.getCliente().getNome()!= null) {
            textViewNome.setText(deposito.getCliente().getNome());
        }
        if(!deposito.getTotalDeposito().equals(0)) {
            textViewPontuacao.setText(deposito.getTotalDeposito().toString());
        }
        return convertView;
    }

}
