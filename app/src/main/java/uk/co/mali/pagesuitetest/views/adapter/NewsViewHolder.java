package uk.co.mali.pagesuitetest.views.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;
import uk.co.mali.pagesuitetest.R;
import uk.co.mali.pagesuitetest.model.pojos.Article;

/**
 * Created by alig2 on 27/06/2017.
 */

class NewsViewHolder extends ViewHolder{

    View view;

    @BindView(R.id.iv_NewsImage)
    ImageView imageNews;
    @BindView(R.id.tv_NewsHeadline)
    TextView tvNewsHeadline;
    @BindView(R.id.tv_NewsAuthor)
    TextView tvNewsAuthor;
    @BindView(R.id.tv_NewsBrief)
    TextView tvNewsBrief;
    @BindView(R.id.tv_NewsDatePublish)
    TextView tvNewsPublishDate;
    @BindView(R.id.view_NewsSeperator)
    View viewNewsSeperator;


    public NewsViewHolder(View itemView, PublishSubject<Integer> clickSubject){
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this,view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }


    void bind(Article article){
        Glide.with(view.getContext()).load(article.getImage().getUrl().toString()).into(imageNews);

        tvNewsHeadline.setText(article.getHeadline());
        tvNewsAuthor.setText("Author: "+article.getAuthor());
        tvNewsBrief.setText(article.getShortHeadline());
        tvNewsPublishDate.setText("Dated: "+article.getPublishDate());
        viewNewsSeperator.setBackgroundColor(Color.LTGRAY);
    }
}
