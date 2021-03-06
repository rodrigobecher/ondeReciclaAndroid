package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WsRest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;

import senac.tcc.rodrigo.ondeReciclaAndroid.cadastrarCliente;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WebClient;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;

public class ClienteTask extends AsyncTask<Object, Object, String >{
    private String json;
    private Context context;
    private ProgressDialog dialog;
    public ClienteTask(String cliente, Context context) {
        this.json = cliente;
        this.context = context;

    }

    @Override
    protected void onPreExecute(){
        dialog = new ProgressDialog(context);
        dialog.setMessage("Carregando...");
        dialog.show();
    }

    @Override
    protected String doInBackground(Object... objects) {
        String resposta = "";
        WebClient cliente = new WebClient(context);
        try {
            resposta = cliente.post(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta;
    }

    @Override
    protected void onPostExecute(String s) {
        dialog.dismiss();
        super.onPostExecute(s);
    }
}
