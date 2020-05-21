/**
 *  Essa eh a classe principal da aplicacao "A Casa Mal Assombrada".
 * 
 *  Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 *  "jogar".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria os
 *  ambientes, cria o analisador e comeca o jogo. Ela tambeme avalia e 
 *  executa os comandos que o analisador retorna.
 * 
 * @author Adriano Domingos, Andre Sousa, Gabriel Casagrande e Matheus Galvao
 * @version 2019.12.05
 */

package programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private final Analisador analisador;
    private Ambiente ambienteAtual;
    private int quantidadeTentativas;
    private final Random geradorAleatorio;
    private final ChaveMestra chaveMestra;
    private final int localizacaoTesouro;
    private final HashMap <Integer, Ambiente> ambientes;
    private boolean terminado;
    private final ArrayList<Dica> dicas;
            
    /**
     * Construtor - Cria o jogo e incializa seu mapa interno.
     */
    public Jogo(){
        
        ambientes = new HashMap<>();
        dicas = new ArrayList<>();
        criarAmbientes();
        analisador = new Analisador();
        geradorAleatorio = new Random();
        quantidadeTentativas = gerarAleatorio(20, 30);
        localizacaoTesouro = gerarAleatorio(0,ambientes.size());
        //Cria a chave mestra gerando a durabilidade e sua localizacao
        chaveMestra = ChaveMestra.getInstance((gerarAleatorio(1, 10)), (ambientes.get(gerarAleatorio(0,ambientes.size()))));
        terminado = false;
        sortearDicas();
        gravarEmArquivo();
    }
    
    /**
     * Funcao para gerar um aleatorio entre 2 numeros
     * @param n1
     * @param n2
     * @return um numero aleatorio entre n1 e n2
     */
    private int gerarAleatorio(int n1, int n2){
        return (geradorAleatorio.nextInt(n2-n1))+n1;
    }
    
    /**
     * Metodo para sortear dicas entre os ambientes
     */
    private void sortearDicas(){
        Dica dica1;
        Dica dica2;
        Dica dica3;
        Dica dica4;
        while(dicas.size() < 4){
            if(dicas.isEmpty()){
                int numAmbiente = 1;
                while(numAmbiente == 1){ // Isso evita que uma dica seja sorteada no ambiente 1, que eh o inicial
                    numAmbiente = gerarAleatorio(0,ambientes.size());
                }
                if (ambientes.get(numAmbiente).getDica()== null && localizacaoTesouro != ambientes.get(numAmbiente).getChave()){
                    dica1 = new Dica(1);
                    dica1.setDescricao(ambientes.get(numAmbiente));
                    ambientes.get(numAmbiente).setDica(dica1);
                    dicas.add(dica1);
                }
            }
            
            if(dicas.size() == 1){
                int numAmbiente = 1;
                while(numAmbiente == 1){
                    numAmbiente = gerarAleatorio(0,ambientes.size());
                }
                if (ambientes.get(numAmbiente).getDica()== null && localizacaoTesouro != ambientes.get(numAmbiente).getChave()){
                    dica2 = new Dica(1);
                    dica2.setDescricao(ambientes.get(numAmbiente));
                    ambientes.get(numAmbiente).setDica(dica2);
                    dicas.add(dica2);
                }
            }
            
            if(dicas.size() == 2){
                int numAmbiente = 1;
                while(numAmbiente == 1){
                    numAmbiente = gerarAleatorio(0,ambientes.size());
                }
                if (ambientes.get(numAmbiente).getDica()== null && localizacaoTesouro != ambientes.get(numAmbiente).getChave()){
                    dica3 = new Dica(1);
                    dica3.setDescricao(ambientes.get(numAmbiente));
                    ambientes.get(numAmbiente).setDica(dica3);
                    dicas.add(dica3);
                }
            }
            
            if(dicas.size() == 3){
                int numAmbiente = 1;
                while(numAmbiente == 1){
                    numAmbiente = gerarAleatorio(0,ambientes.size());
                }
                if (ambientes.get(localizacaoTesouro).getDica()== null && localizacaoTesouro != ambientes.get(numAmbiente).getChave()){
                    dica4 = new Dica(4);
                    dica4.setDescricao(ambientes.get(numAmbiente));
                    ambientes.get(numAmbiente).setDica(dica4);
                    dicas.add(dica4);
                }
            }
        }
    }
    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes(){
        Ambiente escritorio,salaTv,jardim,cozinha,salaJantar,quarto1,quarto2,quarto3,quarto4,corredor,banheiro1,banheiro2;
        // cria os ambientes
        // se for adicionar um novo ambiente, cuidado com espaços ao usar hashmap
        ambientes.put(0,escritorio = new Ambiente("escritorio",0));
        ambientes.put(1,salaTv = new Ambiente("salaTv",1));
        ambientes.put(2,jardim = new Ambiente("jardim",2));
        ambientes.put(3,cozinha = new Ambiente("cozinha",3));
        ambientes.put(4,salaJantar = new Ambiente("salaJantar",4));
        ambientes.put(5,quarto1 = new Ambiente("quarto1",5));
        ambientes.put(6,quarto2 = new Ambiente("quarto2",6));
        ambientes.put(7,quarto3 = new Ambiente("quarto3",7));
        ambientes.put(8,quarto4 = new Ambiente("quarto4",8));
        ambientes.put(9,corredor = new Ambiente("corredor",9));
        ambientes.put(10,banheiro1 = new Ambiente("banheiro1",10));
        ambientes.put(11,banheiro2 = new Ambiente("banheiro2",11));
        
        // inicializa as saidas dos ambientes
        escritorio.ajustarSaidas(1,salaTv);
        
        salaJantar.ajustarSaidas(9,corredor);
        salaJantar.ajustarSaidas(1,salaTv);
        salaJantar.ajustarSaidas(3,cozinha);
        
        quarto1.ajustarSaidas(9, corredor);
        
        quarto2.ajustarSaidas(9, corredor);
        
        quarto3.ajustarSaidas(9, corredor);
        quarto3.ajustarSaidas(11, banheiro2);
     
        corredor.ajustarSaidas(5, quarto1);
        corredor.ajustarSaidas(6, quarto2);
        corredor.ajustarSaidas(10, banheiro1);
        corredor.ajustarSaidas(8, quarto4);
        corredor.ajustarSaidas(7, quarto3);
        corredor.ajustarSaidas(4, salaJantar);
        
        salaTv.ajustarSaidas(0, escritorio);
        salaTv.ajustarSaidas(2, jardim);
        salaTv.ajustarSaidas(4, salaJantar);
        
        cozinha.ajustarSaidas(4, salaJantar);
        cozinha.ajustarSaidas(2, jardim);
        
        jardim.ajustarSaidas(1, salaTv);
        jardim.ajustarSaidas(3, cozinha);
        
        banheiro1.ajustarSaidas(9, corredor);
        quarto4.ajustarSaidas(9, corredor);
        
        banheiro2.ajustarSaidas(7, quarto3);
       
        ambienteAtual = salaTv;  // o jogo comeca na salaTv
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os execusarutamos ate o jogo terminar.
                
        while (!terminado && quantidadeTentativas > 0) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    /**
     * Retorna se ainda tem tentativas restantes
     * @return true se ainda tem tentativas se nao retorna false
     */
    private boolean temTentativas(){
        if(quantidadeTentativas == 0){
            terminado = true;
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas(){
        System.out.println();
        System.out.println("Bem-vindo ao World of Zuul!");
        System.out.println("World of Zuul eh um novo jogo de aventura");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println("Voce tem "+quantidadeTentativas+" tentativas");
        System.out.println();
        
        imprimirLocalizacaoAtual();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        switch (palavraDeComando) {
            case "ajuda":
                imprimirAjuda();
                break;
            case "ir":
                irParaAmbiente(comando);
                break;
            case "sair":
                querSair = sair(comando);
                break;
            case "observar":
                observar();
                break;
            case "explodir":
                explodir();
                break;
            default:
                break;
        }
        return querSair;
    }
    
    /**
     * Metodo para salvar os dados em arquivo txt
     */
    private void gravarEmArquivo() {
        try {
            SistemaArquivo.salvar(gravarDados());
        } catch (IOException e) {
            System.out.println("Falha ao salvar dados");
        }
    }
    
    /**
     * Retorna uma string com os dados das localizacoes
     * @return uma String com os dados da localizacao do tesouro, das dicas
     * e da chave mestra
     */
    private String gravarDados() {
        
        return "Localização do tesouro: " +  ambientes.get(localizacaoTesouro) + "\n" +
               "Dica: " + dicas.get(0).getDescricao() + "\n" +
               "Dica: " + dicas.get(1).getDescricao() + "\n" +
               "Dica: " + dicas.get(2).getDescricao() + "\n" +
               "Dica: " + dicas.get(3).getDescricao() + "\n" +
               "Localização da chave Mestra: " +  chaveMestra.getLocalizacao() + "\n";
    }
    
    // Implementacoes dos comandos do usuario

    /**
     * Printe informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de 
     * palavras de comando
     */
    private void imprimirAjuda() {
        System.out.println("Voce esta perdido. Voce esta sozinho");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println(analisador.getComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo ambiente, caso contrario imprime mensagem de erro.
     * @param comando um comando a ser executado
     */
    private void irParaAmbiente(Comando comando) {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            System.out.println("Ir pra onde?");
            return;
        }

        int direcao = Integer.parseInt(comando.getSegundaPalavra());

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getAmbiente(direcao);
        
        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }

        else {
            //Verifica a porta
            Porta porta = new Porta(proximoAmbiente);
            //Se possuir chave mestra perguntar se deseja utilizar
            if(chaveMestra.isEncontrado()){
                System.out.println("Deseja utilizar a chave mestra? (S/N)");
                Scanner ent = new Scanner(System.in);
                String escolha = ent.nextLine();
                if(escolha.equals("S")){
                    chaveMestra.usar();
                    System.out.println("Voce abriu a porta!");
                    ambienteAtual = proximoAmbiente;
                }
            }
            else{
                //Tenta abrir a porta
                if(porta.getEstado()){
                    ambienteAtual = proximoAmbiente;
                    System.out.println("Voce conseguiu abrir a porta!");
                }
                else{
                    System.out.println("A porta estava emperrada, nao foi possivel abrir!");
                }
                --quantidadeTentativas;
            }
            verificaDicas();
            verificaChaveMestra();
            this.imprimirLocalizacaoAtual();
            if(!temTentativas()){
                    System.out.println("Suas tentativas acabaram mas ainda tem a bomba!");
                    explodir();
                }
        }
    }
    
    /**
     * Verifica se no ambiente atual tem dicas, se tiver imprime
     */
    private void verificaDicas(){
        if (ambienteAtual.getDica() != null){
            System.out.println("Voce encontrou uma dica!");
            System.out.println(ambienteAtual.getDica().getDescricao());
        }
    }
    
    /**
     * Verifica se no ambiente atual esta a chave mestra
     */
    private void verificaChaveMestra(){
        if(ambienteAtual.equals(chaveMestra.getLocalizacao()) && !chaveMestra.isEncontrado()){
            System.out.println("Voce conseguiu uma chave mestra!");
            System.out.println("Com ela voce conseguira passar qualquer porta!");
            chaveMestra.setEncontrado();
        }
    }
    
    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @param comando um comando
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando){
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }
    
    /**
     * Imprime a localizacao atual e suas possiveis saidas
     */
    private void imprimirLocalizacaoAtual(){
            System.out.println("Voce esta no(a) " + ambienteAtual);
            System.out.println(quantidadeTentativas+" tentativas");
            System.out.print("Saidas: ");
            System.out.println(ambienteAtual.getSaidas());
            System.out.println();
    }
    
    /**
     * Observa o ambiente atual
     */
    private void observar(){
        imprimirLocalizacaoAtual();
    }
    
    /**
     * Pergunta se o jogador quer realmente usar a bomba, se sim verifica se
     * ele ganhou
     */
    private void explodir(){
        System.out.println("Tem certeza que quer usar a bomba? (S/N)");
        Scanner ent = new Scanner(System.in);
        String escolha = ent.nextLine();
        if(escolha.equals("S")){
            verificarVitoria();
        }
    }
    
    /**
     * Verifica se o jogador ganhou o jogo
     */
    private void verificarVitoria(){
        if(ambienteAtual.getChave() == localizacaoTesouro){
            vitoria();
        }else{
            derrota();
        }
    }
    
    /**
     * Imprime que o jogador venceu o jogo
     */
    private void vitoria(){
        System.out.println("Parabens voce ganhou o jogo");
        terminado = true;
    }
    
    /**
     * Imprime que o jogador perdeu o jogo
     */
    private void derrota(){
        System.out.println("Infelizmente nao foi dessa vez");
        terminado = true;
    }
        
}