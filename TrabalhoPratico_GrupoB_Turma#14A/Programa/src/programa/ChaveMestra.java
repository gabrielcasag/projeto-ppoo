/**
 *  Classe ChaveMestra - um item do jogo do tipo ChaveMestra.
 *
 * Uma Chave Mestra eh um item do jogo. Ele permite que apos ser encontrada,
 * o jogador possa usa-la e assim garantir que conseguira abrir a porta.
 * A chave so eh instanciada uma vez. Ela possui como atributos um ambiente
 * que eh sua localizacao e uma durabilidade que eh gerada aleatoriamente.
 *
 * @author  Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

public class ChaveMestra extends Item{
    private int durabilidade;
    private static ChaveMestra instanciaUnica;
    private final Ambiente localizacao;
    
    /**
     * Construtor - inicializa as palavras de comando.
     * @param durabilidade
     * @param localizacao
     */
    public ChaveMestra(int durabilidade, Ambiente localizacao){
        super();
        this.durabilidade = durabilidade;
        this.localizacao = localizacao;
    }
    
    /**
     * Retorna a durabilidade da chave mestra
     * @return a durabilidade
     */
    public int getDurabilidade(){
        return durabilidade;
    }
    
    /**
     * Retorna o ambiente em que a chave se encontra
     * @return localizacao da chave
     */
    public Ambiente getLocalizacao(){
        return localizacao;
    } 
    
    /**
     * Usar chama reduzDurabilidade e verifica se chegou a 0, se sim,
     * a chave quebrou.
     */
    public void usar(){
        reduzDurabilidade();
        if(durabilidade == 0){
            System.out.println("A chave mestra quebrou!");
        }
    }
    
    /**
     * Decrementa o atributo durabilidade em 1.
     */
    public void reduzDurabilidade(){
        durabilidade--;
    }
    
    /**
     * Garantir instancia unica.
     * @param durabilidade
     * @param localizacao
     * @return instancia da chave mestra
     */
    public static ChaveMestra getInstance(int durabilidade, Ambiente localizacao){
        if(instanciaUnica == null)  {
            instanciaUnica = new ChaveMestra(durabilidade, localizacao);
        }
        return  instanciaUnica;
    }
}
