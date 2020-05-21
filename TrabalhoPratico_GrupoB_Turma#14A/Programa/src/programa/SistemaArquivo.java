/**
 * Classe para operacoes referentes a arquivos
 * 
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

import java.io.FileWriter;
import java.io.IOException;


public class SistemaArquivo{
    
    /** Salva todos os dados em arquivo texto. Onde estao as dicas, chave mestra
     * e tesouro.
     * @param dados - Localização de todas as dicas e onde está o tesouro
     * @throws java.io.IOException
     */
    public static void salvar(String dados) throws IOException {
        try (FileWriter arq = new FileWriter("dadosJogo.txt")) {
            arq.write(dados);
            arq.close();
        } catch (IOException e) {
            throw e;
        }
    }
    

}
