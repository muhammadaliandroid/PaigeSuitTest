package uk.co.mali.pagesuitetest.dagger.component;

import dagger.Component;
import uk.co.mali.pagesuitetest.dagger.module.FrontPageContextModule;
import uk.co.mali.pagesuitetest.dagger.module.FrontPageModule;
import uk.co.mali.pagesuitetest.dagger.scope.FrontScope;
import uk.co.mali.pagesuitetest.views.activities.FrontPageActivity;

/**
 * Created by alig2 on 27/06/2017.
 */
@FrontScope
@Component(modules = {FrontPageContextModule.class, FrontPageModule.class}, dependencies = {AppComponent.class})
public interface FrontPageComponent {
    void inject(FrontPageActivity activity);
}
