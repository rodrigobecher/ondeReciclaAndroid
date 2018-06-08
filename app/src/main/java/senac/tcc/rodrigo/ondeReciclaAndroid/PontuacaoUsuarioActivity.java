package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
    private View mProgressView;
    private View mPontuacaoFormView;
    private TextView pontuacao;
    private ImageView imageView2;
    private Button qrcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mProgressView = findViewById(R.id.pontuacao_progress);
        pontuacao = (TextView) findViewById(R.id.pontuacaoId);
        imageView2 = findViewById(R.id.imageView2);
        setSupportActionBar(toolbar);
        if((Cliente) getIntent().getSerializableExtra("usuario") != null) {
            cliente = (Cliente) getIntent().getSerializableExtra("usuario");
            mProgressView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            Call<Cliente> call = new RetrofitConfig().getPontuacao().buscaPontuacao(cliente);
            call.enqueue(new Callback<Cliente>() {
                @Override
                public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                    if(response.body().getPontuacao() != null) {
                        pontuacao.setText(response.body().getPontuacao().toString());
                    }else {
                        pontuacao.setText(new BigDecimal(0).toString());
                    }
                    mProgressView.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailure(Call<Cliente> call, Throwable t) {
                    mProgressView.setVisibility(View.INVISIBLE);
                    Toast.makeText(PontuacaoUsuarioActivity.this, "Falha na busca " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    System.out.println(t.getMessage());
                }
            });
        }

    }



}
