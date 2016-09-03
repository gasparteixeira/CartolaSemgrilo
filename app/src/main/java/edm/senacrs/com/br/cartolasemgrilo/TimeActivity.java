package edm.senacrs.com.br.cartolasemgrilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

    public static final int F433 = 0;
    public static final int F343 = 1;
    public static final int F352 = 2;

    private List<Atletas> atletasList = new ArrayList<>();
    RecyclerView recyclerView;
    private Map<String, List<Atletas>> timeMap = new HashMap<String, List<Atletas>>();
    private Map<String, Object> filtro = new HashMap<>();
    private LinearLayoutManager mLayoutManager;
    private TimeAdapter timeAdapter;
    private List<Integer> formacoes = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_time);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        MyApplication application = (MyApplication)getApplicationContext();
        filtro = application.getFiltro();
        Classificacao classificacao = new Classificacao(application);
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
        if((Boolean) filtro.get("p433")) {
            formacoes.add(F433);
        }

        if((Boolean)filtro.get("p343")) {
            formacoes.add(F343);
        }

        if((Boolean)filtro.get("p352")) {
            formacoes.add(F352);
        }

        recyclerView = (RecyclerView) findViewById(R.id.time_recycler_view);

        TimeAdapter adapter = new TimeAdapter(this, timeMap, formacoes, filtro);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);

    }

    public void onListTime(View view) {
        String formacao = "";
        switch (view.getId()) {
            case (R.id.B433):
                formacao = "time433";
                break;
            case (R.id.B343):
                formacao = "time343";
                break;
            case (R.id.B352):
                formacao = "time352";
                break;
        }

        Intent intent = new Intent(getBaseContext(), ListaTimeActivity.class);
        intent.putExtra("FORMACAO", formacao);
        startActivity(intent);
    }


}
