package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import senac.tcc.rodrigo.onderecicla.R;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Empresa;

public class EmpresaAdapter extends BaseAdapter{

    private Context context;
    private List<Empresa> empresas = null;

    public EmpresaAdapter(Context context, List<Empresa> empresas){
        this.empresas = empresas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return empresas.size();
    }

    @Override
    public Object getItem(int position) {
        return empresas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return empresas.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup Parent){
        Empresa empresa = empresas.get(position);
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_lista_empresa, null);
        }
        TextView textViewEmpresa = (TextView) view.findViewById(R.id.nomeEmpresa);
        TextView endereco = (TextView) view.findViewById(R.id.empresaEndereco);
        ImageView imagem = (ImageView) view.findViewById(R.id.item_foto);
        Glide.with(context)
                .load(empresa.getUrl())
                .into(imagem);
        textViewEmpresa.setText(empresa.getNome());
        endereco.setText(empresa.getEndereco());
        return view;
    }
}
