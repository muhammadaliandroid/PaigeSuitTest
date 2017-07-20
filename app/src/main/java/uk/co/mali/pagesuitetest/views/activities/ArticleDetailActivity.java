package uk.co.mali.pagesuitetest.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import uk.co.mali.pagesuitetest.dagger.component.DaggerArticalDetailComponent;
import uk.co.mali.pagesuitetest.dagger.module.ArticleDetailModule;
import uk.co.mali.pagesuitetest.model.pojos.Article;
import uk.co.mali.pagesuitetest.views.subviews.ArticleDetailView;

/**
 * Created by alig2 on 27/06/2017.
 */

public class ArticleDetailActivity extends AppCompatActivity {

    public final static String TAG = ArticleDetailActivity.class.getSimpleName();

    @Inject
    ArticleDetailView articleDetailView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"onCreate.. ");
        Article article = (Article) getIntent().getExtras().get("article");
        DaggerArticalDetailComponent.builder().articleDetailModule(new ArticleDetailModule(this, article)).build().inject(this);
        setContentView(articleDetailView.view());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
