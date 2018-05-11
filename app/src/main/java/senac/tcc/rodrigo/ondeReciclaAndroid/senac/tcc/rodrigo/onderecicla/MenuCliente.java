package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import senac.tcc.rodrigo.ondeReciclaAndroid.activity_empresa;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.onderecicla.R;

public class MenuCliente extends AppCompatActivity {

    private Cliente cliente;
    private TextView nome;
    private Button botaoCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente);
        if((Cliente) getIntent().getSerializableExtra("usuario") != null) {
            cliente = (Cliente) getIntent().getSerializableExtra("usuario");
        }
        nome = (TextView) findViewById(R.id.nomeCliente);
        nome.setText(cliente.getNome());

        botaoCategoria = (Button) findViewById(R.id.categoriaID);

        botaoCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCliente.this, activity_empresa.class);
                startActivity(intent);
            }
        });

    }
}
