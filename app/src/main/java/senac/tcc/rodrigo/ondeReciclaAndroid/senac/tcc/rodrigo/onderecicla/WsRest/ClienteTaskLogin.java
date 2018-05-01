package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WsRest;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WebClient;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;

public class ClienteTaskLogin extends AsyncTask<Object, Object, Cliente> {

    private Context context;
    private String json;

    public ClienteTaskLogin(Context context, String json) {
        this.context = context;
        this.json = json;
    }

    @Override
    protected Cliente doInBackground(Object... objects) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("http://192.168.0.6:8081/clientes/validaCliente");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(10000);
            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);
            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.hasNextLine()) {
                resposta.append(scanner.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cliente cliente = new Gson().fromJson(resposta.toString(), Cliente.class);
        return cliente;
    }

    @Override
    protected void onPostExecute(Cliente c) {
        super.onPostExecute(c);
    }
}
