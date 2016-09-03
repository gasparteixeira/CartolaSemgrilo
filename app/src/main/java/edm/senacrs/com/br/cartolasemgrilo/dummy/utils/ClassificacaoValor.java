package edm.senacrs.com.br.cartolasemgrilo.dummy.utils;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;

/**
 * Created by gaspar on 24/08/16.
 */
public class ClassificacaoValor {

    /*

     */
    private static final int GOLEIRO = 8;
    private static final int TECNICO = 7;
    private static final int ZAGUEIRO = 5;
    private static final int LATERAIS = 5;
    private static final int MEIAS = 8;
    private static final int ATACANTES = 11;

    protected Atletas getVariacaoAtaque(Atletas atletas, Map<String, Object> filtro) {
        Integer valorizacao = 0;

        //variacao comum
        valorizacao += getValorComum(atletas, valorizacao);

        //para obter mais cartoletas
        if((Boolean) filtro.get("cartoletas") && atletas.getVariacao_num() < 0) {
            Double variacao_num = Math.abs(atletas.getVariacao_num());
            variacao_num = variacao_num * 20;
            valorizacao += variacao_num.intValue();
        }

        if(atletas.getScout() != null) {
            //scout de ataque
            valorizacao += getScoutAtaqueBasico(atletas, valorizacao);

            // scout de defesa
            valorizacao -= getScoutDefesa(atletas, valorizacao);
        }

        atletas.setVariacao(valorizacao);
        return  atletas;
    }

    protected Atletas getVariacaoDefesa(Atletas atletas, Map<String, Object> filtro) {
        Integer valorizacao = 0;
        //variacao comum
        valorizacao = getValorComum(atletas, valorizacao);

        //para obter mais cartoletas
        if((Boolean) filtro.get("cartoletas") && atletas.getVariacao_num() < 0) {
            Double variacao_num = Math.abs(atletas.getVariacao_num());
            variacao_num = variacao_num * 20;
            valorizacao += variacao_num.intValue();
        }

        if(atletas.getScout() != null) {
            //scout de ataque
            valorizacao += getScoutAtaqueBasico(atletas, valorizacao);

            // scout de defesa
            valorizacao -= getScoutDefesa(atletas, valorizacao);
        }

        atletas.setVariacao(valorizacao);
        return  atletas;
    }

    protected Atletas getVariacaoGoleiro(Atletas atletas, Map<String, Object> filtro) {
        Integer valorizacao = 0;

        if(!filtro.get("valor").toString().equals("0.0")) {
            double value = Double.valueOf(filtro.get("valor").toString());
            double maxValue = (double)(value*(GOLEIRO/100.0f));

            if(atletas.getPreco_num() > maxValue) {
                atletas.setVariacao(valorizacao);
                return  atletas;
            }
        }

        //variacao comum
        valorizacao += getValorComum(atletas, valorizacao);

        //para obter mais cartoletas
        if((Boolean) filtro.get("cartoletas") && atletas.getVariacao_num() < 0) {
            Double variacao_num = Math.abs(atletas.getVariacao_num());
            variacao_num = variacao_num * 20;
            valorizacao += variacao_num.intValue();
        }

        if(atletas.getScout() != null) {
            if(atletas.getScout().getDD() != null && atletas.getScout().getDD() > 0 ) {
                valorizacao += atletas.getScout().getDD() * 3;
            }

            if(atletas.getScout().getDP() != null && atletas.getScout().getDP() > 0) {
                valorizacao += atletas.getScout().getDP() * 7;
            }

            if(atletas.getScout().getSG() != null && atletas.getScout().getSG() > 0) {
                valorizacao += atletas.getScout().getSG() * 5;
            }

            if(atletas.getScout().getGS() != null && atletas.getScout().getGS() > 0) {
                valorizacao -= atletas.getScout().getGS() * 2;
            }

        }

        atletas.setVariacao(valorizacao);
        return  atletas;
    }

    protected Atletas getVariacaoTecnico(Atletas atletas, Map<String, Object> filtro) {
        Integer valorizacao = 0;

        if(!filtro.get("valor").toString().equals("0.0")) {
            double value = Double.valueOf(filtro.get("valor").toString());
            double maxValue = (double)(value*(TECNICO/100.0f));

            if(atletas.getPreco_num() > maxValue) {
                atletas.setVariacao(valorizacao);
                return  atletas;
            }
        }


        //variacao comum
        valorizacao += getValorComum(atletas, valorizacao);
        //para obter mais cartoletas
        if((Boolean)filtro.get("cartoletas") && atletas.getVariacao_num() < 0) {
            Double variacao_num = Math.abs(atletas.getVariacao_num());
            variacao_num = variacao_num * 20;
            valorizacao += variacao_num.intValue();
        }

        atletas.setVariacao(valorizacao);
        return  atletas;
    }

    protected List<Atletas> getOrdenado(List<Atletas> atletasList) {
        Collections.sort(atletasList, new Comparator<Atletas>() {
            @Override
            public int compare(Atletas a1, Atletas a2) {
                return ComparisonChain.start()
                        .compare(a1.getVariacao(), a2.getVariacao(), Ordering.<Integer>natural().reverse().nullsLast())
                        .result();
            }
        });
        return atletasList;
    }



    private Integer getValorComum(Atletas atletas, Integer valorizacao) {
        if((long)atletas.getClube_id() == (long)atletas.getPartida().getClube_casa_id()){
            valorizacao += 50;
        }
        if(atletas.getMedia_num() != null && atletas.getMedia_num() > 0){
            Double media = (atletas.getMedia_num() * atletas.getJogos_num());
            Long medial = Math.round(media);
            valorizacao += Integer.valueOf(medial.intValue());
        }
        valorizacao += (atletas.getPartida().getClube_visitante_posicao().intValue() - atletas.getPartida().getClube_casa_posicao().intValue());
        return valorizacao;
    }

    private Integer getScoutDefesa(Atletas atletas, Integer valorizacao) {
        if(atletas.getScout().getFC() != null && atletas.getScout().getFC() > 0) {
            valorizacao -= atletas.getScout().getFC();
        }
        if(atletas.getScout().getPE() != null && atletas.getScout().getPE() > 0) {
            valorizacao -= atletas.getScout().getPE();
        }

        if(atletas.getScout().getCA() != null && atletas.getScout().getCA() > 0) {
            valorizacao -= atletas.getScout().getCA() * 3;
        }

        if(atletas.getScout().getCV() != null && atletas.getScout().getCV() > 0) {
            valorizacao -= atletas.getScout().getCV() * 5;
        }

        if(atletas.getScout().getI() != null && atletas.getScout().getI() > 0) {
            Double impedimentos = atletas.getScout().getI() * 1.5;
            valorizacao -=  impedimentos.intValue();
        }
        return valorizacao;
    }

    private Integer getScoutAtaqueBasico(Atletas atletas, Integer valorizacao) {
        if (atletas.getScout().getG() != null && atletas.getScout().getG() > 0) {
            valorizacao += atletas.getScout().getG() * 10;
        }
        if (atletas.getScout().getA() != null && atletas.getScout().getA() > 0) {
            valorizacao += atletas.getScout().getA() * 5;
        }

        if (atletas.getScout().getFT() != null && atletas.getScout().getFT() > 0) {
            valorizacao += atletas.getScout().getFT() * 3;
        }

        if (atletas.getScout().getFS() != null && atletas.getScout().getFS() > 0) {
            valorizacao += atletas.getScout().getFS() * 2;
        }

        if(atletas.getScout().getRB() != null && atletas.getScout().getRB() > 0) {
            Double roubadas = atletas.getScout().getRB() * 1.5;
            valorizacao += roubadas.intValue();
        }

        if(atletas.getScout().getFD() != null && atletas.getScout().getFD() > 0) {
            valorizacao += atletas.getScout().getFD();
        }

        return valorizacao;
    }


}
