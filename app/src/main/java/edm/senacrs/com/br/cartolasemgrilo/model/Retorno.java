package edm.senacrs.com.br.cartolasemgrilo.model;

import java.util.List;
import java.util.Map;

/**
 * Created by gaspar on 07/07/16.
 */
public class Retorno {
    List<Atletas> atletas;
    Map<Integer, Clube> clubes;
    Map<Integer, Posicao> posicoes;
    Map<Integer, Status> status;

    public Map<Integer, Clube> getClubes() {
        return clubes;
    }

    public void setClubes(Map<Integer, Clube> clubes) {
        this.clubes = clubes;
    }

    public Map<Integer, Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(Map<Integer, Posicao> posicoes) {
        this.posicoes = posicoes;
    }

    public Map<Integer, Status> getStatus() {
        return status;
    }

    public void setStatus(Map<Integer, Status> status) {
        this.status = status;
    }

    public List<Atletas> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atletas> atletas) {
        this.atletas = atletas;
    }
}
