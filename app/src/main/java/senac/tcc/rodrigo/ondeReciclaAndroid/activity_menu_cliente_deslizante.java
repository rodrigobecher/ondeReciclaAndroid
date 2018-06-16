package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senac.tcc.rodrigo.GridAdapter;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.MenuCliente;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit.RetrofitConfig;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Categoria;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Deposito;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Ranking;
import senac.tcc.rodrigo.onderecicla.R;

public class activity_menu_cliente_deslizante extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ListView listaRanking;
    private RankingAdapter adapter;
    private GridView gridView;
    private Cliente cliente;
    private List<Categoria> lista;
    private List<Deposito> listaDeRanking;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private NavigationView navigationView;
    private View headerView;
    private TextView texto;
    private boolean fazer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente_deslizante);
        texto = (TextView) findViewById(R.id.texto);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        if((Cliente) getIntent().getSerializableExtra("usuario") != null) {
            cliente = (Cliente) getIntent().getSerializableExtra("usuario");

        }
        texto.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        buscaRanking();
    }


    public void buscaCategoria() {

        Call<List<Categoria>> call = new RetrofitConfig().getCategoria().buscaCategorias();
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    toolbar = (Toolbar) findViewById(R.id.toolbar);
                    setSupportActionBar(toolbar);
                    progressBar.setVisibility(View.INVISIBLE);
                    texto.setVisibility(View.INVISIBLE);
                    lista = response.body();
                    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                            activity_menu_cliente_deslizante.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                    drawer.addDrawerListener(toggle);
                    toggle.syncState();
                    navigationView = (NavigationView) findViewById(R.id.nav_view);
                    navigationView.setNavigationItemSelectedListener(activity_menu_cliente_deslizante.this);
                    headerView = navigationView.getHeaderView(0);
                    ImageView imageView = (ImageView) headerView.findViewById(R.id.foto_cliente);
                    if(cliente.getNome().contains("Rodrigo")) {
                        Glide.with(activity_menu_cliente_deslizante.this)
                                .load("https://scontent.fbnu2-1.fna.fbcdn.net/v/t1.0-1/c0.0.160.160/p160x160/34345933_1511397098972751_2880979296682246144_n.jpg?_nc_cat=0&oh=904f5b37685f2399e788e9882dde1cdc&oe=5BB1D971")
                                .into(imageView);
                    }
                    TextView nome = (TextView) headerView.findViewById(R.id.nome_cliente);
                    TextView email = (TextView) headerView.findViewById(R.id.email_cliente);
                    nome.setText(cliente.getNome());
                    email.setText(cliente.getEmail());

                        viewPager = (ViewPager) findViewById(R.id.viewpager);
                        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
                        tabLayout = (TabLayout) findViewById(R.id.tablayout);

                        tabLayout.setupWithViewPager(viewPager);

                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Toast.makeText(activity_menu_cliente_deslizante.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void buscaRanking() {

        Call<List<Deposito>> call = new RetrofitConfig().buscaRanking().getRanking();
        call.enqueue(new Callback<List<Deposito>>() {
            @Override
            public void onResponse(Call<List<Deposito>> call, Response<List<Deposito>> response) {
                if(response.isSuccessful())
                listaDeRanking = response.body();
                buscaCategoria();
            }

            @Override
            public void onFailure(Call<List<Deposito>> call, Throwable t) {
                Toast.makeText(activity_menu_cliente_deslizante.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyAdapter extends FragmentPagerAdapter{

        private final ArrayList<Fragment> fragments;
        private final ArrayList<String> titles;

        public MyAdapter(FragmentManager fa){
           super(fa);

           fragments = new ArrayList<Fragment>(2);
           fragments.add(new FragmentCategorias(lista,activity_menu_cliente_deslizante.this));
           fragments.add(new FragmentRanking(listaDeRanking, activity_menu_cliente_deslizante.this));
           titles = new ArrayList<String>(2);
           titles.add("Categorias");
           titles.add("Ranking");

        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position){
            return titles.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        TextView nome = findViewById(R.id.nome_cliente);
        TextView email = findViewById(R.id.email_cliente);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pontuacao) {
            Intent intent = new Intent(activity_menu_cliente_deslizante.this, PontuacaoUsuarioActivity.class);
            intent.putExtra("usuario", cliente);
            startActivity(intent);

        } else if (id == R.id.nav_alterar) {
            Intent intent = new Intent(activity_menu_cliente_deslizante.this, cadastrarCliente.class);
            intent.putExtra("usuario", cliente);
            startActivity(intent); //implementar para alterar se ja estiver logado

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
