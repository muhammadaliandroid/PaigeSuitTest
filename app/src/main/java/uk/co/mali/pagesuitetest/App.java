package uk.co.mali.pagesuitetest;

import android.app.Application;

import uk.co.mali.pagesuitetest.dagger.component.AppComponent;
import uk.co.mali.pagesuitetest.dagger.component.DaggerAppComponent;
import uk.co.mali.pagesuitetest.dagger.module.AppModule;

/**
 * Created by alig2 on 23/06/2017.
 */

public class App extends Application {


    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();

    }


    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getNetComponent(){
        return appComponent;

    }




}
