package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Ranking;
import senac.tcc.rodrigo.onderecicla.R;

/**
 * Created by Christian on 26/05/2018.
 */

public class RankingAdapter extends BaseAdapter {

    private Context context;
    private List<Ranking>rankings = null;

    public RankingAdapter(Context context, List<Ranking> rankings){
         this.context = context;
         this.rankings = rankings;
    }

    @Override
    public int getCount() {
        return rankings.size();
    }

    @Override
    public Object getItem(int position) {
        return rankings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rankings.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ranking ranking = rankings.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_ranking, null);
        }

        TextView textViewNome = (TextView) convertView.findViewById(R.id.item_nome);
        TextView textViewPontuacao = (TextView) convertView.findViewById(R.id.item_pontuacao);

        textViewNome.setText(ranking.getNomeCliente());
        textViewPontuacao.setText((int) ranking.getPontuacao());

        return convertView;
    }
}
