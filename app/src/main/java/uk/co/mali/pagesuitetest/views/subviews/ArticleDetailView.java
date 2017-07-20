package uk.co.mali.pagesuitetest.views.subviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.mali.pagesuitetest.R;
import uk.co.mali.pagesuitetest.model.pojos.Article;
import uk.co.mali.pagesuitetest.views.activities.ArticleDetailActivity;

/**
 * Created by alig2 on 27/06/2017.
 */


public class ArticleDetailView {

    @BindView(R.id.iv_ArticleImage)
    ImageView imageArticle;
    @BindView(R.id.tv_ArticleHeadline)
    TextView tvArticleHeadline;
    @BindView(R.id.tv_DateOfArticle)
    TextView tvArticlePublishDate;
    @BindView(R.id.tv_ArticleAuthor)
    TextView tvArticleAuthorName;
    @BindView(R.id.tv_ArticleDetails)
    TextView tvArticleDetail;

    View view;

    public ArticleDetailView(ArticleDetailActivity activity, Article article){
        FrameLayout layout = new FrameLayout(activity);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(activity).inflate(R.layout.activity_article_detail_view,layout,true);
        ButterKnife.bind(this,view);

        Glide.with(activity).load(article.getImage().getUrl()).into(imageArticle);
        tvArticleHeadline.setText(article.getShortHeadline());
        tvArticleAuthorName.setText("Author: "+article.getAuthor());
        tvArticlePublishDate.setText("Publish Date: "+article.getPublishDate());
        tvArticleDetail.setText(article.getBody());

    }

    public View view(){
        return view;
    }


}
