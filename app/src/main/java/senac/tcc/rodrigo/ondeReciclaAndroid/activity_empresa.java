package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WebClient;
import senac.tcc.rodrigo.onderecicla.R;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Empresa;

public class activity_empresa extends AppCompatActivity {

    private ListView listaEmpresas;
    private EmpresaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        List<Empresa> lista = null;
        try {
            lista = new WebClient(activity_empresa.this).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        carregaLista(lista);

    }
    @Override
    protected void onResume() {
        super.onResume();
        List<Empresa> lista = null;
        try {
            lista = new WebClient(activity_empresa.this).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        carregaLista(lista);

    }
    @NonNull
    private List<Empresa> carregaLista(List<Empresa> lista) {
        listaEmpresas = (ListView) findViewById(R.id.lista_empresas);
        adapter = new EmpresaAdapter(this, lista);
        listaEmpresas.setAdapter(adapter);
        return lista;
    }

}
