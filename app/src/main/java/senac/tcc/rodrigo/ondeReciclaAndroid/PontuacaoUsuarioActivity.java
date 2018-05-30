package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit.RetrofitConfig;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WsRest.ClienteTaskLogin;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.onderecicla.R;

public class PontuacaoUsuarioActivity extends AppCompatActivity {

    private Cliente cliente;
    private TextView pontuacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        pontuacao = (TextView) findViewById(R.id.pontuacaoId);
        setSupportActionBar(toolbar);
        if((Cliente) getIntent().getSerializableExtra("usuario") != null) {
            cliente = (Cliente) getIntent().getSerializableExtra("usuario");

            Call<Cliente> call = new RetrofitConfig().getPontuacao().buscaPontuacao(cliente);
            call.enqueue(new Callback<Cliente>() {
                @Override
                public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                    pontuacao.setText(response.body().getPontuacao().toString());

                }

                @Override
                public void onFailure(Call<Cliente> call, Throwable t) {
                    Toast.makeText(PontuacaoUsuarioActivity.this, "Falha na busca " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    System.out.println(t.getMessage());
                }
            });
        }



    }

}
