package edm.senacrs.com.br.cartolasemgrilo.model;

/**
 * Created by gaspar on 12/08/16.
 */
public class Posicao {

    private  Integer id;
    private String nome;
    private String abreviacao;


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
}
