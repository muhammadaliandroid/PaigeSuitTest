package uk.co.mali.pagesuitetest.dagger.component;

import dagger.Component;
import uk.co.mali.pagesuitetest.dagger.module.ArticleDetailModule;
import uk.co.mali.pagesuitetest.views.activities.ArticleDetailActivity;

/**
 * Created by alig2 on 27/06/2017.
 */
@Component(modules = {ArticleDetailModule.class})
public interface ArticalDetailComponent {
    void inject(ArticleDetailActivity articleDetailActivity);

}
