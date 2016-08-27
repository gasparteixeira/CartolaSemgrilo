package edm.senacrs.com.br.cartolasemgrilo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import edm.senacrs.com.br.cartolasemgrilo.MyApplication;
import edm.senacrs.com.br.cartolasemgrilo.R;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;
import edm.senacrs.com.br.cartolasemgrilo.model.Clube;

/**
 * Created by gaspar on 21/08/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;
    LayoutInflater inflater;
    List<Atletas> atletasList;
    public RecyclerAdapter(Context context, List<Atletas> atletasList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.atletasList = atletasList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_list, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {


        holder.atelta_apelido.setText(this.atletasList.get(position).getApelido());

        if(this.atletasList.get(position).getFoto() != null) {
            String url_imagem = this.atletasList.get(position).getFoto().replace("FORMATO", "80x80");
            Picasso.with(context).load(url_imagem).into(holder.atleta_foto);
        } else {
            Picasso.with(context).load(R.drawable.default_img).into(holder.atleta_foto);
        }
        Clube clube = getClube(this.atletasList.get(position).getClube_id());

        holder.clube_desc.setText(clube.getAbreviacao());
        Picasso.with(context).load(clube.getEscudos().get("60x60")).into(holder.time_escudo);
        String atleta_time_text = String.format("C$ %2.2f | P = %d", this.atletasList.get(position).getPreco_num(), this.atletasList.get(position).getVariacao());
        holder.atleta_time.setText(atleta_time_text);
        holder.itemView.setOnClickListener(clickListener);
        holder.itemView.setTag(holder);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();

            Toast.makeText(context,"This is position "+position,Toast.LENGTH_LONG ).show();

        }
    };



    @Override
    public int getItemCount() {
        return this.atletasList.size();
    }

    private Clube getClube(Long clubeId) {
        Clube clube = new Clube();
        final MyApplication application = (MyApplication) this.context.getApplicationContext();
        if(application.getRetorno() != null) {
            clube = application.getRetorno().getClubes().get(clubeId.intValue());
        }
        return clube;
    }
}
