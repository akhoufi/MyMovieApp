package akhoufi.mymovieapp.controllers.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import akhoufi.mymovieapp.models.Movie;
import akhoufi.mymovieapp.ui.interfaces.MovieRecyclerItemListner;

/**
 * Created by akhou on 17/12/2015.
 */
public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView uiPoster;
    private final MovieRecyclerItemListner mMovieRecyclerItemListner;
    private Movie mMovie;

    public MovieHolder(ImageView itemView, MovieRecyclerItemListner mMovieRecyclerItemListner) {
        super(itemView);
        itemView.setOnClickListener(this);
        uiPoster = itemView;
        this.mMovieRecyclerItemListner = mMovieRecyclerItemListner;
    }

    @Override
    public void onClick(View v) {
        mMovieRecyclerItemListner.onMovieClick(mMovie);
    }

    public void setMovie(Movie movie) {
        this.mMovie = movie;
    }
}
