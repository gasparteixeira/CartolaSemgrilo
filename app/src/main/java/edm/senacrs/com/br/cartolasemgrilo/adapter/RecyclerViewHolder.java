package edm.senacrs.com.br.cartolasemgrilo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import edm.senacrs.com.br.cartolasemgrilo.R;

/**
 * Created by gaspar on 21/08/16.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView atelta_apelido, atleta_time, clube_desc;
    ImageView atleta_foto, time_escudo;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        atelta_apelido = (TextView) itemView.findViewById(R.id.atleta_apelido);
        atleta_time = (TextView) itemView.findViewById(R.id.atleta_time);
        atleta_foto = (ImageView) itemView.findViewById(R.id.atleta_foto);
        time_escudo = (ImageView) itemView.findViewById(R.id.time_escudo);
        clube_desc = (TextView) itemView.findViewById(R.id.clube_desc);

    }
}
