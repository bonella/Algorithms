
package br.univali.copa.principal;

import br.univali.copa.sede.Cidade;
import br.univali.copa.sede.Estadio;
import br.univali.copa.time.Jogador;
import br.univali.copa.time.Tecnico;
import br.univali.copa.time.Time;
import br.univali.utilidades.Teclado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author João Felipe Gonçalves
 */
public class Campeonato {
    public static final int QUANTIDADE_TIMES = 32;
    private Collection colecao;
    private List<Time> times = new ArrayList<Time>();
    private List<Cidade> cidades = new ArrayList<Cidade>();
    private List<Estadio> estadios = new ArrayList<Estadio>();
    private int indiceTimes = 0;
    private int indiceCidades = 0;
    private int indiceEstadios = 0;
    private int indiceTitulos;
    private int indiceRank;

    public Campeonato() {
        while (true){
            // Menu
            System.out.println("MENU\n"
                    + "1 - Cadastrar Estadio\n"
                    + "2 - Cadastrar Times\n"
                    + "3 - Encerrar");
            int r = Teclado.lerInteiro("");
            
            if (r == 1){
                // Cadastra estadio
                registrarEstadio();
            } else if (r == 2) {
                // Cadastra time
                for (int i = 0; i < QUANTIDADE_TIMES; i++){
                    registrarTime();
                }
            } else if (r == 3){
                // Encerra
                break;
            } else System.out.println("Opção invalida!");
            
        }
    }

    
    public void registrarCidade(){
        System.out.println("REGISTRO CIDADE");
        String nome = Teclado.lerTexto("Digite o nome da cidade: ");
        
        String estado = Teclado.lerTexto("Digite o estado: ");
        
        String IDH = Teclado.lerTexto("Digite o IDH: ");
        
        cidades.add(new Cidade(nome, estado, IDH));
    }
    
    public void registrarEstadio(){
        System.out.println("REGISTRO DO " + indiceEstadios + "º ESTADIO\n");
        
        registrarCidade();
        
        
        String nome = Teclado.lerTexto("Nome do estadio:");
        
        Date data = Teclado.lerData("Data de fundação:");
        
        int capacidade = Teclado.lerInteiro("Capacidade ocupacional:");
        
        estadios.add(new Estadio(cidades.get(indiceCidades), nome, data, capacidade));
        indiceCidades++;                                                        // Acrescenta indiceCidade pós registro, para capturar primeiro indice
    }
    
    public Tecnico registrarTecnico(){
        System.out.println("Registro do tecnico");
        String nome = Teclado.lerTexto("Nome: ");
        
        String escolaridade = Teclado.lerTexto("Escolaridade: ");
        
        
        float altura = Teclado.lerNumero("Altura: ");
        
        float peso = Teclado.lerNumero("Peso: ");
        
        String nacionalidade = Teclado.lerTexto("Nacionalidade: ");
        
        Tecnico tecnico = new Tecnico(nome, escolaridade, altura, peso, nacionalidade);
        return tecnico;
    }
    
    public void registrarTime(){
        System.out.println("REGISTRO DE TIME");
        
        Tecnico tecnico = registrarTecnico();
        
        String pais = Teclado.lerTexto("Pais:");
        
        
        // Registro jogadores
        List<Jogador> jogadores = new ArrayList<Jogador>();
        
        System.out.println("REGISTRO DE JOGADORES");
        for (int i = 0; i < Time.QUANTIDADE_JOGADORES; i++){
            jogadores.add(registrarJogador(i+1));
        }
        
        indiceTitulos = Teclado.lerInteiro("Titulos:");
        
        indiceRank = Teclado.lerInteiro("Posição no Rank:");
        
        times.add(new Time(tecnico, jogadores, pais, indiceTitulos, indiceRank));
    }
    
    public Jogador registrarJogador(int i){
            System.out.println("Jogador " + i);
            
            String nome = Teclado.lerTexto("Nome: ");
            
            String escolaridade = Teclado.lerTexto("Escolaridade: ");
            
            float altura = Teclado.lerNumero("Altura: ");
            
            float peso = Teclado.lerNumero("Peso: ");
            
            String posicao = Teclado.lerTexto("Posição: ");
            
            String preferencia = Teclado.lerTexto("Lado de Preferencia (canhoto, destro, ambidestro): ");
            
            Jogador jogador = new Jogador(nome, escolaridade, altura, peso, posicao, preferencia);
            return jogador;
    }
}