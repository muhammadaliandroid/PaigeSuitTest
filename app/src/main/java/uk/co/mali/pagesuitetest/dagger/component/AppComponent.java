package uk.co.mali.pagesuitetest.dagger.component;

import android.content.Context;

import dagger.Component;
import uk.co.mali.pagesuitetest.dagger.module.AppModule;
import uk.co.mali.pagesuitetest.dagger.module.NetModule;
import uk.co.mali.pagesuitetest.dagger.module.RestApiServiceModule;
import uk.co.mali.pagesuitetest.dagger.module.RxModule;
import uk.co.mali.pagesuitetest.dagger.scope.AppScope;
import uk.co.mali.pagesuitetest.network.apis.RestApi;
import uk.co.mali.pagesuitetest.utils.rxutils.IRxSchedulers;

/**
 * Created by alig2 on 26/06/2017.
 */

@AppScope
@Component(modules = {AppModule.class,NetModule.class, RxModule.class, RestApiServiceModule.class})
public interface AppComponent {

        Context getAppContext();
        IRxSchedulers iRxSchedulers();
        RestApi apiService();
}
