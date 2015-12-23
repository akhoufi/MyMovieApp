package akhoufi.mymovieapp.network;

import android.content.Context;

import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import java.io.IOException;

import akhoufi.mymovieapp.R;

/**
 * Created by akhou on 16/12/2015.
 */
public abstract class ApiParser implements Response.ErrorListener, Response.Listener {
    protected Context mContext;

    public ApiParser(Context context) {
        this.mContext = context;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String message = null;
        if (error instanceof TimeoutError) {
            message = mContext.getString(R.string.error_no_network);
        } else if (error instanceof NetworkError) {
            message = mContext.getString(R.string.error_no_network);
        } else if (error instanceof ServerError) {
            message = mContext.getString(R.string.error_generic);
        } else if (error instanceof ParseError) {
            message = mContext.getString(R.string.error_generic);
        } else {
            message = error.getCause().getMessage();
            if (error.getCause() instanceof IOException) {
                message = mContext.getString(R.string.error_no_network);
            } else {
                message = mContext.getString(R.string.error_generic);
            }
        }
    }
}
