package senac.tcc.rodrigo.ondeReciclaAndroid.senac.tcc.rodrigo.onderecicla.util;

public class ValidaVazio {

    public static boolean validaString(String valor) throws Exception {
        if(valor.isEmpty() || valor.equals("") || valor == ""){
           throw new Exception("Valor null");
        }else
            return true;
    }
    public static boolean validaInteiro(Integer valor) throws Exception {
        if(valor.equals("") || valor == null){
            throw new Exception("Valor null");
        }else{
            return true;
        }
    }
}
