package edm.senacrs.com.br.cartolasemgrilo.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edm.senacrs.com.br.cartolasemgrilo.R;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;

/**
 * Created by gaspar on 20/08/16.
 */
public class AtletasAdapter extends RecyclerView.Adapter<AtletasAdapter.MyViewHolder> {

    private List<Atletas> atletasList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView atletaNome, atletaTime;
        public ImageView atletaImagem;

        public MyViewHolder(View view) {
            super(view);
            atletaNome = (TextView) view.findViewById(R.id.atletaNome);
            atletaTime = (TextView) view.findViewById(R.id.atletaTime);
            atletaImagem = (ImageView)view.findViewById(R.id.atletaImagem);

        }
    }

    public AtletasAdapter(List<Atletas> atletasList) {
        this.atletasList = atletasList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.atleta_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Atletas atletas = atletasList.get(position);
        holder.atletaNome.setText(atletas.getApelido());
        holder.atletaTime.setText(atletas.getClube_id().toString());
        holder.atletaImagem.setImageURI(Uri.parse(atletas.getFoto()));
    }

    @Override
    public int getItemCount() {
        return atletasList.size();
    }
}
