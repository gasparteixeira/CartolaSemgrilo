package edm.senacrs.com.br.cartolasemgrilo.dummy;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import edm.senacrs.com.br.cartolasemgrilo.dummy.utils.ClassificacaoValor;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;
import edm.senacrs.com.br.cartolasemgrilo.model.Retorno;

/**
 * Created by gaspar on 12/08/16.
 */
public class Classificacao extends ClassificacaoValor {
    public static final Integer ATACANTE=5, MEIA=4, ZAGUEIRO=3, LATERAL=2,GOLEIRO=1,TECNICO=5;
    private Retorno retorno;
    private List<Atletas> atacantes;
    private List<Atletas> meias;
    private List<Atletas> zagueiros;
    private List<Atletas> laterais;
    private List<Atletas> goleiros;
    private List<Atletas> tecnicos;

    public Classificacao(Retorno retorno) {

        this.retorno   = retorno;
        this.atacantes = new ArrayList<Atletas>();
        this.meias     = new ArrayList<Atletas>();
        this.zagueiros = new ArrayList<Atletas>();
        this.laterais  = new ArrayList<Atletas>();
        this.goleiros  = new ArrayList<Atletas>();
        this.tecnicos  = new ArrayList<Atletas>();
    }

    public void classificar() {
        for(Atletas atleta: this.retorno.getAtletas()) {

            if(atleta.getStatus_id() == 7) {
                switch (atleta.getPosicao_id()) {
                    case 1:
                        this.goleiros.add(this.getVariacaoGoleiro(atleta));
                        break;
                    case 2:
                        this.laterais.add(this.getVariacaoDefesa(atleta));
                        break;
                    case 3:
                        this.zagueiros.add(this.getVariacaoDefesa(atleta));
                        break;
                    case 4:
                        this.meias.add(this.getVariacaoAtaque(atleta));
                        break;
                    case 5:
                        this.atacantes.add(this.getVariacaoAtaque(atleta));
                        break;
                    case 6:
                        this.tecnicos.add(this.getVariacaoTecnico(atleta));
                        break;
                }
            }
        }
    }

    public List<Atletas> getAtacantes() {
        return this.getOrdenado(atacantes);
    }

    public List<Atletas> getMeias() {
        return this.getOrdenado(meias);
    }

    public List<Atletas> getZagueiros() {
        return this.getOrdenado(zagueiros);
    }

    public List<Atletas> getLaterais() {
        return this.getOrdenado(laterais);
    }

    public List<Atletas> getGoleiros() {
        return this.getOrdenado(goleiros);
    }

    public List<Atletas> getTecnicos() {
        return this.getOrdenado(tecnicos);
    }


}
