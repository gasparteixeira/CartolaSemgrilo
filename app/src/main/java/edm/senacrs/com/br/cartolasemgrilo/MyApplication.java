package edm.senacrs.com.br.cartolasemgrilo;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edm.senacrs.com.br.cartolasemgrilo.iface.MyInterfaceRetrofit;
import edm.senacrs.com.br.cartolasemgrilo.model.Atletas;
import edm.senacrs.com.br.cartolasemgrilo.model.Retorno;
import edm.senacrs.com.br.cartolasemgrilo.model.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gaspar on 07/07/16.
 */
public class MyApplication extends Application {

    public MyInterfaceRetrofit service;
    public Retorno retorno;
    public Map<String, Object> filtro = new HashMap<>();
    public User user;
    public Map<String, List<Atletas>> timesFormados = new HashMap();


    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.cartolafc.globo.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(MyInterfaceRetrofit.class);
    }

    public Retorno getRetorno() {
        return retorno;
    }

    public void setRetorno(Retorno retorno) {
        this.retorno = retorno;
    }

    public Map<String, Object> getFiltro() {
        return filtro;
    }

    public void setFiltro(Map<String, Object> filtro) {
        this.filtro = filtro;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, List<Atletas>> getTimesFormados() {
        return timesFormados;
    }

    public void setTimesFormados(Map<String, List<Atletas>> timesFormados) {
        this.timesFormados = timesFormados;
    }
}
