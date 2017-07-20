package uk.co.mali.pagesuitetest.dagger.module;

import dagger.Module;
import dagger.Provides;
import uk.co.mali.pagesuitetest.dagger.scope.FrontScope;
import uk.co.mali.pagesuitetest.views.activities.FrontPageActivity;

/**
 * Created by alig2 on 27/06/2017.
 */

@Module
public class FrontPageContextModule {


    FrontPageActivity frontPageActivity;

    public FrontPageContextModule(FrontPageActivity context){
        this.frontPageActivity=context;

    }

    @FrontScope
    @Provides
    FrontPageActivity provideFrontContext(){
        return frontPageActivity;
    }


}
