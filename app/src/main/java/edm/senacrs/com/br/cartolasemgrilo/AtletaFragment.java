package edm.senacrs.com.br.cartolasemgrilo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edm.senacrs.com.br.cartolasemgrilo.adapter.AtletasAdapter;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;

/**
 * Created by gaspar on 20/08/16.
 */
public class AtletaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.atleta_list_row, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Atletas> listaAtletas = (List<Atletas>) getArguments().getSerializable("listaAtletas");
        AtletasAdapter atletasAdapter = new AtletasAdapter(listaAtletas);
        recyclerView.setAdapter(atletasAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}
