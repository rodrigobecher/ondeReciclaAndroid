package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WebClient;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WsRest.ClienteTask;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.util.ValidaVazio;
import senac.tcc.rodrigo.onderecicla.R;

public class cadastrarCliente extends AppCompatActivity {

    private Button cadastrar;
    private EditText nome;
    private EditText cpf;
    private EditText email;
    private EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        cadastrar = (Button) findViewById(R.id.cadastrar);
        nome = (EditText) findViewById(R.id.edNome);
        cpf = (EditText) findViewById(R.id.edCpf);
        email = (EditText) findViewById(R.id.edEmail);
        senha = (EditText) findViewById(R.id.edSenha);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente cli = new Cliente();
                try{
                    ValidaVazio.validaString(nome.getText().toString());
                    cli.setNome(nome.getText().toString());
                    ValidaVazio.validaString(cpf.getText().toString());
                    cli.setCpf(cpf.getText().toString());
                    ValidaVazio.validaString(email.getText().toString());
                    cli.setEmail(email.getText().toString());
                    ValidaVazio.validaString(senha.getText().toString());
                    cli.setSenha(senha.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(cadastrarCliente.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                Gson gson = new Gson();
                String stringJson = gson.toJson(cli);
                ClienteTask clienteTask = new ClienteTask(stringJson, cadastrarCliente.this);
                try {
                    String resposta = clienteTask.execute().get();
                    Intent intent = new Intent(cadastrarCliente.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
