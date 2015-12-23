package akhoufi.mymovieapp.network.parsers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import akhoufi.mymovieapp.controllers.adapters.MovieRecyclerAdapter;
import akhoufi.mymovieapp.models.Movie;
import akhoufi.mymovieapp.network.ApiParser;
import akhoufi.mymovieapp.utils.CommonUtils;

/**
 * Created by akhou on 16/12/2015.
 */
public class MovieParser extends ApiParser {
    private List<Movie> mMovieList;
    private MovieRecyclerAdapter mMovieAdapter;

    public MovieParser(Context context,RecyclerView.Adapter adapter) {
        super(context);
        mMovieList = new ArrayList<>();
        mMovieAdapter=(MovieRecyclerAdapter)adapter;
    }


    public List<Movie> getMovieList() {
        if (mMovieList.size() != 0)
            return mMovieList;
        return null;
    }

    @Override
    public void onResponse(Object response) {
        try {
            JSONObject jsonResponse = (JSONObject) response;
            JSONArray jsonResults = jsonResponse.optJSONArray("results");
            if (jsonResults != null)
                for (int i = 0; i < jsonResults.length(); i++) {
                    JSONObject jsonResult = jsonResults.getJSONObject(i);
                    Movie movie = CommonUtils.getGsonInstance().fromJson(jsonResult.toString(), Movie.class);
                    if (movie != null) {
                        mMovieList.add(movie);
                    }
                }
            mMovieAdapter.setMovieList(mMovieList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
