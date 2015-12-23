package akhoufi.mymovieapp.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import akhoufi.mymovieapp.R;
import akhoufi.mymovieapp.models.Movie;
import akhoufi.mymovieapp.utils.MyMovieAppConstants;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieFragment extends Fragment implements MyMovieAppConstants {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
        TextView releaseDateTextView = (TextView) rootView.findViewById(R.id.releaseDateTextView);
        TextView voteAverageTextView=(TextView)rootView.findViewById(R.id.voteAverageTextView);
        TextView overviewTextView=(TextView)rootView.findViewById(R.id.overviewTextView);
        ImageView posterImageView=(ImageView) rootView.findViewById(R.id.posterImageView);

        Intent intent = getActivity().getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("movieItem");

        getActivity().setTitle(movie.getmTitle());
        releaseDateTextView.setText(movie.getmReleaseDate());
        voteAverageTextView.setText(movie.getmVoteAverage());
        overviewTextView.setText(movie.getmOverview());

        Glide.with(getContext())
                .load(THE_MOVIE_DB_IMAGE_URL + Image_W185_SIZE + movie.getmPosterPath())
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(posterImageView);


        return rootView;
    }
}
