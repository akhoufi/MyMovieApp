package akhoufi.mymovieapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akhou on 16/12/2015.
 */
public class Movie implements Serializable {
    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("adult")
    private String mAdult;

    @SerializedName("id")
    private long mId;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("genre_ids")
    private List<Integer> mGenreIds;

    @SerializedName("original_title")
    private String mOriginalTitle;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("popularity")
    private String mPopularity;

    @SerializedName("vote_count")
    private String mVoteCount;

    @SerializedName("video")
    private String mVideo;

    @SerializedName("vote_average")
    private String mVoteAverage;

    public Movie(){

    }
    public Movie(String mPosterPath, String mAdult, long mId, String mOverview, String mReleaseDate, List<Integer> mGenreIds, String mOriginalTitle, String mOriginalLanguage, String mTitle, String mBackdropPath, String mPopularity, String mVoteCount, String mVideo, String mVoteAverage) {
        this.mPosterPath = mPosterPath;
        this.mAdult = mAdult;
        this.mId = mId;
        this.mOverview = mOverview;
        this.mReleaseDate = mReleaseDate;
        this.mGenreIds = mGenreIds;
        this.mOriginalTitle = mOriginalTitle;
        this.mOriginalLanguage = mOriginalLanguage;
        this.mTitle = mTitle;
        this.mBackdropPath = mBackdropPath;
        this.mPopularity = mPopularity;
        this.mVoteCount = mVoteCount;
        this.mVideo = mVideo;
        this.mVoteAverage = mVoteAverage;
    }


    public String getmPosterPath() {
        return mPosterPath;
    }

    public void setmPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public String getmAdult() {
        return mAdult;
    }

    public void setmAdult(String mAdult) {
        this.mAdult = mAdult;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public List<Integer> getmGenreIds() {
        return mGenreIds;
    }

    public void setmGenreIds(List<Integer> mGenreIds) {
        this.mGenreIds = mGenreIds;
    }

    public String getmOriginalTitle() {
        return mOriginalTitle;
    }

    public void setmOriginalTitle(String mOriginalTitle) {
        this.mOriginalTitle = mOriginalTitle;
    }

    public String getmOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setmOriginalLanguage(String mOriginalLanguage) {
        this.mOriginalLanguage = mOriginalLanguage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBackdropPath() {
        return mBackdropPath;
    }

    public void setmBackdropPath(String mBackdropPath) {
        this.mBackdropPath = mBackdropPath;
    }

    public String getmPopularity() {
        return mPopularity;
    }

    public void setmPopularity(String mPopularity) {
        this.mPopularity = mPopularity;
    }

    public String getmVoteCount() {
        return mVoteCount;
    }

    public void setmVoteCount(String mVoteCount) {
        this.mVoteCount = mVoteCount;
    }

    public String getmVideo() {
        return mVideo;
    }

    public void setmVideo(String mVideo) {
        this.mVideo = mVideo;
    }

    public String getmVoteAverage() {
        return mVoteAverage;
    }

    public void setmVoteAverage(String mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }
}
