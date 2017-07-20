package uk.co.mali.pagesuitetest.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import uk.co.mali.pagesuitetest.App;
import uk.co.mali.pagesuitetest.dagger.component.DaggerNewsComponent;
import uk.co.mali.pagesuitetest.dagger.module.NewsModule;
import uk.co.mali.pagesuitetest.model.pojos.Article;
import uk.co.mali.pagesuitetest.presenter.presentation.NewsListPresenter;
import uk.co.mali.pagesuitetest.views.subviews.NewsView;

/**
 * Created by alig2 on 22/06/2017.
 */
public class NewsListActivity extends AppCompatActivity {


    @Inject
    NewsView newsView;
    @Inject
    NewsListPresenter newsListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                DaggerNewsComponent.builder()
                .appComponent(App.getNetComponent())
                .newsModule(new NewsModule(this))
                .build()
                .inject(this);

        setContentView(newsView.view());

        newsListPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        newsListPresenter.onDestroy();
    }


    public void goToArticleDetailActivity(Article article) {

        Intent intent = new Intent(this, ArticleDetailActivity.class);
        intent.putExtra("article", article);
        startActivity(intent);
    }
}
