package uk.co.mali.pagesuitetest.views.subviews;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import uk.co.mali.pagesuitetest.R;
import uk.co.mali.pagesuitetest.views.activities.FrontPageActivity;

/**
 * Created by alig2 on 27/06/2017.
 */

public class FrontPageView {
    private View view;
    public final static String TAG = FrontPageView.class.getSimpleName();


    public FrontPageView(FrontPageActivity context){
        Log.d(TAG, "Constructor");
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_front_page,parent,true);
        ButterKnife.bind(view,context);
    }

    public View constructView(){
        return view;
    }
}
