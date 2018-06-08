package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;

public class RetrofitConfig {

        private final Retrofit retrofit;

        public RetrofitConfig() {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl("https://frozen-spire-43188.herokuapp.com")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        public ClienteService getPontuacao() {
            return this.retrofit.create(ClienteService.class);
        }
        public CategoriaService getCategoria(){return this.retrofit.create(CategoriaService.class);}
        public EmpresaService getEmpresaCategoria(){
            return this.retrofit.create(EmpresaService.class);
        }
}
