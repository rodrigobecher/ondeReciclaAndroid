package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        registerForContextMenu(listaEmpresas);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo)  {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Empresa empresa = (Empresa) listaEmpresas.getItemAtPosition(info.position);

        MenuItem itemMapa = menu.add("Visualizar Mapa");
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q="+ empresa.getEndereco()));
        itemMapa.setIntent(intentMapa);
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
