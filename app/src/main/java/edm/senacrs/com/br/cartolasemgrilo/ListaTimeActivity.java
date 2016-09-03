package edm.senacrs.com.br.cartolasemgrilo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import edm.senacrs.com.br.cartolasemgrilo.adapter.RecyclerAdapter;
import edm.senacrs.com.br.cartolasemgrilo.adapter.TimeAdapter;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;

public class ListaTimeActivity extends AppCompatActivity {

    private List<Atletas> atletasList = new ArrayList<>();
    RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_time);

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

        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("FORMACAO");
        }

        TextView titulo = (TextView) findViewById(R.id.list_toolbar_title);
        titulo.setText("Listando formação "+ value.replace("time", ""));

        atletasList = application.getTimesFormados().get(value);

        recyclerView = (RecyclerView) findViewById(R.id.time_list_recycler_view);

        RecyclerAdapter adapter = new RecyclerAdapter(this, atletasList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
    }
}
