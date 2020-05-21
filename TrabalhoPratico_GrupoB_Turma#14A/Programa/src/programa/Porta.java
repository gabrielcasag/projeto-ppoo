/**
 *  Classe Porta - uma porta que define passagem entre ambientes.
 *
 * Uma Porta eh a passagem de um ambiente para outro. Eh usado para gerar um
 * aleatorio para definir o estado da porta, se true a porta abre, se nao,
 * ela estara emperrada e o jogador nao conseguira abrir e perdera uma tentativa
 *
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

import java.util.Random;

public class Porta {
    private final Ambiente destino;
    
    /**
     * Construtor - inicializa os ambientes
     * Cria uma porta para o ambiente destino
     * @param destino
     */
    public Porta(Ambiente destino) {
        this.destino = destino;
    }
    
    /**
     * Retorna o estado da porta
     * @return true se a porta abre
     * e false se ela estiver emperrada
     */
    public boolean getEstado() {
        return new Random().nextBoolean();
    }

}