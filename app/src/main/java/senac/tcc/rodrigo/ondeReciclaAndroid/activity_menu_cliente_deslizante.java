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
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import senac.tcc.rodrigo.GridAdapter;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.MenuCliente;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Ranking;
import senac.tcc.rodrigo.onderecicla.R;

public class activity_menu_cliente_deslizante extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listaRanking;
    private RankingAdapter adapter;
    private GridView gridView;
    private Cliente cliente;
    private  int [] imagens;
    private  String [] valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente_deslizante);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if((Cliente) getIntent().getSerializableExtra("usuario") != null) {
            cliente = (Cliente) getIntent().getSerializableExtra("usuario");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);

/*        TextView nome = (TextView) headerView.findViewById(R.id.nome_cliente);
        nome.setText(cliente.getNome());
        TextView email = (TextView) headerView.findViewById(R.id.email_cliente);
        email.setText(cliente.getEmail());
*/
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        tabLayout.setupWithViewPager(viewPager);


        String[] valores = new String[]{
                    new String("teste")
                };
        imagens = new int[1];

        imagens[0] = 1;
        /*
        gridView = (GridView) findViewById(R.id.gridView);


        GridAdapter gridAdapter = new GridAdapter(this,valores, imagens);

        gridView.setAdapter(gridAdapter);*/

    }

    private class MyAdapter extends FragmentPagerAdapter{

        private final ArrayList<Fragment> fragments;
        private final ArrayList<String> titles;

        public MyAdapter(FragmentManager fa){
           super(fa);

           fragments = new ArrayList<Fragment>(2);
           fragments.add(new FragmentCategorias());
           fragments.add(new FragmentRanking());
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
        getMenuInflater().inflate(R.menu.activity_menu_cliente_deslizante_drawer, menu);
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
