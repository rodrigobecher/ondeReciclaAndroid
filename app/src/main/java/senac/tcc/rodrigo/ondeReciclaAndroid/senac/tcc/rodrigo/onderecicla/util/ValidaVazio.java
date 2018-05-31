package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.util;

import senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.model.Cliente;

public class ValidaVazio {

    private boolean retorno = true;

    public boolean validaString(Cliente cliente) {
        if(cliente.getNome().length() == 0) {
            retorno = false;
        }
        if(cliente.getCpf().length() == 0) {
            retorno = false;
        }
        if(cliente.getEmail().length() == 0){
            retorno = false;
        }
        if(cliente.getSenha().length() == 0) {
            retorno = false;
        }
        return retorno;
    }

}
