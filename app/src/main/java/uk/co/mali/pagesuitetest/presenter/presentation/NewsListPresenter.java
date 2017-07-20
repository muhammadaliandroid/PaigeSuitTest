package uk.co.mali.pagesuitetest.presenter.presentation;

import android.util.Log;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import uk.co.mali.pagesuitetest.model.pojos.Article;
import uk.co.mali.pagesuitetest.presenter.dao.NewsListDao;
import uk.co.mali.pagesuitetest.utils.rxutils.IRxSchedulers;
import uk.co.mali.pagesuitetest.utils.ui.UIUtils;
import uk.co.mali.pagesuitetest.views.subviews.NewsView;

/**
 * Created by alig2 on 27/06/2017.
 */

public class NewsListPresenter {

    private static final String TAG= NewsListPresenter.class.getSimpleName();
    NewsView newsView;
    NewsListDao newsListDao;
    IRxSchedulers iRxSchedulers;
    CompositeSubscription compositeSubscription;
    ArrayList<Article> ListArticle = new ArrayList<>();


    public NewsListPresenter(IRxSchedulers iRxSchedulers, NewsListDao newsListDao, NewsView newsView, CompositeSubscription subscription ){
        Log.d(TAG,"Constructor Called: ");
        this.iRxSchedulers = iRxSchedulers;
        this. newsListDao= newsListDao;
        this.newsView = newsView;
        this.compositeSubscription = subscription;
    }


    public void onCreate(){
        Log.d(TAG, TAG+" onCreated() called...");
        compositeSubscription.add(getArticleList());
        compositeSubscription.add(respondToClick());

    }

    public void onDestroy(){

        compositeSubscription.clear();
    }

    private Subscription respondToClick(){
        return newsView.itemClicks().subscribe(integer ->
                newsListDao.gotoArticleDetailActivity(ListArticle.get(integer)));

    }

    private Subscription getArticleList() {

        return newsListDao.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {

            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> newsListDao.provideRestData()).
                subscribeOn(iRxSchedulers.internet()).
                observeOn(iRxSchedulers.androidThread()).subscribe(data -> {
                    Log.d(TAG, "Subcription of Data.");
                    newsView.swapAdapter(data);
                    ListArticle= (ArrayList<Article>) data.getArticles();
                }, throwable -> {
                    UIUtils.handleThrowable(throwable);
                }
        );

    }


}
