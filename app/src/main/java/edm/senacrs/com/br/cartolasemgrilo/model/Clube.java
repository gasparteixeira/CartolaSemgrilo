package edm.senacrs.com.br.cartolasemgrilo.model;

import java.util.Map;

/**
 * Created by gaspar on 07/07/16.
 */
public class Clube {
    private Integer id;
    private String nome;
    private String abreviacao;
    private Integer posicao;
    private Map<String , String> escudos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public Map<String, String> getEscudos() {
        return escudos;
    }

    public void setEscudos(Map<String, String> escudos) {
        this.escudos = escudos;
    }
}
