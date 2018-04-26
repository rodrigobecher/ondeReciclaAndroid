package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model;

import java.util.List;

class Categoria {


    private Integer id;
    private String descricao;
    private List<Residuo> residuo;

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

    public List<Residuo> getResiduo() {
        return residuo;
    }

    public void setResiduo(List<Residuo> residuo) {
        this.residuo = residuo;
    }
}
