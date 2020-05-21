/**
 *  Classe Ambiente - um ambiente do jogo.
 *
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. As saidas sao
 * mapeadas por um HashMap. Um ambiente nunca tera mais de uma dica
 *
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

import java.util.HashMap;

public class Ambiente {
    private final String nomeAmbiente;
    private final HashMap<Integer, Ambiente> saidas;
    private final int chave;
    private Dica dica;

    /**
     * Construtor - inicializa os ambientes
     * Cria um ambiente com o "nome" e uma "chave" passados. Inicialmente, ele
     * nao tem saidas.
     * @param nomeAmbiente A descricao do ambiente.
     * @param chave Uma chave relacionada ao ambiente.
     */
    public Ambiente(String nomeAmbiente,int chave){
        this.nomeAmbiente = nomeAmbiente;
        saidas = new HashMap<>();
        this.chave = chave;
        dica = null;
    }

    /**
     * Define as saidas do ambiente. Cada direcao ou leva a um
     * outro ambiente ou eh null (nenhuma saida para la).
     * @param direcao.
     * @param proxAmbiente.
     */
    public void ajustarSaidas(Integer direcao, Ambiente proxAmbiente) {
        saidas.put(direcao,proxAmbiente);
    }

    /**
     * @return A dica do ambiente se ele tiver.
     */
    public Dica getDica(){
        return dica;
    }
    
    /**
    * Metodo para mudar a dica do ambiente.
    * @param dica.
    */
    public void setDica(Dica dica){
        this.dica = dica;
    }
    
    /**
     * Metodo que retorna uma ambiente dada uma direcao
     * @param direcao.
     * @return um ambiente.
     */
    public Ambiente getAmbiente(Integer direcao){
        return saidas.get(direcao);
    }
    
    /**
     * @return as saidas de um ambiente convertidas para String
     */
    public String getSaidas(){
        String textoSaidas = "";
        
        for(int direcao : saidas.keySet()){
            textoSaidas += direcao + ":" + saidas.get(direcao).nomeAmbiente + " ";
        }
        
        return textoSaidas;
    }
    
    /**
     * @return a chave relacionada com o ambiente.
     */
    public int getChave(){
        return chave;
    }
    
    /**
     * Sobreescrita do metodo toString para retornar o nome do ambiente.
     * @return nome do ambiente.
     */
    @Override
    public String toString(){
        return nomeAmbiente;
    }
    
}