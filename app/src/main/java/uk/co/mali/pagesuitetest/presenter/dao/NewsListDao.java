package uk.co.mali.pagesuitetest.presenter.dao;

import rx.Observable;
import uk.co.mali.pagesuitetest.model.pojos.Article;
import uk.co.mali.pagesuitetest.model.pojos.Data;
import uk.co.mali.pagesuitetest.network.apis.RestApi;
import uk.co.mali.pagesuitetest.utils.network.NetworkUtils;
import uk.co.mali.pagesuitetest.views.activities.NewsListActivity;

/**
 * Created by alig2 on 27/06/2017.
 */

public class NewsListDao {

    NewsListActivity contextNewsListActivity;
    RestApi iRestApi;

    public NewsListDao(NewsListActivity context, RestApi iApi){
        this.contextNewsListActivity = context;
        this.iRestApi = iApi;

    }

    public Observable<Data> provideRestData(){
        Observable<Data> restData = iRestApi.getRestApiData();
        return restData;
            }

    public Observable<Boolean> isNetworkAvailable(){
        return NetworkUtils.isNetworkAvailableObservable(contextNewsListActivity);
    }

    public void gotoArticleDetailActivity(Article article){
        contextNewsListActivity.goToArticleDetailActivity(article);

    }


}
