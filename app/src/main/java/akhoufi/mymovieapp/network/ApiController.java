package akhoufi.mymovieapp.network;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;

import akhoufi.mymovieapp.network.parsers.MovieParser;
import akhoufi.mymovieapp.utils.CommonUtils;
import akhoufi.mymovieapp.utils.MyMovieAppConstants;

/**
 * Created by akhou on 16/12/2015.
 */
public class ApiController implements MyMovieAppConstants{
    public static void requestMostPopularMovies(Context context,RecyclerView.Adapter adapter){
        MovieParser parser=new MovieParser(context,adapter);

        Uri.Builder builder=Uri.parse(THE_MOVIE_DB_API_URL).buildUpon();
        builder.appendQueryParameter(PARAM_SORT_BY,VALUE_SORT_BY_POPULARITY_DESC);
        builder.appendQueryParameter(PARAM_API_KEY,THE_MOVIE_DB_API_KEY);

        ApiRequest request=new ApiRequest(Request.Method.GET,builder.build().toString(),parser,parser);
        CommonUtils.getRequestQueue(context).add(request);
    }
}
