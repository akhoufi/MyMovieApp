package akhoufi.mymovieapp.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import akhoufi.mymovieapp.R;
import akhoufi.mymovieapp.controllers.adapters.MovieRecyclerAdapter;
import akhoufi.mymovieapp.models.Movie;
import akhoufi.mymovieapp.network.ApiController;
import akhoufi.mymovieapp.ui.MovieActivity;
import akhoufi.mymovieapp.ui.interfaces.MovieRecyclerItemListner;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements MovieRecyclerItemListner {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private MovieRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = getContext();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.movie_recycler_view);
        mLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MovieRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        ApiController.requestMostPopularMovies(mContext, mAdapter);
    }

    @Override
    public void onMovieClick(Movie movie) {
        Intent intent = new Intent(getActivity(), MovieActivity.class);
        intent.putExtra("movieItem", movie);
        startActivity(intent);
    }
}
