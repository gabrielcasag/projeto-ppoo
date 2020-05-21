/**
 *  Classe Item - um item do jogo
 *
 * Um item sao recursos que auxiliam o jogador, podem ser dicas ou a chave mestra
 *
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

public class Item {
    
    private final int ambiente;
    private boolean encontrado;
    
    /**
     * Construtor - inicializa os itens
     */
    public Item(){
        ambiente = -1 ;
        encontrado = false;
    }
    
    /**
     * Retorna o estado do item se foi encontrado
     * @return true se o item ja foi encontrado e false se nao
     */
    public boolean isEncontrado() {
        return encontrado;
    }
    
    /**
     * Define o atributo encontrado como true
     */
    public void setEncontrado() {
        encontrado = true;
    }
    
    
    
    
}
