package uk.co.mali.pagesuitetest.dagger.module;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;
import uk.co.mali.pagesuitetest.dagger.scope.NewsScope;
import uk.co.mali.pagesuitetest.network.apis.RestApi;
import uk.co.mali.pagesuitetest.presenter.dao.NewsListDao;
import uk.co.mali.pagesuitetest.presenter.presentation.NewsListPresenter;
import uk.co.mali.pagesuitetest.utils.rxutils.IRxSchedulers;
import uk.co.mali.pagesuitetest.views.activities.NewsListActivity;
import uk.co.mali.pagesuitetest.views.subviews.NewsView;

/**
 * Created by alig2 on 27/06/2017.
 */


@Module
public class NewsModule {

    NewsListActivity contextNewsListActivity;

    public NewsModule(NewsListActivity context){
        this.contextNewsListActivity = context;
    }

    @NewsScope
    @Provides
    public NewsView provideNewsView(){
        return new NewsView(contextNewsListActivity);
    }

    @NewsScope
    @Provides
    public NewsListDao provideDao(RestApi iRestApi){
        return new NewsListDao(contextNewsListActivity, iRestApi);
    }

    @NewsScope
    @Provides
    public NewsListPresenter providePresenter(IRxSchedulers iRxSchedulers, NewsView newsView, NewsListDao newsListDao){
        CompositeSubscription subscription = new CompositeSubscription();
        return new NewsListPresenter(iRxSchedulers, newsListDao, newsView, subscription);
    }

    @NewsScope
    @Provides
    public NewsListActivity provideContext(){
        return contextNewsListActivity;
    }






}
