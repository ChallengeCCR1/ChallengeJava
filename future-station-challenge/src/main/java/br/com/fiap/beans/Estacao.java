package br.com.fiap.beans;

public class Estacao {

    private int id;
    private String nome;
    private String localizacao;
    private int passageirosSimulados;
    private LinhaMetro linhaMetro;

    public Estacao(){
        super();
    }

    public Estacao(int id, String nome, String localizacao, int passageirosSimulados, LinhaMetro linhaMetro) {
        super();
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.passageirosSimulados = passageirosSimulados;
        this.linhaMetro = linhaMetro;
    }

    public Estacao(int estacaoOrigemId, String estaçãoOrigemExemplo) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getPassageirosSimulados() {
        return passageirosSimulados;
    }

    public void setPassageirosSimulados(int passageirosSimulados) {
        this.passageirosSimulados = passageirosSimulados;
    }

    public LinhaMetro getLinhaMetro() {
        return linhaMetro;
    }

    public void setLinhaMetro(LinhaMetro linhaMetro) {
        this.linhaMetro = linhaMetro;
    }

    @Override
    public String toString() {
        return "Estacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", passageirosSimulados=" + passageirosSimulados +
                ", linhaMetro=" + linhaMetro +
                '}';
    }
}
