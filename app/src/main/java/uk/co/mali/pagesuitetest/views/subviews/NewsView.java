package uk.co.mali.pagesuitetest.views.subviews;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import uk.co.mali.pagesuitetest.R;
import uk.co.mali.pagesuitetest.model.pojos.Article;
import uk.co.mali.pagesuitetest.model.pojos.Data;
import uk.co.mali.pagesuitetest.views.activities.NewsListActivity;
import uk.co.mali.pagesuitetest.views.adapter.NewsRecylerAdapter;

/**
 * Created by alig2 on 26/06/2017.
 */

public class NewsView {

    private static final String TAG= NewsView.class.getSimpleName();

    @BindView(R.id.activity_front_news_list_recycleview)
    RecyclerView List_News_Articles;

    View view;
    NewsRecylerAdapter adapter;

    public NewsView(NewsListActivity context){
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_list_news,parent,true);
        ButterKnife.bind(this, view);

        adapter = new NewsRecylerAdapter();
        List_News_Articles.setAdapter(adapter);
        List_News_Articles.setLayoutManager(new LinearLayoutManager(context));



    }

    public Observable<Integer> itemClicks(){
        return adapter.observeClicks();
        }


    public View view(){
        return view;
    }

    public void swapAdapter(Data restData){
        Log.d(TAG,"swapAdapter called:..."+restData.getSection());
        ArrayList<Article> listArticles = (ArrayList<Article>) restData.getArticles();
        if(listArticles!=null) {
            Log.d(TAG,"swapAdapter called:...List Size: "+listArticles.size());
            adapter.swapAdapter(listArticles);
        }
        }
}
