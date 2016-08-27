package edm.senacrs.com.br.cartolasemgrilo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edm.senacrs.com.br.cartolasemgrilo.adapter.RecyclerAdapter;
import edm.senacrs.com.br.cartolasemgrilo.adapter.TimeAdapter;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;
import edm.senacrs.com.br.cartolasemgrilo.dummy.Classificacao;

public class TimeActivity extends AppCompatActivity {


    private List<Atletas> atletasList = new ArrayList<>();
    RecyclerView recyclerView;
    private Map<String, List<Atletas>> timeMap = new HashMap<String, List<Atletas>>();
    private RecyclerView.LayoutManager mLayoutManager;
    private TimeAdapter timeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);


        final MyApplication application = (MyApplication)getApplicationContext();

        Classificacao classificacao = new Classificacao(application.getRetorno());
        classificacao.classificar();
        List<Atletas> atacantes = classificacao.getAtacantes();
        List<Atletas> meias = classificacao.getMeias();
        List<Atletas> laterais = classificacao.getLaterais();
        List<Atletas> zagueiros = classificacao.getZagueiros();
        List<Atletas> goleiros = classificacao.getGoleiros();
        List<Atletas> tecnicos = classificacao.getTecnicos();
        timeMap.put("Atacantes", atacantes);
        timeMap.put("Meias", meias);
        timeMap.put("Laterais", laterais);
        timeMap.put("Zagueiros", zagueiros);
        timeMap.put("Goleiro", goleiros);
        timeMap.put("Tecnico", tecnicos);

        //cardView = (CardView) findViewById(R.id.time_card_view);

        //View view = LayoutInflater.inflate(R.layout.time_show, timeMap, false);
        //view.setVisibility(View.VISIBLE);


        //atletasList = ;

        recyclerView = (RecyclerView) findViewById(R.id.time_recycler_view);

        TimeAdapter adapter = new TimeAdapter(this, timeMap);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
