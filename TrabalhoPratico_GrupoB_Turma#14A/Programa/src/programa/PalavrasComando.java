/**
 * Esta classe eh parte da aplicacao "A Casa Mal Assombrada".  
 * 
 * Essa classe guarda uma enumeracao de todos os comandos conhecidos do
 * jogo. Ela eh usada no reconhecimento de comandos como eles sao digitados.
 *
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

public class PalavrasComando {
    // um vetor constante que guarda todas as palavras de comandos validas
    private static final String[] comandosValidos = {
        "ir", "sair", "ajuda","observar","explodir"
    };

    /**
     * Construtor - inicializa as palavras de comando.
     */
    public PalavrasComando(){
        // nada a fazer no momento...
    }

    /**
     * Verifica se uma dada String eh uma palavra de comando valida. 
     * @param umaString
     * @return true se a string dada eh um comando valido,
     * false se nao eh.
     */
    public boolean ehComando(String umaString){
        for (String comandosValido : comandosValidos) {
            if (comandosValido.equals(umaString)) {
                return true;
            }
        }
        // se chegamos aqui, a string nao foi encontrada nos comandos.
        return false;
    }
    
    /**
     * Retorna os comandos validos
     * @return comandos convertidos para String
     */
    public String getComandos(){
        String comandos = "";
        for(String comando : comandosValidos){
            comandos = comandos + comando + " ";
        }
        return comandos;
    }
}