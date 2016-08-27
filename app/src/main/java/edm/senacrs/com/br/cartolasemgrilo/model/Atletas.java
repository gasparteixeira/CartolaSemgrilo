package edm.senacrs.com.br.cartolasemgrilo.model;

/**
 * Created by gaspar on 07/07/16.
 */
public class Atletas {
    private Long atleta_id;
    private Long clube_id;
    private String apelido;
    private String nome;
    private String foto;
    private Integer jogos_num;
    private Double media_num;
    private Double pontos_num;
    private Integer posicao_id;
    private Double preco_num;
    private Integer rodada_id;
    private Integer status_id;
    private Double variacao_num;
    private Partida partida;
    private Scout scout;
    private Integer variacao = 0;

    public Long getAtleta_id() {
        return atleta_id;
    }

    public void setAtleta_id(Long atleta_id) {
        this.atleta_id = atleta_id;
    }

    public Long getClube_id() {
        return clube_id;
    }

    public void setClube_id(Long clube_id) {
        this.clube_id = clube_id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getJogos_num() {
        return jogos_num;
    }

    public void setJogos_num(Integer jogos_num) {
        this.jogos_num = jogos_num;
    }

    public Double getMedia_num() {
        return media_num;
    }

    public void setMedia_num(Double media_num) {
        this.media_num = media_num;
    }

    public Double getPontos_num() {
        return pontos_num;
    }

    public void setPontos_num(Double pontos_num) {
        this.pontos_num = pontos_num;
    }

    public Integer getPosicao_id() {
        return posicao_id;
    }

    public void setPosicao_id(Integer posicao_id) {
        this.posicao_id = posicao_id;
    }

    public Double getPreco_num() {
        return preco_num;
    }

    public void setPreco_num(Double preco_num) {
        this.preco_num = preco_num;
    }

    public Integer getRodada_id() {
        return rodada_id;
    }

    public void setRodada_id(Integer rodada_id) {
        this.rodada_id = rodada_id;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Double getVariacao_num() {
        return variacao_num;
    }

    public void setVariacao_num(Double variacao_num) {
        this.variacao_num = variacao_num;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Scout getScout() {
        return scout;
    }

    public void setScout(Scout scout) {
        this.scout = scout;
    }

    public Integer getVariacao() {
        return variacao;
    }

    public void setVariacao(Integer variacao) {
        this.variacao = variacao;
    }

    @Override
    public String toString() {
        return (apelido);
    }
}
