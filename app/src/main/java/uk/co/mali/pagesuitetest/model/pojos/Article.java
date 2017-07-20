
package uk.co.mali.pagesuitetest.model.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Article implements Parcelable {

    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("headline_override")
    @Expose
    private String headlineOverride;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("editorial_priority")
    @Expose
    private String editorialPriority;
    @SerializedName("short_headline")
    @Expose
    private String shortHeadline;
    @SerializedName("sub_headline")
    @Expose
    private String subHeadline;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("local_caption")
    @Expose
    private String localCaption;
    @SerializedName("comments_setting")
    @Expose
    private String commentsSetting;
    @SerializedName("publish_date")
    @Expose
    private String publishDate;
    @SerializedName("topics")
    @Expose
    private List<String> topics = null;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("section_url")
    @Expose
    private String sectionUrl;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("body")
    @Expose
    private String body;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHeadlineOverride() {
        return headlineOverride;
    }

    public void setHeadlineOverride(String headlineOverride) {
        this.headlineOverride = headlineOverride;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getEditorialPriority() {
        return editorialPriority;
    }

    public void setEditorialPriority(String editorialPriority) {
        this.editorialPriority = editorialPriority;
    }

    public String getShortHeadline() {
        return shortHeadline;
    }

    public void setShortHeadline(String shortHeadline) {
        this.shortHeadline = shortHeadline;
    }

    public String getSubHeadline() {
        return subHeadline;
    }

    public void setSubHeadline(String subHeadline) {
        this.subHeadline = subHeadline;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocalCaption() {
        return localCaption;
    }

    public void setLocalCaption(String localCaption) {
        this.localCaption = localCaption;
    }

    public String getCommentsSetting() {
        return commentsSetting;
    }

    public void setCommentsSetting(String commentsSetting) {
        this.commentsSetting = commentsSetting;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionUrl() {
        return sectionUrl;
    }

    public void setSectionUrl(String sectionUrl) {
        this.sectionUrl = sectionUrl;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.guid);
        dest.writeString(this.state);
        dest.writeString(this.headlineOverride);
        dest.writeString(this.headline);
        dest.writeString(this.url);
        dest.writeString(this.link);
        dest.writeList(this.authors);
        dest.writeString(this.updatedDate);
        dest.writeString(this.editorialPriority);
        dest.writeString(this.shortHeadline);
        dest.writeString(this.subHeadline);
        dest.writeString(this.author);
        dest.writeString(this.localCaption);
        dest.writeString(this.commentsSetting);
        dest.writeString(this.publishDate);
        dest.writeStringList(this.topics);
        dest.writeStringList(this.tags);
        dest.writeString(this.section);
        dest.writeString(this.sectionUrl);
        dest.writeParcelable(this.image, flags);
        dest.writeString(this.body);
    }

    public Article() {
    }

    protected Article(Parcel in) {
        this.guid = in.readString();
        this.state = in.readString();
        this.headlineOverride = in.readString();
        this.headline = in.readString();
        this.url = in.readString();
        this.link = in.readString();
        this.authors = new ArrayList<Author>();
        in.readList(this.authors, Author.class.getClassLoader());
        this.updatedDate = in.readString();
        this.editorialPriority = in.readString();
        this.shortHeadline = in.readString();
        this.subHeadline = in.readString();
        this.author = in.readString();
        this.localCaption = in.readString();
        this.commentsSetting = in.readString();
        this.publishDate = in.readString();
        this.topics = in.createStringArrayList();
        this.tags = in.createStringArrayList();
        this.section = in.readString();
        this.sectionUrl = in.readString();
        this.image = in.readParcelable(Image.class.getClassLoader());
        this.body = in.readString();
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
