package edm.senacrs.com.br.cartolasemgrilo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import edm.senacrs.com.br.cartolasemgrilo.model.Retorno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<Retorno> {

    ProgressDialog progressDoalog;
    Spinner spinner1;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDoalog = new ProgressDialog(MainActivity.this);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new ItemSelectedListener());
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if(null!=rb && checkedId > -1){
                    //Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void onBuscarAtletas(View view) {

        view.findViewById(R.id.button).setVisibility(View.INVISIBLE);

        progressDoalog.setMax(100);
        progressDoalog.setMessage("Buscando Jorgadores ...");
        progressDoalog.setTitle("Atenção");
        progressDoalog.show();
        Call<Retorno> call = ((MyApplication) getApplication()).service.buscarAtletas();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Retorno> call, Response<Retorno> response) {
        int code = response.code();
        progressDoalog.setMessage("Retornou jorgadores com código "+ code);
        if (code == 200) {
            Retorno retorno = response.body();

            final MyApplication application = (MyApplication)getApplicationContext();
            application.setRetorno(retorno);

            progressDoalog.setMessage("Processando informações... ");

            Intent  intent = new Intent(getBaseContext(), TimeActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Erro: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<Retorno> call, Throwable t) {
        Toast.makeText(this, "Erro na requisição", Toast.LENGTH_LONG).show();
    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        radioGroup.clearCheck();
    }


    @Override
    protected void onResume() {
        super.onResume();
        this.findViewById(R.id.button).setVisibility(View.VISIBLE);
        progressDoalog.hide();
    }

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                /*Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();*/
                // Todo when item is selected by the user
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    }
}
