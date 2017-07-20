
package uk.co.mali.pagesuitetest.model.pojos;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alig2 on 22/06/2017.
 */

public class Feeds implements Parcelable {

    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("url")
    @Expose
    private String url;

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
        dest.writeString(this.section);
        dest.writeString(this.url);
    }

    public Feeds() {
    }

    protected Feeds(Parcel in) {
        this.section = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Feeds> CREATOR = new Parcelable.Creator<Feeds>() {
        @Override
        public Feeds createFromParcel(Parcel source) {
            return new Feeds(source);
        }

        @Override
        public Feeds[] newArray(int size) {
            return new Feeds[size];
        }
    };
}
