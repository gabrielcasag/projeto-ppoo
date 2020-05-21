/**
 *  Classe Dica - um item do jogo do tipo Dica.
 *
 * Uma Dica eh um item do jogo. Apos ser encontrada, o jogador recebe uma dica,
 * que pode ser de dois tipos, "O tesouro nao esta no(a)" ou "O tesouro esta
 * proxima ao".
 *
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

public class Dica extends Item {
    
    private final int tipoDica;
    private String descricao;
    
    /**
     * Construtor - inicializa as dicas.
     * @param tipoDica
     */
    public Dica(int tipoDica) {
        super();
        this.tipoDica = tipoDica;
        this.descricao = "";
    }
    
    /**
     * A partir de um ambiente, configura a descricao da dica
     * se o tipo da dica for 1 a dica sera do tipo:
     * "O tesouro nao está no(a) " se for 2: "O tesouro está proximo ao "
     * @param ambiente 
     */
    public void setDescricao(Ambiente ambiente) {
        if (tipoDica == 1) {
            descricao = "O tesouro nao está no(a) " + ambiente;
        }else{
            descricao = "O tesouro está proximo ao " + ambiente;
        }
        
    }
    
    /**
     * Retorna a descricao da dica
     * @return descricao de uma dica
     */
    public String getDescricao() {
        return descricao;
    }
        
}
