package uk.co.mali.pagesuitetest.presenter.presentation;

import android.util.Log;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import uk.co.mali.pagesuitetest.presenter.dao.FrontPageDao;
import uk.co.mali.pagesuitetest.utils.rxutils.IRxSchedulers;

/**
 * Created by alig2 on 27/06/2017.
 */

public class FrontPagePresenter {

    public final static String TAG = FrontPagePresenter.class.getSimpleName();

    private FrontPageDao frontPageDao;
    private IRxSchedulers iRxSchedulers;
    private CompositeSubscription compositeSubscription;


    public FrontPagePresenter(FrontPageDao frontPageDao, IRxSchedulers iRxSchedulers, CompositeSubscription subscription){
        Log.d(TAG,"constructor called");
        this.frontPageDao = frontPageDao;
        this.iRxSchedulers= iRxSchedulers;
        this.compositeSubscription = subscription;
    }
    public void onCreate(){

        Log.d(TAG,"onCreate: called");
        compositeSubscription.add(getArticleList());
    }

    private void onDestroy(){
        Log.d(TAG,"onCreate: called");
        compositeSubscription.clear();

    }

    private Subscription getArticleList()
    {

        return frontPageDao.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable)
            {
                Log.d("no conn", "no connexion");
                // Show Snackbar can't use app
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> frontPageDao.isNetworkAvailable()).
                subscribeOn(iRxSchedulers.internet()).
                observeOn(iRxSchedulers.androidThread()).subscribe(aBoolean -> {

            frontPageDao.gotoNewsListActivity();
        }, throwable -> {

            //UIUtils.handleThrowable(throwable);
        });
    }

}
