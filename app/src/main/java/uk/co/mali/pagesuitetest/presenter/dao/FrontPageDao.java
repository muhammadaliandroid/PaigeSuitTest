package uk.co.mali.pagesuitetest.presenter.dao;

import rx.Observable;
import uk.co.mali.pagesuitetest.model.pojos.Data;
import uk.co.mali.pagesuitetest.network.apis.RestApi;
import uk.co.mali.pagesuitetest.utils.network.NetworkUtils;
import uk.co.mali.pagesuitetest.views.activities.FrontPageActivity;

/**
 * Created by alig2 on 27/06/2017.
 */

public class FrontPageDao {

    RestApi api;
    FrontPageActivity fpContext;


    public FrontPageDao(RestApi api,FrontPageActivity fpContext){
        this.api = api;
        this.fpContext = fpContext;
    }

    Observable<Data> provideListArticles(){
        return api.getRestApiData();
    }

    public Observable<Boolean> isNetworkAvailable(){
        return NetworkUtils.isNetworkAvailableObservable(fpContext);
    }

    public void gotoNewsListActivity(){
        fpContext.showNewsListActivity();
    }
}


