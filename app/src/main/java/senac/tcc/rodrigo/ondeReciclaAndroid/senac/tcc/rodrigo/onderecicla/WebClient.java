package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Empresa;

/**
 * Created by Rodrigo on 10/04/2018.
 */

public class WebClient extends AsyncTask<Object, Object, List<Empresa>>{

    private Context context;

    public WebClient(Context context) {
        this.context = context;
    }

    public String post(String json) throws IOException {
        try {
            URL url = new URL("http://192.168.0.6:8081/clientes");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true); // post!

            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);

            connection.connect();

            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = scanner.next();
            return resposta;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;

    }
    @Override
    protected List<Empresa> doInBackground(Object... objects) {
        StringBuilder resposta = new StringBuilder();

            try {
                URL url = new URL("http://192.168.0.6:8081/api/empresas");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(10000);

                connection.connect();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNextLine()) {
                    resposta.append(scanner.nextLine());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        List<Empresa> list;
        Type listType = new TypeToken<List<Empresa>>() {}.getType();
        list = new Gson().fromJson(resposta.toString(), listType);
        return list;
    }
    @Override
    protected void onPostExecute(List<Empresa> e){

    }
}

