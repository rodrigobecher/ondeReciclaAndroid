package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model;

import com.google.gson.annotations.SerializedName;
/**
 * Created by Rodrigo on 02/04/2018.
 */

public class Residuo {

    @SerializedName("id")
    private Integer id;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("unimed")
    private String unimed;
    @SerializedName("categoria")
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnimed() {
        return unimed;
    }

    public void setUnimed(String unimed) {
        this.unimed = unimed;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
