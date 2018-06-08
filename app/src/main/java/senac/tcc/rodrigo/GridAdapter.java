package senac.tcc.rodrigo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import senac.tcc.rodrigo.ondeReciclaAndroid.FragmentCategorias;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Categoria;
import senac.tcc.rodrigo.onderecicla.R;

/**
 * Created by Christian on 29/05/2018.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    List<Categoria> lista;
    View view;
    LayoutInflater layoutInflater;

    FragmentCategorias fragmentCategorias;

    public GridAdapter(Context context, List<Categoria> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Categoria categoria = lista.get(position);
        if (convertView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.item_categoria,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.foto_categoria);
            Glide.with(context)
                    .load(categoria.getUrl())
                    .into(imageView);

            TextView textView = (TextView) view.findViewById(R.id.txtCategoria);
            textView.setText(categoria.getDescricao());
        }

        return view;


    }
}
