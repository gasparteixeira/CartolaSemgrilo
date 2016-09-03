package edm.senacrs.com.br.cartolasemgrilo.iface;


import edm.senacrs.com.br.cartolasemgrilo.model.Retorno;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gaspar on 07/07/16.
 */
public interface MyInterfaceRetrofit {

    @GET("atletas/mercado")
    Call<Retorno> buscarAtletas();
}
