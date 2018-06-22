package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WsRest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import senac.tcc.rodrigo.ondeReciclaAndroid.LoginActivity;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.WebClient;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.onderecicla.R;

public class ClienteTaskLogin extends AsyncTask<Object, Object, Cliente> {

    private Context context;
    private String json;
    private ImageView dialog;
    private Animation anim;
    public ClienteTaskLogin(LoginActivity context, ImageView img, Animation animacao, String json) {
        this.anim = animacao;
        this.dialog = img;
        this.context = context;
        this.json = json;
    }

    @Override
    protected void onPreExecute() {
        dialog.startAnimation(anim);
    }

    @Override
    protected Cliente doInBackground(Object... objects) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://frozen-spire-43188.herokuapp.com/clientes/validaCliente");
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
                resposta.append(scanner.nextLine());
            }
        } catch (MalformedURLException e) {
            Toast.makeText(context, "Tente novamente", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (ProtocolException e) {
            Toast.makeText(context, "Tente novamente", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(context, "Tente novamente", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        Cliente cliente = new Gson().fromJson(resposta.toString(), Cliente.class);
        return cliente;
    }

    @Override
    protected void onPostExecute(Cliente c) {
        dialog.clearAnimation();

    }
}
