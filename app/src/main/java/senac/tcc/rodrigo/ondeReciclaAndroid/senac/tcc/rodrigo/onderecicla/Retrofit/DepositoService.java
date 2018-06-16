package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Deposito;


public interface DepositoService {

    @GET("/api/deposito")
    Call<List<Deposito>> getRanking();
}

