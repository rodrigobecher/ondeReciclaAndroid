package senac.tcc.rodrigo.ondeReciclaAndroid;

import android.content.Context;
import android.widget.EditText;
import android.widget.RatingBar;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.onderecicla.R;

class MontaCliente {

    private Cliente cliente;
    private Context context;
    private EditText nome;
    private EditText cpf;
    private EditText email;
    private EditText senha;

    public MontaCliente(cadastrarCliente activity) {
        nome = (EditText) activity.findViewById(R.id.edNome);
        cpf = (EditText) activity.findViewById(R.id.edCpf);
        email = (EditText) activity.findViewById(R.id.edEmail);
        senha = (EditText) activity.findViewById(R.id.edSenha);
    }

    public void montaCadastro(Cliente cliente){
        nome.setText(cliente.getNome());
        cpf.setText(cliente.getCpf());
        email.setText(cliente.getEmail());
        senha.setText(cliente.getSenha());
    }
}

