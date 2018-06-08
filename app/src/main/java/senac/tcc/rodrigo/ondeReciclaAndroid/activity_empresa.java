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
import android.widget.ProgressBar;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit.RetrofitConfig;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WebClient;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Categoria;
import senac.tcc.rodrigo.onderecicla.R;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Empresa;

public class activity_empresa extends AppCompatActivity {

    private ListView listaEmpresas;
    private EmpresaAdapter adapter;
    private Categoria categoria;
    private List<Empresa> lista;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        progressBar = (ProgressBar) this.findViewById(R.id.empresa_progress);
        progressBar.setVisibility(View.VISIBLE);
        if((Categoria) getIntent().getSerializableExtra("categoria")!= null){

            categoria = (Categoria) getIntent().getSerializableExtra("categoria");
            Call<List<Empresa>> call = new RetrofitConfig().getEmpresaCategoria().buscaEmpresaCategoria(categoria.getId());
            call.enqueue(new Callback<List<Empresa>>() {

                @Override
                public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                    if(response.isSuccessful()){
                        lista = response.body();
                        carregaLista(lista);
                        registerForContextMenu(listaEmpresas);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<List<Empresa>> call, Throwable t) {
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });
        }



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
        categoria = (Categoria) getIntent().getSerializableExtra("categoria");
        Call<List<Empresa>> call = new RetrofitConfig().getEmpresaCategoria().buscaEmpresaCategoria(categoria.getId());
        call.enqueue(new Callback<List<Empresa>>() {

            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                if(response.isSuccessful()){
                    lista = response.body();
                    carregaLista(lista);
                    registerForContextMenu(listaEmpresas);
                }
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {

            }
        });
    }
    @NonNull
    private List<Empresa> carregaLista(List<Empresa> lista) {
        listaEmpresas = (ListView) findViewById(R.id.lista_empresas);
        adapter = new EmpresaAdapter(this, lista);
        listaEmpresas.setAdapter(adapter);
        return lista;
    }

}
