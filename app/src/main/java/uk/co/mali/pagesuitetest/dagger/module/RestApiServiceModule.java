package uk.co.mali.pagesuitetest.dagger.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.pagesuitetest.dagger.scope.AppScope;
import uk.co.mali.pagesuitetest.network.apis.RestApi;
import uk.co.mali.pagesuitetest.network.constants.Constants;

/**
 * Created by alig2 on 27/06/2017.
 */

@Module
public class RestApiServiceModule {


    private static final String BASE_URL = Constants.BASE_URL;

    @AppScope
    @Provides
    RestApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter){
           Retrofit retrofit= new Retrofit.Builder()
                   .client(client)
                   .baseUrl(BASE_URL)
                   .addConverterFactory(gson)
                   .addCallAdapterFactory(rxAdapter)
                   .build();

        return retrofit.create(RestApi.class);
    }




}
