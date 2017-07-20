
package uk.co.mali.pagesuitetest.model.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by alig2 on 22/06/2017.
 */

public class Data implements Parcelable {

    @SerializedName("feeds")
    @Expose
    private Feeds feeds;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("url")
    @Expose
    private String url;

    public Feeds getFeeds() {
        return feeds;
    }

    public void setFeeds(Feeds feeds) {
        this.feeds = feeds;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.feeds, flags);
        dest.writeTypedList(this.articles);
        dest.writeString(this.section);
        dest.writeString(this.url);
    }

    public Data() {
    }

    protected Data(Parcel in) {
        this.feeds = in.readParcelable(Feeds.class.getClassLoader());
        this.articles = in.createTypedArrayList(Article.CREATOR);
        this.section = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
