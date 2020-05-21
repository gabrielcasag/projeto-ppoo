/**
 * Esta classe eh parte da aplicacao "A Casa Mal Assombrada".
 *
 * Essa aplicacao eh o projeto final da disciplina de Praticas de Programacao
 * Orientada a Objetos do curso de Ciencia da Computacao da Univeridade Federal
 * de Lavras
 *
 * Essa classe inicia o jogo.
 *
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

public class Programa {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.jogar();
    }

}