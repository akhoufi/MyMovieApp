package akhoufi.mymovieapp.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by akhou on 16/12/2015.
 */
public class CommonUtils implements MyMovieAppConstants {
    private static final boolean LOG_ENABLED = true;
    private static final DateFormat sDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    private static DefaultRetryPolicy mRetryPolicy;
    private static RequestQueue sRequestQueue;
    private static Gson sGson;

    public static String formatDate(Date date) {
        return sDateFormat.format(date);
    }

    public static void log(String message) {
        if (LOG_ENABLED) {
            Log.i(LOG_TAG, message);
        }
    }

    public static void log(String message, Throwable t) {
        if (LOG_ENABLED) {
            Log.e(LOG_TAG, message, t);
        }
    }

    public static Gson getGsonInstance() {
        if (sGson == null) {
            sGson = new Gson();
        }
        return sGson;
    }

    public static RetryPolicy getRetryPolicy() {
        if (mRetryPolicy == null) {
            mRetryPolicy = new DefaultRetryPolicy(5000, 1, 1f);
        }
        return mRetryPolicy;
    }


    public static RequestQueue getRequestQueue(Context context) {
        if (sRequestQueue == null) {
            VolleyLog.setTag(LOG_TAG);
            VolleyLog.DEBUG = LOG_ENABLED;
            sRequestQueue = Volley.newRequestQueue(context, new HurlStack());
        }
        return sRequestQueue;
    }


}
