/**
 * Esta classe eh parte da aplicacao "A Casa Mal Assombrada".
 * 
 * Esse analisador le a entrada do usuario e tenta interpreta-la como um
 * comando "Adventure". Cada vez que eh chamado ele le uma linha do terminal
 * e tenta interpretar a linha como um comando de duas palavras. Ele retorna
 * o comando como um objeto da classe Comando.
 *
 * O analisador tem um conjunto de palavras de comando conhecidas. Ele compara
 * a entrada do usuario com os comandos conhecidos, e se a entrada nao eh um
 * dos comandos conhecidos, ele retorna um objeto comando que eh marcado como
 * um comando desconhecido.
 * 
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

import java.util.Scanner;

public class Analisador {
    private final PalavrasComando palavrasDeComando;  // guarda todas as palavras de comando validas
    private final Scanner entrada;         // origem da entrada de comandos

    /**
     * Cria um analisador para ler do terminal.
     */
    public Analisador(){
        palavrasDeComando = new PalavrasComando();
        entrada = new Scanner(System.in);
    }

    /**
     * @return O proximo comando do usuario
     */
    public Comando pegarComando() {
        String linha;   // guardara uma linha inteira
        String palavra1 = null;
        String palavra2 = null;

        System.out.print("> ");     // imprime o prompt

        linha = entrada.nextLine();

        // Tenta encontrar ate duas palavras na linha
        Scanner tokenizer = new Scanner(linha);
        if(tokenizer.hasNext()) {
            palavra1 = tokenizer.next();      // pega a primeira palavra
            if(tokenizer.hasNext()) {
                palavra2 = tokenizer.next();      // pega a segunda palavra
                // obs: nos simplesmente ignoramos o resto da linha.
            }
        }

        // Agora verifica se esta palavra eh conhecida. Se for, cria um
        // com ela. Se nao, cria um comando "null" (para comando desconhecido)
        if(palavrasDeComando.ehComando(palavra1)) {
            return new Comando(palavra1, palavra2);
        }
        else {
            return new Comando(null, palavra2); 
        }
    }
    
    public String getComandos(){
        return palavrasDeComando.getComandos();
    }
}