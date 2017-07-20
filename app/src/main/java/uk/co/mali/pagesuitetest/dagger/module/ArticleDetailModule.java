package uk.co.mali.pagesuitetest.dagger.module;

import dagger.Module;
import dagger.Provides;
import uk.co.mali.pagesuitetest.model.pojos.Article;
import uk.co.mali.pagesuitetest.views.activities.ArticleDetailActivity;
import uk.co.mali.pagesuitetest.views.subviews.ArticleDetailView;

/**
 * Created by alig2 on 27/06/2017.
 */
@Module
public class ArticleDetailModule {

    ArticleDetailActivity articleDetailActivity;
    Article article;

    public ArticleDetailModule(ArticleDetailActivity activity,Article article){
        this.articleDetailActivity = activity;
        this.article=article;
    }

    @Provides
    ArticleDetailView provideView(){
        return new ArticleDetailView(articleDetailActivity,article);
    }
}
