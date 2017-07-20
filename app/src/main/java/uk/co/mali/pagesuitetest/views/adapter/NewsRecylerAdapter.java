package uk.co.mali.pagesuitetest.views.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;
import uk.co.mali.pagesuitetest.R;
import uk.co.mali.pagesuitetest.model.pojos.Article;


/**
 * Created by alig2 on 26/06/2017.
 */

public class NewsRecylerAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    public final static String TAG = NewsRecylerAdapter.class.getSimpleName();

    PublishSubject<Integer> itemClicks = PublishSubject.create();

    ArrayList<Article> ListArticles = new ArrayList<>();

    public void swapAdapter(List<Article> list) {
        Log.d(TAG, "Recycler Adapter: swapAdapter Called..: " + list.size());

        this.ListArticles.clear();
        this.ListArticles.addAll(list);
        notifyDataSetChanged();
        if (ListArticles == null) {
            Log.d(TAG, "List of Articles is Null");
        }
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "OnCreateViewHolder called: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_news, parent, false);
        return new NewsViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Log.d(TAG, "OnCreateViewHolder called: ");
        Article article = ListArticles.get(position);
        holder.bind(article);

    }

    @Override
    public int getItemCount() {
        if (ListArticles != null && ListArticles.size() > 0) {
            return ListArticles.size();
        } else {
            return 0;
        }
    }
}