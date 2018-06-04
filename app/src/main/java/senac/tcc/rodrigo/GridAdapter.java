package senac.tcc.rodrigo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import senac.tcc.rodrigo.ondeReciclaAndroid.FragmentCategorias;
import senac.tcc.rodrigo.onderecicla.R;

/**
 * Created by Christian on 29/05/2018.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    private  final String [] valores;
    private final int [] imagens;

    View view;
    LayoutInflater layoutInflater;

    FragmentCategorias fragmentCategorias;

    public GridAdapter(Context context, String[] valores, int[] imagens) {
        this.context = context;
        this.valores = valores;
        this.imagens = imagens;
    }

/*    public GridAdapter(FragmentCategorias fragmentCategorias, String[] valores, int[] imagens) {
        this.fragmentCategorias = fragmentCategorias;
        this.valores = valores;
        this.imagens = imagens;
    }
*/
    @Override
    public int getCount() {
        return valores.length;
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

        if (convertView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.item_categoria,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.foto_categoria);
            TextView textView = (TextView) view.findViewById(R.id.txtCategoria);
            //imageView.setImageResource(imagens[position]);
            textView.setText(valores[position]);
        }

        return view;


    }
}
