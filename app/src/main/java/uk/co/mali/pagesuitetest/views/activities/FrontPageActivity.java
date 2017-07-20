package uk.co.mali.pagesuitetest.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import uk.co.mali.pagesuitetest.App;
import uk.co.mali.pagesuitetest.dagger.component.DaggerFrontPageComponent;
import uk.co.mali.pagesuitetest.dagger.module.FrontPageContextModule;
import uk.co.mali.pagesuitetest.presenter.presentation.FrontPagePresenter;
import uk.co.mali.pagesuitetest.views.subviews.FrontPageView;

/**
 * Created by alig2 on 27/06/2017.
 */

public class FrontPageActivity extends AppCompatActivity {

    public final static String TAG = FrontPageActivity.class.getSimpleName();

    @Inject
    FrontPageView frontPageView;
    @Inject
    FrontPagePresenter frontPagePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);

        DaggerFrontPageComponent
                .builder()
                .appComponent(App.getNetComponent())
                .frontPageContextModule(new FrontPageContextModule(this))
                .build().inject(this);

        setContentView(frontPageView.constructView());
        frontPagePresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showNewsListActivity(){
        Intent intent = new Intent(this, NewsListActivity.class);
        startActivity(intent);
    }
}
