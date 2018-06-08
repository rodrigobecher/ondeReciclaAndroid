package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rodrigo on 02/04/2018.
 */

public class Empresa {

    @SerializedName("id")
    private Integer id;
    @SerializedName("endereco")
    private String endereco;
    @SerializedName("residuo")
    private List<Residuo> residuo;
    @SerializedName("nome")
    private String nome;
    @SerializedName("cnpj")
    private String cnpj;
    @SerializedName("login")
    private String login;
    @SerializedName("senha")
    private String senha;

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Residuo> getResiduo() {
        return residuo;
    }

    public void setResiduo(List<Residuo> residuo) {
        this.residuo = residuo;
    }
}
