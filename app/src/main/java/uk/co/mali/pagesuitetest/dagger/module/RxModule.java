package uk.co.mali.pagesuitetest.dagger.module;

import dagger.Module;
import dagger.Provides;
import uk.co.mali.pagesuitetest.utils.rxutils.IRxSchedulers;
import uk.co.mali.pagesuitetest.utils.rxutils.RxSchedulers;


/**
 * Created by alig2 on 27/06/2017.
 */
@Module
public class RxModule {


    @Provides
    IRxSchedulers provideIRxSchedulers(){
        return new RxSchedulers();
    }
}
