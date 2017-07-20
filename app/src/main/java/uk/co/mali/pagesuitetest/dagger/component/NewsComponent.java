package uk.co.mali.pagesuitetest.dagger.component;

import dagger.Component;
import uk.co.mali.pagesuitetest.dagger.module.NewsModule;
import uk.co.mali.pagesuitetest.dagger.scope.NewsScope;
import uk.co.mali.pagesuitetest.views.activities.NewsListActivity;

/**
 * Created by alig2 on 27/06/2017.
 */

@NewsScope
@Component(dependencies = {AppComponent.class} , modules = {NewsModule.class})
public interface NewsComponent {

    void inject(NewsListActivity newsListActivity);

}
