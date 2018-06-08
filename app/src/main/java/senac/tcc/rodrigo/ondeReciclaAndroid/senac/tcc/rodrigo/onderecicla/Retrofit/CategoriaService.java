package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Categoria;


public interface CategoriaService {

    @GET("/api/categorias")
    Call<List<Categoria>> buscaCategorias();


}
