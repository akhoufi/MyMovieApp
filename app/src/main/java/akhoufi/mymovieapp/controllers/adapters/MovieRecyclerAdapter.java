package akhoufi.mymovieapp.controllers.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import akhoufi.mymovieapp.R;
import akhoufi.mymovieapp.controllers.holders.MovieHolder;
import akhoufi.mymovieapp.models.Movie;
import akhoufi.mymovieapp.ui.interfaces.MovieRecyclerItemListner;
import akhoufi.mymovieapp.utils.MyMovieAppConstants;

/**
 * Created by akhou on 16/12/2015.
 */
public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieHolder> implements MyMovieAppConstants {

    private List<Movie> mMovieList;
    private Context mContext;
    private MovieHolder movieHolder;
    private int position;
    private MovieRecyclerItemListner mMovieRecyclerItemListner;

    public MovieRecyclerAdapter(MovieRecyclerItemListner mMovieRecyclerItemListner) {
        this.mMovieRecyclerItemListner = mMovieRecyclerItemListner;
    }


    public void clear() {
        if (mMovieList != null) {
            mMovieList.clear();
        }
    }

    public void setMovieList(List<Movie> mMovieList) {
        this.mMovieList = mMovieList;
        notifyDataSetChanged();
    }

    public MovieRecyclerAdapter(List<Movie> movieList, MovieRecyclerItemListner mMovieRecyclerItemListner) {
        this.mMovieRecyclerItemListner = mMovieRecyclerItemListner;
        mMovieList = movieList;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ImageView view = (ImageView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_poster, viewGroup, false);
        mContext = viewGroup.getContext();
        return new MovieHolder(view, mMovieRecyclerItemListner);
    }

    @Override
    public void onBindViewHolder(MovieHolder movieHolder, int position) {
        this.movieHolder = movieHolder;
        this.position = position;
        Movie movie = mMovieList.get(position);
        movieHolder.setMovie(movie);
        Glide.with(mContext)
                .load(THE_MOVIE_DB_IMAGE_URL + Image_W185_SIZE + movie.getmPosterPath())
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(movieHolder.uiPoster);
    }

    @Override
    public int getItemCount() {
        if (mMovieList != null)
            return mMovieList.size();
        return 0;
    }
}
