package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Empresa;

public interface EmpresaService {

    @GET("/api/empresas/categorias/{id}")
    Call<List<Empresa>> buscaEmpresaCategoria(@Path("id") Integer id);
}
