package uk.co.mali.pagesuitetest.dagger.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import uk.co.mali.pagesuitetest.dagger.scope.AppScope;

/**
 * Created by alig2 on 22/06/2017.
 */

@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context){
        this.context = context;

    }

    @Provides
    @AppScope
    Context provideAppContext(){
        return context;
    }

}
