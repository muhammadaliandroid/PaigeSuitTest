package uk.co.mali.pagesuitetest.dagger.module;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;
import uk.co.mali.pagesuitetest.dagger.scope.FrontScope;
import uk.co.mali.pagesuitetest.network.apis.RestApi;
import uk.co.mali.pagesuitetest.presenter.dao.FrontPageDao;
import uk.co.mali.pagesuitetest.presenter.presentation.FrontPagePresenter;
import uk.co.mali.pagesuitetest.utils.rxutils.IRxSchedulers;
import uk.co.mali.pagesuitetest.views.activities.FrontPageActivity;
import uk.co.mali.pagesuitetest.views.subviews.FrontPageView;

/**
 * Created by alig2 on 27/06/2017.
 */

@Module
public class FrontPageModule {


    @FrontScope
    @Provides
    FrontPagePresenter providesPresenter(IRxSchedulers iRxSchedulers, FrontPageDao frontPageDao){
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new FrontPagePresenter(frontPageDao,iRxSchedulers,compositeSubscription);
    }

    @FrontScope
    @Provides
    FrontPageView provideFrontView(FrontPageActivity frontPageActivity){
        return new FrontPageView(frontPageActivity);
    }

    @FrontScope
    @Provides
    FrontPageDao provideFrontPageDao(RestApi api, FrontPageActivity frontPageActivity){
        return new FrontPageDao(api,frontPageActivity);
    }

}
