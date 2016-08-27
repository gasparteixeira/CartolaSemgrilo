package edm.senacrs.com.br.cartolasemgrilo.model;

/**
 * Created by gaspar on 07/07/16.
 */
public class Partida {

    private Long clube_casa_id;
    private Long clube_casa_posicao;
    private Long clube_visitante_id;
    private Long clube_visitante_posicao;

    public Long getClube_casa_id() {
        return clube_casa_id;
    }

    public void setClube_casa_id(Long clube_casa_id) {
        this.clube_casa_id = clube_casa_id;
    }

    public Long getClube_casa_posicao() {
        return clube_casa_posicao;
    }

    public void setClube_casa_posicao(Long clube_casa_posicao) {
        this.clube_casa_posicao = clube_casa_posicao;
    }

    public Long getClube_visitante_id() {
        return clube_visitante_id;
    }

    public void setClube_visitante_id(Long clube_visitante_id) {
        this.clube_visitante_id = clube_visitante_id;
    }

    public Long getClube_visitante_posicao() {
        return clube_visitante_posicao;
    }

    public void setClube_visitante_posicao(Long clube_visitante_posicao) {
        this.clube_visitante_posicao = clube_visitante_posicao;
    }

}
