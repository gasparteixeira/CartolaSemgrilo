package edm.senacrs.com.br.cartolasemgrilo;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edm.senacrs.com.br.cartolasemgrilo.iface.MyInterfaceRetrofit;
import edm.senacrs.com.br.cartolasemgrilo.model.Retorno;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gaspar on 07/07/16.
 */
public class MyApplication extends Application {

    public MyInterfaceRetrofit service;
    public Retorno retorno;


    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://api.cartolafc.globo.com")
                .baseUrl("http://gasparteixeira.com.br")
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
}
