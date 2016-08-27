package edm.senacrs.com.br.cartolasemgrilo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

import edm.senacrs.com.br.cartolasemgrilo.R;
import edm.senacrs.com.br.cartolasemgrilo.dummy.CircleTransform;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;

/**
 * Created by gaspar on 25/07/16.
 */
public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder>  {

    Context context;
    Map<String, List<Atletas>> map;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class QuatroTresTresViewHolder extends ViewHolder {
        ImageView a_1, a_2, a_3, m_1, m_2, m_3, l_1, l_3, z_1, z_3, g_1, t_1;
        TextView a_1_nome, a_2_nome, a_3_nome, m_1_nome, m_2_nome, m_3_nome, l_1_nome, l_3_nome, z_1_nome, z_3_nome, g_1_nome, t_1_nome;

        public QuatroTresTresViewHolder(View v) {
            super(v);
            this.a_1 = (ImageView) v.findViewById(R.id.a_1);
            this.a_2 = (ImageView) v.findViewById(R.id.a_2);
            this.a_3 = (ImageView) v.findViewById(R.id.a_3);
            this.m_1 = (ImageView) v.findViewById(R.id.m_1);
            this.m_2 = (ImageView) v.findViewById(R.id.m_2);
            this.m_3 = (ImageView) v.findViewById(R.id.m_3);
            this.l_1 = (ImageView) v.findViewById(R.id.l_1);
            this.l_3 = (ImageView) v.findViewById(R.id.l_3);
            this.z_1 = (ImageView) v.findViewById(R.id.z_1);
            this.z_3 = (ImageView) v.findViewById(R.id.z_3);
            this.g_1 = (ImageView) v.findViewById(R.id.g_1);
            this.t_1 = (ImageView) v.findViewById(R.id.t_1);

            this.a_1_nome = (TextView) v.findViewById(R.id.a_1_nome);
            this.a_2_nome = (TextView) v.findViewById(R.id.a_2_nome);
            this.a_3_nome = (TextView) v.findViewById(R.id.a_3_nome);
            this.m_1_nome = (TextView) v.findViewById(R.id.m_1_nome);
            this.m_2_nome = (TextView) v.findViewById(R.id.m_2_nome);
            this.m_3_nome = (TextView) v.findViewById(R.id.m_3_nome);
            this.l_1_nome = (TextView) v.findViewById(R.id.l_1_nome);
            this.l_3_nome = (TextView) v.findViewById(R.id.l_3_nome);
            this.z_1_nome = (TextView) v.findViewById(R.id.z_1_nome);
            this.z_3_nome = (TextView) v.findViewById(R.id.z_3_nome);
            this.g_1_nome = (TextView) v.findViewById(R.id.g_1_nome);
            this.t_1_nome = (TextView) v.findViewById(R.id.t_1_nome);
        }
    }



    public TimeAdapter(Context context, Map<String, List<Atletas>> map) {
        this.context = context;
        this.map = map;
    }



    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_show, parent, false);
        return new QuatroTresTresViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TimeAdapter.ViewHolder viewHolder, int position) {
        QuatroTresTresViewHolder holder = (QuatroTresTresViewHolder) viewHolder;
        holder.a_1_nome.setText(map.get("Atacantes").get(0).getApelido());
        holder.a_2_nome.setText(map.get("Atacantes").get(1).getApelido());
        holder.a_3_nome.setText(map.get("Atacantes").get(2).getApelido());
        holder.m_1_nome.setText(map.get("Meias").get(0).getApelido());
        holder.m_2_nome.setText(map.get("Meias").get(1).getApelido());
        holder.m_3_nome.setText(map.get("Meias").get(2).getApelido());
        holder.l_1_nome.setText(map.get("Laterais").get(0).getApelido());
        holder.l_3_nome.setText(map.get("Laterais").get(1).getApelido());
        holder.z_1_nome.setText(map.get("Zagueiros").get(0).getApelido());
        holder.z_3_nome.setText(map.get("Zagueiros").get(1).getApelido());
        holder.g_1_nome.setText(map.get("Goleiro").get(0).getApelido());
        holder.t_1_nome.setText(map.get("Tecnico").get(0).getApelido());

        if (map.get("Atacantes").get(0).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(0).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a_1);
        }

        if (map.get("Atacantes").get(1).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(1).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a_2);
        }

        if (map.get("Atacantes").get(2).getFoto() != null) {
            String url_imagem = map.get("Atacantes").get(2).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.a_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.a_3);
        }

        if (map.get("Meias").get(0).getFoto() != null) {
            String url_imagem = map.get("Meias").get(0).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m_1);
        }

        if (map.get("Meias").get(1).getFoto() != null) {
            String url_imagem = map.get("Meias").get(1).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m_2);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m_2);
        }

        if (map.get("Meias").get(2).getFoto() != null) {
            String url_imagem = map.get("Meias").get(2).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.m_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.m_3);
        }

        if (map.get("Laterais").get(0).getFoto() != null) {
            String url_imagem = map.get("Laterais").get(0).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.l_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.l_1);
        }

        if (map.get("Laterais").get(1).getFoto() != null) {
            String url_imagem = map.get("Laterais").get(1).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.l_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.l_3);
        }

        if (map.get("Zagueiros").get(0).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(0).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z_1);
        }

        if (map.get("Zagueiros").get(1).getFoto() != null) {
            String url_imagem = map.get("Zagueiros").get(1).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.z_3);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.z_3);
        }


        if (map.get("Goleiro").get(0).getFoto() != null) {
            String url_imagem = map.get("Goleiro").get(0).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.g_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.g_1);
        }

        if (map.get("Tecnico").get(0).getFoto() != null) {
            String url_imagem = map.get("Tecnico").get(0).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).transform(new CircleTransform()).into(holder.t_1);
        } else {
            Picasso.with(context).load(R.drawable.default_img).transform(new CircleTransform()).into(holder.t_1);
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
