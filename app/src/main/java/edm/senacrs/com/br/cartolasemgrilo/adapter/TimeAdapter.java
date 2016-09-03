package edm.senacrs.com.br.cartolasemgrilo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edm.senacrs.com.br.cartolasemgrilo.MyApplication;
import edm.senacrs.com.br.cartolasemgrilo.R;
import edm.senacrs.com.br.cartolasemgrilo.dummy.CircleTransform;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;

/**
 * Created by gaspar on 25/07/16.
 */
public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {

    /**
     433 = (1*7)7 + (1*8)8 + (2*5)10 + (2*5)10 + (4*8)32 + (3*11)33 -> 100% time de ataque
     352 = (1*7)7 + (1*8)8 + (3*5)15 + (5*10)50 + (2*10)20 ->100% time valoriza o meio
     343 = (1*7)7 + (1*8)8 + (3*5)15 + (4*10)40 + (3*10)30 -> 100% time misto
     */

    public static final int F433 = 0;
    public static final int F343 = 1;
    public static final int F352 = 2;

    Context context;
    Map<String, List<Atletas>> map;
    List<Integer> formacoes = new ArrayList<>();
    Map<String, Object> filtro;
    List<Atletas> timeFormado;

    private int indexClic;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class QuatroTresTresViewHolder extends ViewHolder {
        ImageView a433_1, a433_2, a433_3, m433_1, m433_2, m433_3, l433_1, l433_3, z433_1, z433_3, g433_1, t433_1;
        TextView a433_1_nome, a433_2_nome, a433_3_nome, m433_1_nome, m433_2_nome, m433_3_nome, l433_1_nome, l433_3_nome, z433_1_nome, z433_3_nome, g433_1_nome, t433_1_nome, valor433;

        public QuatroTresTresViewHolder(View v) {
            super(v);
            this.a433_1 = (ImageView) v.findViewById(R.id.a433_1);
            this.a433_2 = (ImageView) v.findViewById(R.id.a433_2);
            this.a433_3 = (ImageView) v.findViewById(R.id.a433_3);
            this.m433_1 = (ImageView) v.findViewById(R.id.m433_1);
            this.m433_2 = (ImageView) v.findViewById(R.id.m433_2);
            this.m433_3 = (ImageView) v.findViewById(R.id.m433_3);
            this.l433_1 = (ImageView) v.findViewById(R.id.l433_1);
            this.l433_3 = (ImageView) v.findViewById(R.id.l433_3);
            this.z433_1 = (ImageView) v.findViewById(R.id.z433_1);
            this.z433_3 = (ImageView) v.findViewById(R.id.z433_3);
            this.g433_1 = (ImageView) v.findViewById(R.id.g433_1);
            this.t433_1 = (ImageView) v.findViewById(R.id.t433_1);

            this.a433_1_nome = (TextView) v.findViewById(R.id.a433_1_nome);
            this.a433_2_nome = (TextView) v.findViewById(R.id.a433_2_nome);
            this.a433_3_nome = (TextView) v.findViewById(R.id.a433_3_nome);
            this.m433_1_nome = (TextView) v.findViewById(R.id.m433_1_nome);
            this.m433_2_nome = (TextView) v.findViewById(R.id.m433_2_nome);
            this.m433_3_nome = (TextView) v.findViewById(R.id.m433_3_nome);
            this.l433_1_nome = (TextView) v.findViewById(R.id.l433_1_nome);
            this.l433_3_nome = (TextView) v.findViewById(R.id.l433_3_nome);
            this.z433_1_nome = (TextView) v.findViewById(R.id.z433_1_nome);
            this.z433_3_nome = (TextView) v.findViewById(R.id.z433_3_nome);
            this.g433_1_nome = (TextView) v.findViewById(R.id.g433_1_nome);
            this.t433_1_nome = (TextView) v.findViewById(R.id.t433_1_nome);
            this.valor433    = (TextView) v.findViewById(R.id.valor433);
        }
    }

    public class TresQuatroTresViewHolder extends ViewHolder {

        ImageView a343_1, a343_2, a343_3, m343_1, m343_2, m343_3, m343_4, z343_1, z343_2, z343_3, g343_1, t343_1;
        TextView a343_1_nome, a343_2_nome, a343_3_nome, m343_1_nome, m343_2_nome, m343_3_nome, m343_4_nome, z343_1_nome, z343_2_nome, z343_3_nome, g343_1_nome, t343_1_nome, valor343;

        public TresQuatroTresViewHolder(View v) {
            super(v);
            this.a343_1 = (ImageView) v.findViewById(R.id.a343_1);
            this.a343_2 = (ImageView) v.findViewById(R.id.a343_2);
            this.a343_3 = (ImageView) v.findViewById(R.id.a343_3);
            this.m343_1 = (ImageView) v.findViewById(R.id.m343_1);
            this.m343_2 = (ImageView) v.findViewById(R.id.m343_2);
            this.m343_3 = (ImageView) v.findViewById(R.id.m343_3);
            this.m343_4 = (ImageView) v.findViewById(R.id.m343_4);
            this.z343_1 = (ImageView) v.findViewById(R.id.z343_1);
            this.z343_2 = (ImageView) v.findViewById(R.id.z343_2);
            this.z343_3 = (ImageView) v.findViewById(R.id.z343_3);
            this.g343_1 = (ImageView) v.findViewById(R.id.g343_1);
            this.t343_1 = (ImageView) v.findViewById(R.id.t343_1);

            this.a343_1_nome = (TextView) v.findViewById(R.id.a343_1_nome);
            this.a343_2_nome = (TextView) v.findViewById(R.id.a343_2_nome);
            this.a343_3_nome = (TextView) v.findViewById(R.id.a343_3_nome);
            this.m343_1_nome = (TextView) v.findViewById(R.id.m343_1_nome);
            this.m343_2_nome = (TextView) v.findViewById(R.id.m343_2_nome);
            this.m343_3_nome = (TextView) v.findViewById(R.id.m343_3_nome);
            this.m343_4_nome = (TextView) v.findViewById(R.id.m343_4_nome);
            this.z343_1_nome = (TextView) v.findViewById(R.id.z343_1_nome);
            this.z343_2_nome = (TextView) v.findViewById(R.id.z343_2_nome);
            this.z343_3_nome = (TextView) v.findViewById(R.id.z343_3_nome);
            this.g343_1_nome = (TextView) v.findViewById(R.id.g343_1_nome);
            this.t343_1_nome = (TextView) v.findViewById(R.id.t343_1_nome);
            this.valor343    = (TextView) v.findViewById(R.id.valor343);
        }
    }

    public class TresCincoDoisViewHolder extends ViewHolder {
        ImageView a352_1, a352_3, m352_1, m352_2, m352_3, m352_4, m352_5, z352_1, z352_2, z352_3, g352_1, t352_1;
        TextView a352_1_nome, a352_3_nome, m352_1_nome, m352_2_nome, m352_3_nome, m352_4_nome, m352_5_nome, z352_1_nome, z352_2_nome, z352_3_nome, g352_1_nome, t352_1_nome, valor352;

        public TresCincoDoisViewHolder(View v) {
            super(v);
            this.a352_1 = (ImageView) v.findViewById(R.id.a352_1);
            this.a352_3 = (ImageView) v.findViewById(R.id.a352_3);
            this.m352_1 = (ImageView) v.findViewById(R.id.m352_1);
            this.m352_2 = (ImageView) v.findViewById(R.id.m352_2);
            this.m352_3 = (ImageView) v.findViewById(R.id.m352_3);
            this.m352_4 = (ImageView) v.findViewById(R.id.m352_4);
            this.m352_5 = (ImageView) v.findViewById(R.id.m352_5);
            this.z352_1 = (ImageView) v.findViewById(R.id.z352_1);
            this.z352_2 = (ImageView) v.findViewById(R.id.z352_2);
            this.z352_3 = (ImageView) v.findViewById(R.id.z352_3);
            this.g352_1 = (ImageView) v.findViewById(R.id.g352_1);
            this.t352_1 = (ImageView) v.findViewById(R.id.t352_1);

            this.a352_1_nome = (TextView) v.findViewById(R.id.a352_1_nome);
            this.a352_3_nome = (TextView) v.findViewById(R.id.a352_3_nome);
            this.m352_1_nome = (TextView) v.findViewById(R.id.m352_1_nome);
            this.m352_2_nome = (TextView) v.findViewById(R.id.m352_2_nome);
            this.m352_3_nome = (TextView) v.findViewById(R.id.m352_3_nome);
            this.m352_4_nome = (TextView) v.findViewById(R.id.m352_4_nome);
            this.m352_5_nome = (TextView) v.findViewById(R.id.m352_5_nome);
            this.z352_1_nome = (TextView) v.findViewById(R.id.z352_1_nome);
            this.z352_2_nome = (TextView) v.findViewById(R.id.z352_2_nome);
            this.z352_3_nome = (TextView) v.findViewById(R.id.z352_3_nome);
            this.g352_1_nome = (TextView) v.findViewById(R.id.g352_1_nome);
            this.t352_1_nome = (TextView) v.findViewById(R.id.t352_1_nome);
            this.valor352    = (TextView) v.findViewById(R.id.valor352);
        }
    }


    public TimeAdapter(Context context, Map<String, List<Atletas>> map, List<Integer> formacoes, Map<String, Object> filtro) {
        this.context = context;
        this.map = map;
        this.formacoes = formacoes;
        this.filtro = filtro;
    }


    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == F343) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_343_show, parent, false);
            return new TresQuatroTresViewHolder(v);
        } else if (viewType == F352) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_352_show, parent, false);
            return new TresCincoDoisViewHolder(v);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_433_show, parent, false);
            return new QuatroTresTresViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(TimeAdapter.ViewHolder viewHolder, int position) {

        if (viewHolder.getItemViewType() == F343) {
            getOnBindView343((TresQuatroTresViewHolder) viewHolder);
        } else if (viewHolder.getItemViewType() == F352) {
            getOnBindView352((TresCincoDoisViewHolder) viewHolder);
        } else {
            getOnBindView433((QuatroTresTresViewHolder) viewHolder);
        }

    }

    private void getOnBindView433(QuatroTresTresViewHolder viewHolder) {
        QuatroTresTresViewHolder holder = viewHolder;
        MyApplication application = (MyApplication) context.getApplicationContext();
        timeFormado = new ArrayList<>();

        int ataqueStartPos = 0, meiaStartPos = 0, zagaStartPos = 0, latStartPos = 0, golStartPos = 0, tecStartPos = 0;
        double valorTime433 = 0.0;

        if(!filtro.get("valor").toString().equals("0.0")) {
            double value = Double.valueOf(filtro.get("valor").toString());

            for(Atletas a: map.get("Atacantes")) {
                double maxValue = (double)(value * (11/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                ataqueStartPos++;
            }


            for(Atletas a: map.get("Meias")) {
                double maxValue = (double)(value * (8/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                meiaStartPos++;
            }

            for(Atletas a: map.get("Laterais")) {
                double maxValue = (double)(value * (5/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                latStartPos++;
            }

            for(Atletas a: map.get("Zagueiros")) {
                double maxValue = (double)(value * (5/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                zagaStartPos++;
            }

            for(Atletas a: map.get("Goleiro")) {
                double maxValue = (double)(value * (8/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                golStartPos++;
            }

            for(Atletas a: map.get("Tecnico")) {
                double maxValue = (double)(value * (7/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                tecStartPos++;
            }


        }

        holder.a433_1_nome.setText(map.get("Atacantes").get(ataqueStartPos).getApelido());
        valorTime433 += map.get("Atacantes").get(ataqueStartPos).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos));

        holder.a433_2_nome.setText(map.get("Atacantes").get(ataqueStartPos+1).getApelido());
        valorTime433 += map.get("Atacantes").get(ataqueStartPos+1).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos+1));

        holder.a433_3_nome.setText(map.get("Atacantes").get(ataqueStartPos+2).getApelido());
        valorTime433 += map.get("Atacantes").get(ataqueStartPos+2).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos+2));

        holder.m433_1_nome.setText(map.get("Meias").get(meiaStartPos).getApelido());
        valorTime433 += map.get("Meias").get(meiaStartPos).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos));

        holder.m433_2_nome.setText(map.get("Meias").get(meiaStartPos+1).getApelido());
        valorTime433 += map.get("Meias").get(meiaStartPos+1).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+1));

        holder.m433_3_nome.setText(map.get("Meias").get(meiaStartPos+2).getApelido());
        valorTime433 += map.get("Meias").get(meiaStartPos+2).getPreco_num();

        holder.l433_1_nome.setText(map.get("Laterais").get(latStartPos).getApelido());
        valorTime433 += map.get("Laterais").get(latStartPos).getPreco_num();
        timeFormado.add(map.get("Laterais").get(latStartPos));

        holder.l433_3_nome.setText(map.get("Laterais").get(latStartPos+1).getApelido());
        valorTime433 += map.get("Laterais").get(latStartPos+1).getPreco_num();
        timeFormado.add(map.get("Laterais").get(latStartPos+1));

        holder.z433_1_nome.setText(map.get("Zagueiros").get(zagaStartPos).getApelido());
        valorTime433 += map.get("Zagueiros").get(zagaStartPos).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos));

        holder.z433_3_nome.setText(map.get("Zagueiros").get(zagaStartPos+1).getApelido());
        valorTime433 += map.get("Zagueiros").get(zagaStartPos+1).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos+1));

        holder.g433_1_nome.setText(map.get("Goleiro").get(golStartPos).getApelido());
        valorTime433 += map.get("Goleiro").get(golStartPos).getPreco_num();
        timeFormado.add(map.get("Goleiro").get(golStartPos));

        holder.t433_1_nome.setText(map.get("Tecnico").get(tecStartPos).getApelido());
        valorTime433 += map.get("Tecnico").get(tecStartPos).getPreco_num();
        timeFormado.add(map.get("Tecnico").get(tecStartPos));

        holder.valor433.setText(String.format("Valor do time: C$ %.2f", valorTime433));
        application.getTimesFormados().put("time433", timeFormado);

        indexClic = ataqueStartPos;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a433_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a433_1);
        }


        indexClic = ataqueStartPos+1;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a433_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a433_2);
        }


        indexClic = ataqueStartPos+2;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a433_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a433_3);
        }


        indexClic = meiaStartPos;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m433_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m433_1);
        }

        indexClic = meiaStartPos+1;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m433_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m433_2);
        }

        indexClic = meiaStartPos+2;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m433_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m433_3);
        }


        indexClic = latStartPos;
        if (map.get("Laterais").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Laterais").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.l433_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.l433_1);
        }

        indexClic = latStartPos+1;
        if (map.get("Laterais").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Laterais").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.l433_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.l433_3);
        }


        indexClic = zagaStartPos;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z433_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z433_1);
        }

        indexClic = zagaStartPos+1;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z433_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z433_3);
        }


        indexClic = golStartPos;
        if (map.get("Goleiro").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Goleiro").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.g433_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.g433_1);
        }

        indexClic = tecStartPos;
        if (map.get("Tecnico").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Tecnico").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.t433_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.t433_1);
        }
    }

    private void getOnBindView343(TresQuatroTresViewHolder viewHolder) {
        TresQuatroTresViewHolder holder = viewHolder;
        MyApplication application = (MyApplication) context.getApplicationContext();
        timeFormado = new ArrayList<>();

        int ataqueStartPos = 0, meiaStartPos = 0, zagaStartPos = 0, golStartPos = 0, tecStartPos = 0;
        double valorTime343 = 0.0;

        if(!filtro.get("valor").toString().equals("0.0")) {
            double value = Double.valueOf(filtro.get("valor").toString());

            for(Atletas a: map.get("Atacantes")) {
                double maxValue = (double)(value * (10/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                ataqueStartPos++;
            }


            for(Atletas a: map.get("Meias")) {
                double maxValue = (double)(value * (10/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                meiaStartPos++;
            }


            for(Atletas a: map.get("Zagueiros")) {
                double maxValue = (double)(value * (5/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                zagaStartPos++;
            }

            for(Atletas a: map.get("Goleiro")) {
                double maxValue = (double)(value * (8/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                golStartPos++;
            }

            for(Atletas a: map.get("Tecnico")) {
                double maxValue = (double)(value * (7/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                tecStartPos++;
            }


        }
        holder.a343_1_nome.setText(map.get("Atacantes").get(ataqueStartPos).getApelido());
        valorTime343 += map.get("Atacantes").get(ataqueStartPos).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos));

        holder.a343_2_nome.setText(map.get("Atacantes").get(ataqueStartPos+1).getApelido());
        valorTime343 += map.get("Atacantes").get(ataqueStartPos+1).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos+1));

        holder.a343_3_nome.setText(map.get("Atacantes").get(ataqueStartPos+2).getApelido());
        valorTime343 += map.get("Atacantes").get(ataqueStartPos+2).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos+2));

        holder.m343_1_nome.setText(map.get("Meias").get(meiaStartPos).getApelido());
        valorTime343 += map.get("Meias").get(meiaStartPos).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos));

        holder.m343_2_nome.setText(map.get("Meias").get(meiaStartPos+1).getApelido());
        valorTime343 += map.get("Meias").get(meiaStartPos+1).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+1));

        holder.m343_3_nome.setText(map.get("Meias").get(meiaStartPos+2).getApelido());
        valorTime343 += map.get("Meias").get(meiaStartPos+2).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+2));

        holder.m343_4_nome.setText(map.get("Meias").get(meiaStartPos+3).getApelido());
        valorTime343 += map.get("Meias").get(meiaStartPos+3).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+3));

        holder.z343_1_nome.setText(map.get("Zagueiros").get(zagaStartPos).getApelido());
        valorTime343 += map.get("Zagueiros").get(zagaStartPos).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos));

        holder.z343_2_nome.setText(map.get("Zagueiros").get(zagaStartPos+1).getApelido());
        valorTime343 += map.get("Zagueiros").get(zagaStartPos+1).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos+1));

        holder.z343_3_nome.setText(map.get("Zagueiros").get(zagaStartPos+2).getApelido());
        valorTime343 += map.get("Zagueiros").get(zagaStartPos+2).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos+2));

        holder.g343_1_nome.setText(map.get("Goleiro").get(golStartPos).getApelido());
        valorTime343 += map.get("Goleiro").get(golStartPos).getPreco_num();
        timeFormado.add(map.get("Goleiro").get(golStartPos));

        holder.t343_1_nome.setText(map.get("Tecnico").get(tecStartPos).getApelido());
        valorTime343 += map.get("Tecnico").get(tecStartPos).getPreco_num();
        timeFormado.add(map.get("Tecnico").get(tecStartPos));

        holder.valor343.setText(String.format("Valor do time: C$ %.2f", valorTime343));
        application.getTimesFormados().put("time343", timeFormado);

        indexClic = ataqueStartPos;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a343_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a343_1);
        }

        indexClic = ataqueStartPos+1;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a343_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a343_2);
        }

        indexClic = ataqueStartPos+2;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a343_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a343_3);
        }

        indexClic = meiaStartPos;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m343_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m343_1);
        }

        indexClic = meiaStartPos+1;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m343_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m343_2);
        }

        indexClic = meiaStartPos+2;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m343_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m343_3);
        }

        indexClic = meiaStartPos+3;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m343_4);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m343_4);
        }


        indexClic = zagaStartPos;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z343_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z343_1);
        }

        indexClic = zagaStartPos+1;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z343_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z343_2);
        }

        indexClic = zagaStartPos+2;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z343_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z343_3);
        }

        indexClic = golStartPos;
        if (map.get("Goleiro").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Goleiro").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.g343_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.g343_1);
        }

        indexClic = tecStartPos;
        if (map.get("Tecnico").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Tecnico").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.t343_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.t343_1);
        }
    }

    private void getOnBindView352(TresCincoDoisViewHolder viewHolder) {
        TresCincoDoisViewHolder holder = viewHolder;
        MyApplication application = (MyApplication) context.getApplicationContext();
        timeFormado = new ArrayList<>();

        int ataqueStartPos = 0, meiaStartPos = 0, zagaStartPos = 0, golStartPos = 0, tecStartPos = 0;
        double valorTime352 = 0.0;

        if(!filtro.get("valor").toString().equals("0.0")) {
            double value = Double.valueOf(filtro.get("valor").toString());

            for(Atletas a: map.get("Atacantes")) {
                double maxValue = (double)(value * (10/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                ataqueStartPos++;
            }


            for(Atletas a: map.get("Meias")) {
                double maxValue = (double)(value * (10/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                meiaStartPos++;
            }


            for(Atletas a: map.get("Zagueiros")) {
                double maxValue = (double)(value * (5/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                zagaStartPos++;
            }

            for(Atletas a: map.get("Goleiro")) {
                double maxValue = (double)(value * (8/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                golStartPos++;
            }

            for(Atletas a: map.get("Tecnico")) {
                double maxValue = (double)(value * (7/100.0f));
                if(a.getPreco_num() <= maxValue) {
                    break;
                }
                tecStartPos++;
            }


        }

        holder.a352_1_nome.setText(map.get("Atacantes").get(ataqueStartPos).getApelido());
        valorTime352 += map.get("Atacantes").get(ataqueStartPos).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos));

        holder.a352_3_nome.setText(map.get("Atacantes").get(ataqueStartPos+1).getApelido());
        valorTime352 += map.get("Atacantes").get(ataqueStartPos).getPreco_num();
        timeFormado.add(map.get("Atacantes").get(ataqueStartPos));

        holder.m352_1_nome.setText(map.get("Meias").get(meiaStartPos).getApelido());
        valorTime352 += map.get("Meias").get(meiaStartPos).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos));

        holder.m352_2_nome.setText(map.get("Meias").get(meiaStartPos+1).getApelido());
        valorTime352 += map.get("Meias").get(meiaStartPos+1).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+1));

        holder.m352_3_nome.setText(map.get("Meias").get(meiaStartPos+2).getApelido());
        valorTime352 += map.get("Meias").get(meiaStartPos+2).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+2));

        holder.m352_4_nome.setText(map.get("Meias").get(meiaStartPos+3).getApelido());
        valorTime352 += map.get("Meias").get(meiaStartPos+3).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+3));

        holder.m352_5_nome.setText(map.get("Meias").get(meiaStartPos+4).getApelido());
        valorTime352 += map.get("Meias").get(meiaStartPos+4).getPreco_num();
        timeFormado.add(map.get("Meias").get(meiaStartPos+4));

        holder.z352_1_nome.setText(map.get("Zagueiros").get(zagaStartPos).getApelido());
        valorTime352 += map.get("Zagueiros").get(zagaStartPos).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos));

        holder.z352_2_nome.setText(map.get("Zagueiros").get(zagaStartPos+1).getApelido());
        valorTime352 += map.get("Zagueiros").get(zagaStartPos+1).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos+1));

        holder.z352_3_nome.setText(map.get("Zagueiros").get(zagaStartPos+2).getApelido());
        valorTime352 += map.get("Zagueiros").get(zagaStartPos+2).getPreco_num();
        timeFormado.add(map.get("Zagueiros").get(zagaStartPos+2));

        holder.g352_1_nome.setText(map.get("Goleiro").get(golStartPos).getApelido());
        valorTime352 += map.get("Goleiro").get(golStartPos).getPreco_num();
        timeFormado.add(map.get("Goleiro").get(golStartPos));

        holder.t352_1_nome.setText(map.get("Tecnico").get(tecStartPos).getApelido());
        valorTime352 += map.get("Tecnico").get(tecStartPos).getPreco_num();
        timeFormado.add(map.get("Tecnico").get(tecStartPos));

        holder.valor352.setText(String.format("Valor do time: C$ %.2f", valorTime352));
        application.getTimesFormados().put("time352", timeFormado);

        indexClic = ataqueStartPos;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a352_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a352_1);
        }

        indexClic = ataqueStartPos+1;
        if (map.get("Atacantes").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a352_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a352_3);
        }

        indexClic = meiaStartPos;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m352_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m352_1);
        }


        indexClic = meiaStartPos+1;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m352_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m352_2);
        }

        indexClic = meiaStartPos+2;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m352_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m352_3);
        }

        indexClic = meiaStartPos+3;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m352_4);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m352_4);
        }

        indexClic = meiaStartPos+4;
        if (map.get("Meias").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Meias").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m352_5);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m352_5);
        }


        indexClic = zagaStartPos;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z352_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z352_1);
        }

        indexClic = zagaStartPos+1;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z352_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z352_2);
        }

        indexClic = zagaStartPos+2;
        if (map.get("Zagueiros").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z352_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z352_3);
        }


        indexClic = golStartPos;
        if (map.get("Goleiro").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Goleiro").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.g352_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.g352_1);
        }

        indexClic = tecStartPos;
        if (map.get("Tecnico").get(indexClic).getFoto() != null) {
            String url_imagem = map.get("Tecnico").get(indexClic).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.t352_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.t352_1);
        }
    }

    @Override
    public int getItemCount() {
        return this.formacoes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return this.formacoes.get(position);
    }
}
