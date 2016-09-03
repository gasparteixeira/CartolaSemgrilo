package edm.senacrs.com.br.cartolasemgrilo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;
import java.util.Map;

import edm.senacrs.com.br.cartolasemgrilo.dummy.NumberTextWatcher;
import edm.senacrs.com.br.cartolasemgrilo.model.Retorno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<Retorno> {

    ProgressDialog progressDoalog;
    private CoordinatorLayout coordinatorLayout;
    ToggleButton pontosToggle, cartogletasToggle, p433Toggle, p343Toggle, p352Toggle;
    EditText inputValor;
    public Map<String, Object> filtro = new HashMap<>();
    String name, surname, imageUrl;
    private ShareDialog shareDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        MyApplication application = (MyApplication) getApplicationContext();
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Bundle inBundle = getIntent().getExtras();
        name = inBundle.get("name").toString();
        surname = inBundle.get("surname").toString();
        imageUrl = inBundle.get("imageUrl").toString();


        progressDoalog = new ProgressDialog(MainActivity.this);

        filtro.put("pontos", new Boolean(true));
        filtro.put("cartoletas", new Boolean(false));
        filtro.put("p433", new Boolean(true));
        filtro.put("p352", new Boolean(false));
        filtro.put("p343", new Boolean(false));
        filtro.put("valor", new Double(0.0));

        makeToggleButtons();

        shareDialog = new ShareDialog(this);

        inputValor = (EditText) findViewById(R.id.inputValor);
        inputValor.addTextChangedListener(new NumberTextWatcher(inputValor, "#.###"));

    }

    private void makeToggleButtons() {
        pontosToggle = (ToggleButton) findViewById(R.id.pontos_toggle);
        pontosToggle.setChecked(true);
        pontosToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtro.put("pontos", pontosToggle.isChecked());
            }
        });
        cartogletasToggle = (ToggleButton) findViewById(R.id.catoletas_toggle);
        cartogletasToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtro.put("cartoletas", cartogletasToggle.isChecked());
            }
        });

        p433Toggle = (ToggleButton) findViewById(R.id.p_433_toggle);
        p433Toggle.setChecked(true);
        p433Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtro.put("p433", p433Toggle.isChecked());
            }
        });

        p343Toggle = (ToggleButton) findViewById(R.id.p_343_toggle);
        p343Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtro.put("p343", p343Toggle.isChecked());
            }
        });

        p352Toggle = (ToggleButton) findViewById(R.id.p_352_toggle);
        p352Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtro.put("p352", p352Toggle.isChecked());
            }
        });

    }

    public void onBuscarAtletas(View view) {
        if(!inputValor.getText().toString().equals("") && Double.valueOf(inputValor.getText().toString().replace("C$","")) < 50) {
            showMininoDialog();
        } else if((Boolean) filtro.get("p433") || (Boolean) filtro.get("p343") || (Boolean) filtro.get("p352")) {
            view.findViewById(R.id.button).setVisibility(View.INVISIBLE);
            Double d = (!inputValor.getText().toString().equals("") ? new Double(inputValor.getText().toString().replace("C$","")): new Double(0.0));
            filtro.put("valor", d);
            progressDoalog.setMax(100);
            progressDoalog.setMessage("Buscando Jorgadores ...");
            progressDoalog.setTitle("Atenção");
            progressDoalog.show();
            Call<Retorno> call = ((MyApplication) getApplication()).service.buscarAtletas();
            call.enqueue(this);
        } else {
            showAlertDialog();
        }

    }

    @Override
    public void onResponse(Call<Retorno> call, Response<Retorno> response) {
        int code = response.code();
        progressDoalog.setMessage("Retornou jorgadores com código " + code);
        if (code == 200) {
            Retorno retorno = response.body();

            MyApplication application = (MyApplication) getApplicationContext();
            application.setFiltro(filtro);
            application.setRetorno(retorno);

            progressDoalog.setMessage("Processando informações... ");

            Intent intent = new Intent(getBaseContext(), TimeActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Erro: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<Retorno> call, Throwable t) {
        Toast.makeText(this, "Erro na requisição", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        this.findViewById(R.id.button).setVisibility(View.VISIBLE);
        progressDoalog.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            showLogoutDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem facebook = menu.findItem(R.id.user_facebook);
        facebook.setTitle(name);
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    public void logout(){
        LoginManager.getInstance().logOut();
        Intent login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login);
        finish();
    }

    private void showMininoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.dialog_min_title));
        builder.setMessage(getString(R.string.dialog_min_content));

        String positiveText = getString(R.string.dialog_min_ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.dialog_alert_title));
        builder.setMessage(getString(R.string.dialog_alert_content));

        String positiveText = getString(R.string.dialog_alert_ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.dialog_logout_title));
        builder.setMessage(getString(R.string.dialog_logout_content));

        String positiveText = getString(R.string.dialog_logout_ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        logout();
                    }
                });

        String negativeText = getString(R.string.dialog_logout_no);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
